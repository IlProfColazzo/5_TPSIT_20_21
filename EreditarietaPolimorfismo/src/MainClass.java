import java.util.ArrayList;

public class MainClass {
  
	public static void main(String[] args) {
	
		Persona p = new Persona("Luca", "Giurato", "GRTLCA");
		Studente st = new Studente("Daniele", "Pizzi", "PZZDNL", 3.25f);
		Docente doc = new Docente("Andrea", "Colazzo", "CLZNDR", 1100);
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(st);
		lista.add(doc);
		lista.add(p);
		
		/*p.getQualifica();
		st.getQualifica();
		doc.getQualifica();*/
		
		for(Persona tmp : lista) {
			tmp.getQualifica();
			/*Utilizzo del polimorfismo: 
			 * Java è in grado di riconoscere il tipo
			 * dell'oggetto contenuto nel rifermineto tmp e di
			 * conseguenza invocare il metodo opportuno*/
		}
			
	}
}
