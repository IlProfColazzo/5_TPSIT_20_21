import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

public class ClientConnesso {
	
	private Socket s; //Socket connesso da utilizzare per trasmettere/ricevere dati
	private DataOutputStream toClient;
	private BufferedReader fromClient;
	
	public ClientConnesso(Socket s) {
		this.s = s;
		try {
			this.fromClient = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			this.toClient = new DataOutputStream(this.s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void invia(String daInviare) {
		try {
			this.toClient.writeBytes(daInviare);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**Invia la stringa daInviare al Client connesso*/
	
	}
	
	public String ricevi() {
		String s = "";
		
		try {
			s= this.fromClient.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public void chiudi() {
		try {
			this.fromClient.close();
			this.toClient.close();
			this.s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
