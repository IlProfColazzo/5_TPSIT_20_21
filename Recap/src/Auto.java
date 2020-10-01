public class Auto {
	
	private String targa;
	private String colore;
	private int matricola;
	
	public Auto(String targa, String colore, int matricola) {
		this.targa = targa;
		this.colore = colore;
		this.matricola = matricola;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	/*Metodo autogenerato*/
	/*@Override
	public String toString() {
		return "Auto [targa=" + targa + ", colore=" + colore + ", matricola=" + matricola + "]";
	}*/
	
	/*Metodo autogenerato e personalizzato in funzione delle esigenze del programmatore*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.colore + " " + this.matricola + " " + this.targa;
	}
	
	

}