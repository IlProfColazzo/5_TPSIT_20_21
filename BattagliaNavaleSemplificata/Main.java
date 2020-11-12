import java.io.*;
import java.util.Scanner;

/**
* Soluzione a cura di 
* @author Arcano Francesco
*/

public class Main {
	private static int d=10; //dimensione fissa della matrice
	/**Funzione per l'inserimento della mappa
	 * @param mappa
	 */
	public static void inserimento(char[][] mappa) {
		
		FileReader f=null;
		BufferedReader fIn=null;
		
		try {
			f=new FileReader("Navi.txt");
			fIn=new BufferedReader(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//i per le righe
		//j per le colonne
		for (int i=0; i<d; i++) {
			String s=null;
			try {
				s = fIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}//end try-catch
			for(int j=0; j<d; j++)
				mappa[i][j]  = s.charAt(j);
		}//end for
		
	}//end inserimento
	
	
	/**Funzione per la stampa della mappa del giocatore
	 * @param mappaGiocatore
	 */
	public static void stampaMappa(char[][] mappaGiocatore) {
		System.out.println("\n\nSTAMPO LA MAPPA:\n");
		for(int i=0; i<d; i++) {
			for(int j=0; j<d; j++)
				System.out.print(mappaGiocatore[i][j]);
			System.out.println();
		}
	}//end stampaMappa
	
	public static boolean controlloNotAffondata(char[][] mappa, int row, int col) {
		if(mappa[row][col]!='X') {
			return true;
		}//end if
		return false;
	}//end controlloNotAffondata
	
	
	/**Funzione per controllare se una nave è affondata o meno
	 * Non sono sicuro funzioni, non ho avuto il tempo di testarla.
	 */
	public static void affondata(char[][] mappa, int row, int col) {
		
		boolean flag=false;
		
		for(int i=0; i<4 && mappa[row+i+1][col]!='A' && row<d-1; i++){
			//controllo righe avanti 4
			flag=controlloNotAffondata(mappa, row, col);
			if(flag)
				break;
		}//end for

		for(int i=0; i<4 && mappa[row-i-1][col]!='A' && row>0; i++){
		//controllo righe indietro 4
			flag=controlloNotAffondata(mappa, row, col);
			if(flag)
				break;
		}//end for

		for(int i=0; i<4 && mappa[row][col+i+1]!='A' && col<d-1; i++){
		//controllo colonne sotto 4
			flag=controlloNotAffondata(mappa, row, col);
			if(flag)
				break;
		}//end for

		for(int i=0; i<4 && mappa[row][col-i-1]!='A' && col>0; i++){
		//controllo colonno sopra 4
			flag=controlloNotAffondata(mappa, row, col);
			if(flag)
				break;
		}//end for
		
		if(!flag)
			System.out.println("Colpito e affondato");
		
	}//end affondata
	
	public static void mossa(char[][] mappa, char[][] mappaGiocatore) {
		Scanner in= new Scanner(System.in);
		int col=0, row=0;
		do {
			System.out.print("Inserisci le coordinate della cella.\nInserisci la colonna: ");
			col= in.nextInt();
			System.out.print("Inserisci la riga: ");
			row=in.nextInt();
		}while(row>11||col>11||row<0||col<0);
		
		row--;
		col--;
		
		if(mappa[row][col]=='X') {
			mappaGiocatore[row][col]='C';
			mappa[row][col]='C';
			System.out.println("Hai colpito la nave.");
			stampaMappa(mappaGiocatore);
			
			affondata(mappa, row, col);
			mossa(mappa, mappaGiocatore); //ricorsività
			
		}
		else if(mappa[row][col]=='C') {
			System.out.println("Hai già colpito questa cella. Ritenta.");
			stampaMappa(mappaGiocatore);
			mossa(mappa, mappaGiocatore); //ricorsività
		}
		else {
			mappaGiocatore[row][col]='A';
			System.out.println("Acqua. Ritenta.");
			stampaMappa(mappaGiocatore);
		}
		
		
	}//end mossa
	
	public static void main(String[] args) {
		
		
		char mappa[][] = new char[10][10];
		char mappaGiocatore[][] = new char[10][10];
		int flag=0;
		inserimento(mappa);
		
		for(int i=0; i<d; i++)
			for(int j=0; j<d; j++)
				mappaGiocatore[i][j]=' ';
		
		stampaMappa(mappaGiocatore);
		
		while(mappa!=mappaGiocatore&&flag++!=30)
			mossa(mappa, mappaGiocatore);
		
		if(mappa==mappaGiocatore)
			System.out.println("Hai vinto!");
		else
			System.out.println("Hai perso");
		
		
	}//end main

}//end Main