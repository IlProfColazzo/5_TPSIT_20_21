import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;

public class ClientConnesso extends Thread {

	private Socket s; // Socket connesso da utilizzare per trasmettere/ricevere dati
	private DataOutputStream toClient;
	private BufferedReader fromClient;
	private HashMap<String, String> EnToIt;
	private HashMap<String, String> ItToEn;

	/**
	 * Metodo da modificare: all'interno di questo metodo deve essere descritto il
	 * comportamento che assume il server nel momento in cui si connette un Client
	 */
	@Override
	public void run() {
		boolean esci = false;
		do {
			
			String parolaRicevuta = ricevi();
			System.out.println("[S] Ho ricevuto " + parolaRicevuta);
			String[] vett = parolaRicevuta.split(";");
			String esito = "";
			if(vett.length==2) {
				if (vett[0].equals("T")) {
					// converto da italiano ad inglese
					if (ItToEn.containsKey(vett[1]))
						esito = ItToEn.get(vett[1]);
					else
						esito = "PAROLA NON CONOSCIUTA!";
				} else if (vett[0].equals("RT")) {
					// converto da inglese a italiano
					if (EnToIt.containsKey(vett[1]))
						esito = EnToIt.get(vett[1]);
					else
						esito = "PAROLA NON CONOSCIUTA!";
				} else if (vett[0].equals("QUIT") && vett[1].equals("QUIT")) {
					esci = true;
					esito = "ARRIVEDERCI!";
				} else {
					// comando errato
					esito = "COMANDO ERRATO!";
				}
			}
			else
				esito = "COMANDO ERRATO!";
			invia(esito + "\n");
		} while (esci == false);
		chiudi();
	}

	public ClientConnesso(Socket s, HashMap<String, String> enToIt, HashMap<String, String> itToEn) {
		this.s = s;
		try {
			this.fromClient = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			this.toClient = new DataOutputStream(this.s.getOutputStream());
			this.EnToIt = enToIt;
			this.ItToEn = itToEn;
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
