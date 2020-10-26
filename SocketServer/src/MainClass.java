
public class MainClass {
	
	public static void main(String[] args) {
		
		Server s = new Server(42521);
		System.out.println("S--> Avvio il Server e mi metto in attesa di un client...");
		ClientConnesso client = s.avviaEattendi();
		
		String letta = client.leggiStringa(); //leggo una stringa che mi invierà il client
		System.out.println("S--> Il client mi ha inviato " + letta);
		String daInviare = letta.toUpperCase();
		client.scriviStringa(daInviare+"\n"); //restituisco al client la stessa stringa ma convertita in maiuscolo
		System.out.println("S--> Invio al client la stringa "+ daInviare);
		System.out.println("S--> Ho terminato il mio compito. Chiudo la connessione");
		client.chiudi();
		
		
		
		
	}

}
