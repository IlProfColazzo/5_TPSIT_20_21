<?php

include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{
	
	$result=controllaSessione();
	
	if($result==1){
		$contentSide = "Layout_After_Login.php";
		$nome=$_SESSION['nome'];
		$cognome=$_SESSION['cognome'];
		$testo="Bentornato $nome $cognome.<br><br>Ti auguriamo una buona navigazione";
		$content = "Messaggi.php";
	}
	
	
	else if($result==-1){
		$contentSide="sidebar.php";
		$testo="E' scaduta la sessione. Se vuoi continuare rieffettua il login";
		$content = "Messaggi.php";
	}
	
	else{
		$content = "Layout_Home.php";
		$contentSide="sidebar.php";		
	}
	
	include("Struttura.php");

}
?>