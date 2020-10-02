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
		
		//ArrayList<Object> obj = new ArrayList<Object>();
		
	
	}
}
