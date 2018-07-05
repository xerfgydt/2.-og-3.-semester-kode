-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: adventure_alley_db
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `act_reqs`
--

DROP TABLE IF EXISTS `act_reqs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_reqs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_act_id` int(11) DEFAULT NULL,
  `fk_req_id` int(11) DEFAULT NULL,
  `req_value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `act_reqs_id_uindex` (`id`),
  KEY `act_id` (`fk_act_id`),
  KEY `req_id` (`fk_req_id`),
  CONSTRAINT `act_id` FOREIGN KEY (`fk_act_id`) REFERENCES `activities` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `req_id` FOREIGN KEY (`fk_req_id`) REFERENCES `requirements` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_reqs`
--

LOCK TABLES `act_reqs` WRITE;
/*!40000 ALTER TABLE `act_reqs` DISABLE KEYS */;
INSERT INTO `act_reqs` VALUES (46,3,11,'80kg'),(47,3,12,'200kg'),(48,2,5,'110cm'),(49,2,6,'290cm'),(50,8,9,'20'),(51,8,5,'50cm'),(52,9,7,'16år'),(53,9,5,'0cm');
/*!40000 ALTER TABLE `act_reqs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `equipment` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `activities_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (2,'Basketball','bold og sko','kast bolde i et hoop',' https://soroeakademi.dk/fileadmin/user_upload/images/Cards/Fag/basketball.jpg'),(3,'Sumo-Wrestling','Ble','Skub fede mænd ud af en ring',' https://static01.nyt.com/images/2016/01/27/sports/27SUMOweb1/27SUMOweb1-master768-v2.jpg'),(8,'Skak','Bræt','Hjernevrider spil som folk der hedder magnus er god til',' http://vidsteduat.dk/wp-content/uploads/skak.jpg'),(9,'Paintball','Våben og Kevlar','Skyd hinanden i face med farve skud',' https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/SupAir_Player.jpg/1200px-SupAir_Player.jpg');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `customerID` int(11) NOT NULL,
  `numOfParticipants` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `activityID` int(11) NOT NULL,
  `instructorID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bookings_id_uindex` (`id`),
  KEY `bookings_customers_id_fk` (`customerID`),
  KEY `bookings_activities_id_fk` (`activityID`),
  KEY `bookings_instructors_id_fk` (`instructorID`),
  CONSTRAINT `bookings_activities_id_fk` FOREIGN KEY (`activityID`) REFERENCES `activities` (`id`),
  CONSTRAINT `bookings_customers_id_fk` FOREIGN KEY (`customerID`) REFERENCES `customers` (`id`),
  CONSTRAINT `bookings_instructors_id_fk` FOREIGN KEY (`instructorID`) REFERENCES `instructors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,'2018-05-24 10:30:00',1,10,'Wrestling for 10',3,1),(2,'2018-11-30 20:10:00',2,23,'JuleSkak',8,4),(3,'2018-08-11 12:15:00',3,24,'Sommer Basket v1',2,5),(4,'2018-08-12 12:15:00',3,24,'Sommer Basket v2',2,5),(5,'2018-08-11 12:15:00',3,24,'Sommer Basket v3',2,5),(6,'2018-08-31 11:30:00',4,10,'Wrestling for handikappede',3,1),(7,'2018-05-24 10:30:00',5,10,'Leg og wrestl!',3,1),(8,'2018-03-30 16:00:00',6,10,'Polterabend für kurt',9,2),(9,'2018-03-30 16:00:00',1,10,'Teambuilding',9,2),(10,'2018-03-30 16:00:00',3,10,'Sutterne på skud',9,2);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `companyName` varchar(250) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Peter Bendixen','Lego Teknisk afdeling','22435355'),(2,'Julie P','Julies klippestudie','23232311'),(3,'Sanne Sut','Sannes sutter','61675722'),(4,'Gert P','Kørestolsklubben','22324452'),(5,'Lisbeth Pallesen','Den lille børnehave','23232344'),(6,'Hanz Schnitzel','','99223359');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructors`
--

DROP TABLE IF EXISTS `instructors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `instructor_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructors`
--

LOCK TABLES `instructors` WRITE;
/*!40000 ALTER TABLE `instructors` DISABLE KEYS */;
INSERT INTO `instructors` VALUES (1,'Lotte Hansen'),(2,'Birger Kristensen'),(3,'Jens Jensen'),(4,'Paula Parker'),(5,'Miss Pedigree');
/*!40000 ALTER TABLE `instructors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `imagePath` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `products_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Popcorn',10.00,'http://3.bp.blogspot.com/-f5if0xq5HRg/UAWPDTzw9BI/AAAAAAAAFeg/yjimmpRlw8Q/s320/1.jpg'),(2,'Coke',20.99,'https://botw-pd.s3.amazonaws.com/styles/logo-thumbnail/s3/0000/1232/brand.gif?itok=6uSKXS-x'),(5,'Marabou',30.93,'https://images-eu.ssl-images-amazon.com/images/I/51DDrBzXQRL._AC_US200_.jpg'),(6,'T-shirt',399.00,'http://www.theburbankchurch.org/image/cache/data/category_25/only-and-sons-onsper-drop-shoulder-t-shirt-gra-309248-19-1010-200x200_0.jpg'),(7,'Elg Maskot',50.00,'https://sc02.alicdn.com/kf/HTB1jYSoQFXXXXciXFXXq6xXFXXXK/Factory-Wholesale-Cute-Soft-Stuffed-Plush-Elk.jpg_200x200.jpg'),(8,'Twinkies',20.00,'https://gamezone.no/Media/Cache/Images/5/4/WEB_Image%20Hostess%20Twinkies%20Original%2010%20stk%20i%20Eske%201407240860.Jpeg'),(9,'Kitkat',25.00,'https://londonparticulars.files.wordpress.com/2011/01/kitkat.jpg'),(10,'Øl Fad - Tuborg',20.00,'http://www.fadolsforsyningen.dk/uploads/tx_multishop/images/products/300/tub/tuborg-classic-25-liter-fadol-1.jpeg'),(11,'Øl Kande - Tuborg',90.00,'http://www.fadolsforsyningen.dk/uploads/tx_multishop/images/products/300/tub/tuborg-olplastkander-2-0-l-m-lag.jpeg'),(12,'Øl Tårn - Tuborg',250.00,'http://bridge2shopping.com/wp-content/uploads/2017/07/41GL86x5oYL-200x200.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirements`
--

DROP TABLE IF EXISTS `requirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requirements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `requirements_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirements`
--

LOCK TABLES `requirements` WRITE;
/*!40000 ALTER TABLE `requirements` DISABLE KEYS */;
INSERT INTO `requirements` VALUES (5,'Min Højde'),(6,'Max Højde'),(7,'Min Alder'),(8,'Max Alder'),(9,'Min IQ'),(10,'Max IQ'),(11,'Min Vægt'),(12,'Max Vægt');
/*!40000 ALTER TABLE `requirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sales_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'2018-03-02',123),(2,'2018-03-30',214543),(3,'2018-03-21',2257.78),(4,'2018-03-22',123.32),(6,'2018-03-20',1414.95),(7,'2018-03-23',2447.19);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-22  9:05:14
