<?php
include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{

	$content = "Layout_Home.php";	
	$result=controllaSessione();
	if($result==1){
		session_unset();
		session_destroy();	
	}
	$contentSide = "sidebar.php";
	include ("Struttura.php");
}

?>