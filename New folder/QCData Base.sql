-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: voguetexsystemdatabase
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
-- Table structure for table `fabric_inspection`
--

DROP TABLE IF EXISTS `fabric_inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fabric_inspection` (
  `colourNo` int(11) NOT NULL,
  `pieceNo` int(11) NOT NULL,
  `ticket` double NOT NULL,
  `Act` double NOT NULL,
  `1point` varchar(5) NOT NULL,
  `2point` varchar(5) NOT NULL,
  `3point` varchar(5) NOT NULL,
  `4point` varchar(5) NOT NULL,
  `comments` varchar(50) NOT NULL,
  PRIMARY KEY (`pieceNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabric_inspection`
--

LOCK TABLES `fabric_inspection` WRITE;
/*!40000 ALTER TABLE `fabric_inspection` DISABLE KEYS */;
/*!40000 ALTER TABLE `fabric_inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricregular_information`
--

DROP TABLE IF EXISTS `fabricregular_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fabricregular_information` (
  `date` date NOT NULL,
  `dyeLotNo` int(11) NOT NULL,
  `rollNo` int(11) NOT NULL,
  `contractWidth` double NOT NULL,
  `fabricDescription` varchar(45) NOT NULL,
  `fabricComposition` varchar(45) NOT NULL,
  `fabricConstruction` varchar(45) NOT NULL,
  PRIMARY KEY (`dyeLotNo`,`rollNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricregular_information`
--

LOCK TABLES `fabricregular_information` WRITE;
/*!40000 ALTER TABLE `fabricregular_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `fabricregular_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finalproduct_inspection`
--

DROP TABLE IF EXISTS `finalproduct_inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finalproduct_inspection` (
  `date` date NOT NULL,
  `pieceId` int(11) NOT NULL,
  `buyer` varchar(45) DEFAULT NULL,
  `orderNo` int(11) NOT NULL,
  `orderQty` int(11) NOT NULL,
  `styleNo` int(11) NOT NULL,
  `productType` varchar(45) NOT NULL,
  `sampleSize` varchar(45) NOT NULL,
  `fabric` varchar(45) NOT NULL,
  `construction` varchar(45) NOT NULL,
  `trims` varchar(45) NOT NULL,
  `print` varchar(45) NOT NULL,
  `wash` varchar(45) NOT NULL,
  `clean` varchar(45) NOT NULL,
  `measurements` varchar(45) NOT NULL,
  PRIMARY KEY (`pieceId`,`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finalproduct_inspection`
--

LOCK TABLES `finalproduct_inspection` WRITE;
/*!40000 ALTER TABLE `finalproduct_inspection` DISABLE KEYS */;
/*!40000 ALTER TABLE `finalproduct_inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packing_inspection`
--

DROP TABLE IF EXISTS `packing_inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packing_inspection` (
  `date` varchar(20) NOT NULL,
  `buyer` varchar(45) NOT NULL,
  `orderNo` int(11) NOT NULL,
  `orderQty` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `incorrectInfo` varchar(45) NOT NULL,
  `IncorrectPolyBagSize` varchar(45) NOT NULL,
  `cartonSizeOutOfSpec` varchar(45) NOT NULL,
  `contentIncorrect` varchar(45) NOT NULL,
  `quantityIncorrect` varchar(45) NOT NULL,
  `poorCartonQuantity` varchar(45) NOT NULL,
  PRIMARY KEY (`buyer`,`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packing_inspection`
--

LOCK TABLES `packing_inspection` WRITE;
/*!40000 ALTER TABLE `packing_inspection` DISABLE KEYS */;
/*!40000 ALTER TABLE `packing_inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regularinformation`
--

DROP TABLE IF EXISTS `regularinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regularinformation` (
  `BuyerName` varchar(45) NOT NULL,
  `SupplierNo` varchar(10) NOT NULL,
  `Season` date NOT NULL,
  `LaunchPack` varchar(5) NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BuyerName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regularinformation`
--

LOCK TABLES `regularinformation` WRITE;
/*!40000 ALTER TABLE `regularinformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `regularinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_goods`
--

DROP TABLE IF EXISTS `return_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_goods` (
  `productType` varchar(45) NOT NULL,
  `buyer` varchar(45) NOT NULL,
  `orderNo` int(11) NOT NULL,
  `DefectType` varchar(45) NOT NULL,
  `returnState` varchar(45) NOT NULL,
  PRIMARY KEY (`buyer`,`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_goods`
--

LOCK TABLES `return_goods` WRITE;
/*!40000 ALTER TABLE `return_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_approve`
--

DROP TABLE IF EXISTS `sample_approve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample_approve` (
  `Type` varchar(10) NOT NULL,
  `size` int(11) NOT NULL,
  `colour` varchar(20) NOT NULL,
  `styleNo` int(11) NOT NULL,
  `PONo` int(11) NOT NULL,
  `recivedQty` int(11) NOT NULL,
  `status` varchar(5) NOT NULL,
  `chkQuantity` int(11) NOT NULL,
  `rejectQuantity` int(11) NOT NULL,
  `defectType` varchar(25) NOT NULL,
  `remarks` varchar(50) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`styleNo`,`PONo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_approve`
--

LOCK TABLES `sample_approve` WRITE;
/*!40000 ALTER TABLE `sample_approve` DISABLE KEYS */;
/*!40000 ALTER TABLE `sample_approve` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-24 19:09:36
