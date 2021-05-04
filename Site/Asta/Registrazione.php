<?php
include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{
	
	
	$result=controllaSessione();
	
	if($result==1){
		$testo="Non puoi accedere a questa pagina.<br>Se vuoi registrare un nuovo account effettua il logout.";
		$content = "Messaggi.php";
		$contentSide = "Layout_After_Login.php";
	}
	else if($result==-1){
		$testo="Sessione scaduta.<br>Ricroda: non puoi registrarti più volte.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else{
		$contentSide="sidebar.php";
		
		if(isset($_POST["Registra"])){// Registra premuto
			$nome=strip_tags(trim($_POST["nome"]));		//strip_tags mi permette di ripulire il testo eliminado eventuali parti di codice htlm,php etc
			$cognome=strip_tags(trim($_POST["cognome"]));
			$email=strip_tags(trim($_POST["mail"]));
			$password=strip_tags(trim($_POST["password"]));
			$ConfirmPassword=strip_tags(trim($_POST["ConfirmPassword"]));
			if(!checkOnlyAlpha($nome) || !checkOnlyAlpha($cognome) || $ConfirmPassword=="" || $password=="" || !filter_var($email, FILTER_VALIDATE_EMAIL) || $ConfirmPassword!=$password){ /*Filters a variable with a specified filter*/
				$testo="ERRORE. Possibili cause:<br>
						1)Il nome non contiene solo caratteri alfabetici<br>
						2)Il cognome non contiene solo caratteri alfabetici<br>
						3)Non hai inserito una password<br>
						4)Non hai inserito la password di conferma<br>
						5)Non hai inserito una mail valida<br>
						6)Le password sono diverse";
				$content = "Messaggi.php";
			}
			else{
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
					$cognome=mysqli_real_escape_string($conn,$cognome);
					$email=mysqli_real_escape_string($conn,$email);
					$password=mysqli_real_escape_string($conn,$password);
					$query="SELECT * FROM utenti WHERE email='$email';";
					$record=@mysqli_query($conn,$query);
					if(!$record || $record->num_rows>0){
						if(!$record){
							$testo="Interrogazione al database fallita $email $record";
							$content = "Messaggi.php";
						}
						else{
							$testo="Utente già registrato";
							$content = "Messaggi.php";
						}
					}
					else{	
						$query="INSERT INTO utenti (nome, cognome, email, password) VALUES ('$nome','$cognome','$email',md5('$password'))"; /*md5=cripta la psw*/
						if(!@mysqli_query($conn,$query)){
							$testo="La registrazione non è andata a buon fine";
							$content = "Messaggi.php";
						}
						else{
							$testo="Registrazione avvenuta con successo";
							$content = "Messaggi.php";
						}
					}
					@mysqli_close($conn);
				}
			}
		}
		else{
			$content = "Layout_Registrazione.php";
			$contentSide="sidebar.php";
		}
	}
	

	include ("Struttura.php");
}
?>