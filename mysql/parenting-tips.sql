DROP TABLE IF EXISTS `parenting_tips`;
DROP TABLE IF EXISTS `parenting_resources`;

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
  FOREIGN KEY(resource_id) REFERENCES parenting_resources(resource_id)
);

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
