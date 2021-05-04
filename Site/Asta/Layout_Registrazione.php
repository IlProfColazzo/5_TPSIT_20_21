<?php if(isset($vedi)){?>

<form action="Registrazione.php" id="FormRegistrazione" method="POST">
	<div id="DivRegistrazione">
		<h1>Compila il form e diventa dei nostri!</h1>
		<p class="labelReg">Nome:</p>
		<input type="text" id="nome" name="nome" value="" class="textBoxR"
			title="Sono ammessi solo caratteri alfabetici e spazi.">
		<p class="labelReg">Cognome:</p>
		<input type="text" id="cognome" name="cognome" value=""
			class="textBoxR"
			title="Sono ammessi solo caratteri alfabetici e spazi.">
		<p class="labelReg">Indirizzo e-mail:</p>
		<input type="email" id="mail" name="mail"
			value="" class="textBoxR"
			title="Inserisci un indirizzo email valido.">
		<p class="labelReg"> Password:</p>
		 <input	type="password" id="password" name="password" value=""
			class="passwordBoxR" title="Per una maggiore sicurezza, ti consigliamo di usare lettere e numeri.">
		<p class="labelReg">Conferma password:</p>
		 <input type="password" id="ConfirmPassword"
			name="ConfirmPassword" value="" class="passwordBoxR"
			title="Immetti la password inserita precedemtente.">
		<br> <br> <input
			type="submit" name="Registra" value="Registrati!" class="Entra"
			id="registra_button2"><br> <br>
	</div>
</form>

<?php }else echo "Pagina non disponibile";?>

<script type="text/javascript">
	$(document).ready(function(){

		jQuery.validator.addMethod("alpha", function(value, element) {
			 var regExp=/^[a-zA-Z]+$/;
	         return value.match(regExp); 
	    });
	    
		$("#FormRegistrazione").validate({		
			  rules: {
			  	nome: {
			      	required: true, 
			      //	alpha: true
			    },
			    cognome:{
		    		required:true,
		    	//	alpha: true
	    		},
		    		
			    mail: {
			      	required: true, 
			      	email: true
			    },
			    password:{
		    		required:true
	    		},
			    ConfirmPassword:{
		    		required:true,
		    		equalTo: "#password"
	    		}
			  },
			  messages: {
				  	nome: {
						//alpha: "Sono consentiti solo caratteri alfabetici",
				    	required: "Inserisci il tuo nome"
				   },
				   cognome: {
						//alpha: "Sono consentiti solo caratteri alfabetici",
				    	required: "Inserisci il tuo cognome"
				   },
				   mail: {
						mail: "Inserisci una mail valida",
				    	required: "Inserisci la tua mail"
				   },
				   password: {
				    	required: "Inserisci la password"
				   },
				   ConfirmPassword: {
			      		required: "Conferma la tua password",
			      		equalTo: "Le password sono diverse"
			  		}
			  }
		});
			  
	});
</script>