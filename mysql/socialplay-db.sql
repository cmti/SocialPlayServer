DROP TABLE IF EXISTS `friends`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_hash` varchar(100) NOT NULL,
  `user_type` varchar(1) NOT NULL,
  `user_status` varchar(1) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `identity` varchar(50) NOT NULL,
  `lastaccesstime` int(8) NOT NULL,
  PRIMARY KEY (`user_id`)
) 
AUTO_INCREMENT=1234567;
ALTER TABLE users ADD UNIQUE INDEX (user_hash);
insert into users (user_hash, user_type, user_status, user_name, identity, lastaccesstime) values ('0', 'p', 'n', 'povi test', '4089876543', NOW());

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `invitor_id` int(8) NOT NULL,
  `invitee_id` int(8) NOT NULL,
  PRIMARY KEY (`invitor_id`, `invitee_id`),
  FOREIGN KEY(invitor_id) REFERENCES users(user_id),
  FOREIGN KEY(invitee_id) REFERENCES users(user_id)
);
