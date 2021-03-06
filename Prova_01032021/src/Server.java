import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Giacomo Mastrandrea - 5CI - 2020/21
 * */

public class Server {
	
	private int porta;
	private ServerSocket mioSocket;
	
	public Server (int porta) {
		this.porta = porta;
	}

	public ClientConnesso avviaEattendi() {
		ClientConnesso client=null;
		try {
			/**Creo il Socket sul server*/
			this.mioSocket = new ServerSocket(this.porta);
			System.out.println("S--> Socket creato...");
			
			Scanner myReader = new Scanner(new File("input.txt"));
			
			int N = myReader.nextInt();
			int M = myReader.nextInt();
			int mat[][] = new int[N][M];
			
			
			for(int i=0; i<N && myReader.hasNextLine(); i++) {
				for(int j=0; j<M;j++) {
					mat[i][j] = myReader.nextInt();
				}
			}
			
			myReader.close();
			
			while(true) {
				/**E' necessario mettersi in attesa di Client
				 * Il metodo accept è bloccante e quando un client si connette
				 * il metodo si sblocca e ritorna il socket "connesso"*/
				System.out.println("S--> Socket in attesa...");
				Socket s = this.mioSocket.accept();
				System.out.println("S--> Connesso client con IP " + s.getInetAddress() + " e porta " + s.getPort());
				/**Non dobbiamo chiudere il mioSocket altrimenti
				 * non si possono accettare altre connessioni.*/
				//this.mioSocket.close();
				/**Creo l'oggetto ClientConnesso con i relativi stream di input e output*/
				client = new ClientConnesso(s, mat, N, M);
				/**
				 * Lascio la gestione del Client al proprio destino.
				 * Creo un Thread che gestisce il client appena connesso
				 * */
				client.start();	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

}
