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
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- oneobject: table
CREATE TABLE `oneobject`
(
    `idObject`          int         NOT NULL AUTO_INCREMENT,
    `name`              varchar(45) NOT NULL,
    `idCollectiveOwner` int         NOT NULL,
    `isCommendable`     tinyint     NOT NULL,
    `purchaseDate`      date   DEFAULT NULL,
    `purchasePrice`     double DEFAULT NULL,
    `deposit`           int    DEFAULT 0,
    `maxRentalPeriod`   int         NOT NULL,
    PRIMARY KEY (`idObject`, `name`, `idCollectiveOwner`),
    UNIQUE KEY `name` (`name`),
    KEY `idCollectiveOwner_idx` (`idCollectiveOwner`),
    CONSTRAINT `idCollectiveOwner` FOREIGN KEY (`idCollectiveOwner`) REFERENCES `collective` (`idCollective`),
    CONSTRAINT `oneobject_chk_1` CHECK ((`purchasePrice` > 0)),
    CONSTRAINT `oneobject_chk_2` CHECK ((`deposit` >= 0)),
    CONSTRAINT `oneobject_chk_3` CHECK ((`maxRentalPeriod` > 0)),
    CONSTRAINT `oneobject_chk_4` CHECK ((not ((`name` like _utf8mb3''))))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;

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
    CONSTRAINT `idRental` FOREIGN KEY (`idRental`) REFERENCES `rental` (`idRental`),
    CONSTRAINT `idTypeOfProblemRental` FOREIGN KEY (`idTypeOfProblemRental`) REFERENCES `typeofproblemrental` (`idtypeofproblemrental`),
    CONSTRAINT `problemexitrental_chk_1` CHECK ((`invocedPrice` >= 0)),
    CONSTRAINT `problemexitrental_chk_2` CHECK ((not ((`note` like _utf8mb3''))))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;

-- rental: table
CREATE TABLE `rental`
(
    `idRental`      int         NOT NULL AUTO_INCREMENT,
    `startDate`     date        NOT NULL,
    `idObject`      int         NOT NULL,
    `idTenant`      int         NOT NULL,
    `returnDate`    date DEFAULT NULL,
    `rentalManager` varchar(45) NOT NULL,
    PRIMARY KEY (`idRental`, `startDate`, `idObject`),
    UNIQUE KEY `startDate` (`startDate`, `idObject`),
    KEY `idObject_idx` (`idObject`),
    KEY `idTenant_idx` (`idTenant`),
    CONSTRAINT `idObject` FOREIGN KEY (`idObject`) REFERENCES `oneobject` (`idObject`),
    CONSTRAINT `idTenant` FOREIGN KEY (`idTenant`) REFERENCES `collective` (`idCollective`),
    CONSTRAINT `rental_chk_1` CHECK ((not ((`rentalManager` like _utf8mb3'')))),
    CONSTRAINT `rental_chk_2` CHECK ((`returnDate` >= `startDate`))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;

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
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3;

