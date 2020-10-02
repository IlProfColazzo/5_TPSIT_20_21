public class Persona {
	
	/*Il modificatore di accesso protecter permette la visibilità a tutte le sottoclassi e a tutte le 
	classi appartenenti allo stesso package. */
	
	private String nome;
	private String cognome;
	private String CF;
	
	public Persona(String nome, String cognome, String cF) {
		this.nome = nome;
		this.cognome = cognome;
		CF = cF;
	}
	
	public void getQualifica() {
		
		System.out.println("Io non sono nessuno");
	}
	
	
}