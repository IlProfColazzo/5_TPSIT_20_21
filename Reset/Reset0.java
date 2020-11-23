import java.util.Scanner;

public class Reset0 {

	public static void main(String[] args) {
		esercizio1();
		esercizio2();
		esercizio3();
			
	}
	
	/**Esercizio 1
	Scrivere un metodo che legge da tastiera due valori reali e stampi a video:
		• la somma;
		• il valore assoluto della differenza;
		• il valore più grande dei numeri inseriti;
		• la media.
	*/
	
	public static void esercizio1() {
		System.out.println("#####ESERCIZIO 1#####");
		float var1, var2;
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Dammi il primo valore:");
		var1 = tastiera.nextFloat(); ///cin<<......
		System.out.println("Dammi il secondo valore:");
		var2 = tastiera.nextFloat();
		
		float somma = var1 + var2;
		System.out.println("Ecco la somma: "+somma);		
		float differenza = var1 - var2;
		System.out.println("Ecco la differenza: "+Math.abs(differenza));
		
		if(var1 > var2) {
			System.out.println("Il valore più grande e' "+var1);
		}
		else if(var1 == var2) {
			System.out.println("I valori sono uguali");
		}
		else {
			System.out.println("Il valore più grande e' "+var2);
		}
		
		float media = (var1 + var2) /2 ;
		System.out.println("La media e' "+media);
		
		
	}
	
	/**Esercizio 2
	Date in input le lunghezze di tre segmenti, scrivere un metodo che permetta di definire se i tre segmenti
	possono costituire un triangolo. Specificare anche il tipo di triangolo: isoscele, equilatero, scaleno.
	Tre segmenti formano un triangolo se ciascuno è minore della somma degli altri due e maggiore della loro
	differenza.*/
	
	public static void esercizio2() {
		System.out.println("#####ESERCIZIO 2#####");
		
		float lato1, lato2, lato3;
		
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Dammi il primo lato");
		lato1 = tastiera.nextFloat();
		System.out.println("Dammi il secondo lato");
		lato2 = tastiera.nextFloat();
		System.out.println("Dammi il terzo lato");
		lato3 = tastiera.nextFloat();
		
		if(lato1 < lato2 + lato3 && lato1 > lato2-lato3) {
			if(lato2 < lato1 + lato3 && lato2 > lato1-lato3) {
				if(lato3 < lato1 + lato2 && lato3 > lato1-lato2) {
					System.out.println("Il triangolo esiste");
					if(lato1 == lato2 && lato1 == lato3)
						System.out.println("Il triangolo è equilatero");
					else if (lato1 != lato2 && lato1 != lato3 && lato2!=lato3)
						System.out.println("Il triangolo è scaleno");
					else
						System.out.println("Il triangolo è isoscele");
				}
				else {
					System.out.println("Il triangolo non esiste");
				}
			}
			else {
				System.out.println("Il triangolo non esiste");
			}
		}
		else {
			System.out.println("Il triangolo non esiste");
		}
	}
	
	
	/**Esercizio 3
	Scrivere un metodo che permette di acquisire i valori di un vettore di lunghezza definita dall’utente e stampi
	a video:
	• la somma di tutti gli elementi;
	• il valore più grande;
	• il valore più piccolo;
	• se i numeri contenuti nel vettore costituiscono una serie palindroma.
	
	i topi non avevano nipoti
	
	*/
	public static void esercizio3() {
		System.out.println("#####ESERCIZIO 3#####");
		System.out.println("Inserisci la dimensione del vettore:");
		Scanner tastiera = new Scanner(System.in);
		int dim = tastiera.nextInt();
		
		int vett[] = new int[dim];
		
		for(int i=0; i<dim; i++) {
			System.out.println("Dammi il valore: ");
			vett[i] = tastiera.nextInt();
		}
		
		for(int i=0; i<dim; i++) {
			System.out.println("Elemento " + i + " = " + vett[i]);
		}
		
		int somma = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<dim; i++) {
			somma = somma + vett[i];
			if(max < vett[i]) {
				max = vett[i];
			}
			if(min > vett[i]) {
				min = vett[i];
			}
		}
		System.out.println("Il valore della somma e': "+somma);
		System.out.println("Il valore minimo e': "+min);
		System.out.println("Il valore massimo e': "+max);
		
		boolean palindroma = true;
		for(int i=0; i<dim/2 && palindroma == true; i++) {
			if(vett[i]!=vett[dim-i-1]) {
				palindroma = false;
			}
		}
		if(palindroma == true) {
			System.out.println("Il vettore è palindromo");
		}
		else {
			System.out.println("Il vettore non è palindromo");
		}		
	}
	
	/**Esercizio 4
	Scrivere un metodo che permette di acquisire i valori di una matrice quadrata NxN (N è definita dall’utente).
	Il metodo deve:
	• per ogni riga stampare la somma di tutta gli elementi;
	• per ogni colonna stampare la somma di tutta gli elementi;
	• stampare un messaggio che indiche se la matrice è un quadrato magico.
	Un quadrato magico è una disposizione di numeri interi in forma di tabella quadrata in cui siano rispettate
	due condizioni: i valori siano tutti distinti tra loro e la somma dei numeri presenti in ogni riga, in ogni colonna,
	e in entrambe le diagonali, dia sempre lo stesso risultato.
	*/


	/**Esercizio 5
	Scrivere un metodo che permetta di contare all’interno di un file di testo:
	• il numero di occorrenze di una parola fornita in input dall’utente;
	• Il numero di occorrenze di ogni singolo carattere dell’alfabeto senza distinzione tra lettere maiuscole
	e minuscole.
	Si supponga che il file abbia una sola parola per riga.
	*/
	

}
