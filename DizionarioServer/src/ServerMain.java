import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ServerMain {

	public static void main(String[] args) throws FileNotFoundException {

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

		Server serverNonConnesso = new Server(42521);
		ClientConnesso serverConnesso = serverNonConnesso.avviaEattendi();

		/**
		 * 
		 * HashMap<int, String> EnToIt = new HashMap<String, String>();
		 * EnToIt.put("House", "Casa"); ///Alla chiave House associa il valore Casa
		 * String traduzione = EnToIt.get("House"); ///Cercami il valore corrispondente
		 * alla chieve House //All'interno di traduzione ci finirà Casa
		 * if(EnToIt.containsKey("Hello")) { ///ritorna VERSO se esiste la chiave Hello
		 * e di conseguenza il suo valore ///ritorna FALSO altrimenti }
		 * 
		 */
		boolean esci = false;
		do {
			String parolaRicevuta = serverConnesso.ricevi();
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
			serverConnesso.invia(esito + "\n");
		} while (esci == false);

		// serverConnesso.invia(parolaRicevuta+"\n"); ///sto inviando dal server verso
		// il client
		serverConnesso.chiudi();

	}

}
