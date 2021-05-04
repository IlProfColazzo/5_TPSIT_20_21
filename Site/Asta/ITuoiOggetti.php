<?php

include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{
	
	$result=controllaSessione();
	
	if($result==-2){
		$testo="Non puoi accedere a questa pagina.<br>Effettua prima il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else if($result==-1){
		$testo="Sessione scaduta.<br>Se vuoi continuare rieffettua il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else{

		$contentSide = "Layout_After_Login.php";
		
		//if(isset($_POST["Ituoioggetti"])){
			/* Connessione al database */
			$conn=@mysqli_connect("localhost","root","","s208786");
			if(!$conn){
				$testo="Connessione con il database fallita";
				$content = "Messaggi.php";
			}
			else{
				$mail=mysqli_real_escape_string($conn,$_SESSION['mail']);
				$query="SELECT nome,descrizione,emailultimorilancio,valoreultimorilancio,datainserimento FROM oggetti WHERE emailproprietario='$mail' ORDER BY datainserimento;";
				$record=@mysqli_query($conn,$query);
				if(!$record || $record->num_rows==0){
					if(!$record){
						$testo="Interrogazione al database fallita";
						$content = "Messaggi.php";
					}
					else{
						$testo="Attualmente non hai inserito oggetti";
						$content = "Messaggi.php";
					}
				}
				else{
					$vista=1;
					$content = "Layout_view_oggetti.php";
				}
				@mysqli_close($conn);
			}
		//}
	}
}
include("Struttura.php");

?>