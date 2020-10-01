import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Auto a = new Auto("GF999RT", "nero", 123456);
		
		System.out.println("Ho creato l'oggetto Auto: ");

		/*Stampa utilizzando una formattazione a scelta dello sviluppatore della classe MainClass*/
		System.out.println(a.getColore() + " " + a.getMatricola() + " " + a.getTarga());
		/*Stampa utilizzando l'Override del metodo toString della classe Object nella classe Auto*/
		/*La classe Auto viene fornita del metodo toString che restiuisce una stringa rappresentativa
		dell'oggetto stesso*/
		System.out.println(a.toString());
		
		/*Creazione di un nuovo oggetto Auto. Se si scrivesse 
		a= new Auto(......);
		si perderebbe il riferimento all'auto nera creata precentemente.
		Il garbage collector pulirebbe la zona di memoria dell'auto nera.
		*/
		Auto a1 = new Auto("GT986VG", "rosso", 123457);
		System.out.println(a1.toString());
		
		/*Creazione di una lista in grado di contenere oggetti di classe Auto*/
		ArrayList<Auto> automobili = new ArrayList<>();
		/*Creazione di 10 auto con un numero di targa e di telaio ogni volta diverso.
		La prima auto avrà targa GF0RT e telaio 0
		La seconda auto avrà targa GF1RT e telaio 1
		...
		Ogni volta che un'auto viene creata, il suo riferimento viene memorizzato all'interno 
		della lista.*/
		Auto tmp = null;
		for(int i =0 ; i<10;i++) {
			tmp = new Auto("GF"+i+"RT", "nero", i);
			automobili.add(tmp);
		}
		
		/*Primo metodo per stampare gli elementi di una lista: funziona solo se all'interno
		della classe auto è stato ridefinito il metodo toString*/
		System.out.println(automobili.toString());
		/*Secondo metodo per stampare gli elementi di una lista: funziona anche se all'interno
		della classe auto non è stato ridefinito il metodo toString.*/
		for(int i=0;i<automobili.size();i++)
			System.out.println(automobili.get(i).getColore() + " " + automobili.get(i).getMatricola() + " " + automobili.get(i).getTarga());
		

	}

}