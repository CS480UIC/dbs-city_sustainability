-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: city_sustainability
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `carbon_emission_target`
--

DROP TABLE IF EXISTS `carbon_emission_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carbon_emission_target` (
  `cet_id` int NOT NULL,
  `cet_city_id` int NOT NULL,
  `base_year` year DEFAULT NULL,
  `base_emission` float DEFAULT NULL,
  `target_year` year DEFAULT NULL,
  `target_emission` float DEFAULT NULL,
  PRIMARY KEY (`cet_id`),
  UNIQUE KEY `cet_id_UNIQUE` (`cet_id`),
  KEY `city_id_idx` (`cet_city_id`),
  KEY `id_idx` (`cet_city_id`),
  CONSTRAINT `cet_city_id` FOREIGN KEY (`cet_city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carbon_emission_target`
--

LOCK TABLES `carbon_emission_target` WRITE;
/*!40000 ALTER TABLE `carbon_emission_target` DISABLE KEYS */;
INSERT INTO `carbon_emission_target` VALUES (1,1,2020,10000,2030,5000),(2,2,2018,20000,2030,10000),(3,3,2022,12350,2035,6500),(4,4,2021,12000,2025,7000),(5,5,2016,15000,2026,8500);
/*!40000 ALTER TABLE `carbon_emission_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL,
  `country_id` int NOT NULL,
  `city_name` varchar(45) DEFAULT NULL,
  `city_population` float DEFAULT NULL,
  `city_density` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_idx` (`country_id`),
  CONSTRAINT `country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,1,'Chicago',2710000,11750),(2,1,'New York',8419000,27000),(3,2,'Toronto',2930000,4150),(4,1,'Los Angeles',3967000,4376),(5,3,'Tokyo',13960000,6158);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL,
  `industry_id` int NOT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `company_emission` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `industry_id_idx` (`industry_id`),
  CONSTRAINT `industry_id` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,1,'Walmart',1000),(2,2,'Amazon',1200),(3,3,'Apple',1100),(4,4,'Exxon Mobil',2500),(5,3,'Microsoft',1500);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL,
  `country_name` varchar(45) NOT NULL,
  `country_population` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `country_name_UNIQUE` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Country 1',1000000),(2,'Country2',2000000),(3,'Country3',3000000),(4,'Country4',4000000),(5,'Country5',5000000);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `energy_management`
--

DROP TABLE IF EXISTS `energy_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `energy_management` (
  `em_id` int NOT NULL,
  `em_city_id` int NOT NULL,
  `energy_production` float DEFAULT NULL,
  `energy_consumption` float DEFAULT NULL,
  `energy_management` float DEFAULT NULL,
  PRIMARY KEY (`em_id`),
  KEY `em_city_id_idx` (`em_city_id`),
  CONSTRAINT `em_city_id` FOREIGN KEY (`em_city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `energy_management`
--

LOCK TABLES `energy_management` WRITE;
/*!40000 ALTER TABLE `energy_management` DISABLE KEYS */;
INSERT INTO `energy_management` VALUES (1,1,450,467,32),(2,2,340,129,54),(3,3,1098,1255,478),(4,4,876,899,98),(5,5,238,456,67);
/*!40000 ALTER TABLE `energy_management` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `industry`
--

DROP TABLE IF EXISTS `industry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `industry` (
  `id` int NOT NULL,
  `country_id` int NOT NULL,
  `industry_type` varchar(45) DEFAULT NULL,
  `industry_emission` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `i_country_id_idx` (`country_id`),
  CONSTRAINT `i_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry`
--

LOCK TABLES `industry` WRITE;
/*!40000 ALTER TABLE `industry` DISABLE KEYS */;
INSERT INTO `industry` VALUES (1,1,'Retail',2000),(2,1,'Online Retail',2500),(3,2,'Technology',2600),(4,2,'Gasoline',3500),(5,3,'Agriculture',2500);
/*!40000 ALTER TABLE `industry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transportation`
--

DROP TABLE IF EXISTS `transportation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transportation` (
  `idtransportation_id` int NOT NULL,
  `target_id` int NOT NULL,
  `car_population` float DEFAULT NULL,
  `car_emission` float DEFAULT NULL,
  `public_usage` float DEFAULT NULL,
  `public_emission` float DEFAULT NULL,
  PRIMARY KEY (`idtransportation_id`),
  UNIQUE KEY `idtransportation_id_UNIQUE` (`idtransportation_id`),
  KEY `target_id_idx` (`target_id`),
  CONSTRAINT `target_id` FOREIGN KEY (`target_id`) REFERENCES `carbon_emission_target` (`cet_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportation`
--

LOCK TABLES `transportation` WRITE;
/*!40000 ALTER TABLE `transportation` DISABLE KEYS */;
INSERT INTO `transportation` VALUES (1,1,21378,472143,321375,2432),(2,2,21343,79867200,4327680,432678),(3,3,542132,90765,6543660,5432),(4,4,542356,784523,5732980,54324),(5,5,467832,1234,5432,75843);
/*!40000 ALTER TABLE `transportation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waste_management`
--

DROP TABLE IF EXISTS `waste_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waste_management` (
  `wm_id` int NOT NULL,
  `wm_city_id` int NOT NULL,
  `pollution_rate` float DEFAULT NULL,
  `recycle_rate` float DEFAULT NULL,
  PRIMARY KEY (`wm_id`),
  KEY `city_id_idx` (`wm_city_id`),
  CONSTRAINT `wm_city_id` FOREIGN KEY (`wm_city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waste_management`
--

LOCK TABLES `waste_management` WRITE;
/*!40000 ALTER TABLE `waste_management` DISABLE KEYS */;
INSERT INTO `waste_management` VALUES (1,3,21,12.9),(9,5,29.9,9.9),(12,1,11.23,33.4),(17,4,34.7,5.6),(43,2,9.2,10.3);
/*!40000 ALTER TABLE `waste_management` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-01 18:34:49
