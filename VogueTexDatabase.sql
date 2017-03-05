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
-- Table structure for table `assignmachine`
--

DROP TABLE IF EXISTS `assignmachine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignmachine` (
  `assetID` varchar(45) NOT NULL,
  `styleNo` int(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `factory` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`assetID`,`styleNo`),
  KEY `fk_StyleMachine_idx` (`styleNo`),
  CONSTRAINT `fk_AssetMachine` FOREIGN KEY (`assetID`) REFERENCES `machine` (`assetID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_StyleMachine` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmachine`
--

LOCK TABLES `assignmachine` WRITE;
/*!40000 ALTER TABLE `assignmachine` DISABLE KEYS */;
INSERT INTO `assignmachine` VALUES ('VTW-M1',3616,'Single needle','VTW','V1'),('VTW-M2',6056,'5 Thread overlock','VTW','V1');
/*!40000 ALTER TABLE `assignmachine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmaterial`
--

DROP TABLE IF EXISTS `assignmaterial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignmaterial` (
  `assetID` varchar(45) NOT NULL,
  `styleNo` int(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `quantity` float NOT NULL,
  `factory` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`assetID`,`styleNo`),
  KEY `fk_assignMaterialStyleNo_idx` (`styleNo`),
  CONSTRAINT `fk_assignMaterialAssID` FOREIGN KEY (`assetID`) REFERENCES `material` (`assetID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_assignMaterialStyleNo` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmaterial`
--

LOCK TABLES `assignmaterial` WRITE;
/*!40000 ALTER TABLE `assignmaterial` DISABLE KEYS */;
INSERT INTO `assignmaterial` VALUES ('VTW-MA4',3616,'Nylon Fabric',2500,'VTW','V1');
/*!40000 ALTER TABLE `assignmaterial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignworker`
--

DROP TABLE IF EXISTS `assignworker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignworker` (
  `assetID` char(8) NOT NULL,
  `styleNo` int(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `operation` varchar(45) NOT NULL,
  `factory` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`assetID`,`styleNo`,`operation`),
  KEY `fk_assignWorkerStyle_idx` (`styleNo`),
  KEY `assetID_UNIQUE` (`assetID`),
  CONSTRAINT `fk_assignWorkerStyle` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignworker`
--

LOCK TABLES `assignworker` WRITE;
/*!40000 ALTER TABLE `assignworker` DISABLE KEYS */;
INSERT INTO `assignworker` VALUES ('emp-0005',3616,'Worker','Tack Lable','VTW','V1');
/*!40000 ALTER TABLE `assignworker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `EmployeeNo` char(8) NOT NULL,
  `Intime` datetime NOT NULL,
  `Offtime` datetime DEFAULT NULL,
  `Date` date NOT NULL,
  `OtHrs` int(11) DEFAULT NULL,
  PRIMARY KEY (`EmployeeNo`,`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('Admin123','2016-09-15 12:12:42','2016-09-15 12:12:48','2016-09-15',6),('emp-0002','2016-09-14 02:20:41','2016-09-15 06:52:12','2016-09-15',5),('emp-0004','2016-09-14 05:59:23','2016-09-15 08:58:56','2016-09-15',3);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyer_details`
--

DROP TABLE IF EXISTS `buyer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyer_details` (
  `buyer_code` int(11) NOT NULL,
  `buyer` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dDate` varchar(50) NOT NULL,
  `delivary_mode` varchar(45) CHARACTER SET dec8 NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`buyer_code`),
  UNIQUE KEY `#_UNIQUE` (`buyer_code`),
  UNIQUE KEY `E-mail_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer_details`
--

LOCK TABLES `buyer_details` WRITE;
/*!40000 ALTER TABLE `buyer_details` DISABLE KEYS */;
INSERT INTO `buyer_details` VALUES (1,'Eddie Bauer','Edd@gmail.com','2016-12-27','Ocean','CANADA'),(2,'Eddie Bauer','info@TM.com.hk','2012-12-30','Ocean','Japan'),(3,'M&S RO','info@NIKE.com.hk','2014-12-28','Ocean','Japan'),(4,'Jacques Vert','info@POLO.com.hk','2014-12-28','Ocean','Japan'),(5,'GW-SMS','info@PAT.com.hk','2014-12-28','Ocean','Japan'),(6,'NTS','info@VICS.com.hk','2015-12-27','Ocean','Japan'),(7,'Marks&Spencer','info@Marks.com.hk','2016-12-27','Ocean','Japan');
/*!40000 ALTER TABLE `buyer_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_info`
--

DROP TABLE IF EXISTS `department_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department_info` (
  `DepartmentNo` char(6) NOT NULL,
  `DepartmentName` varchar(40) NOT NULL,
  PRIMARY KEY (`DepartmentNo`),
  UNIQUE KEY `DepartmentNo_UNIQUE` (`DepartmentNo`),
  UNIQUE KEY `DepartmentName_UNIQUE` (`DepartmentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_info`
--

LOCK TABLES `department_info` WRITE;
/*!40000 ALTER TABLE `department_info` DISABLE KEYS */;
INSERT INTO `department_info` VALUES ('dep-05','Account Department'),('dep-01','Human Resource Department'),('dep-04','Maintenance Department'),('dep-02','Sales Department'),('dep-03','Style Planning Dept');
/*!40000 ALTER TABLE `department_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `driver_ name` varchar(45) NOT NULL,
  `d_NIC` varchar(10) NOT NULL,
  `d_dob` varchar(15) NOT NULL,
  `d_gender` varchar(45) NOT NULL,
  `vType` varchar(45) DEFAULT NULL,
  `vNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`d_NIC`),
  KEY `e_k_idx` (`d_NIC`),
  KEY `f_k_idx` (`vNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES ('Athula Wijesundara','667519836V','23-02-1966','Male','Bus','KK-7575'),('Somapala Wijesinghe','684979214V','01-11-1968','Male',NULL,NULL),('Chandrasiri Rajapakse','887912462V','04-12-1988','Male','Bus','AB-7474'),('Kamal Perera','894216357V','14-06-1989','Male','Bus','KE-0877'),('Sunil Perera','902367892V','07-08-1990','Male','Bus','CAA-4785');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_info`
--

DROP TABLE IF EXISTS `employee_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_info` (
  `FullName` varchar(100) NOT NULL,
  `EmployeeNo` char(8) NOT NULL,
  `EPFNo` int(5) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `NIC` char(10) NOT NULL,
  `Gender` char(6) NOT NULL,
  `MaritalStatus` char(9) DEFAULT NULL,
  `Title` char(4) NOT NULL,
  `PhoneNo` char(10) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `DateJoined` date NOT NULL,
  `Department` char(6) NOT NULL,
  `EmployeeType` varchar(20) NOT NULL,
  `Designation` varchar(20) DEFAULT NULL,
  `Location` char(3) DEFAULT NULL,
  `Route` char(7) DEFAULT NULL,
  `BasicSalary` double NOT NULL,
  `AccountNo` varchar(20) NOT NULL,
  `OT` char(3) NOT NULL,
  `EPF` char(3) NOT NULL,
  `ETF` char(3) NOT NULL,
  `Remarks` varchar(500) DEFAULT NULL,
  `Image` blob,
  `Status` varchar(10) NOT NULL DEFAULT 'work',
  `RetirementDate` date DEFAULT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY (`EmployeeNo`),
  UNIQUE KEY `EmployeeNo_UNIQUE` (`EmployeeNo`),
  UNIQUE KEY `EPFNo_UNIQUE` (`EPFNo`),
  UNIQUE KEY `IdNo_UNIQUE` (`NIC`),
  UNIQUE KEY `PhoneNo_UNIQUE` (`PhoneNo`),
  UNIQUE KEY `AccountNo_UNIQUE` (`AccountNo`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `fk_empDept` (`Department`),
  CONSTRAINT `fk_empDept` FOREIGN KEY (`Department`) REFERENCES `department_info` (`DepartmentNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_info`
--

LOCK TABLES `employee_info` WRITE;
/*!40000 ALTER TABLE `employee_info` DISABLE KEYS */;
INSERT INTO `employee_info` VALUES ('Admin','Admin123',23455,'No.3,galle rd,Galle','1993-03-10','930000000V','Male','Unmarried','Mr.','0719928393','sr@gmail.com','2016-04-04','dep-03','Confirm','System Administrator','V1','Route A',45000,'9379272799','No','Yes','No','hbdbaskd',NULL,'work',NULL,'Admin123'),('A.P. Isuru Jayathilaka','emp-0001',12345,'No.223, Station Rd, Udahamulla','1994-07-22','942040660V','Male','Unmarried','Mr.','0719404659','isuruj.94@gmail.com','2014-03-12','dep-01','Confirm','Manager',NULL,NULL,450000,'12543215','No','Yes','Yes',NULL,NULL,'removed','2016-09-11','emp-0001'),('C.P. Chamara Weerasekara','emp-0002',78945,'No.215, New Kandy Rd, Malabe','1985-08-20','852040660V','Male','Married','Mr.','adsf','adsfa','0214-04-10','dep-01','Confirm','Director','V4','Route c',25000,'7841254632','Yes','Yes','No','shows enthusiasm for work place activities.',NULL,'work',NULL,'emp-0002'),('S.R Rajapakse','emp-0003',78947,'No.215, New Kandy Rd, Malabe','1993-03-10','852040677V','Male','Married','Mr.','0717313761','srrajapakse1@gmail.com','0214-04-10','dep-03','Confirm','Worker','V1','Route A',25000,'784125445','Yes','Yes','No','shows enthusiasm for work place activities.','ˇ\ÿˇ\‡\0JFIF\0\0`\0`\0\0ˇ\·\0\"Exif\0\0MM\0*\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ˇ\Ì\0¨Photoshop 3.0\08BIM\0\0\0\0\0êP\0The Eventorg\0XLFyPSOqclKFKEJErD_N(\0bFBMD01000ad0030000cf1c0000c13000007b340000293800005e3f0000bd5b000004630000c8680000ab6e0000dca60000ˇ\‚ICC_PROFILE\0\0\0lcms\0\0mntrRGB XYZ \‹\0\0\0\0)\09acspAPPL\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ˆ\÷\0\0\0\0\0\”-lcms\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\ndesc\0\0\0¸\0\0\0^cprt\0\0\\\0\0\0wtpt\0\0h\0\0\0bkpt\0\0|\0\0\0rXYZ\0\0ê\0\0\0gXYZ\0\0§\0\0\0bXYZ\0\0∏\0\0\0rTRC\0\0\Ã\0\0\0@gTRC\0\0\Ã\0\0\0@bTRC\0\0\Ã\0\0\0@desc\0\0\0\0\0\0\0c2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0text\0\0\0\0FB\0\0XYZ \0\0\0\0\0\0ˆ\÷\0\0\0\0\0\”-XYZ \0\0\0\0\0\0\0\03\0\0§XYZ \0\0\0\0\0\0o¢\0\08ı\0\0êXYZ \0\0\0\0\0\0bô\0\0∑Ö\0\0\⁄XYZ \0\0\0\0\0\0$†\0\0Ñ\0\0∂\œcurv\0\0\0\0\0\0\0\Z\0\0\0\À\…cíkˆ?Q4!Ò)ê2;íFQw]\Ìkpzâ±ö|¨iø}\”\√\È0ˇˇˇ\€\0C\0		\n\n\r\n\n	\rˇ\€\0Cˇ¿\0\0§\0¢\"\0ˇ\ƒ\0\0\0\0\0\0\0\0\0\0\0	\nˇ\ƒ\0µ\0\0\0}\0!1AQa\"q2Åë°#B±¡R\—$3brÇ	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzÉÑÖÜáàâäíìîïñóòôö¢£§•¶ß®©™≤≥¥µ∂∑∏π∫\¬\√\ƒ\≈\∆\«\»\…\ \“\”\‘\’\÷\◊\ÿ\Ÿ\⁄\·\‚\„\‰\Â\Ê\Á\Ë\È\ÍÒÚÛÙıˆ˜¯˘˙ˇ\ƒ\0\0\0\0\0\0\0\0	\nˇ\ƒ\0µ\0\0w\0!1AQaq\"2ÅBë°±¡	#3Rbr\—\n$4\·%Ò\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzÇÉÑÖÜáàâäíìîïñóòôö¢£§•¶ß®©™≤≥¥µ∂∑∏π∫\¬\√\ƒ\≈\∆\«\»\…\ \“\”\‘\’\÷\◊\ÿ\Ÿ\⁄\‚\„\‰\Â\Ê\Á\Ë\È\ÍÚÛÙıˆ˜¯˘˙ˇ\⁄\0\0\0?\0˝\ÿIöˆ\–|•d\Ë:St\Õ\Í\◊Q\À1e?√öt&LÜV\Ô÷¨}™Vm€Öp\«(\Ÿ\Œ[Ùq≠F\Ã\Œ\÷4\È.dëYXå\‰Tˆ:\Âbˆ\∆	´E\\ú\ÓΩ\ÂcÛ5gS!£:û\“G_ˆõQI¶å∂\◊iüñ5\Á≠vì`_õèAYÛ@\œ\ÃŸ¶&cÚ\»\«ÒÆ\ |i&¢˜9ßé\Á~Ò[\≈o,è\n\«\Â$d◊ö|amﬁØØ\€\\Cn\“,q¸\«“Ω:\‚\⁄F;|√•|\Ì˚X˛÷ög¡∑ö\∆\‚\„l\–\∆L¡Xn\‹u\Ê\‚∏>Ü`⁄©6Æ\Ô†}r§⁄Ñ\Í\Z\Óã\·XÛ™7ùs\"#ä#ªp\¬x£ˆ™\”¸8ÒM´mmdä\€\—˝}\Ô_|bˇ\0Çë\Ëü\⁄WVˆ◊óHAKi\–d¡\Ì\Î_0¸E˝¢µﬂà∑7^[_B\”uucü‹Ä1ö˚LÉÉ9t:0IæÆ\◊cî]Ø;øCÙ/ˆä˝∂t\›o√ìfxÅgπé&4(\Ë\ÿ\‰\Â5ÒE\œ\Ìágln\"\◊tªXıyò^An|ó\'¶BÒ\Ì“º2\◊T\÷/¶ô¶í\Í+ÄH3ô=∞*\‹v€ï∞\Ã\”0\∆›õ¡5˜X<\r(;7sÇµI5\ÓF\»˙[ˆKˇ\0Çê¯ª\‡ü\ƒ]6\„\Ì2I°\œt<\ÿCEÂìÉÅ⁄økæ~\“~¯è†X\œi®\¬Û]F¨Puˆ=´¡Ü\”K∫\⁄\…\√%\ﬂ»æ\\Cp\'é=\Î\ËﬂÄøµU∑¬ñm\‚;â!çR;Iê…Ö#=oJ\‰\Œ2öxØz¥óaa\Â(?yü∂ê\…\Ê®a˜}MK^q˚)|Fè\‚ß¿_kKp\◊Mqjí1\‰∞\‡\ÁﬁΩ5˘ΩH∏M\¬]MJ\Í\Ë(†t¢††¢ä(\0¢ä(;b\«\Â\Õ3s\„\Ô ¨Gugxs\ƒ-¯‘ãfß\Ê≠\Ï+Ø\⁄o#+\¬˚˚u´≤\„4\Ô≤l\‰äiUÑÂä©˜4πÆ.[êm\r˙\n∂Æ?:áib≠û˘©Éd˚öQÃô5_\Ì\n?à¥G\ƒΩkAö\Ó\Œ8-n;yè∑\„_yô∂∞˝kÄ¯Ωk5\Êüxê\∆>t˘\Œ:÷îk ï\Â«°ÉßUå^\«\Ê.ã˚xgOÒZ\…˝ók!‹§\ÓL\Ì?ç{≠\◊\Ï°\·K\r∆£K”õ˜c8ÑsWºVí[kn∞\∆≈îÚTu\"ò5-IQL\ \€1úgö¯π\„\Î‘¨‹§\œ\ﬁ#Å•O\r≠cá∂˝ì¸/ˆ©tª4ì\ q_%˛\÷_,~¯±mmòú\‰˛Elûı˜r\Î\Àn:≤û˘Øåˇ\0\‡•z~£™I\“\ŸHˆ%8πQïåÉﬁæÀÖÒ%ãåe-è\‚l=?™9(›Æ\«\œ˛1\Ë∫¸∑⁄ï\‘l∂eÖíãÅ¡¸˚˚T◊û óSé\⁄yÆ1q2±X±\'öÛªM~g\”>\ŒUï|∂$Û◊µu_∫∆≠ˆm‰πñ˘Ñaw7†\‚øhßGë˚I£Ò:ÿó/\›\√sˆ\Î˛Ò™I´˛\«\Zl\Ã€î]œ±}s_UW…øG6]ˆFÉOû9!ö\Œ˛Tx\›v≤ú\ÁW\÷D\◊\„ô≈æπR\€s3\Ë0\◊ˆQæˆ\’¢ä+\Œ7\n(¢Ä\n(¢Ä<N\€>Vd¿\œZªc\‚\À@fl)\∆	ØÕèáøq_\√=|C≥£\Î\ZK7\ \Ïcﬁ´˘W–ü?‡≠ü>\"§+m\‚õ{wìI¡å˛¢ΩgÅ¨∑ã<X\‘[£\Î´àWí\\\«men	…≠\‘dΩΩM\«\Ô0»Ø#ü\Ì\‡\œM∂∫˛ü\"\»7.\ŸG\"ªˇ\0x\ÀL\‘\Ô\"Ú/m\ÊV9 æk	Sq\”_∏\÷5Vz +ÚØµ0Œ±?\ÎUVµ)\Ê4À¥w\œN\„\≈\Z\\,YØ πqR©IªÿøiÆl;¨£\Ê\„“æ˝©ˇ\0mè¸÷ø∞ı\…nm\Ó.Pî[≥B\Ó\\p?\ZÙè¯Ωõ\¬\◊_\ÿ˜VÚﬁ∏¬Ä\„?Öyè~\È?¥_¡ù[KæÛ\·\‘%öhwIû~S\∆E)Rï˘Zv=∂•8\’Sì\€\ÊxOâ˛2\ÈRi\Ì™\≈}m5ù¿2$—∂\Â#\Î^m§~\ﬁ~\Z¨∂ˆ∂\ZÜ¢–∂\¬\Î\Ó\…ıπ\‡_\ÿ:Oá\r5õ=[^ºõL”ÆX\«/\Ÿvì\’<ûô5\«x\√ˆRˇ\0¡\Ì˚_\¬\⁄$µ\‘\0ûVû@°p\0Œº|6SG\⁄MI\ﬂ\Ê~Ø[>s£ŸÆ\«mß~\÷\Z/åfxo4π4\ﬁ¡\»õ¨xè\√\ﬁ&∞∏\”\Ó&∑∫µ∏]¨Æ3¡ÙÆ\'\·\'\√këÀ®i\"\“\“7Ã±\Ôfyr¿\∆q^õ}K∫Òdó\⁄]º\÷Z*∏˚4 Äu\œ\„^ù\·\ËI.k?ºÛ•à≠RÒ\‰mwz#\‡è⁄£ˆv\”|ÒI•\Í^Mé†Å\‡ÄD|\ŸXÒÖéæıÙó\ÏE\n\◊\‡\r≤\›xéKXµ\Õ`,ê˘òl§qå˜\ÊΩˆÄ˝ô≠æ%\›\Ëw–≤\√q¢ÃÖ8`~ï\–¸V[x´∆óêÿñê†H*q\—\0\Î_Mòg\’\'ÇÖ\…ﬂ´<,Ø!•\¬u*%k]vG\ÿ∞çÛ^|1æVâwA®Hûwy:s˝+\‹˚◊ï~\«˛	õ¡?t\ËÆch\Ó.N\Í\›~cëüzıA¿¸k\‰∑’û6g(\À9Ck\Ë:ä(†\‡\n(¢Ä\n(¢Ä?ã}{≈ã\ÿ˚0π\ËGZ\Èº\‚TÇ\ÍI\ZNr§\‰W©¯\œˆDµ\‘\‰âlUóß WO\‡ÿé§n<ﬂòs_¶ai\ŒKôü#Rº#¢g\·\⁄\ﬂ\\\—n\÷8<CÆG\ÂÇ;Ü¿Ø\—\Ô¯&ó\Ì!™k>∑õXÒïÙ∑lÕÖûL≤˙uØó|!ˇ\0˘\—Q£géG|˜\Ô^\ÌøˆNè\¬QB4˘Æ\Ì\’OE~+lFΩcé•yøÑ˙\œˆ˝˝ß5Ø~Œ±C\·ü][kWoâ° ∏\‰˛ï\Êﬂ≥\Á\Ï´˚A~“û∂\◊\‚u›å7KïY\‰!òu˛Qß\ÏÛ/ç†∑áV∫∫ºé<mW9+\È/Å7>&¯O\·´}3Kºg\¬G$A∂è≠yò\Íuiaπ0<™W\’»öt\’Zó\ƒ7o#\≈\Â˝üæ5¸#Ò\\z}\Áç\Ô\ÔZÃé@\ ﬂÅı∑É>2\Í\ﬁ¯qq\‚\„õT´\ Ä\‚™\≈i}\‚=CÌ∫îã4\ÃA\'h°\„ˇ\0G\‚ˇ\0Ü∫ñïêØqn˚qÜè\‰+\∆\Õ*\‚qe\nñR]Vá\“p˝*41ëî\Ó\„Ÿç\◊˛-Ëóø\r\Ì˛\›-´CyjiX~\Ïn9¸Ò_0xˇ\0≈í¯k\ƒÒi˛ºµ’º3\"\Ô∏€è›ìúÅ^oßhæ+Òè\¬\›F\«T\’5&≤∏}?\ Uái¿#é£©Ø6∂ ¯K\‡ã¯WV∏º∫Üf\Ÿ√ñq\Èö˘`πö©\Ôzü∂\‡+BíMR|∫˘üc|1Òüác≥\¬[\0\ÏIR]-œà!ºê,aV28˙\◊\»≥\ƒ=w\≈\◊\rF≤¥l6åuØ|ó\∆?ŸÑ+IåÄEq\—\¬:uπªGN+\nëˆ±VÒK‚ÖøÖ/a∑i}&Punk\⁄?g/\›¯Û\Ïózä\Ÿ\…˝†\¬H\‰K*˙\Í+\‰_â~2¥‘µâ/Ø!ç\Â∑_ê˙_D|¯´™hﬂ≥˜àÙ›±\ÍV62\‹Ÿ´r7*í?ï}Ö\\πNÑVœá\ƒc™\“sp\Ì¯xiv•XCnß+\nÖ¯´#≠|\Ô˚\'~÷ó?|9£¶¥akçBuïF\›ƒèO≠}r√Øn}\Î\Õ\∆`\Ía™{:ãS\Âi÷çUÃáîfê\n\\\◊)£\n)3JhÛ\0¢ä(∫\√_≠\«˛ã3\‹W®xW\·nü,q˛\Ê>q¸5\Ïñ4à\—H∂Uc\–t5\‘i?Ù\€hîà˙ï˙ˆÖÙG\Ãˇ\0g¥\Œ\¬\ﬂ	4\‚—ñÅO\·^ô·üÉñ;¢˝\ ıÙ≠\rN±\“\Ó≤t<W†xz˚OH\„\0.\Ô≠cS˙\\∏\‡ı‘Ø\·ﬂÖv0,πQ∑ûï\‘YxJ\÷‘Öéˆ¿´∂Z≈ú8\À\€\Ïk¢\“u}%ïåQ±˛Û\◊´KΩŒÖáKc\Z\«\¬?l+˚∞ã\”\Î]ü\Í≤≤≥m\‹1\œÙ™æ3¯≠•¯\“ÚV\Ëæa±\Âå˜Ø˝®i\rB\‚\ÁNo\ﬂ}óÏÆÜH\Œ.Aa\∆G#\÷Qß^ø∫ïóôµ<:N\ÂK\œ]k^ÒÖøáæ\√\r˛ì®\À\Ê≠\»\ÃL\‡	„úåW\œ˙oÜ5\Î\Ÿ$mV\◊J[∂ê\‰Fªês\‘fº\◊ˆª˝¨|sW\„V∑•hwë\√k≠L<¯\Âbw9\„?\Á“æn¯Å˚s|P7â\Ê\“nÙ\…-n£;Lœªa¯áN+ã0\·ºO2ˆ6Qz\ﬁ\Á\ËôS£E˝bÌØôˆ˛£\·\Î\‹\∆X efåm\Œ+áÒ\«\«\›\“\Õ\∆\….n∞B7Nk\Â\'ˆ¶Òã•o\Ì\ﬂCìÚ\«G\Â?^sShQjüu3\rê\ƒœ¥ÀÉ”π\\çP|¯ô^\«}\\\‚Xà⁄Ñw\Ëz_Énı/ç>3˚#∂≠\"£\Ì?(^ßö˚&\«\ƒ\÷\ﬂ\r˛ù6_∞\⁄⁄ò¸≤2Æ∏¡\œ÷ºw\‡ó\√\€?á˙>ZÜ∏\0yí\À\Z\Õ¯\„ÒI£Ç\‚\ŒW\ `\«w^+zò\≈^≤åâ\Ëe±r7Sv?\·\◊\ÌF∫.ªm\rö˝åirmGàT1 ÙØ∑¸/ˇ\0\"µæÒmæåtøµ7Ÿ¢y^)’≥t\Ìﬁø¸Ò+\≈\r5\Ì˙\≈4Ú3(ﬂÄ£\'^\—˚&¸Bæ\“tèkWo%ı\‰§G+7£;q_£f%M ¢\’$~IG(÷îv~\ÿ|9¯Øo\„…Æ-¸ø≥\ﬁ\€\‡ºe≤6∑!Å≠Ox˚O]™\Õy6\–\ﬂuG\ﬁ¸´Ú3\‡?¸+Z¯[s©\Ÿ\ÎØu-òØ#m≥*vì\ﬂ\Î\÷ﬂµ\Âø\∆˚xı=JÚxm@eîg◊ê+\„jpº£Z˜˜OZû%µnß\Ë«Ñ¸wß¯\∆\–\…g6ˇ\0UaÇ+`±VØ\Ã¯?j=C@h≤ºñW)Ñìhlt&ªo¡E|Ie≠\Õ’Ω\”/º\«ÛÆZ\‹1Y;“±§k1˜\Ë<Q_\Z\≈ˇ\05ºhî∂ükú\‡\—\\\Í˛3≤+\€\ƒ¯\ﬂ˛-˚@¯õˆd¯:u\œ\›-ç\ÍK\Ó+∏`ú\Z\ ˇ\0Ç\'~◊û*˝Ø¥[â<eq\r\ƒˆÚ∫.\’\⁄\«Û¨O¯8$o\Ÿjc\'¨\–ß©˘´\Õ\‡\€\ÁFû¸g˛Z\»z˚-a\ZìX7+\Îr©Ú∫‹®ı\Ô¯)?¸\ƒ≤/\Ì\'\·ˇ\0\r\Ë\⁄}≠÷ü´\›Cç!¡P\Áˆ÷•s%è\¬M/VµÑ\…wyNQFylç~Uˇ\0¡y\"\ﬂ˚\\x%°Vïé©h°Uw3|\Á•~ôxá\‚\Í¯7\·ë¶¨ë[\Í1\È\—n,~d;\∆=k´F∂#íù7\ﬁ\Ïsï:rî^∑\€\Ê\\“æ$4\…ÛI\n\‹Fπki>˜\Áü\ÈX>(˝§-\Ï\Á˚<\—\«GHI:W\…~:˝•$:lóP\ﬁG˝†¨¿…üòûz◊í¯áˆéæÒ5\‰\Õ4ä≥H°r¶æØ\ÍÙ†¨ê\Ë\‡ù˝\„\Î\Ê˝™¶∫\’\Ó,uWKõEa\‰Õø\r∑ﬂ±\≈h\ﬁ\√øm5ˆü©y\—»πX˜eÅØà¥ü\Z\\][\‹	ye#q\Í8≠?|a\‘<$ë\…ÃõGQø“¥R∂\«w\‘v±\‹¡Pº/a\‡\›O\√˜öµ\ËÜ˚T\“\„π\Áb:ì\Ô\≈xè~5[¯\√D\“u®%32\€-¥\Â∞\‚FA∑\'\Î÷´˛\◊5/éSE˝•™\Õqm•\∆cµÖ\ŒD`úúw\Î_1\\\È∑Zi\€\…\‰gv¿ˇ\0.~ï\›ı\n∞—Öfõ^v∑ë\ÁSÃ±X<\\\ÂAY=,ıπı√ø\Ëæ+\‘b∑∫±\“\⁄gpö5S˘\◊‘æY±±Ö\Ìm\„ç\ÏZ¸∞õP‘¨J\…Ú6\Ãç\€\Ëz\◊\“≥¸\'^¯i¶Vçµk=Ñ\¬\“\‰\…Åª\”8Øé\Œ8s\◊6W]ôˆ9/a§˘q\–\Â}\—ı\«?éQ¸\–%íÚ\ÈV_,¥q\nœèA_xÛˆó\’|q}4˜≥Iol\«˝Do\À\”&∏ã?uØå\ﬁ1∫\÷u+Ø6iú\Ï¸ê.xEÄVéõˆâw0,Ù<\ÁÒØß\»8zjQû\'ﬁùæ\„\Â¯ãâ™\„*J{\∆≤∂\ÔÕöæª∏∂æ{Å c.re\€=3\–„∏Ø¢<\„π,˛\Ìˇ\0wò#◊éµÛ\Áíc⁄àø3|†\nıΩ”º3co! \∆<\«\œ&æ∂u\Ã˘ZT\Í9+lèHø˘][\n\ﬁt@>{ö¿œè5èÜ∫ìO¶\ÃV9~¸gïa\Ó*ﬁë©R\rä≠4ä8ÿ•π™:wÇ<G\‚+\Ÿ#µ\–u+à˜cxÖ∂©˙\‚ºZÿäp˛$í>ìó◊´•9?$ŒÆ\Á„ú∫µ¨ç˘~`\ﬁ—Ü˚≠\\\‘\Óô\Ê\›r\À\r™ô\\o¡8\ÌVº˚\"¯\ÀXÒ\r\‚\›[…¶√∞≤ñ¡\œ\·öãq\Õ\‡¶62M∫\Ó\‚v[Åû@SçøŒßä\¬◊õÖÛ5Ωç3lßÄß\nò∫nñ\◊\Íztøµgç\'ë§Ñ≤\¬\‰¥kì¬ûÉÚ¢ºû-dàó˝0ØåÙ¢Ω-;µ]\œ\—O¯8_¡ˇ\0e˚\€\·ømº\–Ûû3∫º\'˛\rø\’cè\ƒZÖª∂˘8\'\Ÿk\Õˇ\0\‡ßYˆ¿¯\'s\·})f\›xSwô\‹m9\Î^ïˇ\0/˝ú|k\Á\·\Ì\«\≈-RA£¯_RÇa¶ñ!fπ~ä¡Oñ≠~Iá¿‘©Ütç≥≥öú*s¿˚£ˆü˝üºü#¯ì\‚uMkH;¥\ÿnb∂qê$+‹éqö¯\◊\„G\ÌE}\‚O\œ∑#JWpn’∑Òõˆ¥è„Ü∑\·\€\Õi¥\ﬂD\ÌG;aπ\«Lv\‰~µÚ?è|7\‚m\≈-°ä\‚Pª¡‹ß\'\0\Êæ\œáÜ\ná*Z\€VvaÈ∫µ9\ﬂ}\ﬂ\ﬁkâÆ=\¬˘ÖYX\ÁØΩb§[oqπé1ì^\—\‡O¯\'û•9µ∏\‘5GH•å;yr|\‹Û\È^\Ô\‡ø\ÿ#¡6\–\∆◊ülΩìqyH\œ\Âä˘äºMÉ][g\Í\‘|;\Õ\Âì\Ó|Ø\·qãWè\Ã ∞\Íz÷î^i\ÏUm\„öL\Á$)nk\Óˇ\0\n˛\À>Ùj-¸?o&\ﬂ˘\Î˚\Ã˛fª≠\'\·ﬁÉ†€Ö≥\—Ù˚u^w\nä\Ê©\≈Tö¥ ˛gDx¥_\Ô*%\Ëô˘S\‚_Ÿè\ƒ#∏i,Ù˚π|¡\∆Pä ≤˝Ç¸g®øôun\÷q˚Äx¸\Îıó[”≠\—K$1(\Ÿ\Ê~.µé\ÊVU\Î\Ë+\ \ƒÒf&~\…#\Î≤_Ú™Û_Zìg\Á›á¸\ﬁ{v›®kR*ˇ\0v4è\„G\Ï\Ÿ˚0\È>(>.ñ˚ŒëtΩA¨≠•˛!∑©?ù}s\„KO\Ï\€Y[ôÆ$Rë3`˛U\Ïo˚%¯ª\∆Øµ]7Eí{}[Wºë\ﬂpRYe(r	\œä\Ê\√Ò6eZ%\ŒÔ•≠¯üQôp	\‡+\·H\≈Aπss5Æö\Z\ﬂOo\\[F\–_j–´.v´Æ?ï:\◊˛	›£8U∂\÷5ˇ\0\ﬁ Û˘W\Ÿz\'\Ï}Ò\Z\¬ˆ\ﬁ9<>˛N—ú∫Ò˙\“\Îˇ\0≥\Ôå<\'™*\„\Ã<Ä\0aJ9˛qw9∏oÄ\Î\…¬ù:W\Ë\”Kı>u¯Aˇ\0\Â˛ç\‚KmCT∫∫‘£∑ê8â\„új˙:_Å˛’¨\¬I\·˝%\÷µ\Ÿ\«\›¯ˆh¯É\‚(¢kõlcb?÷∞z◊£\Ë?≤Ωm+$ó\÷j\Ãzoˇ\0\ÎT\‘\«f8ß\Ì*\ ^Z\ÿ˘öì\·\\¶2°E\”◊¢≥¸Oü¥_\0h>ëÜü§\È\÷}Û#-¯\”ıâ\÷\Œm™5ì∞Óöó\ÏMØm	$ø≤é\ﬂ=U˘˛U\–/\Ï]°®G\‘//&pB8\€¸´ñX<Ugi6¸\€:\ÈÒ∑`\‘e	\'¶\—K˛ÒßâµF∂‘Ñ\¬M≤BwüΩ\Ì_ô?µ\ƒ?e˝†5\ËÉcm\€MèMˇ\07ıØ\Ë\Ôˆi>áe4H.\œ33˘ö¸@ˇ\0ÇΩxZ?˛\ﬂ\ﬁ4Ü\÷\Ÿml\‰[yaç\0U\0ƒΩ?\◊\ﬂp.[WâõúóΩ}\«\‰\ﬁ-qˆ]û\‡)ap¥\ÂBW\Êv\⁄\ﬁMü;=¡f?3uı¢™´≥\‡ÛE~°\œ\«\·~\ÁÛ™≥∑¸w\·ˇ\0\Ïâ\·\—\„\È¥Kqwxcsu*∂\Ôø‘© •`~\—µt~\“[IäMQkünõ#ä@\ÔVˇ\0i\œ\⁄\◊CÒF°q§i˙≈øá\ÁèG¶\\bÇé\ ~\Ì|£\„Hu+gñi•Ü\Ê$è\"eïO\‚+\„®\·ia‹ßMk\'C\Ëx]=˝\Œ/\‚UÆãÒ/TìP\”u[ˆìxGbìF}=x¶¯7\«>.\”n\Ì\ÏıI$æ≥éE_2@±ê5ã\‚4˚\ÈöFO≥‹®\·Ä¡°µÒoˆ4j\ÕtdXˆìœß5\Õ*˜Ω\œbî$•\ÿ˝¢WÜ\Ô¸K\·-&htõ\…>\—k)[sÜ èj\Ô4O\ŸÛ\≈Z\¬F\÷˙-\ƒk\–˘Ä.?:˜\Ÿ\≈ˆ\ﬁ(˝ò˛\Í\Ìeº\–\Ìd\«9åW≠[J\Ã2:W\Êr\Àc\œv~ô[\≈g≥P•IG’∑˛G\Œ\Z\Ïù\‚Y\„Vú\€\€.pAìúWw°˛\…6ˆ\ \◊\◊SI\'Òoó˘W∞F˚π¸™aÛ/Òq\Ì÷∫#Ñß|Æ+ç3:\Ì˚¸æáö\≈˚4xF\ﬁ!\Ái\Ì3zª≥fí\Á\‡áÑ\ÏÚ|;¶≥\„í\«ÛØAù;v7\„⁄≥/\Ïg\«Ò\Í\’Jù%\–Û?∂±\“\÷U•˜≥äõ¿ZNù&c“¨b\⁄26¬º~ï\Œ¯\·\‹4©\Ït≥\€\Ÿ=\‹˜b<\„+óo‘öÙ[\Ì[ü˘i≥zΩc\'Ö\Ó,\Ê˝\Â\Âæ\‹Ù_õ˙WM(\Ïr\‚1*iRn^≠ø\ÃÕ∑éiY\⁄Y#õ\Àlç˜kb\ÀWY:z≤n5r-*\‹«Érßw\\!ˇ\0\nñ=\n‹ß˙\Ê\«l#Ök:âúº‹ø	≥\€\›D\“,£w`Ω™\‹7°ÏïïDõF25¯6›üpëæo˙fj’ñÜöo\›y\‰_A\‚¶5\–\Œz´ı+âçÙFI8¿\∆≠fjhn->V\Âzêk®M>7èòeìèMµV\Ê\ﬁ\÷\Ÿ6ãXWø\œ\'•kJ≤æ\∆},yŒπh\◊Q\ÌUb\Ÿ\…\0uØ\»ˇ\0¯8\‡U÷ÅÒã\¬~4˛\œhÌµ´eq.:\…pO\‡ﬂ•~\Œ\Õ<ø+mè˚∞«¥~|WÃüS\ﬂ\ÿ\ÁX˝ØæI§\Ëvkq®i\”˝Æ\›\n¸\Œ¡H\∆\ÔS_Gîf>∆ºe;%\‘ÚÒ\‘\\\·eπ¸˘æåª\œ\Ó€≠˙Ußˇ\0¡ΩüÆ¥¯$w\–ai#Vh\⁄\Ë\ÓBFpx\Í:Q_˝Øïˇ\0\œ\ÿ˝\ÁÉı\Zˇ\0\ |\œ˚|<\‘ˇ\0gﬂä:◊Å¸q§\…$vÛ∑\ÿ5@ø-\‹g%XÙ¸\Î\‰¥3\Ë\◊\rq£k\…\Â˘.\≈[\ËE~\‹¡T\ﬂ√üºeÆ¸\"ÒΩØˆuÆ∏\‚\„\√˛\"$óïF=@,8ıØ\√_éü5OÉøu?Íëµæ±•\ cw^côGFS\‹\Õ~eÅÕæ¥öøΩ˙viî\÷¡FùZã›®ìOÙıFÖˇ\0\≈;\À\Âdº∑\n\Ã1∏µá{\‚\…>\≈$kª\ÁR=q\\Ò\÷\⁄\ÌTúñß5g\ÏR<H˚Nf`÷Ωh≈∑°\‡ ∂∫ü\“w¸ª\‚_¸-¯\'ß\√k÷∏∂Ö¨\Ïæ\¬¡ü.<¶d\È◊µ}©¶4kˇ\0¨ê/ÒîW\‡\ﬂ¸g˛\nY¶¸\nM\‡ûµ§\ﬁ-Êª©yV\Zï≤Ü¥¨R	\‰ûk˜\¬isú™cG }\È_q?Z˘úvqìl\—TU4;òßç\‘yex4˘j\Ás{Ûä\Ã”≠%xDíM\«p£ÅVdhNa≠yn,|Æˆ#ö˛5$∑ìˇ\0í™À™Gª\Ê˚&\ﬂ˜≥ü“¥¥ ˇ\0©åmÔäôaç~\Ïk˘Q\À\‘\÷ˆ0_REqµ≠á\—	¢MW¯|¡¯@k°\n≠üëxˆßÖ\\g\Â\œ“ö∂»ûfrækK6\„Ñ\”c∑õq`\◊\Ï=vWQ\"ë\ﬂnM4ú\ÓÌö≤Nr5òúˇ\0\ƒ\ƒ\‡˙Z≤-§êˇ\0´æofa˛5™\◊,ã\€\◊5∑{Ü\ﬂ\ÎTN\≈Ht\Èäˇ\0«ª{oq\ÕGq•NyU∑á±¿\‹j\Í\‹Hûx\ÕJ≤˘ü˝zØz:ô\ W2,º?\Z>\È§i\ÿ˙ÙJË¥ã/\"=\€zÙ„†™p¬≥\Ã0:w∞ã±q\ÈX÷®ﬁåòG®¬úˇ\0´ù%\Œh~\\˛’ø\n\Ìj?Ñw±^HOà¨Ûykrárp\Á_ùæ5¯	s˚I\Ík†¯≥MÛu+UÚ°÷≠A[àÇóztp“øG<9ØH∑ëû™x<u\Êº\«\¬∑\–˛=\œ\ZØ\Õˆó€ü\Ó∞\„Ù5\Ê\Â5ú1*I\Ôπ˚^>ú^Xz±RQ\÷)ÙÚ\Óè ø\Z˛¡W\ﬂ\rRmJ\„\≈^ª\–\"%£πèQA<†q∑\…˚˚∏\∆1÷®\È˛–≠ÁµπB\”4*\nnó8\Îä\’˝¶˛\Z˝É\„/â¨¸\…?\–5)¢\nÅá=™∂ã\≈\⁄ŒÜ∑ñ∂Ø%à\Î2:W\⁄Gâ\È\≈˚-$ˇ\0Û:<)ä\ƒA\‚9c\Ê{¸¿÷æ9ˇ\0Çê¸3µçw\…˝•ˆña˛¬≥ˇ\0J˛è|?ZM$l~Ul\◊\‡O¸\Á\·UƒøRˇ\0\»\Ã\Ã˙=º˜\r\«O\›2ˇ\0Z˛ÇÌ¥∂ LΩ\……¨1ò∑Q˚\Í«ëSNçGKò–∑õt*ãR\‹C˚\Œ\›\Î]ãÛ5+.\–YªöÚ˘ë1‹Ü$*6ˇ\0:ì<}\‡8\≈1X©˙zTÖC\Zæm\nïò©s\≈(ìw©!èhß\»\ÌQ\Õ\‹Ãà≥/Ví6?á8ßI\÷\Ì¯\“-ìÚ\’\ƒ%\À”úb´¥LOC\”÷Æ8\»5]\¬ˇ\0yπ´çàñ\‡ü*r)S\Â˙ú˛î≤}\ﬂ∆£Ä\‚m¶Ø°Ñã˙jfN∏≠:£¶3zΩ\\u74é¡EVeñæm÷à\‹n\«Z\Â/ù†˝§≠\ŸI`å∑π\⁄(¢ºL∆ΩQ˚ñ?e\Êè\Ã\Ô⁄∂/7ˆ™¯Å\Ê	˝µrp˚d◊†|7¯á®\Ë\ﬂÕúFá\À#\Áè-˘\—E|ı?\Ìãı>“§Wˆ2\”\ÏØ\»˙˛\r˚Q´ˇ\0¡I5∂ü\ÊÚt]=éTZ˝\–”¢Sm∑QE~ïãm\⁄˝ë¸\≈S¯\“ıe∏\–y\€{t®Æ˛OóµW,H\ÍUç\»\„ﬁÆm\ \—Ei-ä\räíä+32•\ÕW\Œ\›\‘QZD∫~ïR\·£⁄ä*°πõ\‹7n®\‘\‚\·MV\∆264ı\€}j”±\rE\«SsH\Ï7qı¢ä*¨ä?ˇ\Ÿ','work',NULL,'emp-0003'),('C.P. Chamara Weerasekara','emp-0004',78942,'No.215, New Kandy Rd, Malabe','1985-08-20','877040660V','Male','Married','Mr.','656565','adfadf','0214-04-10','dep-04','Confirm','Director','V4','Route B',25000,'7841254611','Yes','Yes','No','shows enthusiasm for work place activities.','âPNG\r\n\Z\n\0\0\0\rIHDR\0\0\0§\0\0\0§\0\0\0µÖA\0\0\0sRGB\0Æ\Œ\È\0\0\0gAMA\0\0±è¸a\0\0\0	pHYs\0\0\ƒ\0\0\ƒï+\0\0\0tEXtSoftware\0Adobe ImageReadyq\…e<\0\0öIDATx^\Ìù	åT\≈Ü\ŸAuÑAQT`ãh@c0äâ	¢Q\–ïDü\—ƒ∏q´â¢†\"F¡T6áTîUQdqAÅz˜;\Œ}oÑ\Óô\Óπ˜vW›Æ?©\Ã\“\›uk˘˚\‘9ßNù™°=(á\·ÿ±c\Í\ÔøˇV¸Òá⁄øø˙˝˜\ﬂ’è?˛®V≠Z•÷¨Y£æˇ˛{µo\ﬂ>µw\Ô^˘yÙ\ËQ˘\\≠ZµTì&M\‘ißù&?[µj•∫v\Ì™zˆÏ©ö7oÆ\Í◊ØØÚÚÚTΩzıT\Ì⁄µUÕö5\Âsˇá#d9rD˝Ú\À/B>H˜\Õ7ﬂ®•Kó™\Ôæ˚N˝˘\ÁüBL\ndÖÑºüü˛÷®QCHy\“I\'\…OH	)u\Î\÷Ugü}∂\Í◊Øü:\ÁúsÑ¨ê¥i”¶Ú~á\‡\ÈRAƒ≠[∑™yÛ\Ê©%Kñà\‰Û%$d:LêR˙	:`¿\05j\‘(’∫uk!&$\Œu8BzÄ|s\Á\ŒUoΩıñ*))Qªv\Ì\È%êägúqÜ\Í‘©ì∫Ú\ +\’5\◊\\#$\Õu\‰¥ÉÆ¯ÎØø™O?˝T}¯\·á\Í\„è?V?¸C\‰d<ÉgÒLûMhm\ e‰§ÑD¸˘ÁüÖ\0H\ƒ…ì\'´\“\“R˘\€7P2ñ\ÈSN9Eu\Ï\ÿQ\›q\«\"1˘˚\‘SO4◊êsÑ¸ÎØø\ƒR~\ÂïW‘Ü\r‘∂m\€ƒÄÅ§\Ÿ\‰\√\–iŸ≤•∫\‡Ç\‘\Ë—£U∑n\›\‘\…\'ü\\˛éÑ\Ã>|X/_æ\\iO\nio≤µglÖ4¢\–\⁄D\€h#m•ÕπÑú!§g1\À˜\È\”G&=!L*¥ë∂\“f⁄û+\»	B2°ã/÷Ωzı≤Çå~°≠¥ô∂\Á\n)s\¬\ \∆\—=e\ ı\Âó_äih+m¶\ÌÙ!{Bb9Ø^ΩZ}Ò\≈\‚\Ë∂\r¥ô∂\”˙wƒñêH¨gv]û~˙iµ{˜\ÓÚW\ÏmßÙÖ>\Ÿ$\Â\”E,\›>L\ÿgü}¶ûz\Í)q83°∂O¢ßO™\”O?]ı\Ë\—CMò0A]r\…%Òt	â&#=zTóîî\Ë!CÜ\ËFç\Zù`(\ÿ^\Ë}£èÙ5nà›íM0ƒªÔæ´÷Æ]´:T˛\ﬂ¯Ä>\—7˙H_\„ÜXíeô›óŸ≥g´ü~˙)pÑéâ†OÙç>\“\◊\ÿ\Èì\"\'cÄc«é\Èoø˝V<X◊©SÁÑ•.nÖ>\“W˙L\ﬂ\„Ç\ÿHH¢d#€≤eã:|¯p˘\„˙H_\Èsú\"ÑbCH\"πø˙\Í´X\Íç\…@_\È3}èbAHO“´ù;w™_|QÙ´\\}•\œÙù1àbAH$!eõ7oéµ\”¯x\–W˙\Ãˆb\\§d,â\„{\Í‘©F\Ô\∆pd°Eã™]ªvRö5k\ \Z˙<m\⁄4£˚û¨\'$\ ˝û={‘é;≤d[à\0\'\"|÷¨Y\ÍÖ^Pw\ﬁyß\Í“•ã¯\‚\0XuAü∑o\ﬂ.ÑåÖ1\'∂∂\≈(--\’\„∆ç\”yyy\'∏FL)Ñë\Î\r6hè@Rˆ\Ó\›+±é√á\◊˘˘˘⁄ì†	?õJi‹∏±æ˘\Êõı∆ç\ÀG\≈^X/!9Ée≤u\ÕÙ≠∑\ﬁ*\Á≤Y∫)HÃã/æX\›s\œ=r\\Ås4\’\≈oø˝&c¿Q^\€a-!ÒΩ±DA\ƒl\ŒJú\≈\Êå\‰#a@E∞\\ìŸ¢oﬂæ™{˜\Ó\'ºû*\Ë;€àåcb≥_\“ZBbar∞üb™eç\—“¶Mu\›u\◊IzïDÄ∞ΩzıIy\—EUõî6åG*®ı\Âø[|p\Ó_ºx±˙˙ÎØçS\ËYñ\œ<ÛLYé\…NAfäD∆ãü—Ç˜û{Óπ¢Ç \È»ñëé\‘˜\‘/	\Ê\Âs\Ì€∑Wç\Z5*\≈2¸£J\⁄èÑz\Ë–°∫AÉ∫fÕö	ï˝lO*JàòG.=a\¬Ωi\”&}\‰»ëÚVWèL⁄ìpzŒú9⁄ìñi:åc¡ò06∂\¬\ %\€k∑HÇÉäBoäŒÑTdâ&5\ -∑\‹\"C&Ucù:uTAAÅ∫\Ï≤\À‘ç7\ﬁ(~\ÀT]Båc¡òÑëã([∞íê8\…L≤¨âﬁæ\¬≈ø8q\‚Du\√\r7®∂m\€\nI\”Y\—˙˜\Ô/\Ày:`L¸lm6\¬JB\"	\ÿ*4¡ÕÅ\√!\‰O<!:#∫ â£™CFÄDÖ\Ã::tHkGá1al#a≠Ñdó\Â)€Ä,HFŒπ\‡OLá@…Ä\ƒ%èdQQQZ\nc\¬\ÿ8	ôAê9å\ÏµŸ∂¨\√Ú#&ıù˛˘i\’Àò06ô\»\‡¨$$˚∑úœÜ`∆ßHb($\‚}˜\›\'ß\0	ñû\’,æIåõT•.c\¬ÿòºØ_¨$$˛9|n©Jryc¡\…\ÈMv≤¸¸|\Ÿq¡z~¸Ò\«\’s\œ=ß(p£Hù	\œ:\Î,u˘Âóßºµ»ò06¶\Ó\\U+		\“qk i.ΩÙR1\Z6lX•+Ö\◊!üC:°#™ázHÕú9Sç?^]q\≈\ÍºÛ\Œ≠Sp®>\\~¶\n[]>¿\ DeeeÍ™´ÆíüUÅ%ñd†$\rÄd3fÃêc§lØ\—u$\n\≈\'!RâüX…§\\\Ê`>Ü\nw$\ÕÙ\Ì	$\ﬂg˚ëvß≤Û\≈{Û\Õ7\Âßmà=!ëp#FåP<Ä\Ëy\ƒN\‚°€êíCR¸}H!$(§Ñ\»X∫¸›∏q\„P,\Á\Íùp“§Iídï4\–U¡fB21÷ÅHo∞˘\"UY<È®ßNù™˜\Ô\ﬂ_˛\Èˇ\√”≥$\ÕØ<xP{5ÚH\È°Cá¥GF›πs\ÁÑ}<æ06åëç∞VáL∏LHìú(K/í	à$d©éR¨.hí}5\Ó\»	Bb\'\"§-Äê∏ö\ƒ±\'$∫_PóO∂\·\\6˜!UƒøáV¡ZBö®\Îôõ\«\∆JB≤£\‡W7ö&\Œ`Lõl∫©Ç¿JB¢Oqí/\›X¡\\\0c\¬\ÿ0F6\¬JB\"8F\Íy\"\∆\∆\÷\’\√JB2\Ë\r¿w\Ëo0&åç≠_V+	\…~2qà©ı\ÂYeˆ¡9)HI5˙(]\–v˙êJc\¬\ÿ0F6\"ˆÚ¿Åj”¶M°\≈N\ÍÚÄŒÆpEw\»ÜF\·w˛\«kºá˜Ü\⁄N\ËKU∞]BZy.∑ìÛ¡HnD$G≤\…\ÁΩH\"∫ÉúU\Êa@82◊Æ\\πR=˚\Ï≥j˙Ù\Èr\ﬂ5Ω˜\ﬁ{j›∫uÚ~$\Z\ƒ\‰˘AÛDÄø¸Ú\Àr\’	u&ı≥+\≈yB\„\–#mÑµ˜\‘p\ÎˇK/Ω§ñ-[&ó†\'ªë\0\Âæs\Á\Œ\Í\’W_ï3*ÈÄ°ÅXD\€PHJ0˛|9HÖ\‘\‚\'¡∞˛B>\\.,õH(~iD/°k»ôÆüê≥kØΩV≠_ø>©Zêóó\'08Nq˝ı\◊KËúïÄê6Ç(ù≤≤2â\‰i›∫µDπ$+m€∂\’+V¨êhû™\‡M∏d&€ºy≥d+[∏p°9r§D\r5k\÷L$zF¢\¬{˘ü•\Í¢N\Í\Ê<´*\–f\⁄N=\√/åc¡ò06∂\¬ZB:\ÊI)Ωh\—\"›æ}˚Ñì\‰OR\Èâ\'\Í={ˆî:9Eõ={∂=z¥ˆ§ç&É˜W{Kb¬∫S)|ñ:®ã:©õg$\nâ;¥ô∂”áDu˚Ö1`,\∆\∆VXi\‘\0t&ñ?îxñ´\ v&Hw\\RR\"\Àk\"x\„ \«Gâ\»^æ|π\ËÑ\‘≤´±\“˘,uPu˙ıÛ,û…≥iC\"¯\…¸+K\ŸL\ﬂ\∆\¬ˆ@kìM˘ ˙C+}/ ∫dqq±\ËV˛Ñq\0¢Ö\r18\Ê0g\Œ…µàìäõ•:†ùd)C˜---B¢[≤\√\‚π\–\ÈYwâtOFZå5ÙT˙\≈\È\«L\¬˙\À7ô\‹\œ?ˇ\\ç3F\»\'√ÄlL:\“CIıˆ\€oˇ\œp©h§D\r\ﬂÚ\rûa√ÜI^~\Áˇ|a{\Ï11»ímÄ,\‹\∆¿âH$§Õà\≈m∞Ò¶õnRü|ÚI\“CPHE¨\Ï\€oø]}Ù\—GˇÛ\ÎQ∞ñ£íÜ©©àUNÙ:˜M\ÔﬁΩ\’3\œ<#Vv2ïÅ/\'*ü˛y!¶\Ìà!Y∂ërHø\ A1yD^CB$aUz°\Ô∫!\⁄<\Ë0!\r9TÊªå*_$$\ƒ\ƒY\ŸICég EëÆ∂\Ó\ŒTD,IHZ:n\‹8ëíL| ç	uíb/ôˇ/U†\√\‚P\Á˙åî0¿\ÈHùúO◊øi\"bAHÄ•˙\∆o®˚\Ôø_Æ	,ôO>˘§,üAá	≤†&êî\nï!pV\Ë\·áV#Gé¥7c\Óq∞\◊?p¸\ƒL©\Ïoß\nÙJ§≠ø|)\‘A]a\Í™Ù5\›dT¶#6ÑD\Ô\"\€\ÀkXñ&y\Ãq\Õ }ÉÇ:®+¨ª\È#}•\œ6˚O\0Kv\\p¯aΩl\Ÿ2\ŸÒt6\÷\ÿ@\≈\”\—tœû=C\…\ŸM\‘EùâûïN°oÙëæ\“\Á8!F_≠î|\ÓÑ!\‚†J>K,iú\ÿ…ú\Ó©¿wÑSWPÉã>\—7˙H_\Ès¨PN\ÃÿÄ}‹íí=d\»π\rÅ.)H¥>}˙\»5p’ëF|Ü\œzR(“ë>\—7˙H_\„Ü\ÿ@œí\’W_}µn’™U`\"x˙öE§KJüåEEEÅ\€¿\Á\È}¢o\’˘rÿÄX0a€∂m”Øø˛∫H∏0HI=\Ôøˇæﬁ≤eãﬁµkóÑy´êúä\ﬂ˘ØÒ\ﬁ∆≥˘<ı\–˙W2Ç\ÿ¯!ìÅ\‡â%Kñ®ª\Ó∫KÇ0Ç\0˜\n)ñqBw\Í\‘I\r:T∂\Î¸`\\:lc≤k¥q\„F\ŸÚ#\¬\'\Ë\ÂÍ§è&ﬂÄ]\“ibOH\0π´z—¢EIC\–R\Ó\“,CHé\nTº	BrGÃÇÑê8\Ë=i&ØU¯/¨&Oû,ƒå;rÇê\ÏØX±B=¯\‡Ér.%à•ã\œ\œ[BeüiA}kû°ÑÄHeà\œsÇ/\œ!±>\…VΩ%\€⁄É[iB\Ê\–\Ì00\¬\–\È2Q|Ωë6\”ˆ\\A\Œ`¯V/G\nòtO∫%$D6\nm°M¥ç6¶k\’\«9±dW\À(WØëØ{√Ü\r ≥ZE\«L%ô|î 4ëp2\ﬁ\\Q◊≠[∑¯9æ´@\Œ@>2M†\Îq\÷ÉÅ£¸fC*¿ B\Â¶/å%˛\ÊX$\Õ5\‰$!}†K∞\Ó™U´\‰¿¬ÖC	§HÑç\·>\‚x´`â4ëª=˜¿\ƒ#ç∏ãÜ≥,¥g\…$ò6jû\≈3y6m†-πLFê\”\“\À4GÄò7oû8\“9uà\ÎÜ\√U∏çÇÆ!\‹66√∑H\ÿé\ÓQ£F\…\’tï˝ôπG\»\n\‡ò\ƒ\‰Ù!Ü;-Kó.ï\›v[»´C¡\◊X\’y$>JÇh)\ÏÚ∞´”Ø_?9lÜ\√\ÈBàò	âl!\0≤a¯¯íCd\‰\‚º:ñyU€Å∞††@R\„q\ÓÖÛ\‡\¬Ú%$KÆ/œâ\‡ô\"\‹EA$$\ÓG\«!9!åÇ[3åÇ#§ÉQpÑt0\néêF¡\“¡(8B:GH£`åím;\"o\ÿ	\Z˙_\ÿS6˘Ü~vàH*PU⁄æ ¿Iè≥ûù#\"åLŸæ4Üê\‰º!ˇˆ;\Ôº#˚\»A\”\ﬂ%;(\Ï%\ﬂv\€mí®\…DêÆè;p*KT\Zê˝Ù!CÜ\»U\"¶§Ç\Œ\Z!y,\€peee≤/L@C¶	}ÙQI∑«û≥){ êè± ]ﬂΩ˜\ﬁ+\ƒ\Ã!	Ù`,:t\Ë [ù\Ÿ\⁄\Ê\Ã\n!Yí\…tKî6)ã∑o\ﬂ.ˇ\À‘íM\")†ô\ŒYõí[ë\‡`ˇ¶R4Wñ\r8(é_≤	ˆ\‡x\Ô¯Ò\„%zù1\ \ Ò	ô)x\ﬂv\Ì\r∫^\Z<x∞n”¶çdÑˆe¨xÉØ=R6ÃòÉT˛4\⁄D\€hc¢∂GY< ú8P2´y\"\„˘É2FHO\ÍiO ÖA=zÙ–ûaëpP2Y¸\ƒM\‹~ïÈÅØûM\¬Jê¥ $ò£Y≥fiOJßtZXà¸û\Z¢±Yä\»\Œ0S¶LëÉU,\ÀŸÜÛH\‡,Ü\·b\Ÿ\0∫4Y5^{\Ì59|ñm0g\ËÙË∞åA\ƒã\·,\'f$\‡õ\œ7l\ÊÃô\⁄\”\Ÿd9®ï\∆]Åô(,çHÉl-\›˛RM≤±LWVò´ÇÇ=f\Ã\Ì	\ÌõëØ$ë\“3P¥ßú\Î\¬\¬B\Ì)\œ∆ë\—/®É\r\ ¯\“Õ≥x&\œ6AÖITò3\œ\Ë\—›ªw\◊3f\ÃH\È~\∆ àT˛≤¸Ãù;W\‰c=≥ò\–¯¸HïIUÇgÒLû•<ò3º®YÄãZ•àåê¯\”pa\‡\⁄AG2¥ë/NUge\¬\œ\‚ô6åÁäò\À0\“VärI*p\Ô∞ı\Î\◊œä\ƒNîL\Îí&\Îé\…\ns…ú2∑\ÃqàDBÚm\‚BL,k¨\ÈTÄ≈Ωn\›:ı\»#è»ç[Q\Ìê\0\Í\Ê<ãgf;ØP™`.ôS\Êñ9éëí¿Ä\È”ß\ÀOõÄ\«\ q\◊(u%\Í\Ê<\ÀT\›1¢û\€\–	\…4>¨ù;wZÛÕØz⁄¥i≤}\ÁoiÜ\Í¢N\Í\Ê∂}as\ \‹2«ë\ƒî/›°¡d}˜\›w\Î¶Mõ&\‘Cl(∏`:v\Ï®«é´7m\⁄ä+à:®ã:©\€T7O*Öπeéô\Î∞∫Ñ\ƒE¿j¸¥û¡!Æòı\Î◊ãÆÜ§ß\Í¢N\Í\Ê∂\"\ 9éd\…&?NT\·côÄ˜EïˆsWuXÆ \ﬂ\≈Cù\‘\Õ3lEîsâQ†\Ô\·fO7à.\…g©É∫®\”!9B%$\ﬂz<˚6˚+∑¡º§Í´é+à\œY\Í†.€¨\ÍdàjÆC%$íÄ¥\»6/\◊\«°˜°3U\«˜\∆g¯,uƒÖåÄ9fÆ\√ÙBÄ\–%dú\»\Ëc˜\Ó\›\‚¶YªvmZ¿{˘ü•é∏\Èo¥Ñ$,>éY`±ê\”\›≈±u7&0\ﬂaüΩqFMä`π\≈J\Ê\0V*ª8ºá˜⁄∏ìM8B¶é\Íb)ìA∑*\ﬁ\ÀgRá#d\Z¿ôÕ•ö+WÆ\…GxˇÒ\‡º\∆{xØ\Õl¿2M∞á\À\—].[\‚¸xE}í\ﬂ˘ØÒ\ﬁ\Îê!\”˙ ∑2¨^ΩZtƒäÆ ~\Áº\∆{ú\Óò>!´$!˚—Ña˘Æ \ﬂ\≈\√ˇx-K\‹\·D8BV\ËÜ8ªq\Î`¿P¯ùˇ9Ω±˙pÑ\0ñd\ﬂ\»Òç∑LÉ#d@`∏Lö4Iä3bÇ\√2 pÛ∞LSπÅ“É#§ÉQpÑt0\néêF¡\“¡(8B:GH£\‡\È`!åÇ#§ÉQpÑt0\néêF¡\“¡(8B:GH£\‡\È`!åÇ#§ÉQpÑt0\néêF¡\“¡(8B:GH£\‡\È`!åÇ#§ÉQpÑt0\néêF¡\“¡(8B:ÖP	\…%:a_§\„`.¢òo\'!åB®Ñ¨]ª∂jÿ∞a,oÛr¯7òc\Êö9°íF÷´WO’≠[7Ù+\«\Ãs\À3\◊aü–ó\ÏFç\Z©n›∫…∑\«!û`nôc\Ê:lÑN\»\ÊÕõ´±c«™v\Ì⁄π•;Ü`Nô[Êòπ°ù¢u\Î÷™∞∞\–I\…Ç9enô\„∞ıG:!A˝˙ıUó.]Tã-úîåòK§\"s\ÀGÅH…∑®oﬂæ™ˇ˛™eÀñ™Nù:\ÂØ8\ÿ\nÊêπ,..VEEEë≠~5tDû\Ï#Gé\»\ÌVã-RÛ\Á\œW[∑nïª\0˜\Ô\ﬂ/\◊g∏´\◊\ÃFÕö5≈ä\Œ\À\ÀS\r\Z4ê%zƒàj–†A™†† í\Â\ZDFH\0\È8†ˆ\Ì€ßv\Ï\ÿ!S.X∞@≠Y≥\∆\›xe8p\Ît\Ì\⁄U\r>\\ı\Ó\›[\Â\Á\Á´&Mö®∆çY£ÅRˇ¢E\Íôo\Ë\0\0\0\0IENDÆB`Ç','work',NULL,'emp-0004'),('Nadith Weerasekara','emp-0005',34566,'No.215, New Kandy Rd, Malabe','1985-08-20','877045656V','Male','Married','Mr.','6565','asdasd','0214-04-10','dep-03','Confirm','Worker','V1','Route D',25000,'7834535434','Yes','Yes','No','shows enthusiasm for work place activities.','?','work',NULL,'emp-0005'),('A.D. Karunarathne','emp-0006',99664,'No.215, New Kandy Rd, Malabe','1985-08-20','863123450V','Male','Married','Mr.','0112833235','karuna@gmail.com','0214-04-10','dep-01','Confirm','Director','V4','Route C',25000,'558844331','Yes','Yes','No','shows enthusiasm for work place activities.',NULL,'work',NULL,'emp-0006');
/*!40000 ALTER TABLE `employee_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `ideventID` varchar(45) NOT NULL,
  `venue` varchar(45) DEFAULT NULL,
  `eventName` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`ideventID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES ('ASALA1','Head Office','Asala Kalapaya','2016-08-04','high participation',55000),('ASALA2','Weligama Branch','Asala Kalapaya','2016-08-12','high participation',5600),('ASALA3','Kosgoda Branch','Asala Kalapaya','2016-09-02','The date wasnt supporting',44000),('AURUDU1','Head Office','Newyear Festival','2015-12-12','Rain Ruined the Event',20000),('AURUDU3','Koggla Branch','Newyear Festival','2016-02-12','high participation',30000),('PIRITHA1','Weligama Branch','Piritha','2016-10-23','Very Heigh Participation',52000),('PIRITHA2','Head Office','Annual Piritha','2016-05-30','low Participation',56000),('PIRITHA3','Weligama Branch','Piritha Chanting Ceromony','2016-04-06','low Participation',42000),('PIRITHA4','Kosgoda Branch','Piritha','2016-09-02','low Participation',42000);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenseactual`
--

DROP TABLE IF EXISTS `expenseactual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expenseactual` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` varchar(12) DEFAULT NULL,
  `productioncharges` double NOT NULL,
  `salaries` double NOT NULL,
  `travelling` double NOT NULL,
  `repair` double NOT NULL,
  `water` double NOT NULL,
  `insurance` double NOT NULL,
  `rent` double NOT NULL,
  `electricity` double NOT NULL,
  `security` double NOT NULL,
  `communication` double NOT NULL,
  `furniture` double NOT NULL,
  `other` double NOT NULL,
  `totalexpense` double NOT NULL,
  `totalbudget` double NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenseactual`
--

LOCK TABLES `expenseactual` WRITE;
/*!40000 ALTER TABLE `expenseactual` DISABLE KEYS */;
INSERT INTO `expenseactual` VALUES (26,'2016-10-28',100000,3000000,100000,10000,10000,15678,45789,12395,10569,15908,12967,12890,3346196,106200),(27,'2016-11-30',100000,3000000,100000,10000,10000,15678,45789,12395,10569,15908,12967,12890,3346196,106200),(28,'2016-09-24',100000,3000000,100000,10000,10000,15678,45789,12395,10569,15908,12967,12890,3346196,106200),(29,'2016-05-28',678000,3000000,30700,5600,4000,1200,4500,5400,4657,7000,2000,3800,3746857,106200),(30,'2016-04-16',678000,600000,30700,7600,3000,2000,6500,5900,4600,6000,2000,3800,1350100,106200),(31,'2016-09-16',100000,23364.583333333332,100000,10000,10000,15678,45789,12395,10569,15908,12967,12890,369560.5833333333,106200);
/*!40000 ALTER TABLE `expenseactual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expensebudget`
--

DROP TABLE IF EXISTS `expensebudget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expensebudget` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Frombud` varchar(12) DEFAULT NULL,
  `Tobud` varchar(12) DEFAULT NULL,
  `budproductioncharges` double NOT NULL,
  `budsalaries` double NOT NULL,
  `budtravelling` double NOT NULL,
  `budrepair` double NOT NULL,
  `budwater` double NOT NULL,
  `budelectricity` double NOT NULL,
  `budinsurance` double NOT NULL,
  `budrent` double NOT NULL,
  `budsecurity` double NOT NULL,
  `budcommunication` double NOT NULL,
  `budfurniture` double NOT NULL,
  `budother` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expensebudget`
--

LOCK TABLES `expensebudget` WRITE;
/*!40000 ALTER TABLE `expensebudget` DISABLE KEYS */;
INSERT INTO `expensebudget` VALUES (23,'2016-06-01','2016-06-30',2000000,1000000,1000000,2000000,50000,50000,1000000,200000,50000,50000,5000,10000),(24,'2016-07-01','2016-07-30',2000000,1000000,1000000,2000000,50000,50000,1000000,200000,50000,50000,5000,10000),(25,'2016-08-01','2016-08-30',3000000,4000000,1000000,2000000,50000,50000,1000000,200000,50000,50000,5000,10000),(26,'2016-09-01','2016-09-30',3000000,4000000,2000000,2000000,60000,50000,1000000,200000,50000,50000,5000,10000),(27,'2016-10-01','2016-10-31',20000,15500,15500,2000,5500,5000,1400,8200,5000,5000,5000,14500),(28,'2016-11-01','2016-11-30',20000,15500,15500,2000,5500,5000,1400,8200,5000,5000,5000,14500),(29,'2016-09-01','2016-09-30',20000,15500,15500,2000,5500,5000,1400,8200,5000,5000,5000,14500);
/*!40000 ALTER TABLE `expensebudget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabric_inspection`
--

DROP TABLE IF EXISTS `fabric_inspection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fabric_inspection` (
  `colourNo` int(11) NOT NULL,
  `pieceNo` int(11) NOT NULL,
  `ticket` int(10) NOT NULL,
  `Act` int(10) NOT NULL,
  `1point` varchar(30) NOT NULL,
  `2point` varchar(30) NOT NULL,
  `3point` varchar(30) NOT NULL,
  `4point` varchar(30) NOT NULL,
  `comments` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pieceNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabric_inspection`
--

LOCK TABLES `fabric_inspection` WRITE;
/*!40000 ALTER TABLE `fabric_inspection` DISABLE KEYS */;
INSERT INTO `fabric_inspection` VALUES (2367,0,10,9,'A3T2Y1','I3C2','B2','H1D1','No defects found'),(1245,11,19,25,'A3T2','I3C2','B2K2','H1D1','more defects found'),(2367,12,10,9,'A3T2Y1','I3C2','B2','H1D1','No defects found'),(2367,13,19,9,'A3T2Y1','I3C2','B2','H1D1','No defects found'),(2367,15,11,10,'A3T2Y1','I3C1','no','M11','No defects found'),(2439,16,33,17,'A3T2Y1','I3C2','B2','H1D1',''),(2034,26,29,30,'no','no','no','no',''),(2300,30,25,19,'A1T2Y2','I3C1','B2','H1D1','No defects found'),(2367,34,23,12,'A1','no','no','no','No defects found'),(2367,55,40,14,'no','no','no','H1D1','No defects found');
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
INSERT INTO `fabricregular_information` VALUES ('2016-08-04',13,3,123,'lines','Double Line','ABC Holders'),('2016-08-04',23,11,187,'Dotted','Line','ABC Holders'),('2016-08-04',25,12,254,'Dotted','Double Line','ABC Holders'),('2016-08-09',26,13,254,'Dotted','Double Line','ABC Holders'),('2016-08-04',34,72,254,'Dotted','Double Line','ABC Holders'),('2016-08-04',35,12,254,'Dotted','Double Line','ABC Holders'),('2016-09-14',44,41,176,'Dotted','Single Line','ABC Holders'),('2016-08-04',53,76,132,'Dotted','Double Line','ABC Holders'),('2016-08-04',59,33,254,'Dotted','Double Line','ABC Holders'),('2016-08-04',66,72,254,'Dotted','Double Line','ABC Holders'),('2016-08-04',71,31,254,'Dotted','Double Line','ABC Holders'),('2016-08-04',91,31,254,'Dotted','Double Line','ABC Holders'),('2016-08-04',94,42,254,'Dotted','Double Line','ABC Holders');
/*!40000 ALTER TABLE `fabricregular_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilitybreakdown`
--

DROP TABLE IF EXISTS `facilitybreakdown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facilitybreakdown` (
  `idfacilityBreakdownID` varchar(45) NOT NULL,
  `facilityType` varchar(45) DEFAULT NULL,
  `reportedBy` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `locationDeails` varchar(45) DEFAULT NULL,
  `breakdownDetails` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idfacilityBreakdownID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilitybreakdown`
--

LOCK TABLES `facilitybreakdown` WRITE;
/*!40000 ALTER TABLE `facilitybreakdown` DISABLE KEYS */;
INSERT INTO `facilitybreakdown` VALUES ('CPUY6666','Buildings','ENG-6666','2016-08-04','MATARA','Should be rapaired'),('RRT56666','Buildings','MECH-666','2016-08-05','KOSGA','Should be rapaired'),('TY6655444','Cafeteria','ENG-7689','2016-08-04','MAIN','Should be rapaired');
/*!40000 ALTER TABLE `facilitybreakdown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `final_transport`
--

DROP TABLE IF EXISTS `final_transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `final_transport` (
  `styleID` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `net_weight` float NOT NULL,
  `transport_type` varchar(45) NOT NULL,
  `request_date` date DEFAULT NULL,
  PRIMARY KEY (`styleID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final_transport`
--

LOCK TABLES `final_transport` WRITE;
/*!40000 ALTER TABLE `final_transport` DISABLE KEYS */;
INSERT INTO `final_transport` VALUES (1,100,750,'Sea','2016-08-24'),(2,100,750,'select one','2016-08-24'),(3,500,1000,'Sea','2016-08-26'),(4,5500,15000.8,'Sea','2016-08-27'),(5,25000,10000,'Sea','2016-08-30');
/*!40000 ALTER TABLE `final_transport` ENABLE KEYS */;
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
INSERT INTO `finalproduct_inspection` VALUES ('2016-08-14',15,'TOMMY',76,500,1323,'Shirt','M','No','No','no','No','no','Min1&M2','No'),('2016-08-14',23,'Lango',73,200,2434,'Trouser','S','No','No','Min2','No','Min1','Min1&M2','No'),('2016-08-14',24,'M&S',22,500,2245,'Skirt','S','No','No','Min2','No','Min1','Min1&M2','No'),('2016-08-14',32,'TOMMY',73,500,2425,'Jump Suit','M','No','No','Min2','No','Min1','Min1&M2','No'),('2016-08-14',35,'TOMMY',12,400,2425,'Jacket','XL','No','No','Min2','No','Min1','Min1&M2','No'),('2016-08-14',67,'M&S',21,500,2425,'Shirt','M','No','No','Min2','No','Min1','Min1&M2','No'),('2016-08-14',87,'Lango',57,400,1546,'Skirt','L','No','No','Min2','No','Min1M1','Min1&M2','No');
/*!40000 ALTER TABLE `finalproduct_inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income` (
  `Code` int(11) NOT NULL AUTO_INCREMENT,
  `Incomedate` varchar(20) DEFAULT NULL,
  `Sales` double NOT NULL,
  `totalExpense` double NOT NULL,
  `Grossprofit` double NOT NULL,
  `Interest` double NOT NULL,
  `Netincome` double NOT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES (101,'2016-08-02',4300000,1350100,1649900,10000,1659900),(102,'2016-09-02',3000000,1350100,1649900,1000,1649900),(103,'2016-07-04',7689000,1220100,6468900,5000,6473900),(104,'2016-06-09',9089000,8900100,188900,1000,189900),(105,'2016-06-09',8089000,7100100,988900,1000,989900),(111,'2016-09-05',3000000,1350100,1649900,10000,1659900),(113,'2016-09-30',1000000,1350100,-350100,10000,-340100);
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_info`
--

DROP TABLE IF EXISTS `leave_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_info` (
  `LeaveNo` char(7) NOT NULL,
  `EmployeeNo` char(8) NOT NULL,
  `DepartmentNo` char(6) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `FromDate` date NOT NULL,
  `ToDate` date NOT NULL,
  `FullDays` int(11) DEFAULT NULL,
  `HalfDays` int(11) DEFAULT NULL,
  `Reason` varchar(45) NOT NULL,
  `PhoneNo` char(10) NOT NULL,
  `Status` varchar(10) NOT NULL DEFAULT 'Pending',
  `ApprovedBy` char(8) DEFAULT NULL,
  PRIMARY KEY (`LeaveNo`),
  UNIQUE KEY `LeaveNo_UNIQUE` (`LeaveNo`),
  KEY `fk2_levDept` (`DepartmentNo`),
  KEY `fk1_levEmp` (`EmployeeNo`),
  CONSTRAINT `fk1_levEmp` FOREIGN KEY (`EmployeeNo`) REFERENCES `employee_info` (`EmployeeNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2_levDept` FOREIGN KEY (`DepartmentNo`) REFERENCES `department_info` (`DepartmentNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_info`
--

LOCK TABLES `leave_info` WRITE;
/*!40000 ALTER TABLE `leave_info` DISABLE KEYS */;
INSERT INTO `leave_info` VALUES ('lev-001','emp-0001','dep-01','Casual','2016-09-01','2016-09-02',1,1,'Personal','','Pending',NULL),('lev-002','emp-0002','dep-01','No-Pay','2016-09-01','2016-09-03',1,0,'Personal','4498','Pending',NULL),('lev-003','emp-0002','dep-01','No-Pay','2016-09-01','2016-09-02',1,0,'Personal','34234','Accepted',NULL),('lev-004','emp-0002','dep-01','Casual','2016-09-02','2016-09-09',1,0,'Personalad','asdf','Accepted',NULL),('lev-005','emp-0004','dep-04','Casual','2016-10-05','2016-11-02',6,1,'Personal','5478656','Pending',NULL),('lev-006','emp-0004','dep-04','No-Pay','2016-09-01','2016-09-03',1,0,'Personal','7879898','Pending',NULL),('lev-007','emp-0004','dep-04','Casual','2016-09-08','2016-09-08',1,0,'Personal','7985','Rejected',NULL),('lev-008','emp-0004','dep-04','Medical','2016-09-08','2016-09-17',7,2,'Personal','0714455507','Pending',NULL),('lev-009','Admin123','dep-03','Casual','2016-09-21','2016-09-30',1,1,'Personal','0123456789','Pending',NULL),('lev-010','Admin123','dep-03','Casual','2016-09-16','2016-09-18',2,0,'Personal','0123456789','Pending',NULL);
/*!40000 ALTER TABLE `leave_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machine`
--

DROP TABLE IF EXISTS `machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machine` (
  `assetID` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `modelNumber` varchar(45) NOT NULL,
  `serialNumber` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `ownership` varchar(45) NOT NULL,
  `factory` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`assetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machine`
--

LOCK TABLES `machine` WRITE;
/*!40000 ALTER TABLE `machine` DISABLE KEYS */;
INSERT INTO `machine` VALUES ('VTW-M1','Brother','001','1234','Single needle','Company Owned','VTW','V1'),('VTW-M10','JUKI','43566','2233','5 Thread overlock','Rent','TGK','V9'),('VTW-M2','ZOJE','002','123456','5 Thread overlock','Rent','VTW','V1'),('VTW-M3','ZOJE','567','45354','5 Thread overlock','Rent','VTW','V1'),('VTW-M4','ZOJE','098','0898776','5 Thread overlock','Company Owned','VTW','V2'),('VTW-M5','JAPSEW','2313','313','5 Thread overlock','Company Owned','VTW','V1'),('VTW-M6','JAPSEW','32423','434234','Pearl stitch','Company Owned','VTW','V1'),('VTW-M7','Veit 2003','43234','432434','Pearl stitch','Rent','VTW','V2'),('VTW-M8','JUKI','32424','4324','Iron','Company Owned','VTW','V1');
/*!40000 ALTER TABLE `machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machine_registration`
--

DROP TABLE IF EXISTS `machine_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machine_registration` (
  `MachineID` int(11) NOT NULL AUTO_INCREMENT,
  `Brand` varchar(45) NOT NULL,
  `Model_Number` int(11) NOT NULL,
  `AssetID` int(11) NOT NULL,
  `Ownership` varchar(45) NOT NULL,
  `Factory` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  PRIMARY KEY (`MachineID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machine_registration`
--

LOCK TABLES `machine_registration` WRITE;
/*!40000 ALTER TABLE `machine_registration` DISABLE KEYS */;
INSERT INTO `machine_registration` VALUES (2,'JAPSEW',1,122,'Rent','TGZ','V5','Pearl stitch'),(3,'JUKI',3,123,'Company own ','TGK','V4','Iron'),(4,'Veit 2003',4,124,'Rent','UTH','V1','5 thread overlocks'),(5,'Brother',5,125,'Rent','TGZ','V7','Pearl stitch'),(6,'Brother',6,126,'Rent','TGK','CPU','Iron');
/*!40000 ALTER TABLE `machine_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machinebreakdown`
--

DROP TABLE IF EXISTS `machinebreakdown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machinebreakdown` (
  `breakdownID` varchar(45) NOT NULL,
  `serialNum` varchar(45) DEFAULT NULL,
  `lineNum` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `reporter` varchar(45) DEFAULT NULL,
  `requstedSparePart` varchar(45) DEFAULT NULL,
  `error` varchar(45) DEFAULT NULL,
  `errorInDetails` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`breakdownID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machinebreakdown`
--

LOCK TABLES `machinebreakdown` WRITE;
/*!40000 ALTER TABLE `machinebreakdown` DISABLE KEYS */;
INSERT INTO `machinebreakdown` VALUES ('ABCD4556','V45','ENG-4567','2012-01-11','CHAIN-1234567','CHAIN-1234567','Abnormal Sound','The chain is over used'),('ABCDE2345','V45','ENG-4567','2012-01-21','CHAIN-1234567','CHAIN-1234567','Abnormal Sound','The chain is over used'),('ASC34456','ASDC445566','V13','2016-01-08','ENG-7890','NEEDLE-456','Brocken Needle','need to repair immediatly'),('ASCD4556','FGBFGBF566','V7','2016-01-06','ENG-6677','NEDDLE-678','ttBrocken Needle','need to repair immediatly'),('ASD003444','DFDG556677','V5','2016-01-02','ENG-5678','NEEDLE-45','Brocken Needle','need to repair immediatly'),('WER0025','WERT22334','MEC66','2016-01-02','ENG-6474','BEARING-008','Heating','Mechanicall repair'),('WER0043','RFGT34566','MEC66','2011-12-5','MECH-7887','NEEDLE-003','Brocken Needle','Immediatly Repair this');
/*!40000 ALTER TABLE `machinebreakdown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machinedifference`
--

DROP TABLE IF EXISTS `machinedifference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machinedifference` (
  `nextStyleNo` int(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `difference` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`nextStyleNo`,`type`),
  CONSTRAINT `fk_MachineDiff` FOREIGN KEY (`nextStyleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machinedifference`
--

LOCK TABLES `machinedifference` WRITE;
/*!40000 ALTER TABLE `machinedifference` DISABLE KEYS */;
INSERT INTO `machinedifference` VALUES (6056,'Flat Lock',0,'1'),(6056,'Single Needle',0,'1'),(6056,'Thread Overlock',1,'1'),(6098,'Flat Lock',0,'1'),(6098,'Pearl Stitch',-6,'1'),(6098,'Single Needle',7,'1'),(6098,'Thread Overlock',1,'1');
/*!40000 ALTER TABLE `machinedifference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manpowerdifference`
--

DROP TABLE IF EXISTS `manpowerdifference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manpowerdifference` (
  `styleNo` int(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `difference` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`styleNo`,`type`),
  CONSTRAINT `fk_StyleNoManPowerDiff` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manpowerdifference`
--

LOCK TABLES `manpowerdifference` WRITE;
/*!40000 ALTER TABLE `manpowerdifference` DISABLE KEYS */;
INSERT INTO `manpowerdifference` VALUES (6056,'Direct',5,'1'),(6056,'Indirect',3,'1');
/*!40000 ALTER TABLE `manpowerdifference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `assetID` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `quantity` float NOT NULL,
  `serialNumber` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `factory` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`assetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES ('VTW-MA1','JUKI',10000,'01234','Wool Fabric','Black','VTW','CPU'),('VTW-MA2','Veit 2003',100,'10294','Silk Fabric','Yellow','VTW','V1'),('VTW-MA3','JAPSEW',2500,'68392','Cotton Fabric','White','VTW','V1'),('VTW-MA4','Veit 2003',4500,'86823','Nylon Fabric','Black','VTW','V1'),('VTW-MA5','JUKI',995000,'23442','Cotton Fabric','Yellow','VTW','CPU'),('VTW-MA6','Veit 2003',31924,'3242','Nylon Fabric','Green','VTW','V1');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_registration`
--

DROP TABLE IF EXISTS `material_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material_registration` (
  `MaterialID` int(11) NOT NULL AUTO_INCREMENT,
  `Brand` varchar(45) NOT NULL,
  `Serial_Number` int(11) NOT NULL,
  `AssetID` int(11) NOT NULL,
  `Color` varchar(45) NOT NULL,
  `Factory` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  PRIMARY KEY (`MaterialID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_registration`
--

LOCK TABLES `material_registration` WRITE;
/*!40000 ALTER TABLE `material_registration` DISABLE KEYS */;
INSERT INTO `material_registration` VALUES (11,'JUKI',1,1,'White','TGK','V4','Silk Fabric'),(12,'JAPSEW',2,2,'Yellow','TGZ','V4','Silk Fabric'),(13,'JUKI',3,33,'White','VTW','V3','Cotton Fabric'),(14,'JAPSEW',4,4,'Yellow','TGK','V2','Silk Fabric'),(15,'Brother',5,5,'White','TGZ','V5','Nylon Fabric'),(16,'Brother',4,6,'Black','VTW','CPU','Silk Fabric');
/*!40000 ALTER TABLE `material_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materialdifference`
--

DROP TABLE IF EXISTS `materialdifference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materialdifference` (
  `styleNo` int(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `difference` float NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`styleNo`,`type`),
  CONSTRAINT `fk_StyleNomaterialDiff` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialdifference`
--

LOCK TABLES `materialdifference` WRITE;
/*!40000 ALTER TABLE `materialdifference` DISABLE KEYS */;
INSERT INTO `materialdifference` VALUES (6056,'Cotton Fabric',0,'1'),(6056,'Nylon Fabric',0,'1'),(6056,'Silk Fabric',3456,'1'),(6056,'Wool Fabric',-1668,'1');
/*!40000 ALTER TABLE `materialdifference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `order_no` int(11) NOT NULL,
  `item` varchar(20) NOT NULL,
  `country_origin` varchar(15) NOT NULL,
  `season` varchar(10) NOT NULL,
  `account_no` varchar(19) NOT NULL,
  `issueDate` varchar(20) NOT NULL,
  `endDate` varchar(20) NOT NULL,
  `supplier` varchar(15) NOT NULL,
  `supplier_no` int(11) NOT NULL,
  `country` varchar(20) NOT NULL,
  `delivary_mode` varchar(10) NOT NULL,
  `quntity` int(11) NOT NULL,
  `unit_price` double NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`order_no`),
  UNIQUE KEY `Account_code_UNIQUE` (`account_no`),
  UNIQUE KEY `Order No_UNIQUE` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (1,'Skirt','Sri Lanka','AU12','142235426','2016-12-27','2016-12-27','POLO',1,'','Ocean',230,4.12,972),(2,'skirt','Sri Lanka','AU12','835601623','2016-12-27','2016-12-27','NIKE',2,'','Ocean',203,3.8,771.4),(3,'Blouse','select','AU23','584934839','2016-12-27','2016-12-27','PATAGONI',3,'','Ocean',340,3.1,1054),(5,'short','Sri Lanka','AU01','386456426','2016-12-27','2016-12-27','Grimx',10,'','Ocean',678,5,3390);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
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
  `incorrectCartonMarks` varchar(45) NOT NULL,
  `poorCartonQuantity` varchar(45) NOT NULL,
  `other` varchar(45) NOT NULL,
  `describeOther` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`buyer`,`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packing_inspection`
--

LOCK TABLES `packing_inspection` WRITE;
/*!40000 ALTER TABLE `packing_inspection` DISABLE KEYS */;
INSERT INTO `packing_inspection` VALUES ('2016-08-18','Lango',49,500,'XS','false','false','false','false','false','false','false','false',''),('2016-08-18','Lango',72,500,'XS','true','false','false','false','false','true','false','true',NULL),('2016-08-18','Lango',73,500,'M','true','false','false','true','false','false','false','true',NULL),('2016-08-18','M&S',74,500,'S','false','false','false','false','false','false','false','true',NULL),('2016-08-14','M&SNew',33,500,'XS','false','false','false','false','false','false','false','false',''),('2016-08-14','TOMMY',2,500,'XS','false','false','false','false','false','false','false','false','');
/*!40000 ALTER TABLE `packing_inspection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preventivemaintenance`
--

DROP TABLE IF EXISTS `preventivemaintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preventivemaintenance` (
  `pvLogID` varchar(45) NOT NULL,
  `assetID` varchar(45) DEFAULT NULL,
  `serialNum` varchar(45) DEFAULT NULL,
  `LSDate` varchar(45) DEFAULT NULL,
  `NSDate` varchar(45) DEFAULT NULL,
  `conditionDetails` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pvLogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preventivemaintenance`
--

LOCK TABLES `preventivemaintenance` WRITE;
/*!40000 ALTER TABLE `preventivemaintenance` DISABLE KEYS */;
INSERT INTO `preventivemaintenance` VALUES ('JUKI-4556','VTW-857','GVH54678','2016-01-01','2016-09-02','Bearing was replaced'),('JUKI4455','VTW-004','FG467844','2016-03-01','2016-09-02','Needle reconditioned'),('JUKI4567','VTW-756','ADC456677','2016-07-01','2016-12-06','Electirlal system was replaced'),('JUKI567','VTW-758','NFJJJ4778','2016-08-01','2016-10-12','Needle replaced');
/*!40000 ALTER TABLE `preventivemaintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `Company_code` int(11) NOT NULL,
  `Order_no` int(11) NOT NULL,
  `company_name` varchar(45) NOT NULL,
  `Supplier_code` int(11) NOT NULL,
  `Supplier_name` varchar(45) NOT NULL,
  `country_origin` varchar(45) NOT NULL,
  `Date` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `shipment_mode` varchar(20) NOT NULL,
  `Currency` double NOT NULL,
  `Exchange_rate` double NOT NULL,
  `credit_trem` varchar(45) NOT NULL,
  PRIMARY KEY (`Company_code`),
  UNIQUE KEY `Supplier_code_UNIQUE` (`Supplier_code`),
  UNIQUE KEY `Company_code_UNIQUE` (`Company_code`),
  UNIQUE KEY `Order_no_UNIQUE` (`Order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseorder`
--

DROP TABLE IF EXISTS `purchaseorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorder` (
  `purchaseOrderID` int(11) NOT NULL,
  `styleNo` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `remarks` longtext NOT NULL,
  PRIMARY KEY (`purchaseOrderID`,`styleNo`,`size`,`color`),
  KEY `styleNo_idx` (`styleNo`),
  CONSTRAINT `fk_StyleNo` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseorder`
--

LOCK TABLES `purchaseorder` WRITE;
/*!40000 ALTER TABLE `purchaseorder` DISABLE KEYS */;
INSERT INTO `purchaseorder` VALUES (1,3616,'L','Black',150,''),(1,3616,'L','White',150,''),(1,3616,'XL','Grey',50,''),(1,3616,'XXL','Black',100,'black buttons'),(1,4567,'M','White',1000,'First Order'),(1,4598,'M','Ginger',200,''),(1,5225,'S','Pumice',500,''),(1,6056,'L','White',200,''),(1,6056,'XXL','White',34,''),(2,3616,'M','Grey',500,''),(2,3616,'XXL','White',1500,''),(2,4510,'XXL','White',500,''),(3,5225,'M','Pumice',1200,'');
/*!40000 ALTER TABLE `purchaseorder` ENABLE KEYS */;
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
  PRIMARY KEY (`SupplierNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regularinformation`
--

LOCK TABLES `regularinformation` WRITE;
/*!40000 ALTER TABLE `regularinformation` DISABLE KEYS */;
INSERT INTO `regularinformation` VALUES ('M&S','11','2016-08-04','P21','sample discripton'),('Lango','12','2016-09-20','P24','sample discripton'),('M&S','22','2016-08-04','P21','sample discripton'),('M&S','25','2016-08-04','P21','sample discripton'),('Lango','32','2016-08-18','P21','discripton'),('M&S','43','2016-09-02','43','some'),('TOMMY','45','2016-08-08','45',' discripton'),('TOMMY','51','2016-08-23','P68','sample discripton'),('Lango','52','2016-08-04','P34','sample discripton'),('M&S','53','2016-08-04','P34','sample discripton'),('M&S','65','2016-08-04','P21','sample discripton'),('M&S','66','2016-08-04','P24','sample discripton'),('M&S','67','2016-08-27','P32','sample discripton'),('M&S','78','2016-08-04','P21','sample discripton'),('M&S','79','2016-08-17','P28','sample discripton'),('M&S','83','2016-08-04','P21','sample discripton'),('M&S','84','2016-08-04','P21','sample discripton'),('TOMMY','86','2016-12-20','86','sample discripton'),('TOMMY','89','2016-10-12','P21','sample discripton'),('M&S','99','2016-08-04','P21','sample discripton');
/*!40000 ALTER TABLE `regularinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_goods`
--

DROP TABLE IF EXISTS `return_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_goods` (
  `returnBy` varchar(45) NOT NULL,
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
INSERT INTO `return_goods` VALUES ('Company','Skirt','Lango',23,'Cutting','Cannot Repair'),('Company','Shirt','TOMMY',29,'Trims','Cannot Repair'),('Customer','Shirt','TOMMY',33,'','Can Repair'),('Customer','Label','TOMMY',240,'Trims','Can Repair');
/*!40000 ALTER TABLE `return_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rg_type`
--

DROP TABLE IF EXISTS `rg_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rg_type` (
  `returnBy` varchar(20) NOT NULL,
  `productType` varchar(30) NOT NULL,
  PRIMARY KEY (`returnBy`,`productType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rg_type`
--

LOCK TABLES `rg_type` WRITE;
/*!40000 ALTER TABLE `rg_type` DISABLE KEYS */;
INSERT INTO `rg_type` VALUES ('Company','Button'),('Company','Lable'),('Company','Zipper'),('Customer','Jacket'),('Customer','Jump Suit'),('Customer','Shirt'),('Customer','Skirt'),('Customer','Trouser');
/*!40000 ALTER TABLE `rg_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_info`
--

DROP TABLE IF EXISTS `salary_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary_info` (
  `SalaryId` int(11) NOT NULL AUTO_INCREMENT,
  `Month` varchar(10) NOT NULL,
  `Year` int(11) NOT NULL,
  `EmployeeNo` char(8) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `EPFNo` char(5) NOT NULL,
  `BasicSalary` double NOT NULL,
  `EPF` double NOT NULL,
  `ETF` double DEFAULT NULL,
  `NoPayLeave` double DEFAULT NULL,
  `Deductions` double NOT NULL,
  `Bonus` double DEFAULT NULL,
  `OtAmount` double DEFAULT NULL,
  `GrossSalary` double NOT NULL,
  `NetSalary` double NOT NULL,
  PRIMARY KEY (`SalaryId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_info`
--

LOCK TABLES `salary_info` WRITE;
/*!40000 ALTER TABLE `salary_info` DISABLE KEYS */;
INSERT INTO `salary_info` VALUES (1,'September',2016,'emp-0004','C.P. Chamara Weerasekara','78942',25000,2000,750,1666.66,4416.66,2000,1562.5,28562.5,24145.83),(2,'September',2016,'emp-0002','C.P. Chamara Weerasekara','78945',25000,2000,750,1666.6666666666667,4416.666666666667,2000,781.25,27781.25,23364.583333333332);
/*!40000 ALTER TABLE `salary_info` ENABLE KEYS */;
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
  `remarks` varchar(50) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`styleNo`,`PONo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_approve`
--

LOCK TABLES `sample_approve` WRITE;
/*!40000 ALTER TABLE `sample_approve` DISABLE KEYS */;
INSERT INTO `sample_approve` VALUES ('Button',5,'Off White',312,97,1,'1',100,2,'Indentation',NULL,'2016-08-04'),('Button',3,'Perl White',1245,23,400,'1',200,5,'patches',NULL,'2016-08-04'),('Zipper',2,'black',2413,65,1,'1',100,45,'Indentation',NULL,'2016-09-04'),('Zipper',8,'dark blue',3111,25,100,'1',50,0,'no',NULL,'2016-08-04'),('Button',7,'Off White',3123,25,1,'0',100,50,'Indentation',NULL,'2016-08-04'),('Button',5,'Off White',3124,12,1,'0',100,2,'Indentation',NULL,'2016-08-04'),('Zipper',5,'Off White',3143,85,1,'0',100,2,'Indentation',NULL,'2016-08-09'),('Button',5,'Off White',3199,28,1,'0',100,2,'Indentation',NULL,'2016-08-04'),('Button',5,'Off White',3199,81,1,'1',100,2,'Indentation',NULL,'2016-08-04'),('Button',3,'Off White',3213,43,300,'false',150,2,'Indentation','','2016-08-04'),('Label',6,'Black',3921,35,200,'1',100,3,'wrog marks',NULL,'2016-08-04');
/*!40000 ALTER TABLE `sample_approve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockissue`
--

DROP TABLE IF EXISTS `stockissue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockissue` (
  `stockissueID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` varchar(11) DEFAULT NULL,
  `OrderID` int(11) NOT NULL,
  `Order_Type` varchar(45) NOT NULL,
  `To_Department` varchar(45) NOT NULL,
  `From_Department` varchar(45) NOT NULL,
  `To_location` varchar(45) NOT NULL,
  `Total_Amount` double NOT NULL,
  PRIMARY KEY (`stockissueID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockissue`
--

LOCK TABLES `stockissue` WRITE;
/*!40000 ALTER TABLE `stockissue` DISABLE KEYS */;
INSERT INTO `stockissue` VALUES (1,'15-07-2016',8,'Cotton Fabric','muttm','nkr','V2',25),(3,'28-09-2016',465465,'Wool Fabric','njsrnjsy ','evt','CPU',5465645),(4,'21-09-2016',1234,'Wool Fabric','njsrnjsy ','evt','CPU',5000),(5,'21-09-2016',1234,'Wool Fabric','njsrnjsy ','evt','CPU',6000),(6,'21-09-2016',123,'Wool Fabric','njsrnjsy ','evt','CPU',435345);
/*!40000 ALTER TABLE `stockissue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockorder`
--

DROP TABLE IF EXISTS `stockorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockorder` (
  `OrderID` int(11) NOT NULL,
  `Date` varchar(12) DEFAULT NULL,
  `CompID` int(11) NOT NULL,
  `SupplierID` int(11) NOT NULL,
  `Order_Type` varchar(45) NOT NULL,
  `Delivery_Date` varchar(15) DEFAULT NULL,
  `Unit_price` double NOT NULL,
  `Total_Amount` double NOT NULL,
  `Payment_Method` varchar(45) NOT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockorder`
--

LOCK TABLES `stockorder` WRITE;
/*!40000 ALTER TABLE `stockorder` DISABLE KEYS */;
INSERT INTO `stockorder` VALUES (1,'12-09-2016',1,1,'Cotton Fabric','12-09-2016',3445,45667,'Cash'),(2,'13-09-2016',2,2,'Single needle','13-09-2016',3465,34544,'Check'),(3,'11-09-2016',3,3,'Cotton Fabric','11-09-2016',3645,34546,'Check'),(4,'21-09-2016',4,4,'5 thread overlocks','21-09-2016',6000,34657,'Cash');
/*!40000 ALTER TABLE `stockorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockreceipt`
--

DROP TABLE IF EXISTS `stockreceipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockreceipt` (
  `stockreceiptID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` varchar(12) DEFAULT NULL,
  `Receipt_No` int(11) NOT NULL,
  `CompID` int(11) NOT NULL,
  `SupplierID` int(11) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `Order_Type` varchar(45) NOT NULL,
  `Invoice_No` int(11) NOT NULL,
  `Invoice_Date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stockreceiptID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockreceipt`
--

LOCK TABLES `stockreceipt` WRITE;
/*!40000 ALTER TABLE `stockreceipt` DISABLE KEYS */;
INSERT INTO `stockreceipt` VALUES (30,'09-08-2016',12,1,3,488,'Pearl stitch',23,'15-08-2016'),(31,'11-08-2016',50,5,2,429,'Overlock',34,'08-08-2016'),(32,'07-08-2016',56,4,3,722,'Single needle',86,'10-08-2016'),(33,'16-08-2016',36,6,4,266,'Wool Fabric',74,'11-08-2016');
/*!40000 ALTER TABLE `stockreceipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockrequistion`
--

DROP TABLE IF EXISTS `stockrequistion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockrequistion` (
  `StockrequistionID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` varchar(14) DEFAULT NULL,
  `OrderID` int(11) NOT NULL,
  `Order_Type` varchar(45) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Remarks` varchar(45) NOT NULL,
  `From_Department` varchar(45) NOT NULL,
  `To_Department` varchar(45) NOT NULL,
  `To_Location` int(11) NOT NULL,
  PRIMARY KEY (`StockrequistionID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockrequistion`
--

LOCK TABLES `stockrequistion` WRITE;
/*!40000 ALTER TABLE `stockrequistion` DISABLE KEYS */;
INSERT INTO `stockrequistion` VALUES (19,'05-09-2016',1,'Nylon Fabric',54657,'expected','V4','V5',4),(20,'02-09-2016',7,'Iron',30000,'expected','V6','V8',8),(21,'12-09-2016',3,'Pearl stitch',57768,'expected','V3','V5',8),(23,'07-09-2016',4,'Iron',64646,'expected','V7','V5',8),(25,'01-09-2016',6,'Single needle',36457,'expected','V9','V8',8),(26,'02-09-2016',1,'Nylon Fabric',54657,'expected','V4','V5',4);
/*!40000 ALTER TABLE `stockrequistion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `style` (
  `styleNo` int(4) NOT NULL,
  `buyer` varchar(45) NOT NULL,
  `prototype` varchar(45) NOT NULL,
  `factory` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  PRIMARY KEY (`styleNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (3616,'M&S','Trouser','VTW','V1','2016-08-05','2016-08-22'),(3968,'EddieBaur','Shirt','TGK','V1','2016-08-10','2016-08-30'),(4510,'Dean','Shirt','VTW','V2','2016-08-03','2016-08-13'),(4520,'Dean','Shirt','TGK','V2','2016-08-01','2016-08-17'),(4536,'Deutch','Denim','VTW','V3','2016-08-10','2016-08-27'),(4567,'Tommy','Touser','TGK','V2','2016-08-18','2016-08-30'),(4598,'Deutch','Dress','VTW','V3','2016-08-28','2016-09-15'),(5225,'EddieBaur','Trouser','TGK','V1','2016-08-31','2016-09-22'),(6056,'M&S','Long Dress','VTW','V1','2016-08-23','2016-09-09'),(6098,'M&S','Trouser','VTW','V1','2016-09-10','2016-09-28'),(8716,'Lewis','Denim','VTW','V2','2016-08-14','2016-08-25');
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stylemanamount`
--

DROP TABLE IF EXISTS `stylemanamount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stylemanamount` (
  `styleNo` int(4) NOT NULL,
  `direct` int(11) DEFAULT NULL,
  `indirect` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `difference` int(11) DEFAULT '0',
  `type` varchar(45) DEFAULT 's',
  PRIMARY KEY (`styleNo`),
  CONSTRAINT `fk2_StyleNo` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stylemanamount`
--

LOCK TABLES `stylemanamount` WRITE;
/*!40000 ALTER TABLE `stylemanamount` DISABLE KEYS */;
INSERT INTO `stylemanamount` VALUES (3616,39,9,48,0,'s'),(3968,40,10,50,0,'s'),(4510,35,10,45,0,'s'),(4520,38,8,46,0,'s'),(4536,23,10,33,0,'s'),(4598,60,20,80,0,'s'),(5225,45,8,53,0,'s'),(6056,34,6,40,0,'s'),(6098,50,10,60,0,'s'),(8716,40,10,50,0,'s');
/*!40000 ALTER TABLE `stylemanamount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stylematerial`
--

DROP TABLE IF EXISTS `stylematerial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stylematerial` (
  `styleNo` int(4) NOT NULL,
  `materialNo` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `quantity` float NOT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `difference` int(11) DEFAULT '5',
  PRIMARY KEY (`styleNo`,`materialNo`,`type`,`color`),
  CONSTRAINT `fk_StyleNoMaterial` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stylematerial`
--

LOCK TABLES `stylematerial` WRITE;
/*!40000 ALTER TABLE `stylematerial` DISABLE KEYS */;
INSERT INTO `stylematerial` VALUES (3616,1,'Silk Fabric','Grey',1000,'',5),(3616,1,'Silk Fabric','White',3456,'mix with Wool Fabric',5),(3616,1,'Wool Fabric','Black',900.6,'',5),(3616,2,'Cotton Fabric','Baltic',10000,'',5),(3616,2,'Nylon Fabric','Taupe Mix',1500,'',5),(3616,2,'Wool Fabric','Baltic',3500,'',5),(3968,1,'Wool Fabric','Silver',2450,'',5),(4510,1,'Cotton Fabric','Baltic',3000,'',5),(4598,1,'Wool Fabric','Baltic',7800,'',5),(5225,1,'Cotton Fabric','Grey',5000,'',5),(6056,1,'Cotton Fabric','Black',5000,'',5),(6056,1,'Cotton Fabric','White',8000,'',5),(6056,1,'Wool Fabric','Black',2568,'',5),(6098,1,'Nylon Fabric','Baltic',5000,'',5),(6098,1,'Wool Fabric','Pumice',4500,'',5),(6098,2,'Cotton Fabric','Baltic',4500,'',5);
/*!40000 ALTER TABLE `stylematerial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `styleoperation`
--

DROP TABLE IF EXISTS `styleoperation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `styleoperation` (
  `styleNo` int(4) NOT NULL,
  `operationNo` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `machine` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `speciality` varchar(45) NOT NULL,
  `remarks` varchar(45) NOT NULL,
  `mc` double NOT NULL,
  `ma` double NOT NULL,
  PRIMARY KEY (`styleNo`,`operationNo`),
  CONSTRAINT `fk_STyleNoOperation` FOREIGN KEY (`styleNo`) REFERENCES `style` (`styleNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `styleoperation`
--

LOCK TABLES `styleoperation` WRITE;
/*!40000 ALTER TABLE `styleoperation` DISABLE KEYS */;
INSERT INTO `styleoperation` VALUES (3616,1,'Tack Lable','5 Thread Overlock',5,'Without Lights','Start Of Style',0.75,1),(3616,2,'Bundle & sort','Overlock',4,'Extra Table','',1.2,1.8),(3616,3,'Sew loop','Overlock',6,'With Light','',1.7999999999999998,2.7),(3616,4,'Measure & cut loop','Single Needle',10,'Without Lights','',1.2,1.5),(3616,5,'Fold & iron waist band','Iron',5,'Without Lights','',6.5,7.25),(6056,1,'Tack Lable','5 Thread Overlock',4,'Without Lights','',0.6,0.8),(6056,2,'Bundle & sort','Overlock',4,'Extra Table','',1.92,2.2800000000000002),(6056,3,'Measure & cut loop','Single Needle',5,'Without Lights','',0.6,0.75),(6056,4,'Join waist band','Pearl Stitch',4,'With Light','',0.52,0.6),(6056,5,'Tack fly box Ovl thread edge','5 Thread Overlock',4,'With Light','',0.6,0.8),(6098,1,'Tack Lable','Single Needle',3,'Without Lights','',0.36,0.44999999999999996),(6098,2,'Bundle & sort','5 Thread Overlock',4,'Without Lights','',0.6,0.8),(6098,3,'Measure & cut loop','Pearl Stitch',6,'With Light','',0.78,0.8999999999999999),(6098,4,'Fold & iron waist band','Iron',3,'Extra Table','',3.9000000000000004,4.35);
/*!40000 ALTER TABLE `styleoperation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_details`
--

DROP TABLE IF EXISTS `supplier_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_details` (
  `Supplier_Code` varchar(45) NOT NULL,
  `Supplier` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `Date` varchar(45) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Cost` double NOT NULL,
  `Delivary_Mode` varchar(10) NOT NULL,
  `Currency` double NOT NULL,
  `Country` varchar(45) NOT NULL,
  PRIMARY KEY (`Supplier_Code`),
  UNIQUE KEY `E-mail_UNIQUE` (`email`),
  UNIQUE KEY `Supplier_Code_UNIQUE` (`Supplier_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_details`
--

LOCK TABLES `supplier_details` WRITE;
/*!40000 ALTER TABLE `supplier_details` DISABLE KEYS */;
INSERT INTO `supplier_details` VALUES ('123','afsf','fasfs','2016-08-03','safsf',4124,'Ocean',214,'asff'),('224','sfasrf','rwrr','2016-08-11','rrr',3434,'Ocean',414,'sdgd'),('2414','safsf','sfasf','2016-08-04','sfsf',424,'Ocean',2424,'sdsdf'),('242','dfsdf','42424fsdfsdf','2016-08-11','fsdfsdf',24214,'Ocean',412,'dfdf'),('2424','erwer','rrer','2016-08-05','erer',2224,'Ocean',2424,'sfdf'),('3123','asfsf','waf','2016-08-04','sdfsd',214,'Ocean',124,'sfdgd'),('4124','asfs','fasf','2016-08-04','safsa',1424,'Ocean',2324,'sfsf'),('4214','fafasf','fdsff','2016-08-05','fdsf',4342,'Ocean',24,'fff'),('5','sup',' 2','2016-12-02','df',22,'Ocean',2,'ee'),('9','ffffffffff','fffffffffffffff','2016-08-04','ffffff',12,'Ocean',56,'fffffffff');
/*!40000 ALTER TABLE `supplier_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilitybreakdown`
--

DROP TABLE IF EXISTS `utilitybreakdown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilitybreakdown` (
  `utilityBreakdownID` varchar(45) NOT NULL,
  `utilityType` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `repoter` varchar(45) DEFAULT NULL,
  `locationDetails` varchar(45) DEFAULT NULL,
  `breakdownDetails` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`utilityBreakdownID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilitybreakdown`
--

LOCK TABLES `utilitybreakdown` WRITE;
/*!40000 ALTER TABLE `utilitybreakdown` DISABLE KEYS */;
INSERT INTO `utilitybreakdown` VALUES ('ELEC4354','Steam Distribution System','2016-08-11','MEC-5567','KOK-LINE3343','A Replacement '),('ELEC4567','Electrical System','2016-08-11','MEC-4567','KOK-CPU005','A Replacement '),('ELEC4568','Generator','2016-08-03','MEC-5567','KOK-CPU005','NEED QUICK ATTENTION'),('MEC127','Generator','','ENG-400000','VET-LINE4456','Need quick attention'),('MEC5678','Steam Distribution','2016-05-11','ENG-0034','KOK-CPU005','An Electrical Repair'),('MECH556','Electrical System','2016-08-13','ELEC-4567','vet-005678','A Mechanical Repair');
/*!40000 ALTER TABLE `utilitybreakdown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `vehicle_number` varchar(8) NOT NULL,
  `vehicle_type` varchar(10) NOT NULL,
  `vehicle_capacity` int(3) NOT NULL,
  `route` char(7) DEFAULT NULL,
  `driverAssigned` char(1) DEFAULT NULL,
  `avalable_capacity` int(3) DEFAULT NULL,
  PRIMARY KEY (`vehicle_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('AB-7474','Bus',60,'Route C','Y',60),('CAA-4785','Bus',40,'Route C','Y',40),('KE-0877','Bus',40,'Route A','Y',-60),('KK-7575','Bus',60,'Route B','Y',60),('LC-6523','Lorry',20000,'Route B','N',20000),('NA-2465','Lorry',12000,'Route B','N',12000);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-05  6:36:03
