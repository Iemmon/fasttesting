CREATE TABLE IF NOT EXISTS `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `role` VARCHAR(45) DEFAULT 'STUDENT' NOT NULL,
  `salt` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `results` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `score` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_results_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_results_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `topics` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `tests` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `topic_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_topics_id_idx` (`topic_id` ASC),
  CONSTRAINT `fk_topics_id`
    FOREIGN KEY (`topic_id`)
    REFERENCES `topics` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `questions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `question_text` VARCHAR(255) NOT NULL,
  `test_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_test_id_idx` (`test_id` ASC),
  CONSTRAINT `fk_test_id`
    FOREIGN KEY (`test_id`)
    REFERENCES `tests` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `answers` (
  `id` INT(11) NOT NULL  AUTO_INCREMENT,
  `answer_text` VARCHAR(255) NOT NULL,
  `is_correct` TINYINT(1) NULL,
  `question_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_id_idx` (`question_id` ASC),
  CONSTRAINT `fk_question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `questions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
