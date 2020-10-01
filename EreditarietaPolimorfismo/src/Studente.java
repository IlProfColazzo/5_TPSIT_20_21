public class Studente extends Persona{
	private float media;

	public Studente(String nome, String cognome, String cF, float media) {
		/*E' obbigatorio richimare il costruttore della classe padre: non
		è possibile costruire un oggetto figlio se ancora non è stato costruito l'oggetto
		padre*/
		super(nome, cognome, cF);
		this.media = media;
	}
	
	
}