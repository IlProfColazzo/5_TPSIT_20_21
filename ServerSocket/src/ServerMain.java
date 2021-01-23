
public class ServerMain {
	
	public static void main(String[] args) {
		
		Server serverNonConnesso = new Server(42521);
		ClientConnesso serverConnesso = serverNonConnesso.avviaEattendi();
		
		String parolaRicevuta = serverConnesso.ricevi();
		System.out.println("[S] Il client mi ha inviato la parola: "+parolaRicevuta);
		String risultato = parolaRicevuta.toUpperCase();
		serverConnesso.invia(risultato+"\n"); ///sto inviando dal server verso il client
		serverConnesso.chiudi();
		
		
	}

}
