import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

public class ClientConnesso extends Thread {

	private Socket s; // Socket connesso da utilizzare per trasmettere/ricevere dati
	private DataOutputStream toClient;
	private BufferedReader fromClient;

	/**
	 * Metodo da modificare: all'interno di questo metodo deve essere descritto il
	 * comportamento che assume il server nel momento in cui si connette un Client
	 */
	@Override
	public void run() {

		boolean fine = false;
		do {
			// System.out.println("S--> Sono in attesa di una stringa da " +s.getPort());
			String letta = ricevi(); // leggo una stringa che mi invierà il client
			// System.out.println("S--> Il client " +s.getPort()+ " mi ha inviato " +
			// letta);
			if (letta.equals("fine")) {
				fine = true;
			}
			String daInviare = letta.toUpperCase();
			invia(daInviare + "\n"); // restituisco al client la stessa stringa ma convertita in maiuscolo
			// System.out.println("S--> Invio al client " +s.getPort()+ " la stringa "+
			// daInviare);
			// System.out.println("S--> Ho terminato il mio compito. Chiudo la
			// connessione");
		} while (fine == false);

		chiudi();/// termina la connessione con il client
	}

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
		/** Invia la stringa daInviare al Client connesso */
		try {
			this.toClient.writeBytes(daInviare);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String ricevi() {
		String s = "";

		try {
			s = this.fromClient.readLine();
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
