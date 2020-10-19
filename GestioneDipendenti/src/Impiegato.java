public class Impiegato extends Dipendente{

	private float bonus;
	
	public Impiegato(String nome, String numero, String indirizzo, String CF, float paga, float bonus) {
		super(nome, numero, indirizzo, CF, paga);
		this.bonus = bonus;
	}
	
	public float getPaga() {
		float stipendio = this.bonus + super.getPaga();
		this.bonus= 0;
		return stipendio;
	}
	
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	
	
}