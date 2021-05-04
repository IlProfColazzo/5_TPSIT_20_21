<?php 

include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{

	$result=controllaSessione();
	
	if($result==1){
		$testo="Non puoi accedere a questa pagina.<br>Effettua prima il logout.";
		$content = "Messaggi.php";
		$contentSide = "Layout_After_Login.php";
	}
	else if($result==-1){
		$testo="Sessione scaduta.<br>Ricarica la pagina se vuoi vedere gli oggetti.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else{
	//if(isset($_POST["VediOggetti"])){
		/* Connessione al database */
		$conn=@mysqli_connect("localhost","root","","s208786");
		if(!$conn){
			//$testo="Connessione con il database fallita";
			$testo=mysqli_connect_error() ;
			$contentSide = "sidebar.php";
			$content = "Messaggi.php";
		}
		else{
			$query="SELECT nome,descrizione,valoreultimorilancio,datainserimento FROM oggetti ORDER BY datainserimento;";
			$record=@mysqli_query($conn,$query);
			if(!$record || $record->num_rows==0){
				if(!$record){
					$testo="Interrogazione al database fallita";
					$content = "Messaggi.php";
					$contentSide = "sidebar.php";
				}
				else{
					$testo="Attualmente non sono presenti oggetti";
					$content = "Messaggi.php";
					$contentSide="sidebar.php";
				}
			}
			else{
				$vista=0;
				$rilancio=0;
				$contentSide="sidebar.php";
				$content = "Layout_view_oggetti.php";
			}
			@mysqli_close($conn);
		}
	}
	include("Struttura.php");
}
?>