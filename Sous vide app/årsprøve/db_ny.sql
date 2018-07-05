-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `emner`
--

DROP TABLE IF EXISTS `emner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emner` (
  `emne_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `vægt` varchar(100) DEFAULT NULL,
  `tykkelse` varchar(100) DEFAULT NULL,
  `bemærkning` varchar(100) DEFAULT NULL,
  `fk_opskrift_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emne_id`),
  KEY `emner_opskrift_id_fk` (`fk_opskrift_id`),
  CONSTRAINT `emner_opskrift_id_fk` FOREIGN KEY (`fk_opskrift_id`) REFERENCES `opskrifter` (`opskrift_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emner`
--

LOCK TABLES `emner` WRITE;
/*!40000 ALTER TABLE `emner` DISABLE KEYS */;
INSERT INTO `emner` VALUES (15,'kasjndank','kajsdnalk','lakjsndalskj','alksjdnalsk',24),(16,'Filet','2','8 ','Oksefileten kommer fra en fritgående øko ko og kødet har hængt i 3 uger',25),(17,'Hamburgerryg','2','8','Hamburgerryggen er pumpet med masser af vand og er derfor af dårlig kvalitet',26),(18,'Skank','0.5','6','Lammekødet har hængt længe og har derfor en kraftig smag af får',27),(19,'Bryst','0.140','2','Kyllingen er fra Løgmosen',28),(20,'Laks','0.3','2','Det er en laksefilet',29),(21,'Fersken','0.225','5','Det er en fersken fra Mallorca og den er meget moden',30);
/*!40000 ALTER TABLE `emner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indlæg`
--

DROP TABLE IF EXISTS `indlæg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indlæg` (
  `indlæg_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `tekst` text,
  `dato` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`indlæg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indlæg`
--

LOCK TABLES `indlæg` WRITE;
/*!40000 ALTER TABLE `indlæg` DISABLE KEYS */;
INSERT INTO `indlæg` VALUES (29,'aldjfadnj','adsjfnldsnflsadæflkmsdæf','2017-12-11 21:28:02','patrick'),(33,'Det sagde hun også igår','Hvor Laaaaaaaaaaaaaaaaaaaaaaaaaangtid skal en stor pølse have','2017-12-12 13:36:37','Kasper');
/*!40000 ALTER TABLE `indlæg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kommentare`
--

DROP TABLE IF EXISTS `kommentare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kommentare` (
  `kommentar_id` int(11) NOT NULL AUTO_INCREMENT,
  `tekst` text,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fk_indlæg_id` int(11) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`kommentar_id`),
  KEY `kommentar_indlæg_id_fk` (`fk_indlæg_id`),
  CONSTRAINT `kommentar_indlæg_id_fk` FOREIGN KEY (`fk_indlæg_id`) REFERENCES `indlæg` (`indlæg_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kommentare`
--

LOCK TABLES `kommentare` WRITE;
/*!40000 ALTER TABLE `kommentare` DISABLE KEYS */;
INSERT INTO `kommentare` VALUES (8,'2 min og 37 sekunder','2017-12-12 15:06:09',33,'Kasper'),(9,'Det kan du selv være Patrick','2017-12-12 15:06:39',29,'Kasper');
/*!40000 ALTER TABLE `kommentare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opskrifter`
--

DROP TABLE IF EXISTS `opskrifter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opskrifter` (
  `opskrift_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `karakter` varchar(50) DEFAULT NULL,
  `vurdering` varchar(250) DEFAULT NULL,
  `dato` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fk_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`opskrift_id`),
  KEY `opskrift_user_id_fk` (`fk_user_id`),
  CONSTRAINT `opskrift_user_id_fk` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opskrifter`
--

LOCK TABLES `opskrifter` WRITE;
/*!40000 ALTER TABLE `opskrifter` DISABLE KEYS */;
INSERT INTO `opskrifter` VALUES (24,'safdjaslkn','7','dsa,jfbdshjfajhbsdfasdfadf','2017-12-11 16:01:08',8),(25,'oksekød','','','2017-12-12 14:32:05',1),(26,'svinekød',NULL,NULL,'2017-12-12 14:36:07',1),(27,'lammekød',NULL,NULL,'2017-12-12 14:39:31',1),(28,'fjerkræ',NULL,NULL,'2017-12-12 14:42:12',1),(29,'fisk',NULL,NULL,'2017-12-12 14:44:36',1),(30,'frugt',NULL,NULL,'2017-12-12 14:47:31',1);
/*!40000 ALTER TABLE `opskrifter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tilberedninger`
--

DROP TABLE IF EXISTS `tilberedninger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tilberedninger` (
  `tilberedning_id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(100) DEFAULT NULL,
  `temp` varchar(100) DEFAULT NULL,
  `detaljer` text,
  `fk_emne_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tilberedning_id`),
  KEY `tilberedning_emner_id_fk` (`fk_emne_id`),
  CONSTRAINT `tilberedning_emner_id_fk` FOREIGN KEY (`fk_emne_id`) REFERENCES `emner` (`emne_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tilberedninger`
--

LOCK TABLES `tilberedninger` WRITE;
/*!40000 ALTER TABLE `tilberedninger` DISABLE KEYS */;
INSERT INTO `tilberedninger` VALUES (15,'aksjndaskljd','alksjndlask','aksljndalksjd',15),(16,'9 timer','54','Hvis den ikke skal være rød men medium skal den have 57 grader istedet for 54',16),(17,'8','65','Ved denne temperatur er den gennemstegt',17),(18,'14','58','Man ikke med fordel give det en laverer temperatur, da kødet så vil blive sejt',18),(19,'1','61','Kyllingen tager ikke skade af at blive tilberedt i lidt længere tid',19),(20,'1/2','48','Nogle gange skal fiske tilberedes i lidt kortere tid - da fisk er mere sart end kød.',20),(21,'3/4','84','Den bliver meget blød',21);
/*!40000 ALTER TABLE `tilberedninger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ro','ro','','admin'),(8,'Kasper','l','Rasmussen','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-12 16:05:38
