import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
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

		ArrayList<Integer> l = new ArrayList<Integer>();
		String risposta="";
		boolean fine = false;
		do {
			String letta = ricevi();
			String[] comando = letta.split(":");
			if(comando[0].equals("add")) {
				int valore = Integer.parseInt(comando[1]);
				l.add(valore);
				risposta = "Valore aggiunto correttamente!";
			}
			if(comando[0].equals("list")) {
				risposta = "Gli elementi inseriti sono: " + l.toString();
			}
			if(comando[0].equals("avg")) {
				int sum=0;
				if(l.size()==0) {
					risposta = "Lista vuota.";
				}
				else {
					for(int value:l)
						sum+=value;
					risposta = "Il valore della media e' "+sum/l.size();
				}
			}
			if(comando[0].equals("max")) {
				int max=Integer.MIN_VALUE;
				if(l.size()==0) {
					risposta = "Lista vuota.";
				}
				else {
					for(int i=0;i<l.size();i++)
						if(l.get(i)>max)
							max=l.get(i);
					risposta = "Il valore max e' "+max;
				}
			}
			if(comando[0].equals("min")) {
				int min=Integer.MAX_VALUE;
				if(l.size()==0) {
					risposta = "Lista vuota.";
				}
				else {
					for(int i=0;i<l.size();i++)
						if(l.get(i)<min)
							min=l.get(i);
					risposta = "Il valore min e' "+min;
				}
			}
			if (letta.equals("len")) {
				risposta = "Il numero di elementi inseriti e': "+l.size();
			}
			
			if (letta.equals("quit")) {
				fine = true;
				risposta = "ARRIVEDERCI!";
			}
			invia(risposta + "\n"); 
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
