import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	
	private String nomeServer;
	private int portaServer;
	private Socket mioSocket;
	
	
	private DataOutputStream toServer;
	private BufferedReader fromServer;
	
	
	public Client(String nomeServer, int portaServer) {
		this.nomeServer = nomeServer;
		this.portaServer = portaServer;
	}
	
	public Socket connetti() {
		try {
			
			this.mioSocket = new Socket(this.nomeServer,this.portaServer);
			this.toServer = new DataOutputStream(this.mioSocket.getOutputStream());
			this.fromServer = new BufferedReader(new InputStreamReader(this.mioSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.mioSocket;
	}
	
	public void invia(String stringaUtente) {
			
		try {
			this.toServer.writeBytes(stringaUtente);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String ricevi() {
		String stringaFromServer="";
		try {
			stringaFromServer = this.fromServer.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringaFromServer;
	}
	
	public void chiudi() {
		try {
			this.mioSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
