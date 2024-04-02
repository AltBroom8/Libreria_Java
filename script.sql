-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: practica6
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `practica6`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `practica6` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `practica6`;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editorial` (
  `id` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` VALUES (1,'Libros Excepcionales S.A.','Calle de los Libros 123, Ciudad de la Lectura','+123-456-7890'),(2,'Publicaciones Literarias Globales','Avenida de las Historias 456, Metrópolis de las Letras','+234-567-8901'),(3,'Ediciones Creativas del Sur','Plaza de la Imaginación 789, Pueblo de las Novelas','+345-678-9012'),(4,'Imprenta Innovadora Moderna','Calle de la Impresión 101, Ciudad del Conocimiento','+456-789-0123'),(5,'Editorial Visionarios del Libro','Carrera de las Ideas 202, Villa de la Sabiduría','+567-890-1234'),(6,'Libros y Más Libros Ltda.','Paseo de las Letras 303, Ciudad de las Páginas','+678-901-2345'),(7,'Ediciones Imaginativas Express','Bulevar de la Creación 404, Rincón de los Cuentos','+789-012-3456'),(8,'Editorial del Futuro Literario','Calle de la Innovación 505, Metrópolis de las Palabras','+890-123-4567'),(9,'Librería Impresa y Digital','Avenida de las Tendencias 606, Ciudad de los Libros','+901-234-5678'),(10,'Ediciones Ilustres y Clásicas','Plaza de los Maestros 707, Villa de los Escritores','+012-345-6789');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `anioPublicacion` int DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `editorialID` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Cien años de soledad','Gabriel García Márquez',1967,'Realismo mágico',25.99,1),(2,'1984','George Orwell',1949,'Distopía',19.99,2),(3,'To Kill a Mockingbird','Harper Lee',1960,'Ficción clásica',22.5,3),(4,'Don Quijote de la Mancha','Miguel de Cervantes',1605,'Novela clásica',18.75,4),(5,'Pride and Prejudice','Jane Austen',1813,'Romance clásico',20,5),(6,'The Great Gatsby','F. Scott Fitzgerald',1925,'Novela moderna',21.5,6),(7,'One Hundred Years of Solitude','Gabriel García Márquez',1967,'Magic realism',25.99,1),(8,'Crime and Punishment','Fyodor Dostoevsky',1866,'Psychological fiction',23.75,7),(9,'The Catcher in the Rye','J.D. Salinger',1951,'Coming-of-age',19.5,8);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaccion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fechaVenta` date DEFAULT NULL,
  `libroID` int DEFAULT NULL,
  `usuarioID` int DEFAULT NULL,
  `tipo_transaccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaccion`
--

LOCK TABLES `transaccion` WRITE;
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
INSERT INTO `transaccion` VALUES (1,'2024-02-24',16,1,'Alta'),(2,'2024-02-24',17,1,'Baja'),(3,'2024-02-24',17,1,'Baja'),(4,'2024-02-24',17,1,'Baja'),(5,'2024-02-24',17,1,'Baja'),(6,'2024-02-24',14,1,'Baja'),(7,'2024-02-24',12,1,'Baja'),(8,'2024-02-24',11,1,'Baja'),(9,'2024-02-25',10,1,'Alta'),(10,'2024-02-25',11,1,'Modificacion'),(11,'2024-02-25',11,1,'Modificacion'),(12,'2024-02-25',11,1,'Baja'),(13,'2024-02-25',10,1,'Alta'),(14,'2024-02-25',11,1,'Baja');
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','1234'),(2,'Alice','Aa1!Alice'),(3,'Bob','Bb2!Secure'),(4,'Charlie','Cc3!Strong'),(5,'David','Dd4!David'),(6,'Eva','Ee5!Eva'),(7,'Frank','Ff6!Frank'),(8,'Grace','Gg7!Grace'),(9,'Henry','Hh8!Henry'),(10,'Ivy','Ii9!Ivy'),(11,'Jack','Jj10!Jack'),(12,'Karen','Kk11!Karen'),(13,'Leo','Ll12!Leo'),(14,'Mia','Mm13!Mia'),(15,'Nathan','Nn14!Nathan'),(16,'Olivia','Oo15!Olivia'),(17,'Peter','Pp16!Peter'),(18,'Quinn','Qq17!Quinn'),(19,'Rachel','Rr18!Rachel'),(20,'Sam','Ss19!Sam');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-25 16:33:50
