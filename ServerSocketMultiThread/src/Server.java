import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
				client = new ClientConnesso(s);
				client.start();	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
