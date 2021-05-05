-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `collective`
--

DROP TABLE IF EXISTS `collective`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collective` (
  `idCollective` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `physicalAdress` varchar(45) NOT NULL,
  `emailAdress` varchar(45) NOT NULL,
  PRIMARY KEY (`idCollective`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collective`
--

LOCK TABLES `collective` WRITE;
/*!40000 ALTER TABLE `collective` DISABLE KEYS */;
/*!40000 ALTER TABLE `collective` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object`
--

DROP TABLE IF EXISTS `object`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `object` (
  `idObject` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `idCollectiveOwner` int NOT NULL,
  `isCommandable` tinyint NOT NULL,
  `purchaseDate` date DEFAULT NULL,
  `purchasePrice` double DEFAULT NULL,
  `deposit` int DEFAULT NULL,
  `maxRentalPeriod` int NOT NULL,
  PRIMARY KEY (`idObject`,`name`,`idCollectiveOwner`),
  KEY `idCollectiveOwner_idx` (`idCollectiveOwner`),
  CONSTRAINT `idCollectiveOwner` FOREIGN KEY (`idCollectiveOwner`) REFERENCES `collective` (`idCollective`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object`
--

LOCK TABLES `object` WRITE;
/*!40000 ALTER TABLE `object` DISABLE KEYS */;
/*!40000 ALTER TABLE `object` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problemexitlocation`
--

DROP TABLE IF EXISTS `problemexitlocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problemexitlocation` (
  `idproblemExitLocation` int NOT NULL,
  `idRental` int NOT NULL,
  `idTypeOfProblemRental` int NOT NULL,
  `invocedPrice` double NOT NULL,
  `note` longtext,
  PRIMARY KEY (`idproblemExitLocation`,`idRental`),
  KEY `idRental_idx` (`idRental`),
  KEY `idTypeOfProblemRental_idx` (`idTypeOfProblemRental`),
  CONSTRAINT `idRental` FOREIGN KEY (`idRental`) REFERENCES `rental` (`idRental`),
  CONSTRAINT `idTypeOfProblemRental` FOREIGN KEY (`idTypeOfProblemRental`) REFERENCES `typeofproblemrental` (`idtypeofproblemrental`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problemexitlocation`
--

LOCK TABLES `problemexitlocation` WRITE;
/*!40000 ALTER TABLE `problemexitlocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `problemexitlocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental`
--

DROP TABLE IF EXISTS `rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental` (
  `idRental` int NOT NULL,
  `startDate` date NOT NULL,
  `idObject` int NOT NULL,
  `idTenant` int NOT NULL,
  `returnDate` date DEFAULT NULL,
  `rentalManager` varchar(45) NOT NULL,
  PRIMARY KEY (`idRental`,`startDate`,`idObject`),
  KEY `idObject_idx` (`idObject`),
  KEY `idTenant_idx` (`idTenant`),
  CONSTRAINT `idObject` FOREIGN KEY (`idObject`) REFERENCES `object` (`idObject`),
  CONSTRAINT `idTenant` FOREIGN KEY (`idTenant`) REFERENCES `collective` (`idCollective`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental`
--

LOCK TABLES `rental` WRITE;
/*!40000 ALTER TABLE `rental` DISABLE KEYS */;
/*!40000 ALTER TABLE `rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typeofproblemrental`
--

DROP TABLE IF EXISTS `typeofproblemrental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofproblemrental` (
  `idtypeofproblemrental` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  PRIMARY KEY (`idtypeofproblemrental`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typeofproblemrental`
--

LOCK TABLES `typeofproblemrental` WRITE;
/*!40000 ALTER TABLE `typeofproblemrental` DISABLE KEYS */;
/*!40000 ALTER TABLE `typeofproblemrental` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-04 10:41:13
