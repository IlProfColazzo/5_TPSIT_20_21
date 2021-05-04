<?php 

include 'Funzioni.php';
if(!checkCookies()){
	include 'errorPage.php';
}
else{
	
	
	//$content = "Layout_Home.php";
	//$contentSide = "Layout_After_Login.php";
	
	
/*	foreach ($_POST as $key => $value) {
		echo "      Chiave--->".$key;
		echo "      Valore--->".$value;
	}*/
	
	
	
	$result=controllaSessione();
	
	if($result==-1){
		$testo="Sessione scaduta.<br>Se vuoi continuare rieffettua il login.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else if($result==-2 && !isset($_POST["Rilancia"])){
		$testo="Per visualizzare questa pagina devi autenticarti.";
		$content = "Messaggi.php";
		$contentSide = "sidebar.php";
	}
	else{
		$contentSide = "Layout_After_Login.php";
		
		$flag=false;
		/*Riceverò i valori del rilancio e il campo nascosto
		 * il campo nascosto se ha un valore != da -1 vuol dire che ho premuto
		 * sul bottone corrispondente. il suo valore varrà la chiave*/
		foreach ($_POST as $key => $value){
			//echo "Chiave-->".$key."valore-->".$value."<br>";
			if($value!=-1 && !is_numeric($key)){
				$flag=true;
				break;
			}
		};
		
		//if(isset($_POST["Rilancia"])){
		if($flag){
				/* Connessione al database */
				$conn=@mysqli_connect("localhost","root","","s208786");
				if(!$conn){
					$testo="Connessione con il database fallita";
					$content = "Messaggi.php";
				}
				else{
					$flag=false;
					/*Mi trovo l'ID dell'oggetto sottoposta a rilancio*/
					foreach ($_POST as $key => $value){
						if($value!=-1 && !is_numeric($key)){
							$id=$value;
							break;
						}
					};
					
					//echo "ID=".$id;
					
					/*Mi trovo il valore del rilancio*/
					foreach ($_POST as $key => $value){
						//echo "Chiave-->".$key."valore-->".$value."<br>";
						if($key==$id){
							$valore=$value;
							break;
						}
					};
					
					if(!is_numeric($valore)){
						$testo="Devi inserire un valore valido per il rilancio";
						$content = "Messaggi.php";
					}
					else{
						$valore=strip_tags(trim($valore));
						$id=strip_tags(trim($id));
						$id=mysqli_real_escape_string($conn,$id);
						$valore=mysqli_real_escape_string($conn,$valore);
						$query="SELECT * FROM oggetti WHERE ID='$id' and valoreultimorilancio<'$valore';";
						$mail=mysqli_real_escape_string($conn,$_SESSION['mail']);
						
						
						$record=@mysqli_query($conn,$query);
						if(!$record || $record->num_rows==0){
							if(!$record){
								$testo="Interrogazione al database fallita";
								$content = "Messaggi.php";
							}
							else{
								$testo="Hai sbagliato ad inserire l'offerta. Hai inserito un prezzo minore o uguale a quello attuale.";
								$content = "Messaggi.php";
							}
						}
						else{
							
							
							$query="UPDATE oggetti SET valoreultimorilancio='$valore', emailultimorilancio='$mail' WHERE ID='$id';";
							
							try{
								mysqli_autocommit($conn,false);
								$record=@mysqli_query($conn,$query);
								if(!$record)
									throw  new Exception("Transazione fallita");
									//$testo="Interrogazione al database fallita";
								else{
									mysqli_commit($conn);
									$testo="Complimenti! Rilancio effettuato correttamente";
									$content = "Messaggi.php";
								}
							}
							catch (Exception $e){
								mysqli_rollback($conn);
								$testo="Interrogazione al database fallita";
								$content = "Messaggi.php";
							}
							
						}
						@mysqli_close($conn);
					}
				}
			}
			else{
				$testo="Pagina non raggiungibile in maniera diretta.";
				$content = "Messaggi.php";
			}
		}	
	include("Struttura.php");
}
?>