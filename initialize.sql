-- Collective
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Ekot','Kap','Rue sous la pelière','antoine@lesmarostin');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Thomas','AGE','Bruno','thomas@age-namur.be');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Alice','AGE','Rue Bruno N°7','alice@age-namur.be');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Kotésport','Kap','Rue sous la pelière','kotesport@akap.com');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Akap','Kap','Rue sous la pelière','antoine@lesmarostin.be');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Cercle info','Cercle','Rue Bruno N°7','cercleinfo@gmail.com');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Cercle math','Cercle','Rue Bruno N°7','cerclemath@gmail.com');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Lux','Régionale','Rur de la lux','lux@gmail.com');
INSERT INTO `collective` (`name`,`category`,`physicalAddress`,`emailAddress`) VALUES ('Namuroise','Régionale','Rue de namur','Namuroise@gmail.com');

-- typeOfProblemRental
INSERT INTO `typeofproblemrental` (`name`,`description`) VALUES ('Retard','L\'objet a ete rendu en retard');
INSERT INTO `typeofproblemrental` (`name`,`description`) VALUES ('Oubli','Le locataire a oublié sa commande');
INSERT INTO `typeofproblemrental` (`name`,`description`) VALUES ('Casse','L\'objet a été retourné en mauvais état');

-- oneObject
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('table',6,0,'2021-05-02',NULL,NULL,9);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('gobelets',6,0,NULL,NULL,NULL,5);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('peinture',7,1,NULL,150,50,14);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('cables',8,1,'2021-03-16',NULL,NULL,14);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('pins',8,0,'2021-05-02',NULL,NULL,6);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('bougies',9,1,NULL,NULL,NULL,11);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Projecteur',9,1,'2021-05-17',10,5,12);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Micro',5,0,NULL,NULL,NULL,4);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Téléphone',2,0,'2019-05-17',250,100,25);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('projecteur',1,1,'2020-03-12',500,100,7);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Lampes LED',1,0,NULL,NULL,NULL,5);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Raquettes',3,1,'2021-03-30',NULL,20,10);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Balle',3,0,NULL,NULL,NULL,3);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Filets',4,1,'2020-09-21',NULL,NULL,5);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Volants',4,1,'2020-09-25',NULL,5,5);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Sono',5,0,NULL,250,100,2);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Pompe',5,1,NULL,NULL,NULL,10);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Sono',6,1,'2021-04-03',150,10,5);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Four',6,1,'2020-10-10',NULL,NULL,2);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Chaises',7,1,NULL,NULL,NULL,3);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Table',7,0,NULL,10,5,3);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Barrières',8,0,'2021-04-05',NULL,NULL,5);
INSERT INTO `oneobject` (`name`,`idCollectiveOwner`,`isCommendable`,`purchaseDate`,`purchasePrice`,`deposit`,`maxRentalPeriod`) VALUES ('Micro',9,1,'2021-04-16',30,10,5);

-- rental
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-05-05',4,6,NULL,'Val');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2019-10-10',5,6,'2020-10-10','Antoine');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2020-05-24',6,6,'2020-06-07','Simon');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-01-12',7,7,'2021-02-02','Evan');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-03-03',8,7,NULL,'Quentin');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2020-10-10',9,8,'2021-05-04','Oli');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-02-27',10,8,'2021-02-28','Lucie');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-03-05',11,9,NULL,'Mathias');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-04-04',12,9,'2021-04-08','Rémi');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2020-09-09',13,5,'2020-10-10','Arnaud');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2019-10-10',15,1,'2019-11-10','Henri');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-02-09',19,4,'2021-03-15','Florian');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2020-12-12',21,5,'2021-02-01','William');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-03-03',28,9,'2021-05-02','Basile');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-04-09',24,6,NULL,'Théo');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2020-06-09',26,7,'2020-07-09','Eytan');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2020-03-03',14,2,'2020-03-05','Blaise');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2019-05-07',16,1,'2019-05-09','Chloé');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-02-28',17,3,NULL,'Léa');
INSERT INTO `rental` (`startDate`,`idOneObject`,`idTenant`,`returnDate`,`rentalManager`) VALUES ('2021-01-01',22,5,NULL,'Sylvie');

-- problemExitLocation
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (1,1,10,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (2,2,20,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (3,3,10,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (4,1,20,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (5,2,10,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (6,3,20,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (7,3,30,'');
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (8,1,30,'L\'objet n\'a toujours pas été rendu');
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (9,3,10,'Légère dégradation');
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (14,1,50,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (12,2,15,NULL);
INSERT INTO `problemexitrental` (`idRental`,`idTypeOfProblemRental`,`invocedPrice`,`note`) VALUES (16,3,60,'L\'objet est inutilisable');