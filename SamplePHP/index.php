<html>
<head>
    <title>Esempio</title>
</head>
<body>
<div>
    <p id="pentra">Entra:</p>
    <form action="login.php"  id="login_form" method="POST" >
        <input type="email" placeholder="email" id="email_text" name="email_text" >
        <input type="password" placeholder="password" id="password_text" name="password_text" >
        <input type="submit" name="PressLogin" value="Entra"  title="Premi per effettuare il login.">
        <p id="pentra">Non sei ancora registrato?</p>
    </form>
    <form action="layoutRegistrazione.php" method="POST" >
        <input type="submit" name="Registra" value="Registrati"  id="registra_button" title="Premi per registrarti.">
    </form>
    <form action="cercaProdotti.php" method="POST" >
        <input type="text" placeholder="filtro" id="find_text" name="find_text">
        <input type="submit" name="Find" value="Cerca"  id="find_button" title="Premi per cercare.">
    </form>
</div>
</body>
</html>
