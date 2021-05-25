CREATE SCHEMA inventory DEFAULT CHARACTER SET utf8;
USE inventory;

CREATE USER 'BaeAnt'@'localhost' IDENTIFIED BY 'projectJava';
GRANT ALL PRIVILEGES ON *.* TO 'BaeAnt'@'localhost';
FLUSH PRIVILEGES;

-- collective: table
CREATE TABLE `collective`
(
    `idCollective`    int         NOT NULL AUTO_INCREMENT,
    `name`            varchar(45) NOT NULL,
    `category`        varchar(45) NOT NULL,
    `physicalAddress` varchar(45) NOT NULL,
    `emailAddress`    varchar(45) NOT NULL,
    PRIMARY KEY (`idCollective`, `name`),
    UNIQUE KEY `idCollective_UNIQUE` (`idCollective`),
    UNIQUE KEY `name` (`name`),
    CONSTRAINT `collective_chk_1` CHECK ((not ((`name` like _utf8mb3'')))),
    CONSTRAINT `collective_chk_2` CHECK ((not ((`category` like _utf8mb3'')))),
    CONSTRAINT `collective_chk_3` CHECK ((not ((`physicalAddress` like _utf8mb3'')))),
    CONSTRAINT `collective_chk_4` CHECK ((not ((`emailAddress` like _utf8mb3''))))
);

-- oneobject: table
CREATE TABLE `oneobject`
(
    `idOneObject`       int         NOT NULL AUTO_INCREMENT,
    `name`              varchar(45) NOT NULL,
    `idCollectiveOwner` int         NOT NULL,
    `isCommendable`     tinyint     NOT NULL,
    `purchaseDate`      date   DEFAULT NULL,
    `purchasePrice`     double DEFAULT NULL,
    `deposit`           int    DEFAULT '0',
    `maxRentalPeriod`   int         NOT NULL,
    PRIMARY KEY (`idOneObject`, `name`, `idCollectiveOwner`),
    KEY `idCollectiveOwner_idx` (`idCollectiveOwner`),
    CONSTRAINT `idCollectiveOwner` FOREIGN KEY (`idCollectiveOwner`) REFERENCES `collective` (`idCollective`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `oneobject_chk_1` CHECK ((`purchasePrice` > 0)),
    CONSTRAINT `oneobject_chk_2` CHECK ((`deposit` >= 0)),
    CONSTRAINT `oneobject_chk_3` CHECK ((`maxRentalPeriod` > 0)),
    CONSTRAINT `oneobject_chk_4` CHECK ((not ((`name` like _utf8mb3''))))
);

-- rental: table
CREATE TABLE `rental`
(
    `idRental`      int         NOT NULL AUTO_INCREMENT,
    `startDate`     date        NOT NULL,
    `idOneObject`   int         NOT NULL,
    `idTenant`      int         NOT NULL,
    `returnDate`    date DEFAULT NULL,
    `rentalManager` varchar(45) NOT NULL,
    PRIMARY KEY (`idRental`, `startDate`, `idOneObject`),
    UNIQUE KEY `startDate` (`startDate`, `idOneObject`),
    KEY `idObject_idx` (`idOneObject`),
    KEY `idTenant_idx` (`idTenant`),
    CONSTRAINT `id_Collective` FOREIGN KEY (`idTenant`) REFERENCES `collective` (`idCollective`) ON UPDATE CASCADE,
    CONSTRAINT `idObject` FOREIGN KEY (`idOneObject`) REFERENCES `oneobject` (`idOneObject`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `rental_chk_1` CHECK ((not ((`rentalManager` like _utf8mb3'')))),
    CONSTRAINT `rental_chk_2` CHECK ((`returnDate` >= `startDate`))
);

-- typeofproblemrental: table
CREATE TABLE `typeofproblemrental`
(
    `idtypeofproblemrental` int         NOT NULL AUTO_INCREMENT,
    `name`                  varchar(45) NOT NULL,
    `description`           mediumtext  NOT NULL,
    PRIMARY KEY (`idtypeofproblemrental`, `name`),
    UNIQUE KEY `name` (`name`),
    CONSTRAINT `typeofproblemrental_chk_1` CHECK ((not ((`name` like _utf8mb3'')))),
    CONSTRAINT `typeofproblemrental_chk_2` CHECK ((not ((`description` like _utf8mb3''))))
);

-- problemexitrental: table
CREATE TABLE `problemexitrental`
(
    `idproblemExitLocation` int    NOT NULL AUTO_INCREMENT,
    `idRental`              int    NOT NULL,
    `idTypeOfProblemRental` int    NOT NULL,
    `invocedPrice`          double NOT NULL,
    `note`                  longtext,
    PRIMARY KEY (`idproblemExitLocation`, `idRental`),
    UNIQUE KEY `idRental` (`idRental`),
    KEY `idRental_idx` (`idRental`),
    KEY `idTypeOfProblemRental_idx` (`idTypeOfProblemRental`),
    CONSTRAINT `idRental` FOREIGN KEY (`idRental`) REFERENCES `rental` (`idRental`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `idTypeOfProblemRental` FOREIGN KEY (`idTypeOfProblemRental`) REFERENCES `typeofproblemrental` (`idtypeofproblemrental`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `problemexitrental_chk_1` CHECK ((`invocedPrice` >= 0)),
    CONSTRAINT `problemexitrental_chk_2` CHECK ((not ((`note` like _utf8mb3''))))
);

