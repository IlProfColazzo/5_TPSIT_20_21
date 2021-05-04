<?php if(isset($vedi)){?>
<form action="NuovoOggetto.php" method="POST" id="FormNuovoProdotto">
	<div id="DivNuovoProdotto">
		<h1>Compila i seguenti campi e potrai aggiungere il tuo prodotto!</h1>
		<p class="labelReg">Nome:</p>
		<input type="text" id="nomeOggetto" name="nomeOggetto" value="" class="textBoxR"
			title="Inserisci il nome ed tuo prodotto.">
		<p class="labelReg">Descrizione:</p>
		<textarea id="descrizioneOggetto" name="descrizioneOggetto"
			class="textBoxR" placeholder="max 1024 caratteri"
			title="Inserisci una breve descrizione del tuo prodotto. Sono consentiti al max 1024 caratteri"></textarea>
		<p class="labelReg">Base d'asta:</p>
		<input type="text" id="baseOggetto" name="baseOggetto"
			value="0" class="textBoxR"
			title="Inserisci il valore di base dell'oggetto.">
		<br> <br> <input
			type="submit" name="Aggiungi" value="Aggiungi!" class="Entra"
			id="registra_button3"
			title="Aggiungi il tuo oggetto."><br> <br>
	</div>
</form>

<?php }else echo "Pagina non disponibile";?>

<script type="text/javascript">
	$(document).ready(function(){

		jQuery.validator.addMethod("isfloat", function(value, element) {
			 var regExp= /^\s*(\+|-)?((\d+(\.\d+)?)|(\.\d+))\s*$/;
			return value.match(regExp);
				/*if(value.match(regExp))
	         	return true;
			else if (value.match(""))
				return true;
			else
				return false;*/ 
	    });
		
	    
		$("#FormNuovoProdotto").validate({		
			  rules: {
				 nomeOggetto: {
			      	required: true, 
			    },
				baseOggetto: {
					isfloat: true,	
			  	},
			  	descrizioneOggetto: {
			  		maxlength: 1024,
			  	}
			  	
			  },
			  messages: {
				  nomeOggetto: {
				    	required: "E' obbligatorio inserire un nome per l'articolo"
				   },
				   baseOggetto: {
					   isfloat: "La base d'asta deve essere un valore numerico"
					},
					descrizioneOggetto: {
				  		maxlength: "il testo deve essere lungo al max 1024 caratteri"
				  	}
			  }
		});
			  
	});
</script>