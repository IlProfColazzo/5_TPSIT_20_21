import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
* Soluzione a cura di 
* @author Scorrano Jacopo
*/

public class MainScorrano {

	public static void main(String[] args) {
		
		char casella;
		char mappa[][] = new char[10][10];
		int i=0, j=0;
		
		//lettura file e assegnazione caratteri file alla matrice
		try {
			File file = new File("mappa.txt");
		    Scanner myReader = new Scanner(file);
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	for(j=0; j<data.length(); j++) {
		    		casella = data.charAt(j);
		    		mappa[i][j] = casella;
		    	}
		    	i+=1;
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File not found.");
		    e.printStackTrace();
		}
		
		//stampa del tabellone contenuto nella matrice
		System.out.println("*****TABELLONE*****");
		for(i=0; i<10; i++) {
			for(j=0; j<10; j++) {
				System.out.print(mappa[i][j]+" ");
		    }
			System.out.println("");
		}
		
		System.out.println("--------------------");
		
		
		
		
		
		
		
		
		Scanner tastiera = new Scanner(System.in);
		int rigaSparo, colonnaSparo, n, c=0, tot=0;
		boolean trovato = false;
		
		
		do {
			System.out.println("A quale riga vuoi sparare?");
			rigaSparo = tastiera.nextInt();
			System.out.println("A quale colonna vuoi sparare?");
			colonnaSparo = tastiera.nextInt();
			
			if(mappa[rigaSparo][colonnaSparo] == 'a')	System.out.println("Acqua!!!");
			else  {
				n=0;
				if(mappa[rigaSparo][colonnaSparo] == 'n') {
					
					for(int k=0; k>=-3; k--) {
						try {
							if(mappa[rigaSparo+k][colonnaSparo] == 'n') {
								n++;
							}else { 
								if(mappa[rigaSparo+k][colonnaSparo] == 'a'){
									break;
								}
							}
						}catch(ArrayIndexOutOfBoundsException e) {
							break;
						}
					}
					for(int k=1; k<=3; k++) {
						try {
							if(mappa[rigaSparo+k][colonnaSparo] == 'n') {
								n++;
							}else {
								if(mappa[rigaSparo+k][colonnaSparo] == 'a'){
									break;
								}
							}
						}catch(ArrayIndexOutOfBoundsException e) {
							break;
						}	
					}
					
					if(n>1) {
						System.out.println("Colpito!!!");
					}else {
						n=0;
						for(int k=0; k>=-3; k--) {
							
							try {
								if(mappa[rigaSparo][colonnaSparo+k] == 'n') {
									n++;
								}else {
									if(mappa[rigaSparo][colonnaSparo+k] == 'a'){
										break;
									}
								}
							}catch(ArrayIndexOutOfBoundsException e) {
								break;
							}
						}
						for(int k=1; k<=3; k++) {
							try {
								if(mappa[rigaSparo][colonnaSparo+k] == 'n') {
									n++;
								}else {
									if(mappa[rigaSparo][colonnaSparo+k] == 'a'){
										break;
									}
								}
							}catch(ArrayIndexOutOfBoundsException e) {
								break;
							}
						}
						if(n>1) System.out.println("Colpito!!!");
						else System.out.println("Colpito e affondato!!!");
					}
				
				mappa[rigaSparo][colonnaSparo]='x';
				}else System.out.println("Qui hai già sparato!!!");
			}
			
			//stampa del tabellone contenuto nella matrice
			System.out.println();
			System.out.println("*****TABELLONE*****");
			for(i=0; i<10; i++) {
				for(j=0; j<10; j++) {
					System.out.print(mappa[i][j]+" ");
			    }
				System.out.println("");
			}
			System.out.println("--------------------");
			
			//algoritmo per verificare se il gioco è finito
			tot=0;
			for(i=0; i<10; i++) {
				for(j=0; j<10; j++) {
					if(mappa[i][j]=='n') tot++;
			    }
			}
			
			/*soluzione con la variabile booleana
			trovato = false;
			for(i=0; i<10 && !trovato; i++) {
				for(j=0; j<10 && !trovato; j++) {
					if(mappa[i][j]=='n')
						trovato = true;
			    }
			}
			*/
			
			//condizione per variabile boolean: while(trovato)
		}while(tot!=0);
		
		
	}

}
