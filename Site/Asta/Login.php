<?php 

include 'Funzioni.php';

if(!checkCookies()){
	include 'errorPage.php';
}
else{
	
	
	$result=controllaSessione();
	
	if($result==1){
		$nome=$_SESSION['nome'];
		$cognome=$_SESSION['cognome'];
		$testo="Bentornato $nome $cognome.<br><br>Ti auguriamo una buona navigazione";
		$content = "Messaggi.php";
		$contentSide = "Layout_After_Login.php";
	}
	else if($result==-1){
		$testo="Sessione scaduta.<br>Se vuoi continuare rieffettua il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else {
		if(isset($_POST["PressLogin"])){
			$contentSide="sidebar.php";
			$email=strip_tags(trim($_POST["email_text"]));
			$password=strip_tags(trim($_POST["password_text"]));
			if( !filter_var($email, FILTER_VALIDATE_EMAIL) || !checkAlphaNum($password)){
				$testo="Non è stata inserita una mail valida o la password non contiene solo valori alphanumerici";
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
					$email=mysqli_real_escape_string($conn,$email);
					$password=mysqli_real_escape_string($conn,$password);
					$query="SELECT * FROM utenti WHERE email='$email' and password=md5('$password');";
					$record=@mysqli_query($conn,$query);
					if(!$record || $record->num_rows==0){
						if(!$record){
							$testo="Interrogazione al database fallita";
							$content = "Messaggi.php";
						}
						else{
							$query="SELECT * FROM utenti WHERE email='$email';";
							$record=@mysqli_query($conn,$query);
							if(!$record || $record->num_rows==0){
								if(!$record){
									$testo="Interrogazione al database fallita";
									$content = "Messaggi.php";
								}
								else		
									$testo="Non sei un utente registrato";
							}
							else 
								$testo="Hai sbagliato ad inserire la password";
							$content = "Messaggi.php";
						}
					}
					else{
						session_start();
						$_SESSION['time']=time();
						$riga=mysqli_fetch_array($record);
						$_SESSION['mail']=$email;
						$_SESSION['nome']=$riga['nome'];
						$_SESSION['cognome']=$riga['cognome'];
						$contentSide = "Layout_After_Login.php";
						$nome=$_SESSION['nome'];
						$cognome=$_SESSION['cognome'];
						$testo="Bentornato $nome $cognome.<br><br>Ti auguriamo una buona navigazione";
						$content = "Messaggi.php";
					}
					@mysqli_close($conn);
				}
			}
		}
		else{
			$content = "Layout_Home.php";
			$contentSide="sidebar.php";
		}
	}
	include("Struttura.php");
}

?>
