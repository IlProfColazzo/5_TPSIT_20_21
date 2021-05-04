<noscript>Il tuo browser non supporta JavaScript! Per avere maggiori funzionalità si prega di attivarlo.</noscript>
<?php if(isset($vedi)){?>
<div>
	<p id="pentra">Entra:</p>
	<form action="Login.php"  id="login_form" method="POST" >
		<input type="email" placeholder="email" id="email_text" name="email_text" class="textBox"> 
		<input type="password" placeholder="password" id="password_text" name="password_text" class="passwordBox"> 
		<input type="submit" name="PressLogin" value="Entra" class="Entra" title="Premi per effettuare il login.">
		<br><br><br><br><br><br><br>
		<p id="pentra">Non sei ancora registrato?</p>
	</form>
	<form action="Registrazione.php" method="POST" >
		<input type="submit" name="Registra2" value="Registrati" class="Entra" id="registra_button" title="Premi per registrarti.">
	</form>
	<br><br><br><br><br>
	<form action="Oggetti.php" method="POST">
		<input
		type="submit" name="VediOggetti" value="Offerte" class="Entra"
		id="oggetti" title="Premi per vedere gli oggetti in vendita.">
	</form>
</div>
<?php }else echo "Pagina non disponibile";?>


<script type="text/javascript">
	$(document).ready(function(){
		
		$("#login_form").validate({		
			  rules: {
				  email_text: {
			      	required: true, 
			      	email: true
			      
			    },
			    password_text:{
		    		required:true
	    		}
			  },
			  messages: {
				  email_text: {
				    	email: "Inserire una mail valida",
				    	required: "Inserisci il tuo username"
					    
				    },
				    password_text: {
			      		required: "Inserisci la tua password"
			  		}
			  }
		});
			  
	});
</script>
