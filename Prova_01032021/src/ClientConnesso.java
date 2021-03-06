import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientConnesso extends Thread {
	
	/**
	 * @author Giacomo Mastrandrea - 5CI - 2020/21
	 * */

	private Socket s; // Socket connesso da utilizzare per trasmettere/ricevere dati
	private DataOutputStream toClient;
	private BufferedReader fromClient;
	private int mat[][];
	private int N, M;
	
	public void run() {

		boolean exit=false;
		String daInviare;
		
		do {
			
			String parolaRicevuta = ricevi();
			String vett[] = parolaRicevuta.split(";");
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			if(vett[0].equals("R")) {
				int riga = Integer.parseInt(vett[1]);
				if(riga>=0 && riga<N) {
					for(int i=0; i<M; i++) {
						if(mat[riga][i]>max) {
							max=mat[riga][i];
						}
					}
					daInviare = "Il valore massimo alla riga " + riga + " e' " + max;  
				}
				else{
					daInviare = "Riga inesistente";
				}
			}
			else if(vett[0].equals("C")) {
				int colonna = Integer.parseInt(vett[1]);
				if(colonna>=0 && colonna<M) {
					for(int i=0; i<N; i++) {
						if(mat[i][colonna]<min) {
							min=mat[i][colonna];
						}
					}
					daInviare = "Il valore minimo alla colonna " + colonna + " e' " + min;  
				}
				else{
					daInviare = "Colonna inesistente";
				}
			}
			else if(vett[0].equals("MAX")) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(mat[i][j]>max) {
							max=mat[i][j];
						}
					}
				}
				daInviare = "Il valore massimo nella matrice è " + max;
			}
			else if(vett[0].equals("MIN")) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(mat[i][j]<min) {
							min=mat[i][j];
						}
					}
				}
				daInviare = "Il valore minimo nella matrice è " + min;
			}
			else if(vett[0].equals("QUIT") && vett[1].equals("QUIT")){
				daInviare = "Programma terminato!";
				exit=true;
			}
			else {
				daInviare = "Comando errato";
			}
			
			invia(daInviare+"\n");
		
		}while(exit==false);

		chiudi();/// termina la connessione con il client
	}

	public ClientConnesso(Socket s, int[][] mat, int N, int M) {
		this.s = s;
		this.mat = mat;
		this.N = N;
		this.M = M;
		try {
			this.fromClient = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
			this.toClient = new DataOutputStream(this.s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void invia(String daInviare) {
		/** Invia la stringa daInviare al Client connesso */
		try {
			this.toClient.writeBytes(daInviare);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String ricevi() {
		String s = "";

		try {
			s = this.fromClient.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public void chiudi() {
		try {
			this.fromClient.close();
			this.toClient.close();
			this.s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
