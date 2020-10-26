import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader tastiera;
		String stringaUtente,stringaFromServer;
		
		Client c = new Client("127.0.0.1", 42521);
		c.connetti();
		
		tastiera = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("C-->Inserisci la stringa che vuoi inviare al server....");
			stringaUtente = tastiera.readLine();
			System.out.println("C-->Invio la stringa al server e attendo....");
			c.invia(stringaUtente+"\n");
			System.out.println("C-->...attendo risposta dal server....");
			stringaFromServer = c.ricevi(); //metodo bloccante
			System.out.println("C-->Risposta dal server --> " + stringaFromServer);
			System.out.println("C-->Chiudo la connessione");
			c.chiudi();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
