public class Persona {
	
	private String nome;
	private String numero;
	private String indirizzo;
	private String CF;
	private float paga;
	
	public Persona(String nome, String numero, String indirizzo, String CF, float paga) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.indirizzo = indirizzo;
		this.CF = CF;
		this.paga = paga;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", numero=" + numero + ", indirizzo=" + indirizzo + ", CF=" + CF + "]";
	}
	
	public float getPaga() {
		return this.paga;
	}

	public String getCF() {
		return this.CF;
	}

	
	
	
	
	

}