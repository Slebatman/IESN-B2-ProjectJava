-- Collective
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (1,'Ekot','Kap','Rue sous la pelière','antoine@lesmarostin');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (2,'Thomas','AGE','Bruno','thomas@age-namur.be');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (3,'Alice','AGE','Rue Bruno N°7','alice@age-namur.be');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (4,'Kotésport','Kap','Rue sous la pelière','kotesport@akap.com');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (5,'Akap','Kap','Rue sous la pelière','antoine@lesmarostin.be');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (6,'Cercle info','Cercle','Rue Bruno N°7','cercleinfo@gmail.com');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (7,'Cercle math','Cercle','Rue Bruno N°7','cerclemath@gmail.com');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (8,'Lux','Régionale','Rur de la lux','lux@gmail.com');
INSERT INTO `collective` (`idCollective`,`name`,`category`,`physicalAddress`,`emailAddress`) VALUES (9,'Namuroise','Régionale','Rue de namur','Namuroise@gmail.com');

-- typeOfProblemRental
INSERT INTO `typeofproblemrental` (`idtypeofproblemrental`,`name`,`description`) VALUES (1,'Retard','L\'objet a ete rendu en retard');
INSERT INTO `typeofproblemrental` (`idtypeofproblemrental`,`name`,`description`) VALUES (2,'Oubli','Le locataire a oublié sa commande');
INSERT INTO `typeofproblemrental` (`idtypeofproblemrental`,`name`,`description`) VALUES (3,'Casse','L\'objet a été retourné en mauvais état');

-- oneObject
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (6,'table',6,0,'2021-05-02',NULL,NULL,9);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (7,'gobelets',6,0,NULL,NULL,NULL,5);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (8,'peinture',7,1,NULL,150,50,14);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (9,'cables',8,1,'2021-03-16',NULL,NULL,14);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (10,'pins',8,0,'2021-05-02',NULL,NULL,6);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (11,'bougies',9,1,NULL,NULL,NULL,11);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (12,'oui',9,1,'2021-05-17',10,5,12);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (13,'gse',5,0,NULL,NULL,NULL,4);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (14,'Téléphone',2,0,'2019-05-17',250,100,25);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (15,'projecteur',1,1,'2020-03-12',500,100,7);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (16,'Lampes LED',1,0,NULL,NULL,NULL,5);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (17,'Raquettes',3,1,'2021-03-30',NULL,20,10);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (18,'Balle',3,0,NULL,NULL,NULL,3);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (19,'Filets',4,1,'2020-09-21',NULL,NULL,5);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (20,'Volants',4,1,'2020-09-25',NULL,5,5);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (21,'Sono',5,0,NULL,250,100,2);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (22,'Pompe',5,1,NULL,NULL,NULL,10);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (23,'Sono',6,1,'2021-04-03',150,10,5);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (24,'Four',6,1,'2020-10-10',NULL,NULL,2);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (25,'Chaises',7,1,NULL,NULL,NULL,3);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (26,'Table',7,0,NULL,10,5,3);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (27,'Barrières',8,0,'2021-04-05',NULL,NULL,5);
INSERT INTO `oneobject` (`idOneObject`,`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES (28,'Micro',9,1,'2021-04-16',30,10,5);

-- rental
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (1,'2021-05-05',6,6,NULL,'Val');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (2,'2019-10-10',7,6,'2020-10-10','Antoine');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (3,'2020-05-24',8,7,'2020-06-07','Simon');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (4,'2021-01-12',9,7,'2021-02-02','Evan');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (5,'2021-03-03',8,9,NULL,'Quentin');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (6,'2020-10-10',9,8,'2021-05-04','Oli');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (7,'2021-02-27',10,8,'2021-02-28','Lucie');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (8,'2021-03-05',11,9,NULL,'Mathias');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (9,'2021-04-04',12,9,'2021-04-08','Rémi');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (10,'2020-09-09',13,5,'2020-10-10','Arnaud');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (11,'2019-10-10',15,1,'2019-11-10','Henri');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (12,'2021-02-09',19,4,'2021-03-15','Florian');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (13,'2020-12-12',21,5,'2021-02-01','William');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (14,'2021-03-03',28,9,'2021-05-02','Basile');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (15,'2021-04-09',24,6,NULL,'Théo');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (16,'2020-06-09',26,7,'2020-07-09','Eytan');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (17,'2020-03-03',14,2,'2020-03-05','Blaise');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (18,'2019-05-07',16,1,'2019-05-09','Chloée');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (19,'2021-02-28',17,3,NULL,'Léa');
INSERT INTO `rental` (`idRental`,`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES (20,'2021-01-01',22,5,NULL,'Sylvie');


-- problemexitrental
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (1,1,1,10,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (2,2,2,20,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (3,3,3,10,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (4,4,1,20,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (5,5,2,10,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (6,6,3,20,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (7,7,3,30,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (8,8,1,30,'L\'objet n\'a toujours pas été rendu');
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (9,9,3,10,'Légère dégradation');
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (10,14,1,50,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (11,12,2,15,NULL);
INSERT INTO `problemexitrental` (`idproblemExitLocation`,`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (12,16,3,60,'L\'objet est inutilisable');