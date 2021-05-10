<form action="test.php" id="FormRegistrazione" method="POST">
	<div id="DivRegistrazione">
		<h1>Compila il form e diventa dei nostri!</h1>
		<p class="labelReg">Nome:</p>
		<input type="text" id="nome" name="nome" value=""
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
			name="ConfirmPassword" value=""
			title="Immetti la password inserita precedemtente.">
		<br> <br> <input
			type="submit" name="Registra" value="Registrati!"
			id="registra_button2"><br> <br>
	</div>
</form>
