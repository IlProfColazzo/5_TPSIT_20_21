import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
	
	private int porta;
	private ServerSocket mioSocket;
	
	public Server (int porta) {
		this.porta = porta;
	}
	
	public void avviaEattendi() {
		ClientConnesso client=null;
		try {
			/**Creo il Socket sul server*/
			this.mioSocket = new ServerSocket(this.porta);
			System.out.println("S--> Socket creato...");
			
			Scanner myReader = new Scanner(new File("italiano_inglese.txt"));
			HashMap<String, String> EnToIt = new HashMap<String, String>();
			HashMap<String, String> ItToEn = new HashMap<String, String>();

			while (myReader.hasNextLine()) {
				String it = myReader.next();
				String en = myReader.next();
				EnToIt.put(en, it);
				ItToEn.put(it, en);
			}
			myReader.close();
			
			/**Inserire la lettura del file e il riempimento delle mappe.
			 * I riferimenti alle mappe create devono essere passati come 
			 * parametri nel costrutture delle classe ClientConnesso.
			 * In questo modo ogni thread, che gestisce un client separato, potrà
			 * avere accesso alle mappe e di conseguenza potrà svolgere i suoi compiti.**/
			
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
				client = new ClientConnesso(s, EnToIt, ItToEn);
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
		return;
	}

}
