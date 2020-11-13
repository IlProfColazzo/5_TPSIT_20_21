import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
* Soluzione a cura di 
* @author Angele' Nicolo'
* @author Lezzi Matteo
*/

/*Gestione:
 * - caricamento file su matrice
 * - gestisce lo sparo se colpisce o colpisce e affonda la nave, tranne che per le navi da tre o quattro poizioni
 * - il gioco continua a girare finchè non ci sono piu navi da affondare.
 * */

public class MainAngele_Lezzi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		Scanner in = new Scanner(System.in);
		int riga=10,colonna=10,i=0,j=0;
		String[][] mappa = new String [riga][colonna];
		
		System.out.println("inserire nome file da cui vuoi leggere la mappa");
		String nomeFile=in.next();
		
		try {
			FileReader fr= new FileReader(nomeFile);
			BufferedReader fIN = new BufferedReader(fr);
			
			StringTokenizer st;
			String s = fIN.readLine(); // Legge la prima riga
			
			while(s != null) {
				st= new StringTokenizer(s,",");
					
					//System.out.println(st.countTokens());
					j=0;
					while(st.hasMoreTokens()) {
						mappa [i][j]=st.nextToken();
						j++;
					}
				
				s = fIN.readLine(); // Legge la riga successiva
				i++;
			}
			
			fr.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//boolean controlla=false;
		String a;
		int contV=0,contX=0;
		for(i=0;i<riga;i++){					//for per stampa
			a="";
			for(j=0;j<colonna;j++){
				a=a+ " " +mappa[i][j];
			}
			System.out.println(a);
		}
		
		for(i=0;i<riga;i++){					//for per contare le V totali nella matrice
			for(j=0;j<colonna;j++){
				if(mappa[i][j].equals("V"))
					contV++;
			}
		}
		
		do {
			
			int n1,n2;
			String colpo="";
			System.out.println("\n inserisci cordinata riga: ");
			n1=in.nextInt();
			System.out.println("\n inserisci cordinata colonna: ");
			n2=in.nextInt();
			
			if(mappa[n1][n2].equals("o")) {
				System.out.println("MARE");
			}
			else {
				if(mappa[n1][n2].equals("x"))
					System.out.println("Hai gia colpito qui.");
				else {
					if(mappa[n1][n2].equals("V")){
						colpo="colpita";
						mappa[n1][n2]= "x";
						contX++;
						
						if(n1==0 & n2==0) {
								if((mappa[n1][n2+1].equals("o") || mappa[n1][n2+1].equals("x")) 
									& ( mappa[n1+1][n2].equals("o")  || mappa[n1+1][n2].equals("x") ))
									colpo="Nave colpita e affondata";
						}
						else {
							if(n1==0 & n2==colonna-1) {
								if(((mappa[n1][n2-1].equals("o") || mappa[n1][n2-1].equals("x") )
										& (mappa[n1+1][n2].equals("o")  || mappa[n1+1][n2].equals("x"))))
									colpo="Nave colpita e affondata";
							}
							else {
								if(n1==riga-1 & n2==0) {
									if(((mappa[n1][n2+1].equals("o") || mappa[n1][n2+1].equals("x")) 
											& (mappa[n1-1][n2].equals("o") || mappa[n1-1][n2].equals("x")))) 
										colpo="Nave colpita e affondata";
								}
								else {
									if(n1==riga-1 & n2==colonna-1) {
										if(((mappa[n1][n2-1].equals("o") || mappa[n1][n2-1].equals("x")) 
												& (mappa[n1-1][n2].equals("o") || mappa[n1-1][n2].equals("x"))))
											colpo="Nave colpita e affondata";
									}
									else {       
										if(n1==0) {
											if(((mappa[n1+1][n2].equals("o") || mappa[n1+1][n2].equals("x")) & (mappa[n1][n2+1].equals("o") || mappa[n1][n2+1].equals("x")) 
													& (mappa[n1][n2-1].equals("o") || mappa[n1][n2-1].equals("x"))))
												colpo="Nave colpita e affondata";
										}
										else {			
											if(n2==0) {
												if(((mappa[n1+1][n2].equals("o") || mappa[n1+1][n2].equals("x")) & (mappa[n1][n2+1].equals("o") || mappa[n1][n2+1].equals("x")) 
														& (mappa[n1-1][n2].equals("o") || mappa[n1-1][n2].equals("x"))))
													colpo="Nave colpita e affondata";
											}
											else {		//qui sono rimasto
												if(n1==riga-1) {
													if(((mappa[n1][n2+1].equals("o") || mappa[n1][n2+1].equals("x")) & (mappa[n1][n2-1].equals("o") || mappa[n1][n2-1].equals("x")) 
															& (mappa[n1-1][n2].equals("o") || mappa[n1-1][n2].equals("x"))))
														colpo="Nave colpita e affondata";
												}
												else {
													if(n2==colonna-1) {
														if(((mappa[n1][n2-1].equals("o") || mappa[n1][n2-1].equals("x")) & (mappa[n1+1][n2].equals("o") || mappa[n1+1][n2].equals("x")) 
																& (mappa[n1-1][n2].equals("o") || mappa[n1-1][n2].equals("x"))))
															colpo=" Nave colpita e affondata";
															
													}
													else {
														if((n1!=0 & n2!=0) & (n1!=riga-1 & n2!=colonna-1)) {
															if(((mappa[n1+1][n2].equals("o") || mappa[n1+1][n2].equals("x")) & (mappa[n1-1][n2].equals("o") || mappa[n1-1][n2].equals("x"))
																	& (mappa[n1][n2-1].equals("o") || mappa[n1][n2-1].equals("x")) & (mappa[n1][n2+1].equals("o") || mappa[n1][n2+1].equals("x")))) 
																colpo="Nave colpita e affondata";
																
														}
													}
												}
											}
										}	
									}
								}
							}
						}
					}
					
				}
			}     //fine primo else
			
			System.out.println("\n" + colpo);
			
		}while(contX<contV);
		
		System.out.println("GIOCO TERMINATO");
	}
}
