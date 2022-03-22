-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: world_wild
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `feed` varchar(100) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `life` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `race` varchar(100) DEFAULT NULL,
  `size` varchar(100) DEFAULT NULL,
  `weight` varchar(100) DEFAULT NULL,
  `wiki_link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (2,'Carnivore','8197f747181747139dcdce03cf8f73dd.jpg','8 à 10 ans','Tigre','Félin','de 70 à 120cm','90 à 310 Kg','https://fr.wikipedia.org/wiki/Tigre'),(6,'Carnivore','0a80f6f035d74b64ab9aa300afed56e6.jpg','10ans','Boa','Reptile','200cm','20kg','https://fr.wikipedia.org/wiki/Boa_constricteur'),(7,'Carnivore','caade9abbd904b3d853e515358babc73.jpg','15ans','Panthère noire','Félin','180cm','60Kg','https://fr.wikipedia.org/wiki/Panth%C3%A8re_noire_(animal)'),(8,'Herbivore','93441560a52d44f7927d72ad289568da.jpg','20 à 30ans','Gorille','Hominidés','210cm','150Kg','https://fr.wikipedia.org/wiki/Gorille'),(9,'Insectivore','3ed501357a4f4e9ab85987703abdbdb6.jpg','8ans','Iguane','Reptile','60cm','1,2kg','https://fr.wikipedia.org/wiki/Iguana');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-22 16:52:15
