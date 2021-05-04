<?php
include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{
	
	
	$result=controllaSessione();
	
	if($result==-1){
		$testo="Sessione scaduta.<br>Se vuoi continuare rieffettua il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else if($result==-2){
		$testo="Per visualizzare questa pagina devi autenticarti.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else{
		$contentSide = "Layout_After_Login.php";
		//if(isset($_POST["Oggetticheseiinteressato"])){
			/* Connessione al database */
			$conn=@mysqli_connect("localhost","root","","s208786");
			if(!$conn){
				$testo="Connessione con il database fallita";
				$content = "Messaggi.php";
			}
			else{
				$mail=mysqli_real_escape_string($conn,$_SESSION['mail']);
				$query="SELECT nome,descrizione,valoreultimorilancio,datainserimento, emailproprietario FROM oggetti WHERE emailproprietario<>'$mail' and emailultimorilancio='$mail' ORDER BY datainserimento;";
				$record=@mysqli_query($conn,$query);
				if(!$record || $record->num_rows==0){
					if(!$record){
						$testo="Interrogazione al database fallita";
						$content = "Messaggi.php";
					}
					else{
						$testo="Non hai partecipato a nessuna asta o tutte le tue offerte sono state superate";
						$content = "Messaggi.php";
					}
				}
				else{
					$vista=2;
					$content = "Layout_view_oggetti.php";
				}
				@mysqli_close($conn);
			}
		//}
	}
}
include("Struttura.php");

?>