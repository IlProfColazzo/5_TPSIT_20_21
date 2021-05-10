<?php
$nome = $_POST["nome"];
$cognome = $_POST["cognome"];
$email = $_POST["mail"];
$password = $_POST["password"];
$ConfirmPassword = $_POST["ConfirmPassword"];
/* Connessione al database */
$conn = @mysqli_connect("localhost", "root", "", "s208786");
if (!$conn) {
    $testo = "Connessione con il database fallita";
} else {
    $nome = mysqli_real_escape_string($conn, $nome);
    $cognome = mysqli_real_escape_string($conn, $cognome);
    $email = mysqli_real_escape_string($conn, $email);
    $password = mysqli_real_escape_string($conn, $password);
    $query = "SELECT * FROM utenti WHERE email='$email';";
    $record = @mysqli_query($conn, $query);
    if (!$record || $record->num_rows > 0) {
            $testo = "Utente già registrato o interrogazione fallita";
    } else {
        $query = "INSERT INTO utenti (nome, cognome, email, password) VALUES ('$nome','$cognome','$email',md5('$password'))"; /*md5=cripta la psw*/
        if (!@mysqli_query($conn, $query)) {
            $testo = "La registrazione non è andata a buon fine";
        } else {
            $testo = "Registrazione avvenuta con successo";
        }
    }
    @mysqli_close($conn);
}
echo $testo;