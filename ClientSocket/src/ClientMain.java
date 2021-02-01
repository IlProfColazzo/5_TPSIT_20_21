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
		while(true) {
			System.out.println("[C] Inserisci una parola: ");
			String parola = tastiera.next();
			System.out.println("[C] La parola inserita e': "+parola);
			c.invia(parola+"\n");
			String parolaRicevuta = c.ricevi();
			System.out.println("[C] Il server mi ha inviato: "+parolaRicevuta);
		}
		//c.chiudi();

	}

}
