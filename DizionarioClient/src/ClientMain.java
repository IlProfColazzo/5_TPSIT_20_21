import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Client c = new Client("127.0.0.1", 42521);
		c.connetti();
		Scanner tastiera = new Scanner(System.in);
		boolean esci = false;
		do {
			System.out.println("[C] Inserisci un comando: ");
			String parola = tastiera.next();
			c.invia(parola+"\n");
			String risposta = c.ricevi();
			System.out.println("[C] Il server mi ha inviato: "+risposta);
			if(risposta.equals("ARRIVEDERCI!")) {
				esci = true;
			}
		}while(!esci);
		
		c.chiudi();

	}

}
