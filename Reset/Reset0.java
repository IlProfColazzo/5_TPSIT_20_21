import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Reset0 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//esercizio1();
		//esercizio2();
		//esercizio3();
		//esercizio4();
		//esercizio5();
		esercizio6();
			
	}
	
	/**Scrivere un metodo che legge da tastiera due valori reali e stampi a video:
		� la somma;
		� il valore assoluto della differenza;
		� il valore pi� grande dei numeri inseriti;
		� la media.
	*/
	
	public static void esercizio1() {
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
			System.out.println("Il valore pi� grande e' "+var1);
		}
		else if(var1 == var2) {
			System.out.println("I valori sono uguali");
		}
		else {
			System.out.println("Il valore pi� grande e' "+var2);
		}
		
		float media = (var1 + var2) /2 ;
		System.out.println("La media e' "+media);
		
		
	}
	
	/**Date in input le lunghezze di tre segmenti, scrivere un metodo che permetta di definire se i tre segmenti
	possono costituire un triangolo. Specificare anche il tipo di triangolo: isoscele, equilatero, scaleno.
	Tre segmenti formano un triangolo se ciascuno � minore della somma degli altri due e maggiore della loro
	differenza.*/
	
	public static void esercizio2() {
		
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
						System.out.println("Il triangolo � equilatero");
					else if (lato1 != lato2 && lato1 != lato3 && lato2!=lato3)
						System.out.println("Il triangolo � scaleno");
					else
						System.out.println("Il triangolo � isoscele");
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
	
	
	/**Scrivere un metodo che permette di acquisire i valori di un vettore di lunghezza definita dall�utente e stampi
	a video:
	� la somma di tutti gli elementi;
	� il valore pi� grande;
	� il valore pi� piccolo;
	� se i numeri contenuti nel vettore costituiscono una serie palindroma.
	
	i topi non avevano nipoti
	
	*/
	public static void esercizio3() {
		
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
			System.out.println("Il vettore � palindromo");
		}
		else {
			System.out.println("Il vettore non � palindromo");
		}
		
		
	}
	

	/**Esercizio 4
	Scrivere un metodo che permette di acquisire i valori di una matrice quadrata NxN (N � definita dall�utente).
	Il metodo deve:
	� per ogni riga stampare la somma di tutta gli elementi;
	� per ogni colonna stampare la somma di tutta gli elementi;
	� stampare un messaggio che indica se la matrice � un quadrato magico.
	Un quadrato magico � una disposizione di numeri interi in forma di tabella quadrata in cui siano rispettate
	due condizioni: i valori siano tutti distinti tra loro e la somma dei numeri presenti in ogni riga, in ogni colonna,
	e in entrambe le diagonali, dia sempre lo stesso risultato.
	*/
	public static void esercizio4() {
		
		System.out.println("Inserisci il numero di righe/colonne: ");
		Scanner tastiera = new Scanner(System.in);
		
		int dim = tastiera.nextInt();
		
		int mat[][] = new int[dim][dim]; //il primo dim si riferisce alla righe, il secondo alle colonne
		int somme[] = new int[(dim*2)+2]; //dichiaro un vettore che conterr� tutte le somme
		int i_somma=0;
		
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				System.out.println("Inserisci il valore: ");
				mat[i][j] = tastiera.nextInt();
			}
		}
		
		/*for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}*/
		int somma = 0;
		for(int i=0; i<dim; i++) {
			somma = 0;
			for(int j=0; j<dim; j++) {
				somma = somma + mat[i][j];
			}
			System.out.println("La somma sulla riga "+i+" vale "+somma);
			somme[i_somma] = somma;
			i_somma++;
		}
		
		somma = 0;
		for(int j=0; j<dim; j++) {
			somma = 0;
			for(int i=0; i<dim; i++) {
				somma = somma + mat[i][j];
			}
			System.out.println("La somma sulla colonna "+j+" vale "+somma);
			somme[i_somma] = somma;
			i_somma++;
		}
		
		somma = 0;
		for(int i=0; i<dim; i++) {
			somma = somma + mat[i][i];
		}
		System.out.println("La somma sulla diagonale principale vale "+somma);
		somme[i_somma] = somma;
		i_somma++;
		
		somma = 0;
		for(int i=0; i<dim; i++) {
			somma = somma + mat[i][dim-1-i];
		}
		System.out.println("La somma sulla diagonale secondaria vale "+somma);
		somme[i_somma] = somma;
		i_somma++;
		
		for(int i=0;i<somme.length;i++) {
			System.out.println("Elemento " + i +": " + somme[i]);
		}
		
		boolean magico = true;
		for(int i=0;i<somme.length-1 && magico == true;i++) {
			if(somme[i]!=somme[i+1])
				magico = false;
		}
		
		if(magico==true) {
			System.out.println("Il quadrato � magico");
		}
		else {
			System.out.println("Il quadrato non � magico");
		}
		
		
	}
	

	/**Esercizio 5
	Scrivere un metodo che permetta di contare all�interno di un file di testo:
	� il numero di occorrenze di una parola fornita in input dall�utente;
	� Il numero di occorrenze di ogni singolo carattere dell�alfabeto senza distinzione tra lettere maiuscole
	e minuscole.
	Si supponga che il file abbia una sola parola per riga.
	 * @throws FileNotFoundException 
	*/
	
	public static void esercizio5() throws FileNotFoundException {
		
		System.out.println("Dammi la parola da ricercare: ");
		Scanner tastiera = new Scanner(System.in);
		String toFind = tastiera.nextLine(); //Stringa da ricercare nel file
		int occ[] = new int [26];
		
		
		File fileIn = new File("input.txt");
		Scanner myReader = new Scanner(fileIn);
		int cnt = 0;
		int cntch = 0;
		 while (myReader.hasNextLine()) { //finch� ci sono righe nel file
	        String data = myReader.nextLine();  //leggi l'intera riga e mettila in data
	        if(toFind.compareTo(data)==0) //compareTo torna 0 se toFind � uguale a data
	        	cnt++;
        	for(int i=0; i< data.length(); i++) { //per ogni carattere della parola
        		char ch =  Character.toLowerCase(data.charAt(i));
        		occ[ch - 97]++; //utilizzo il codice ascii del carattere e sottraendo 97 ottengo l'indice del vettore delle occ.
        		
        	}
	      }
		 myReader.close(); //permette di chiudere il file
		 System.out.println("La parola " + toFind + " compare " + cnt + " volte");
		 for(int i=0; i<occ.length;i++) {
			 System.out.println("Il carattarere " + (char)(i+97) + " compare " + occ[i] + " volte.");
		 }
		
	}
	
	
	/**Esercizio 6
	Scrivere un metodo che permetta di analizzare i vicini di una cella di una matrice. 
	I valori della matrice sono contenuti all�interno di un file di testo in cui:
		� sulla prima riga sono contenuti due interi che indicano il numero di righe N e il numero di colonne M della matrice
		� nelle N righe successive sono contenuti i valori (interi) di ogni riga della matrice. 
	Ogni valore � separato da uno spazio.
	Esempio file.txt
	
	3 7
	1  2  3  4  5  6  7
	8  9  40 11 12 13 14
	15 16 17 18 19 20 34
	
	Il metodo dovr� individuare tutte le celle che hanno come valore la somma dei valori dei propri vicini.
	Esempio:
		la cella con indici 1 2 � valida. (17 + 9 + 3 + 11 = 40)
		la cella con indici 2 6 � valida. (20 + 14 = 34)
	*/
	
	public static void esercizio6() {
		//TODO
	}
	
}
