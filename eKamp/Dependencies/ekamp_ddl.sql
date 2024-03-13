-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eKamp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eKamp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eKamp` DEFAULT CHARACTER SET utf8 ;
USE `eKamp` ;

-- -----------------------------------------------------
-- Table `eKamp`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `namel_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `date_of_birth` DATE NULL,
  `sex` CHAR(1) NULL,
  `jmbg` CHAR(13) NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `jmbg_UNIQUE` (`jmbg` ASC) VISIBLE,
  INDEX `fk_Person_Country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_Person_Country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `eKamp`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`municipality`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`municipality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `country_id` INT NOT NULL,
  `post_code` VARCHAR(20) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_City_Country1_idx` (`country_id` ASC) VISIBLE,
  UNIQUE INDEX `post_code_UNIQUE` (`post_code` ASC) VISIBLE,
  CONSTRAINT `fk_City_Country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `eKamp`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NULL,
  `municipality_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_place_municipality1_idx` (`municipality_id` ASC) VISIBLE,
  CONSTRAINT `fk_place_municipality1`
    FOREIGN KEY (`municipality_id`)
    REFERENCES `eKamp`.`municipality` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`employee` (
  `person_id` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` CHAR(64) NOT NULL,
  `is_admin` TINYINT NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `eKamp`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`camp_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`camp_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`camp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`camp` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `place_id` INT NOT NULL,
  `camp_status_id` INT NOT NULL,
  `capacity` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Camp_Place1_idx` (`place_id` ASC) VISIBLE,
  INDEX `fk_Camp_Camp_Status1_idx` (`camp_status_id` ASC) VISIBLE,
  CONSTRAINT `fk_Camp_Place1`
    FOREIGN KEY (`place_id`)
    REFERENCES `eKamp`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Camp_Camp_Status1`
    FOREIGN KEY (`camp_status_id`)
    REFERENCES `eKamp`.`camp_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`assignment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `employee_person_id` INT NOT NULL,
  `camp_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Assignment_Employee1_idx` (`employee_person_id` ASC) VISIBLE,
  INDEX `fk_Assignment_Camp1_idx` (`camp_id` ASC) VISIBLE,
  CONSTRAINT `fk_Assignment_Employee1`
    FOREIGN KEY (`employee_person_id`)
    REFERENCES `eKamp`.`employee` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Assignment_Camp1`
    FOREIGN KEY (`camp_id`)
    REFERENCES `eKamp`.`camp` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`resident`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`resident` (
  `person_id` INT NOT NULL,
  `needs_hospitalisation` TINYINT NULL,
  `employee_person_id` INT NOT NULL,
  PRIMARY KEY (`person_id`),
  INDEX `fk_resident_employee1_idx` (`employee_person_id` ASC) VISIBLE,
  CONSTRAINT `fk_Resident_Person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `eKamp`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resident_employee1`
    FOREIGN KEY (`employee_person_id`)
    REFERENCES `eKamp`.`employee` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eKamp`.`residence_period`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eKamp`.`residence_period` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  `camp_id` INT NOT NULL,
  `resident_person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_residence_period_camp1_idx` (`camp_id` ASC) VISIBLE,
  INDEX `fk_residence_period_resident1_idx` (`resident_person_id` ASC) VISIBLE,
  CONSTRAINT `fk_residence_period_camp1`
    FOREIGN KEY (`camp_id`)
    REFERENCES `eKamp`.`camp` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_residence_period_resident1`
    FOREIGN KEY (`resident_person_id`)
    REFERENCES `eKamp`.`resident` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
