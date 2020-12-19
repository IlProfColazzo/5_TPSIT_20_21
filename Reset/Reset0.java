import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reset0 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// esercizio1();
		// esercizio2();
		// esercizio3();
		// esercizio4();
		// esercizio5();
		//esercizio6();
		esercizioPreProva();

	}

	/**
	 * Scrivere un metodo che legge da tastiera due valori reali e stampi a video: •
	 * la somma; • il valore assoluto della differenza; • il valore più grande dei
	 * numeri inseriti; • la media.
	 */

	public static void esercizio1() {
		float var1, var2;

		Scanner tastiera = new Scanner(System.in);

		System.out.println("Dammi il primo valore:");
		var1 = tastiera.nextFloat(); /// cin<<......
		System.out.println("Dammi il secondo valore:");
		var2 = tastiera.nextFloat();

		float somma = var1 + var2;
		System.out.println("Ecco la somma: " + somma);
		float differenza = var1 - var2;
		System.out.println("Ecco la differenza: " + Math.abs(differenza));

		if (var1 > var2) {
			System.out.println("Il valore più grande e' " + var1);
		} else if (var1 == var2) {
			System.out.println("I valori sono uguali");
		} else {
			System.out.println("Il valore più grande e' " + var2);
		}

		float media = (var1 + var2) / 2;
		System.out.println("La media e' " + media);

	}

	/**
	 * Date in input le lunghezze di tre segmenti, scrivere un metodo che permetta
	 * di definire se i tre segmenti possono costituire un triangolo. Specificare
	 * anche il tipo di triangolo: isoscele, equilatero, scaleno. Tre segmenti
	 * formano un triangolo se ciascuno è minore della somma degli altri due e
	 * maggiore della loro differenza.
	 */

	public static void esercizio2() {

		float lato1, lato2, lato3;

		Scanner tastiera = new Scanner(System.in);
		System.out.println("Dammi il primo lato");
		lato1 = tastiera.nextFloat();
		System.out.println("Dammi il secondo lato");
		lato2 = tastiera.nextFloat();
		System.out.println("Dammi il terzo lato");
		lato3 = tastiera.nextFloat();

		if (lato1 < lato2 + lato3 && lato1 > lato2 - lato3) {
			if (lato2 < lato1 + lato3 && lato2 > lato1 - lato3) {
				if (lato3 < lato1 + lato2 && lato3 > lato1 - lato2) {
					System.out.println("Il triangolo esiste");
					if (lato1 == lato2 && lato1 == lato3)
						System.out.println("Il triangolo è equilatero");
					else if (lato1 != lato2 && lato1 != lato3 && lato2 != lato3)
						System.out.println("Il triangolo è scaleno");
					else
						System.out.println("Il triangolo è isoscele");
				} else {
					System.out.println("Il triangolo non esiste");
				}
			} else {
				System.out.println("Il triangolo non esiste");
			}
		} else {
			System.out.println("Il triangolo non esiste");
		}
	}

	/**
	 * Scrivere un metodo che permette di acquisire i valori di un vettore di
	 * lunghezza definita dall’utente e stampi a video: • la somma di tutti gli
	 * elementi; • il valore più grande; • il valore più piccolo; • se i numeri
	 * contenuti nel vettore costituiscono una serie palindroma.
	 * 
	 * i topi non avevano nipoti
	 * 
	 */
	public static void esercizio3() {

		System.out.println("Inserisci la dimensione del vettore:");
		Scanner tastiera = new Scanner(System.in);
		int dim = tastiera.nextInt();

		int vett[] = new int[dim];

		for (int i = 0; i < dim; i++) {
			System.out.println("Dammi il valore: ");
			vett[i] = tastiera.nextInt();
		}

		for (int i = 0; i < dim; i++) {
			System.out.println("Elemento " + i + " = " + vett[i]);
		}

		int somma = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < dim; i++) {
			somma = somma + vett[i];
			if (max < vett[i]) {
				max = vett[i];
			}
			if (min > vett[i]) {
				min = vett[i];
			}
		}
		System.out.println("Il valore della somma e': " + somma);
		System.out.println("Il valore minimo e': " + min);
		System.out.println("Il valore massimo e': " + max);

		boolean palindroma = true;
		for (int i = 0; i < dim / 2 && palindroma == true; i++) {
			if (vett[i] != vett[dim - i - 1]) {
				palindroma = false;
			}
		}
		if (palindroma == true) {
			System.out.println("Il vettore è palindromo");
		} else {
			System.out.println("Il vettore non è palindromo");
		}

	}

	/**
	 * Esercizio 4 Scrivere un metodo che permette di acquisire i valori di una
	 * matrice quadrata NxN (N è definita dall’utente). Il metodo deve: • per ogni
	 * riga stampare la somma di tutta gli elementi; • per ogni colonna stampare la
	 * somma di tutta gli elementi; • stampare un messaggio che indica se la matrice
	 * è un quadrato magico. Un quadrato magico è una disposizione di numeri interi
	 * in forma di tabella quadrata in cui siano rispettate due condizioni: i valori
	 * siano tutti distinti tra loro e la somma dei numeri presenti in ogni riga, in
	 * ogni colonna, e in entrambe le diagonali, dia sempre lo stesso risultato.
	 */
	public static void esercizio4() {

		System.out.println("Inserisci il numero di righe/colonne: ");
		Scanner tastiera = new Scanner(System.in);

		int dim = tastiera.nextInt();

		int mat[][] = new int[dim][dim]; // il primo dim si riferisce alla righe, il secondo alle colonne
		int somme[] = new int[(dim * 2) + 2]; // dichiaro un vettore che conterrà tutte le somme
		int i_somma = 0;

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.println("Inserisci il valore: ");
				mat[i][j] = tastiera.nextInt();
			}
		}

		/*
		 * for(int i=0; i<dim; i++) { for(int j=0; j<dim; j++) {
		 * System.out.print(mat[i][j] + " "); } System.out.println(); }
		 */
		int somma = 0;
		for (int i = 0; i < dim; i++) {
			somma = 0;
			for (int j = 0; j < dim; j++) {
				somma = somma + mat[i][j];
			}
			System.out.println("La somma sulla riga " + i + " vale " + somma);
			somme[i_somma] = somma;
			i_somma++;
		}

		somma = 0;
		for (int j = 0; j < dim; j++) {
			somma = 0;
			for (int i = 0; i < dim; i++) {
				somma = somma + mat[i][j];
			}
			System.out.println("La somma sulla colonna " + j + " vale " + somma);
			somme[i_somma] = somma;
			i_somma++;
		}

		somma = 0;
		for (int i = 0; i < dim; i++) {
			somma = somma + mat[i][i];
		}
		System.out.println("La somma sulla diagonale principale vale " + somma);
		somme[i_somma] = somma;
		i_somma++;

		somma = 0;
		for (int i = 0; i < dim; i++) {
			somma = somma + mat[i][dim - 1 - i];
		}
		System.out.println("La somma sulla diagonale secondaria vale " + somma);
		somme[i_somma] = somma;
		i_somma++;

		for (int i = 0; i < somme.length; i++) {
			System.out.println("Elemento " + i + ": " + somme[i]);
		}

		boolean magico = true;
		for (int i = 0; i < somme.length - 1 && magico == true; i++) {
			if (somme[i] != somme[i + 1])
				magico = false;
		}

		if (magico == true) {
			System.out.println("Il quadrato è magico");
		} else {
			System.out.println("Il quadrato non è magico");
		}

	}

	/**
	 * Esercizio 5 Scrivere un metodo che permetta di contare all’interno di un file
	 * di testo: • il numero di occorrenze di una parola fornita in input
	 * dall’utente; • Il numero di occorrenze di ogni singolo carattere
	 * dell’alfabeto senza distinzione tra lettere maiuscole e minuscole. Si
	 * supponga che il file abbia una sola parola per riga.
	 * 
	 * @throws FileNotFoundException
	 */

	public static void esercizio5() throws FileNotFoundException {

		System.out.println("Dammi la parola da ricercare: ");
		Scanner tastiera = new Scanner(System.in);
		String toFind = tastiera.nextLine(); // Stringa da ricercare nel file
		int occ[] = new int[26];

		File fileIn = new File("input.txt");
		Scanner myReader = new Scanner(fileIn);
		int cnt = 0;
		int cntch = 0;
		while (myReader.hasNextLine()) { // finchè ci sono righe nel file
			String data = myReader.nextLine(); // leggi l'intera riga e mettila in data
			if (toFind.compareTo(data) == 0) // compareTo torna 0 se toFind è uguale a data
				cnt++;
			for (int i = 0; i < data.length(); i++) { // per ogni carattere della parola
				char ch = Character.toLowerCase(data.charAt(i));
				occ[ch - 97]++; // utilizzo il codice ascii del carattere e sottraendo 97 ottengo l'indice del
								// vettore delle occ.

			}
		}
		myReader.close(); // permette di chiudere il file
		System.out.println("La parola " + toFind + " compare " + cnt + " volte");
		for (int i = 0; i < occ.length; i++) {
			System.out.println("Il carattarere " + (char) (i + 97) + " compare " + occ[i] + " volte.");
		}

	}

	/**
	 * Esercizio 6 Scrivere un metodo che permetta di analizzare i vicini di una
	 * cella di una matrice. I valori della matrice sono contenuti all’interno di un
	 * file di testo in cui: • sulla prima riga sono contenuti due interi che
	 * indicano il numero di righe N e il numero di colonne M della matrice • nelle
	 * N righe successive sono contenuti i valori (interi) di ogni riga della
	 * matrice. Ogni valore è separato da uno spazio. Esempio file.txt
	 * 
	 * 3 7 1 2 3 4 5 6 7 8 9 40 11 12 13 14 15 16 17 18 19 20 34
	 * 
	 * Il metodo dovrà individuare tutte le celle che hanno come valore la somma dei
	 * valori dei propri vicini. Esempio: la cella con indici 1 2 è valida. (17 + 9
	 * + 3 + 11 = 40) la cella con indici 2 6 è valida. (20 + 14 = 34)
	 * @throws FileNotFoundException 
	 */

	public static void esercizio6() throws FileNotFoundException {
		Scanner myReader = new Scanner(new File("file.txt"));		
		int nRighe = myReader.nextInt();
		int nColonne = myReader.nextInt();
		int mat[][] = new int[nRighe][nColonne];
		int somma = 0;
		System.out.println("Dimensione: " + nRighe + " righe e " + nColonne + " colonne");

		for (int i = 0; i < nRighe; i++) {
			for (int j = 0; j < nColonne; j++) {
					mat[i][j] = myReader.nextInt();
			}
		}

		for (int i = 0; i < nRighe; i++) {
			for (int j = 0; j < nColonne; j++) {
				somma = 0;
				if (i < nRighe - 1)
					somma += mat[i + 1][j];
				if (i > 0)
					somma += mat[i - 1][j];
				if (j < nColonne - 1)
					somma += mat[i][j + 1];
				if (j > 0)
					somma += mat[i][j - 1];
				if (somma == mat[i][j]) {
					System.out.println("La cella " + i + " " + j + " è valida");
				} else {
					System.out.println("La cella " + i + " " + j + " non è valida");
				}
			}
		}
				 
	}

	public static void esercizio6Gianfreda() {

		try {

			File file = new File("file");
			Scanner myReader = new Scanner(file);

			int righe = myReader.nextInt();
			int colonne = myReader.nextInt();
			int mat[][] = new int[righe][colonne];


			for (int i = 0; i < righe; i++) {
				for (int j = 0; j < colonne; j++) {
					mat[i][j] = myReader.nextInt();
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}

			myReader.close(); // permette di chiudere il file

			for (int i = 0; i < righe; i++) {
				for (int j = 0; j < colonne; j++) {
					int calcolo = 0;

					if (i == 0 && j == 0) {
						calcolo += mat[i][j + 1] + mat[i + 1][j];
					} else if (i == 0 && j < colonne && j > 0) {
						calcolo += mat[i][j - 1] + mat[i + 1][j] + mat[i][j + 1];
					} else if (i == 0 && j == colonne) {
						calcolo += mat[i + 1][j] + mat[i][j - 1];
					} else if (i > 0 && i < righe && j == 0) {
						calcolo += mat[i][j + 1] + mat[i - 1][j] + mat[i + 1][j];
					} else if (i == 1 && j > 0 && j < colonne) {
						calcolo += mat[i][j + 1] + mat[i + 1][j] + mat[i][j - 1] + mat[i - 1][j];
					} else if (i == 1 && j == colonne) {
						calcolo += mat[i + 1][j] + mat[i - 1][j] + mat[i][j - 1];
					} else if (i == righe && j == 0) {
						calcolo += mat[i - 1][j] + mat[i][j + 1];
					} else if (i == righe && j > 0 && j < colonne) {
						calcolo += mat[i][j - 1] + mat[i - 1][j] + mat[i][j + 1];
					} else if (i == righe - 1 && j == colonne - 1) {
						calcolo += mat[i][j - 1] + mat[i - 1][j];
					}

					if (calcolo == mat[i][j]) {
						System.out.println(mat[i][j] + " è il numero che corrsiponde alla somma dei propri vicini");
					}

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERRORE!!!!!!!");
			e.printStackTrace();
		}
	}

	public static void esercizio6Carissimo() throws FileNotFoundException {

		Scanner myReader = new Scanner(new File("file.txt"));

		int nRighe = myReader.nextInt();
		int nColonne = myReader.nextInt();
		int mat[][] = new int[nRighe][nColonne];
		int somma = 0;
		System.out.println("Dimensione: " + nRighe + " righe e " + nColonne + " colonne");

		for (int i = 0; i < nRighe; i++) {
			for (int j = 0; j < nColonne; j++) {

				try {
					mat[i][j] = myReader.nextInt();

				} catch (java.util.NoSuchElementException e) {
				}
			}
		}

		for (int i = 0; i < nRighe; i++) {
			for (int j = 0; j < nColonne; j++) {
				if (i != 0 && i < nRighe - 1 && j != 0 && j < nColonne - 1) {
					somma = 0;
					somma += mat[i + 1][j];
					somma += mat[i - 1][j];
					somma += mat[i][j + 1];
					somma += mat[i][j - 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}

				}
				if (i == nRighe - 1 && j == 0) {
					somma = 0;
					somma += mat[i - 1][j];
					somma += mat[i][j + 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (i == 0 && j == 0) {
					somma = 0;
					somma += mat[i + 1][j];
					somma += mat[i][j + 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (i == 0 && j == nColonne - 1) {
					somma = 0;
					somma += mat[i + 1][j];
					somma += mat[i][j - 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (i == nRighe - 1 && j == nColonne - 1) {
					somma = 0;
					somma += mat[i - 1][j];
					somma += mat[i][j - 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (i == 0 && j != 0 && j < nColonne - 1) {
					somma = 0;
					somma += mat[i + 1][j];
					somma += mat[i][j + 1];
					somma += mat[i][j - 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (j == 0 && i != 0 && i < nRighe - 1) {
					somma = 0;
					somma += mat[i + 1][j];
					somma += mat[i - 1][j];
					somma += mat[i][j + 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (j == nColonne - 1 && i != 0 && i < nRighe - 1) {
					somma = 0;
					somma += mat[i + 1][j];
					somma += mat[i - 1][j];
					somma += mat[i][j - 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
				if (i == nRighe - 1 && j != 0 && j < nColonne - 1) {
					somma = 0;
					somma += mat[i - 1][j];
					somma += mat[i][j + 1];
					somma += mat[i][j - 1];

					if (somma == mat[i][j]) {
						System.out.println("La cella " + i + " " + j + " è valida");
					} else {
						System.out.println("La cella " + i + " " + j + " non è valida");
					}
				}
			}
		}
	}
	
	public static void esercizio6Lezzi() throws Exception{
		try {
			FileReader fr = new FileReader("matrice.txt");
			BufferedReader fIN = new BufferedReader(fr);

			StringTokenizer st;
			String s = fIN.readLine(); // Legge la prima riga

			st = new StringTokenizer(s, " ");

			int righe = Integer.parseInt(st.nextToken());
			int colonne = Integer.parseInt(st.nextToken());

			int matrice[][] = new int[righe][colonne];

			s = fIN.readLine();
			int j = 0, i = 0;

			while (s != null) {
				st = new StringTokenizer(s, " ");

				j = 0;
				while (st.hasMoreTokens()) {
					matrice[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}

				s = fIN.readLine(); // Legge la riga successiva
				i++;
			}

			System.out.println("MATRICE :");

			for (i = 0; i < righe; i++) {
				for (j = 0; j < colonne; j++) {
					System.out.print(matrice[i][j] + " ");
				}
				System.out.println();
			}

			fr.close();
			int somma = 0;

			for (i = 0; i < righe; i++) {
				for (j = 0; j < colonne; j++) {
					somma = 0;
					try {
						somma = somma + matrice[i + 1][j];
					} catch (ArrayIndexOutOfBoundsException e) {
						somma = somma + 0;
					}

					try {
						somma = somma + matrice[i - 1][j];
					} catch (ArrayIndexOutOfBoundsException e) {
						somma = somma + 0;
					}

					try {
						somma = somma + matrice[i][j + 1];
					} catch (ArrayIndexOutOfBoundsException e) {
						somma = somma + 0;
					}

					try {
						somma = somma + matrice[i][j - 1];
					} catch (ArrayIndexOutOfBoundsException e) {
						somma = somma + 0;
					}

					if (somma == matrice[i][j])

						System.out.println("La cella " + " " + i + " " + j + " della matrice è valida!!");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 	La conformazione di un fondale marino è memorizzata in una mappa di dimensioni NxN. 
	  	La mappa descrive la profondità in metri nel range 0 – 5000 metri. N è definita dall’utente tramite input da tastiera. 
	  	Gli interi che costituiscono la mappa sono separati da uno spazio.

		Scrivere un programma in Java per verificare eventuali variazioni del fondale dovuti ad eruzioni laviche marine e/o a spostamento tettonico. 
		A tal proposito si assuma di avere a disposizione due files di testo Map1.txt e Map2.txt contenenti le profondità del fondale scattate a 36 mesi di distanza l’una dall’altra. 
		Il programma legge da tastiera 3 interi. I primi due rappresentano le coordinate del centro di un quadrato di dimensioni MxM all’ interno della mappa, il terzo rappresenta il valore di M (si assuma M dispari e minore di N). 
		Si faccia l’assunzione che il quadrato di interesse definito dall’utente sia interamente contenuto nella mappa. (Non è necessario controllare i bordi)
		
		In caso di effettiva variazione, il programma deve:
		1.	stampare a video le coordinate dei punti all’ interno del quadrato di interesse e le corrispondenti percentuali di variazione solo in caso siano diverse da zero.
		2.	nel caso tutti i punti all’ interno del quadrato di interesse abbiano subito lo stesso tipo di variazione (verso l’alto o verso il basso) ma non necessariamente della stessa quantità, stampare a video il messaggio “SPOSTAMENTO TETTONICO” senza indicare le percentuali.
		Esempio (N=6)
		Map1.txt		
		1200 1205 1213 1220	1225 999   
		1240 1225 1120 1130	1164 1110
		1320 1230 1011 963  1102 1017
		1410 1340 1100 940  1010 960
		1501 1345 1204 923  1002 1001
		1507 1370 1230 1100	1001 901	
		Map2.txt (es.1)
		1200 1205 1213 1220	1225 999   
		1240 1225 1120 1130	1164 1110
		1320 1230 1011 963  1102 1017
		1410 1340 1100 940  1010 960
		1522 1352 1150 923  1002 1001
		1537 1380 1245 1100	1001 901	
		Map2.txt (es.2)
		1200 1205 1213 1220	1225 999   
		1240 1225 1120 1130	1164 1110
		1320 1230 1011 963  1102 1017
		1310 1240 1000 940  1010 960
		1401 1245 1104 923  1002 1001
		1407 1270 1130 1100	1001 901
		
		Es.1: Il programma stampa a video le seguenti informazioni. In questo  caso N=6, M = 3 e il centro della matrice MxM ha coordinate 4 1
		
		4,0:  1.40%
		4,1:  0.52%
		4,2:  -4.49%
		5,0:  1.99%
		5,1:  0.73%
		5,2:  1.22%

		Es.2: Il programma stampa a video le seguenti informazioni. In questo  caso N=6, M = 3 e il centro della matrice MxM ha coordinate 4 1
		
		3,0:  -7.09%
		3,1:  -7.46%
		3,2:  -9.09%
		4,0:  -6.66%
		4,1:  -7.43%
		4,2:  -8.31%
		5,0:  -6.64%
		5,1:  -7.30%
		5,2:  -8.13%
		SPOSTAMENTO TETTONICO

	  **/
	
	public static void esercizioPreProva() throws FileNotFoundException {
		Scanner myReaderMap1 = new Scanner(new File("Map1.txt"));
		Scanner myReaderMap2 = new Scanner(new File("Map2.txt"));
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Dammi la dimensione della matrice:");
		int N = tastiera.nextInt(); 
		int map1[][] = new int[N][N];
		int map2[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
					map1[i][j] = myReaderMap1.nextInt();
					map2[i][j] = myReaderMap2.nextInt();
			}
		}
		myReaderMap1.close();
		myReaderMap2.close();
		System.out.println("Dammi x0 (coordinata del centro):");
		int x0 = tastiera.nextInt();
		System.out.println("Dammi y0 (coordinata del centro):");
		int y0 = tastiera.nextInt();
		System.out.println("Dammi M (dimensione della sottomatrice):");
		int M = tastiera.nextInt();
		float diff = 0;
		int istart=x0-M/2;
		int jstart=y0-M/2;
		boolean up = true;
		boolean down = true;
		for (int i = istart; i < istart+M; i++) {
			for (int j = jstart; j < jstart+M; j++) {
				diff = (float)(map2[i][j]*100)/map1[i][j] - 100;
				if (diff != 0) {
					System.out.println(i+","+j+": "+diff+"%");
					if(diff<0)
						up = false;
					else
						down = false;
				}
			}
		}
		if(up==true ||down==true) {
			System.out.println("SPOSTAMENTO TETTONICO");
		}
		tastiera.close();
				 
	}

}
