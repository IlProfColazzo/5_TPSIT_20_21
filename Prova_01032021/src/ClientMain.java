import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Giacomo Mastrandrea - 5CI - 2020/21
 * */

public class ClientMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));;
		String stringaUtente,stringaFromServer;
		
		Client c = new Client("127.0.0.1", 42521);
		c.connetti();
		
		boolean exit = false;
			
		do {
			System.out.print("[C] Inserisci il comando da inviare al server:");
			stringaUtente = tastiera.readLine();
			c.invia(stringaUtente+"\n");			
			stringaFromServer = c.ricevi();
			System.out.println("[C] " + stringaFromServer);
			if(stringaFromServer.equals("Programma terminato!")) {
				exit = true;
			}
		
		}while(exit==false);
		
		System.out.println("[C] Chiudo la connessione");
		c.chiudi();

	}

}
