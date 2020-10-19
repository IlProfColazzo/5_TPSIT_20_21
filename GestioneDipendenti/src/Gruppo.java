import java.util.ArrayList;
import java.util.TreeMap;

public class Gruppo {

	private String nome;
	private String slogan;
	private ArrayList<Persona> membri;
	private TreeMap<String, Persona> mappaMembri;
	
	
	public Gruppo(String nome, String slogan) {
		super();
		this.nome = nome;
		this.slogan = slogan;
		this.membri = new ArrayList<Persona>();
		this.mappaMembri = new TreeMap<String, Persona>();
	}
	
	public void addMembro(Persona p) {
		this.membri.add(p); //aggiungo nella lista
		this.mappaMembri.put(p.getCF(), p); //aggiungo nella mappa
	}
	
	public void removeMembro(String CF) {
		boolean trovato = false;
		for(int i=0;i<this.membri.size() && trovato == false;i++) {
			if(CF.compareTo(this.membri.get(i).getCF())==0) {
				this.membri.remove(i);
				trovato = true;
			}
		}
	}
	
	public void removeMembroFromMappa(String CF) {
		this.mappaMembri.remove(CF);
	}
	
	public float calcolaPaga() {
		float paga = 0;
		for(Persona p : this.mappaMembri.values()) {
			paga += p.getPaga();
		}
		return paga;
	}
	
	
}