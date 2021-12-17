-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vinil_java
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vinil_java
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vinil_java` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema vinil_java
-- -----------------------------------------------------
USE `vinil_java` ;

-- -----------------------------------------------------
-- Table `vinil_java`.`gravadoras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinil_java`.`gravadoras` (
  `gravadora_id` INT NOT NULL AUTO_INCREMENT,
  `gravadora_nome` VARCHAR(100) NULL,
  PRIMARY KEY (`gravadora_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vinil_java`.`artistas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinil_java`.`artistas` (
  `artista_id` INT NOT NULL AUTO_INCREMENT,
  `artista_nome` VARCHAR(100) NULL,
  `artista_historia` TEXT NULL,
  PRIMARY KEY (`artista_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vinil_java`.`albuns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinil_java`.`albuns` (
  `album_id` INT NOT NULL AUTO_INCREMENT,
  `album_nome` VARCHAR(100) NULL,
  `album_data` DATE NULL,
  `album_artista` INT NULL,
  `album_tipo` ENUM("coletanea", "solo") NULL,
  `album_gravadora` INT NULL,
  PRIMARY KEY (`album_id`),
  INDEX `album_gravadora_idx` (`album_gravadora` ASC) VISIBLE,
  INDEX `album_artista_idx` (`album_artista` ASC) VISIBLE,
  CONSTRAINT `album_gravadora`
    FOREIGN KEY (`album_gravadora`)
    REFERENCES `vinil_java`.`gravadoras` (`gravadora_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `album_artista`
    FOREIGN KEY (`album_artista`)
    REFERENCES `vinil_java`.`artistas` (`artista_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vinil_java`.`musicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinil_java`.`musicas` (
  `musica_id` INT NOT NULL AUTO_INCREMENT,
  `musica_nome` VARCHAR(255) NULL,
  `musica_data` DATE NULL,
  `musica_artista` INT NULL,
  `musica_composicao` VARCHAR(255) NULL,
  `musica_regravacao` TINYINT NULL,
  `musica_album` INT NULL,
  `musica_historia` TEXT NULL,
  PRIMARY KEY (`musica_id`),
  INDEX `muscia_artista_idx` (`musica_artista` ASC) VISIBLE,
  INDEX `musica_album_idx` (`musica_album` ASC) VISIBLE,
  CONSTRAINT `muscia_artista`
    FOREIGN KEY (`musica_artista`)
    REFERENCES `vinil_java`.`artistas` (`artista_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `musica_album`
    FOREIGN KEY (`musica_album`)
    REFERENCES `vinil_java`.`albuns` (`album_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;