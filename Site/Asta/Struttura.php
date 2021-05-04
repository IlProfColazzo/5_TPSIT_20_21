<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Les Affaires</title>
	<META http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
	<META name="author" content="Andrea Colazzo">
	<link href="NewStyle.css" rel=stylesheet type="text/css">
	<?php 
	if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == ""){
		header("Location: https://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
		exit;
	}
	?>
		
	<script type="text/javascript" src="jquery-1.10.1.js"></script>
	<script type="text/javascript" src="jquery.validate.js"></script>

</head>

<body>
	<div id="container">
		<div id="header">
			<p id=Ptitolo>Nati per i tuoi affari</p>
			<div id="logo"><img id="logosup" alt="immagine non disonibile" src="immagine_LOGO2.png"></div>
		</div>
		
		
		<div id="sidebar">
			<?php
			$vedi=1;
			include($contentSide);
			?>
		</div>
		<div id="main">
			<?php
			$vedi=1;
			if(file_exists($content)) include($content);
			else echo"File not exist";
			?>
		</div>
		
		<div id="footer">
			<?php
			$foo=1;
			include 'footer.php';
			?>
		</div>
		
		
		
	</div>
	

</body>
</html>
