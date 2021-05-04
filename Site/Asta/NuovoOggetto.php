<?php
include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
	
}
else{
	
	$result=controllaSessione();
	
	if($result==-2){
		$testo="Non puoi accedere a questa pagina.<br>Se vuoi aggiungere un nuovo oggetto effettua il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else if($result==-1){
		$testo="Sessione scaduta.<br>Se vuoi continuare rieffettua il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else{
		if(isset($_POST["Aggiungi"])){// Registra premuto
			
			$nome=strip_tags(trim($_POST["nomeOggetto"]));		//strip_tags mi permette di ripulire il testo eliminado eventuali parti di codice htlm,php etc
			$descrizioneOggetto=strip_tags(trim($_POST["descrizioneOggetto"]));
			$baseOggetto=strip_tags(trim($_POST["baseOggetto"]));
			if($nome==""){
				$testo="Il nome del prodotto è obbligatorio";
				$contentSide = "Layout_After_Login.php";
				$content = "Messaggi.php";
			}
			else{
				$contentSide = "Layout_After_Login.php";
				
				
				/* Connessione al database */
				$conn=@mysqli_connect("localhost","root","","s208786");
				if(!$conn){
					$testo="Connessione con il database fallita";
					$content = "Messaggi.php";
				}
				else{
					
					$nome=mysqli_real_escape_string($conn,$nome); /* mysqli_real_escape_string: 
					This function is used to create a legal SQL string that you can use in an SQL statement. 
					The given string is encoded to an escaped SQL string, taking into account 
					the current character set of the connection.*/
					$descrizioneOggetto=mysqli_real_escape_string($conn,$descrizioneOggetto);
					$baseOggetto=mysqli_real_escape_string($conn,$baseOggetto);
					$mail=mysqli_real_escape_string($conn,$_SESSION['mail']);
					$query="INSERT INTO oggetti (nome, descrizione, emailproprietario,emailultimorilancio, valoreultimorilancio,datainserimento) VALUES ('$nome','$descrizioneOggetto','$mail',NULL,'$baseOggetto',now())";
				
					try{
						mysqli_autocommit($conn,false);
						if(!@mysqli_query($conn,$query)){
							throw  new Exception("Transazione fallita");
							
						}
						else{
							mysqli_commit($conn);
							$testo="Inserimento avvenuto correttamente";
							$contentSide = "Layout_After_Login.php";
							$content = "Messaggi.php";
						}
					}
					catch (Exception $e){
						mysqli_rollback($conn);
						$testo="Inserimento non avvenuto correttamente";
						$content = "Messaggi.php";
					}
				@mysqli_close($conn);
				}
			}
		}
		else{
			$content = "Layout_Nuovo_Oggetto.php";
			$contentSide = "Layout_After_Login.php";
		}
	}

	include ("Struttura.php");
}

?>