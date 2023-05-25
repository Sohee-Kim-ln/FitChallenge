-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fitchallenge
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fitchallenge
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fitchallenge`;
CREATE SCHEMA IF NOT EXISTS `fitchallenge` DEFAULT CHARACTER SET utf8 ;
USE `fitchallenge` ;

-- -----------------------------------------------------
-- Table `fitchallenge`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitchallenge`.`team` (
  `team_id` INT NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(45) NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT now(),
  `max_capacity` INT NOT NULL,
  `cur_capacity` INT NULL DEFAULT 0,
  `info` VARCHAR(200) NOT NULL,
  `announce` VARCHAR(200) NULL,
  `team_img` VARCHAR(200) NULL,
  `team_img_org` VARCHAR(200) NULL,
  PRIMARY KEY (`team_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitchallenge`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitchallenge`.`user` (
  `user_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `birth_date` DATE NOT NULL,
  `gender` INT NOT NULL,
  `recent_login` DATETIME NOT NULL DEFAULT now(),
  `continued` INT NOT NULL DEFAULT 1,
  `reg_date` DATETIME NOT NULL DEFAULT now(),
  `user_img` VARCHAR(200) NULL,
  `user_img_org` VARCHAR(200) NULL,
  `team_id` INT NULL,
  `is_owner` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_team1_idx` (`team_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `fitchallenge`.`team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitchallenge`.`phrase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitchallenge`.`phrase` (
  `phrase_id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`phrase_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitchallenge`.`sports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitchallenge`.`sports` (
  `sports_id` INT NOT NULL AUTO_INCREMENT,
  `sports_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`sports_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitchallenge`.`goal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitchallenge`.`goal` (
  `goal_id` INT NOT NULL AUTO_INCREMENT,
  `team_id` INT NOT NULL,
  `sports_id` INT NOT NULL,
  `goal_time` INT NOT NULL,
  `goal_distance` INT NOT NULL,
  `visible` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`goal_id`, `team_id`, `sports_id`),
  INDEX `fk_goal_group1_idx` (`team_id` ASC) VISIBLE,
  INDEX `fk_goal_sports1_idx` (`sports_id` ASC) VISIBLE,
  UNIQUE INDEX `goal_id_UNIQUE` (`goal_id` ASC) VISIBLE,
  CONSTRAINT `fk_goal_group1`
    FOREIGN KEY (`team_id`)
    REFERENCES `fitchallenge`.`team` (`team_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_goal_sports1`
    FOREIGN KEY (`sports_id`)
    REFERENCES `fitchallenge`.`sports` (`sports_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fitchallenge`.`daily`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitchallenge`.`daily` (
  `daily_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `sports_id` INT NOT NULL,
  `date` DATE NOT NULL DEFAULT (current_date),
  `daily_time` INT NOT NULL,
  `daily_distance` INT NOT NULL,
  `comment` VARCHAR(200) NULL,
  PRIMARY KEY (`daily_id`),
  INDEX `fk_record_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_record_sports1_idx` (`sports_id` ASC) VISIBLE,
  CONSTRAINT `fk_record_user10`
    FOREIGN KEY (`user_id`)
    REFERENCES `fitchallenge`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_record_sports10`
    FOREIGN KEY (`sports_id`)
    REFERENCES `fitchallenge`.`sports` (`sports_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
