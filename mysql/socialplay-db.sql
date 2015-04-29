DROP TABLE IF EXISTS `events`;
DROP TABLE IF EXISTS `friends`;
DROP TABLE IF EXISTS `chat_invitation`;
DROP TABLE IF EXISTS `events`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_hash` varchar(100) NOT NULL,
  `user_type` varchar(1) NOT NULL,
  `user_status` varchar(1) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `identity` varchar(50) NOT NULL,
  `lastaccesstime` bigint NOT NULL,
  PRIMARY KEY (`user_id`)
) 
AUTO_INCREMENT=1234567;
ALTER TABLE users ADD UNIQUE INDEX (user_hash);
insert into users (user_hash, user_type, user_status, user_name, identity, lastaccesstime) values ('zllo5/Rd6gzaZhKAUC3VSa4fDH/WD0EgvI0e99UuV1A=', 'p', 'n', 'povi test', '4089876543', NOW());

CREATE TABLE `friends` (
  `invitor_id` int(8) NOT NULL,
  `invitee_id` int(8) NOT NULL,
  PRIMARY KEY (`invitor_id`, `invitee_id`),
  FOREIGN KEY(invitor_id) REFERENCES users(user_id),
  FOREIGN KEY(invitee_id) REFERENCES users(user_id)
);

CREATE TABLE `chat_invitation` (
  `invitor_id` int(8) NOT NULL,
  `invitee_id` int(8) NOT NULL,
  `room_id` varchar(15) NOT NULL,
  `started` varchar(1) NOT NULL,
  `invite_time` bigint NOT NULL,
  PRIMARY KEY (`invitor_id`, `invitee_id`),
  FOREIGN KEY(invitor_id) REFERENCES users(user_id),
  FOREIGN KEY(invitee_id) REFERENCES users(user_id)
);

CREATE TABLE `events` (
  `event_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NOT NULL,
  `event_type` varchar(2) NOT NULL,
  `timestamp` bigint NOT NULL,
  `duration` int NOT NULL,
  `eventdetails` varchar(400) NOT NULL,
  PRIMARY KEY(`event_id`),
  FOREIGN KEY(user_id) REFERENCES users(user_id)
)
AUTO_INCREMENT=10000001;
ALTER TABLE events ADD UNIQUE INDEX (timestamp, user_id);
