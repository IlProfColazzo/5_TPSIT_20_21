<?php
$conn = @mysqli_connect("localhost", "root", "", "s208786");
if (!$conn) {
    $testo = "Connessione con il database fallita";
} else {
    $filtro = mysqli_real_escape_string($conn, $_POST['find_text']);
    $query = "SELECT nome,descrizione,valoreultimorilancio,datainserimento, emailproprietario FROM oggetti WHERE descrizione LIKE '%$filtro%';";
    $record = @mysqli_query($conn, $query);
    if (!$record || $record->num_rows == 0) {
        if (!$record) {
            $testo = "Interrogazione al database fallita";
        } else {
            $testo = "Non ci sono prodotti";
        }
        echo  $testo;
    } else {
    echo "<TABLE>";
	echo "<tr style=\"background-color: #565654; color: white;\"><th>Nome</th><th>Descrizione</th><th>Valore attuale</th><th>Oggetto di</th><th>Inserito il</th></tr>";
	while($riga=mysqli_fetch_array($record)){
		echo "<tr>";
		echo "<td>".$riga['nome']."</td>";
		echo "<td>".$riga['descrizione']."</td>";
		echo "<td>".$riga['valoreultimorilancio']."€"."</td>";
		echo "<td>".$riga['emailproprietario']."</td>";
		echo "<td>".$riga['datainserimento']."</td>";
		echo "</tr>";
	}
    echo  "</TABLE>";
    }
    @mysqli_close($conn);
}
?>
