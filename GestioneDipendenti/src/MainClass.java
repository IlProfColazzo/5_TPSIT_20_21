public class MainClass {

	public static void main(String[] args) {
		
		
		Gruppo g = new Gruppo("5CI", "non facimu nienti");
		
		Volontario v1 = new Volontario("Mario", "3204122", "Corso Torino", "MRA");
		Giornaliero g1 = new Giornaliero("Filippo", "3204122", "Corso Torino", "FLP",5f,5);
		Impiegato i1 = new Impiegato ("Luca", "3204122", "Corso Torino", "LCA",1500f,50f);
		
		g.addMembro(i1);
		g.addMembro(v1);
		g.addMembro(g1);
		
		System.out.println("La spesa e': "+ g.calcolaPaga());
		
		
	}

}