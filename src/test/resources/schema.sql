DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS tests;
DROP TABLE IF EXISTS topics;
DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `role` VARCHAR(45) DEFAULT 'STUDENT' NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `results` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `score` INT(11) NOT NULL,
  `test_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `topics` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tests` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `topic_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_topics_id`
    FOREIGN KEY (`topic_id`)
    REFERENCES `topics` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `questions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `question_text` VARCHAR(255) NOT NULL,
  `test_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_test_id`
    FOREIGN KEY (`test_id`)
    REFERENCES `tests` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `answers` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `answer_text` VARCHAR(255) NOT NULL,
  `is_correct` TINYINT(1) NULL,
  `question_id` INT(11) NULL,
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `questions` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);