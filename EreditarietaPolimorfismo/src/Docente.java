public class Docente extends Persona{
	private float RAL; //RAL = Retribuzione Annua Lorda

	public Docente(String nome, String cognome, String cF, float rAL) {
		/*E' obbigatorio richimare il costruttore della classe padre: non
		è possibile costruire un oggetto figlio se ancora non è stato costruito l'oggetto
		padre*/
		super(nome, cognome, cF);
		RAL = rAL;
	}
	
	
}