CREATE DATABASE  IF NOT EXISTS `voguetexsystemdatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `voguetexsystemdatabase`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: voguetexsystemdatabase
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `expensebudget`
--

DROP TABLE IF EXISTS `expensebudget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expensebudget` (
  `budproductioncharges` double NOT NULL,
  `budsalaries` double NOT NULL,
  `budtravelling` double NOT NULL,
  `budrepair` double NOT NULL,
  `buddepreciation` double NOT NULL,
  `budwater` double NOT NULL,
  `budelectricity` double NOT NULL,
  `budinsurance` double NOT NULL,
  `budrent` double DEFAULT NULL,
  `budsecurity` double DEFAULT NULL,
  `budcommunication` double DEFAULT NULL,
  `budfurniture` double DEFAULT NULL,
  `budother` double DEFAULT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expensebudget`
--

LOCK TABLES `expensebudget` WRITE;
/*!40000 ALTER TABLE `expensebudget` DISABLE KEYS */;
INSERT INTO `expensebudget` VALUES (3,3,3,3,3,3,3,3,3,3,3,3,3,1),(2,2,2,2,2,2,2,2,2,2,2,2,2,2),(4,4,4,4,4,4,4,4,4,4,4,4,4,3);
/*!40000 ALTER TABLE `expensebudget` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-24 19:22:47
