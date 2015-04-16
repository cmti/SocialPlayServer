DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_hash` varchar(100) NOT NULL,
  `user_type` varchar(1) NOT NULL,
  `user_status` varchar(1) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `identity` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) 
AUTO_INCREMENT=1234567;

insert into users (user_hash, user_type, user_status, user_name, identity) values ('0', 'p', 'n', 'povi test', '4089876543');
