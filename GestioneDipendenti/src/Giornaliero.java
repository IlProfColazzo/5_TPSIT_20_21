
public class Giornaliero extends Dipendente{
	
	private int giornate;
	
	public Giornaliero(String nome, String numero, String indirizzo, String CF, float paga, int giornate) {
		super(nome, numero, indirizzo, CF, paga);
		this.giornate = giornate;
	}
	
	public float getPaga() {
		float stipendio = this.giornate * super.getPaga();
		this.giornate = 0;
		return stipendio;
	}
	
	public void setGiornate(int giornate) {
		this.giornate = giornate;
	}

	

}
