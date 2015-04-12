DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_hash` varchar(100) NOT NULL,
  `user_type` varchar(1) NOT NULL,
  `user_status` varchar(1) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ;
