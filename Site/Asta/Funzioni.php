<?php

function checkCookies()
{
	setcookie('cookie_test','cookie_value'); //setto un cookie
	if(!isset($_COOKIE['cookie_test']))  //tra i cookie inviati dal client esiste coocki chiamato cookie_test?
	{
		if(!isset($_GET['flag']))  //nell'url esiste il parametro flag?
		{
			header("Location: ".htmlentities($_SERVER['PHP_SELF'])."?flag"); //faccio ricaricare la pagina al client. Quindi il server riceverà un altra richiesta
			return false;
		}
		else
			return false;
	}
	return true;
}



function checkOnlyAlpha($stringa){
	if(!ctype_alpha(str_replace(' ', '', $stringa)) || $stringa=="")
		return false;
	return true;
}

function checkAlphaNum($stringa){
	if(!ctype_alnum($stringa) || $stringa=="")
		return false;
	return true;
}

function controllaSessione(){
	session_start();

	$tattuale=time();
	$diff=0;
	
	if(isset($_SESSION['time'])){
		$tstart=$_SESSION['time'];
		$diff=$tattuale-$tstart;
	}
	else{
		session_unset();
		session_destroy();
		return -2;
	}
	if($diff > 120){
		session_unset();
		session_destroy();
		return -1;
	}
	else
		$_SESSION['time']=time();
	return 1;
}

?>