import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
			/**E' necessario mettersi in attesa di Client
			 * Il metodo accept � bloccante e quando un client si connette
			 * il metodo si sblocca e ritorna il socket "connesso"*/
			Socket s = this.mioSocket.accept();
			/**Chiudiamo il socket non pi� necessario*/
			this.mioSocket.close();
			/**Creo l'oggetto ClientConnesso con i relativi stream di input e output*/
			client = new ClientConnesso(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

}
