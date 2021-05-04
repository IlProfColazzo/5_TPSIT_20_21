<noscript>Il tuo browser non supporta JavaScript! Per avere maggiori funzionalità si prega di attivarlo.</noscript>
<?php if(isset($vedi)){?>
<div>
	
	<h3>Utente:
	<?php echo $_SESSION['nome'];
	echo "  ";
	echo $_SESSION['cognome'];?>
	</h3>
	<form action="ITuoiOggetti.php" method="POST">
	<input
	type="submit" name="Ituoioggetti" value="I tuoi oggetti" class="Entra"
	title="Clicca per vedere gli oggetti che hai messo in vendita.">
	</form>
	
	<form action="OggettiCheSeiInteressato.php" method="POST">
	<input
	type="submit" name="Oggetticheseiinteressato" value="Oggetti che tieni d'occhio" class="Entra"
	title="Clicca per vedere gli oggetti a cui sei interessato.">
	</form>
	
	<form action="Partecipa.php" method="POST">
	<input
	type="submit" name="PartecipaAsta" value="Partecipa ad un asta" class="Entra"
	title="Prova ad aggiudicarti un nuovo oggetto. Basta cliccare qui!">
	</form>
	
	<form action="NuovoOggetto.php" method="POST">
	<input
	type="submit" name="AggiungiOggetto" value="Aggiungi un nuovo oggetto" class="Entra"
	title="Se hai oggetti da vendere basta cliccare qui.">
	</form>
	
	<form action="Logout.php" method="POST">
	<input
	type="submit" name="Logout" value="Logout" class="Entra"
	title="Clicca se vuoi uscire dalla tua pagina personale.">
	</form>
</div>
<?php }else echo "Pagina non disponibile";?>