<?php if(isset($vedi)){?>
<?php 
if ($vista==0 && $rilancio==0){ ?>
<TABLE>
	<tr style="background-color: #565654; color: white;"><th>Nome</th><th>Descrizione</th><th>Valore attuale</th><th>Inserito il</th></tr>
    <?php
	    $i=0;	
		while($riga=mysqli_fetch_array($record)){
			if($i%2==0)
				$color="background-color: #7C7C78";
			else
				$color="background-color: #959592";
			$i++;
			echo "<tr style='$color;'>";
			echo "<td>".$riga['nome']."</td>";
			echo "<td>".$riga['descrizione']."</td>";
			echo "<td>".$riga['valoreultimorilancio']."€"."</td>";
			echo "<td>".$riga['datainserimento']."</td>";
			echo "</tr>";
		}
	    ?>
</TABLE>

<?php } else if ($vista==0 && $rilancio==1){ ?>
<form action="Rilancio.php" method="POST" id="Rilancio">
<TABLE id="Trilanci">
	<tr style="background-color: #565654; color: white;"><th>Nome</th><th>Descrizione</th><th>Valore attuale in euro</th><th>Inserito il</th><th>Valore Rilancio</th><th>Rilancia</th></tr>
    <?php
    
    $i=0;
	while($riga=mysqli_fetch_array($record)){
		if($i%2==0)
			$color="background-color: #7C7C78";
		else
			$color="background-color: #959592";
		$i++;
		echo "<tr style='$color;'>";
		echo "<td>".$riga['nome']."</td>";
		echo "<td>".$riga['descrizione']."</td>";
		$ID=$riga['ID'];
		//echo "<td>".$riga['valoreultimorilancio']."€"."</td>";
		$valore=$riga['valoreultimorilancio'];
		$ID_p=$ID."_p";
		echo "<td><p id='$ID_p'>$valore</p></td>";
		
		echo "<td>".$riga['datainserimento']."</td>";

		
		$ID_val=$ID."_val";
		
		echo "<input type='hidden' id='$ID_val' value='-1' name='$ID_val'>";
		
		echo  "<td><input type='text' name='$ID' value='' id='$ID'
			title='Inserisci il valore del rilancio.'></td>";
		echo "<td><input
			type='button' name='Rilancia' value='OK!' class='Entra'  
			onclick='myFunction(\"$ID\")' title='Funzionalità non disponibile senza aver attivato javascript.'>
			</td>";
		
		echo "</tr>";
	}
    ?>
</TABLE>
</form>


<?php } else if ($vista==1){ ?>
<TABLE>
	<tr style="background-color: #565654; color: white;"><th>Nome</th><th>Descrizione</th><th>Valore attuale</th><th>Ultimo rilancio effettuato da</th><th>Inserito il</th></tr>
    <?php
    $i=0;
	while($riga=mysqli_fetch_array($record)){
		if($i%2==0)
			$color="background-color: #7C7C78";
		else
			$color="background-color: #959592";
		$i++;
		echo "<tr style='$color;'>";
		echo "<td>".$riga['nome']."</td>";
		echo "<td>".$riga['descrizione']."</td>";
		echo "<td>".$riga['valoreultimorilancio']."€"."</td>";
		echo "<td>".$riga['emailultimorilancio']."</td>";
		echo "<td>".$riga['datainserimento']."</td>";
		echo "</tr>";
	}
    ?>
</TABLE>
<?php } else if ($vista==2){ ?>
<TABLE>
	<tr style="background-color: #565654; color: white;"><th>Nome</th><th>Descrizione</th><th>Valore attuale</th><th>Oggetto di</th><th>Inserito il</th></tr>
    <?php
    $i=0;
	while($riga=mysqli_fetch_array($record)){
		if($i%2==0)
		$color="background-color: #7C7C78";
		else
			$color="background-color: #959592";
		$i++;
		echo "<tr style='$color;'>";
		echo "<td>".$riga['nome']."</td>";
		echo "<td>".$riga['descrizione']."</td>";
		echo "<td>".$riga['valoreultimorilancio']."€"."</td>";
		echo "<td>".$riga['emailproprietario']."</td>";
		echo "<td>".$riga['datainserimento']."</td>";
		echo "</tr>";
	}
    ?>
</TABLE>


<?php }?>
<?php }else echo "Pagina non disponibile";?>

<script>
function myFunction(id)
{
	str="Devi inserire un numero per poter effettuare il rilancio";
	val=document.getElementById(id).value;
	id_val=id+"_val";
	/*Setto il campo nascosco che ha come valore di default -1, lo stesso al valore dell'ID. 
	In questo modo riesco a capire da dove ho premuto OK!*/
	document.getElementById(id_val).value=id;
	id_p=id+"_p";
	/*Prendo il valore dell'ultimo rilancio*/
	base=document.getElementById(id_p).innerHTML;
	str2="Il valore di rilancio deve essere maggiore del valore attuale";

	var v = parseInt(val);
	var s = parseInt(base);

	
	if(isNaN(val)||val=="")
		alert(str);
	else if(s>=v)
		alert(str2);
	else	
		document.getElementById("Rilancio").submit();
}
</script>


