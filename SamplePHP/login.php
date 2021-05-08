<?php
$email = $_POST["email_text"];
$password = $_POST["password_text"];
/* Connessione al database */
$conn = @mysqli_connect("localhost", "root", "", "s208786");
if (!$conn) {
    $testo = "Connessione con il database fallita";
} else {
    $email = mysqli_real_escape_string($conn, $email);
    $password = mysqli_real_escape_string($conn, $password);
    $query = "SELECT * FROM utenti WHERE email='$email' and password=md5('$password');";
    $record = @mysqli_query($conn, $query);
    if (!$record || $record->num_rows == 0) { //controllo se la variabile record è null (interrogazione fallita) oppure se non ci sono tuple
        //echo
        $testo = "Interrogazione al database fallita o utente non esistente o password sbagliata";
    } else {
        $riga = mysqli_fetch_array($record); //tiro fuori la riga dal mio risultato
        $nome = $riga['nome']; //tra apici c'è il nome della colonna della tabella utenti
        $cognome = $riga['cognome'];
        $testo = "Bentornato $nome $cognome.<br><br>Ti auguriamo una buona navigazione";
        //echo
    }
    @mysqli_close($conn);
}
echo $testo;