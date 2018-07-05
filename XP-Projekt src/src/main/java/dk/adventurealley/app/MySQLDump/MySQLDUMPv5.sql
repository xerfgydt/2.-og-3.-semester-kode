-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: adventure_alley_db
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `act_reqs`
--

DROP TABLE IF EXISTS `act_reqs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_reqs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_act_name` varchar(100) NOT NULL,
  `fk_req_names_name` varchar(100) NOT NULL,
  `req_value` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `act_reqs_id_uindex` (`id`),
  KEY `act_reqs_activities_name_fk` (`fk_act_name`),
  KEY `act_reqs_req_names_name_fk` (`fk_req_names_name`),
  CONSTRAINT `act_reqs_activities_name_fk` FOREIGN KEY (`fk_act_name`) REFERENCES `activities` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `act_reqs_req_names_name_fk` FOREIGN KEY (`fk_req_names_name`) REFERENCES `req_names` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_reqs`
--

LOCK TABLES `act_reqs` WRITE;
/*!40000 ALTER TABLE `act_reqs` DISABLE KEYS */;
INSERT INTO `act_reqs` VALUES (1,'GokartTest','Højde','200 cm');
/*!40000 ALTER TABLE `act_reqs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `equipment` varchar(500) DEFAULT NULL,
  `image_path` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `activities_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES ('Hjelm','https://img.grouponcdn.com/deal/htzFHaEQ5LVhwTgFS9ZR/5t-1500x900/v1/c700x420.jpg','YOLO','GokartTest'),('Kølle','https://www.jesperhus.dk/media/581399/minigolf2016_Galleri.jpg','','Mini-GolfTest'),('Hjelm, Våben og Rustning','http://hevansscent.com/wp-content/uploads/2016/06/paintball.jpg','','PaintballTest'),('Ble','https://i.ytimg.com/vi/s2i841E1DFQ/maxresdefault.jpg','','Sumo-WrestlingTest');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `customerID` int(11) DEFAULT NULL,
  `numOfParticipants` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `activityID` int(11) DEFAULT NULL,
  `instructorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `instructorID___fk` (`instructorID`),
  CONSTRAINT `instructorID___fk` FOREIGN KEY (`instructorID`) REFERENCES `instructor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (2,'2018-03-13 09:30:35',15,2,'moist',2,1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `companyName` varchar(250) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `instructor_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'Jens'),(2,'John'),(3,'Lars'),(4,'Andreas'),(5,'Carsten'),(6,'Henning'),(7,'Morten');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `req_names`
--

DROP TABLE IF EXISTS `req_names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `req_names` (
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `req_names_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `req_names`
--

LOCK TABLES `req_names` WRITE;
/*!40000 ALTER TABLE `req_names` DISABLE KEYS */;
INSERT INTO `req_names` VALUES ('Højde'),('vægt');
/*!40000 ALTER TABLE `req_names` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-12 12:47:39
