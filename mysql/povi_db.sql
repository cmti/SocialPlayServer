CREATE DATABASE  IF NOT EXISTS `povi_schema` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `povi_schema`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 192.168.1.2    Database: povi_schema
-- ------------------------------------------------------
-- Server version	5.6.24-0ubuntu2

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

DROP TABLE IF EXISTS `parenting_tips_history`;
DROP TABLE IF EXISTS `parenting_tips`;
DROP TABLE IF EXISTS `parenting_resources`;

--
-- Table structure for table `children`
--
DROP TABLE IF EXISTS `children`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `children` (
  `user_id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` enum('male','female','unspecified') NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`user_id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `children`
--

LOCK TABLES `children` WRITE;
/*!40000 ALTER TABLE `children` DISABLE KEYS */;
/*!40000 ALTER TABLE `children` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `user_id` varchar(45) NOT NULL,
  `tip_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `text_comment` mediumtext,
  `audio_comment` blob,
  `video_comment` blob,
  PRIMARY KEY (`user_id`,`tip_id`),
  KEY `fk_tip_idx` (`tip_id`),
  CONSTRAINT `fk_tip` FOREIGN KEY (`tip_id`) REFERENCES `tips` (`idtips`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `user_id` varchar(45) NOT NULL,
  `token_povi` varchar(45) DEFAULT NULL,
  `token_fb` varchar(45) DEFAULT NULL,
  `login_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_session` FOREIGN KEY (`user_id`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tips`
--

DROP TABLE IF EXISTS `tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tips` (
  `idtips` int(11) NOT NULL,
  `tip` mediumtext NOT NULL,
  `category` enum('emotion','activity','friends') NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtips`),
  KEY `fk_tips_idx` (`author`),
  CONSTRAINT `fk_tips` FOREIGN KEY (`author`) REFERENCES `users` (`email`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tips`
--

LOCK TABLES `tips` WRITE;
/*!40000 ALTER TABLE `tips` DISABLE KEYS */;
/*!40000 ALTER TABLE `tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `email` varchar(45) NOT NULL,
  `hash` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('fabio@email.com','2c4c1398f11ddd95c4d71ce993ad194eddeabd4d','555','Fabio',NULL,'1970-01-01'),('fh','314747b7ffea9f42e24ae3c5c512cb65e93eac5f','555','hj',NULL,'1970-01-01');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'povi_schema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-12 12:26:55
-- tips related tables 
CREATE TABLE `parenting_resources` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `resource_url` varchar(200) NOT NULL,
  `resource_type` varchar(1) NOT NULL,
  `resource_status` varchar(1) NOT NULL,
  PRIMARY KEY (`resource_id`)
)
AUTO_INCREMENT=1;
insert into parenting_resources (resource_url, resource_type, resource_status) values ('http://momastery.com/blog/2015/04/24/key-jar/', 'q', 'y');

CREATE TABLE `parenting_tips` (
  `resource_id` int NOT NULL,
  `tip_id` int NOT NULL,
  `content` varchar(400) NOT NULL,
  `tip_type` varchar(1) NOT NULL,
  `tip_status` varchar(1) NOT NULL,
  PRIMARY KEY (`resource_id`, `tip_id`),
  CONSTRAINT `fk_resource` FOREIGN KEY (`resource_id`) REFERENCES `parenting_resources` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into parenting_tips values (1, 1, 'What was your first thought when you work up today?', 'q', 'y');
insert into parenting_tips values (1, 2, 'What are you most afraid of?', 'q', 'y');
insert into parenting_tips values (1, 3, 'What do you want to accomplish by your next birthday?', 'q', 'y');
insert into parenting_tips values (1, 4, 'If you could be famous for one thing, what would it be?', 'q', 'y');
insert into parenting_tips values (1, 5, 'What\'s your favorite word right now? Why?', 'q', 'y');
insert into parenting_tips values (1, 6, 'What do you love about yourself?', 'q', 'y');
insert into parenting_tips values (1, 7, 'What\'s something that is hard for you?', 'q', 'y');
insert into parenting_tips values (1, 8, 'Describe your perfect day.', 'q', 'y');
insert into parenting_tips values (1, 9, 'Who in your class is lonely?', 'q', 'y');
insert into parenting_tips values (1, 10, 'Who in your class is a leader?', 'q', 'y');
insert into parenting_tips values (1, 11, 'When is it hard being a friend?', 'q', 'y');
insert into parenting_tips values (1, 12, 'Who is somebody you\'d like to be friends with who isn\'t yet your friend?', 'q', 'y');
insert into parenting_tips values (1, 13, 'If you could switch places with one friend for a day, who would it be?', 'q', 'y');
insert into parenting_tips values (1, 14, 'How were you a helper today?', 'q', 'y');
insert into parenting_tips values (1, 15, 'What\'s the smartest thing you heard somebody say today?', 'q', 'y');
insert into parenting_tips values (1, 16, 'Who in your class makes you smile?', 'q', 'y');
insert into parenting_tips values (1, 17, 'What\'s the best thing about living here?', 'q', 'y');
insert into parenting_tips values (1, 18, 'How can you change the world?', 'q', 'y');
insert into parenting_tips values (1, 19, 'What\'s the biggest challenge facing our world today?', 'q', 'y');
insert into parenting_tips values (1, 20, 'If somebody from another planet came to Earth, what would he or she think of our world?', 'q', 'y');
insert into parenting_tips values (1, 21, 'What is something you sue every day that you don\'t need?', 'q', 'y');
insert into parenting_tips values (1, 22, 'What would be the hardest thing about being blind?', 'q', 'y');
insert into parenting_tips values (1, 23, 'If you could give everybody in the world one piece of advice, what would you say?', 'q', 'y');
insert into parenting_tips values (1, 24, 'If you could time travel, where would you go? What would you change?', 'q', 'y');
insert into parenting_tips values (1, 25, 'What is something you know how to do that you could teach others?', 'q', 'y');
insert into parenting_tips values (1, 26, 'What will you be doing in 10 years?', 'q', 'y');
insert into parenting_tips values (1, 27, 'What\'s the most important choice you will have to make in your life?', 'q', 'y');
insert into parenting_tips values (1, 28, 'If you could only eat one food for an entire year, what would you choose?', 'q', 'y');
insert into parenting_tips values (1, 29, 'If you could have one superpower, what would it be?', 'q', 'y');
insert into parenting_tips values (1, 30, 'What is the best thing that\'s ever happened to you? What is the worst thing?', 'q', 'y');
insert into parenting_tips values (1, 31, 'If you had 3 wishes, what would they be?', 'q', 'y');
insert into parenting_tips values (1, 32, 'What are you the most proud of?', 'q', 'y');
insert into parenting_tips values (1, 33, 'Who in your class seems sad?', 'q', 'y');
insert into parenting_tips values (1, 34, 'Who do you admire? Why?', 'q', 'y');
insert into parenting_tips values (1, 35, 'What is something you\'ve always wanted to ask me?', 'q', 'y');
insert into parenting_tips values (1, 36, 'If you could switch places with one family member for a day, who would it be?', 'q', 'y');
insert into parenting_tips values (1, 37, 'What are the 3 most important qualities in a friend?', 'q', 'y');
insert into parenting_tips values (1, 38, 'What\'s the funniest thing somebody did or said today?', 'q', 'y');
insert into parenting_tips values (1, 39, 'Besides your teacher, who is somebody in your class you could learn from?', 'q', 'y');
insert into parenting_tips values (1, 40, 'Who in your class is special? Why?', 'q', 'y');
insert into parenting_tips values (1, 41, 'What is the most important job in the world?', 'q', 'y');
insert into parenting_tips values (1, 42, 'If you could create one law that everybody on Earth had to follow, what would it be?', 'q', 'y');
insert into parenting_tips values (1, 43, 'If you could go anywhere in the world to complete a good deed, where would you go and what would you do?', 'q', 'y');
insert into parenting_tips values (1, 44, 'What will the world be like in 10 years? What will be the same? What will be different?', 'q', 'y');
insert into parenting_tips values (1, 45, 'Is it possible to help somebody you\'ve never met? How?', 'q', 'y');
insert into parenting_tips values (1, 46, 'If you could live in another country for 1 year, where would you live?', 'q', 'y');
insert into parenting_tips values (1, 47, 'Is it better to have too much of something or not enough of something?', 'q', 'y');
insert into parenting_tips values (1, 48, 'Who is the most important person in the world?', 'q', 'y');
CREATE TABLE `parenting_tips_history` (
  `user_id` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `resource_id` int NOT NULL,
  `tip_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `date`, `resource_id`, `tip_id`),
  CONSTRAINT `fk_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `parenting_resources` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
