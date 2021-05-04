--
-- Struttura della tabella `utenti`
--

DROP TABLE IF EXISTS `utenti`;
CREATE TABLE IF NOT EXISTS `utenti` (
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`nome`, `cognome`, `email`, `password`) VALUES
('Mario', 'Rossi', 'u1@polito.it', md5('p1')),
('Filippo', 'Verdi', 'u2@polito.it', md5('p2'));

--
-- Struttura della tabella `oggetti`
--

DROP TABLE IF EXISTS `oggetti`;
CREATE TABLE IF NOT EXISTS `oggetti` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descrizione` varchar(1024) NOT NULL,
  `emailproprietario` varchar(100) NOT NULL,
  `emailultimorilancio` varchar(100),
  `valoreultimorilancio`  float NOT NULL,
  `datainserimento`  datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dump dei dati per la tabella `oggetti`
--

INSERT INTO `oggetti` (`nome`, `descrizione`, `emailproprietario`, `emailultimorilancio`,`valoreultimorilancio`,`datainserimento`) VALUES
('Appartamento', 'Super attico di 250mq. Fate le vostre offerte ed aggiudicatevi questo spettacolo.', 'u1@polito.it','u2@polito.it' ,1,now()),
('Mansarda', 'Vendo mansarda con un altezza minima di 1.50m', 'u1@polito.it','u2@polito.it' ,7,now()),
('Play station', 'Cedo la mia play station perchè non viene più utilizzata dai miei figli', 'u1@polito.it',NULL ,1,now()),
('Casse', 'Cedo fantastico impianto audio BOSE della potenza complessiva di 1500W', 'u2@polito.it','u1@polito.it' ,5,now()),
('Smartphone', 'Vendo il mio nuovissimo iphone 7500. Finalmente ho capito che la Apple è una truffa. Cercatelo di capire anche voi.', 'u2@polito.it',NULL ,1,now()),
('La mia ragazza', 'Regalo la mia ragazza in quanto non riesce a fare i dolci', 'u2@polito.it','u1@polito.it' ,1,now()),
('Letto', 'vendo letto ikea, come nuovo. Color grigio fumo', 'u1@polito.it',NULL ,1,now());
