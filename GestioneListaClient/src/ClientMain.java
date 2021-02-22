import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		Client c = new Client("127.0.0.1", 42521);
		c.connetti();
		Scanner tastiera = new Scanner(System.in);
		boolean esci = false;
		do {
			printMenu();
			String parola = tastiera.next();
			String cmd="";
			if(!parola.equals("add") && !parola.equals("list")
				&& !parola.equals("avg") && !parola.equals("min")
				&& !parola.equals("max")&& !parola.equals("len")
				&& !parola.equals("quit"))
				System.out.println("Comando errato!");
			if(parola.equals("add")) {
					System.out.println("[C] Dammi l'elemento da aggiungere:");
					int value = tastiera.nextInt();
					parola=parola+":"+value;
			}
			c.invia(parola+"\n");			
			String risposta = c.ricevi();
			System.out.println("-----> "+risposta);
			if(risposta.equals("ARRIVEDERCI!")) {
				esci = true;
			}
		}while(!esci);
		
		c.chiudi();
	}
	
	public static void printMenu() {
		System.out.println("[C] Inserisci un comando:");
		System.out.println("[C] add per aggiungere un elemento");
		System.out.println("[C] list per visualizzare gli elementi");
		System.out.println("[C] avg per visualizzare la media");
		System.out.println("[C] min per visualizzare il valore minimo");
		System.out.println("[C] max per visualizzare il valore massimo");
		System.out.println("[C] len per visualizzare il numero di elementi inseriti");
		System.out.println("[C] quit per terminare il programma");
	}
	

}
