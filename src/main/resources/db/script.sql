drop database if exists bookmanager;
create database bookmanager;
use bookmanager;

CREATE TABLE `bookmanager`.`books`
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `book_title`  VARCHAR(255),
    `book_author` VARCHAR(255),
    `book_price`  INT,
    PRIMARY KEY (`id`)
);

CREATE TABLE `bookmanager`.`users`
(
    `id`       INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255),
    `login`    VARCHAR(255),
    `password` VARCHAR(255),
    `mail`     VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE `bookmanager`.`comment`
(
    `id`      INT          NOT NULL AUTO_INCREMENT,
    `id_user` INT          NOT NULL,
    `id_book` INT          NOT NULL,
    `date`    DATE         NULL,
    `text`    VARCHAR(500) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_user`
        FOREIGN KEY (`id_user`)
            REFERENCES `bookmanager`.`users` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_book`
        FOREIGN KEY (`id_book`)
            REFERENCES `bookmanager`.`books` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

UPDATE `bookmanager`.`books`
SET `book_title`  = 'Война и мир',
    `book_author` = 'Толстой',
    `book_price`  = '1200'
WHERE (`id` = '2');
UPDATE `bookmanager`.`books`
SET `book_title`  = 'Евгений Онегин',
    `book_author` = 'Пушкин',
    `book_price`  = '600'
WHERE (`id` = '3');
UPDATE `bookmanager`.`books`
SET `book_title`  = 'Герой нашего времени',
    `book_author` = 'Лермонтов',
    `book_price`  = '400'
WHERE (`id` = '4');
UPDATE `bookmanager`.`books`
SET `book_title`  = 'Алые паруса',
    `book_author` = 'Грин',
    `book_price`  = '700'
WHERE (`id` = '5');

CREATE TABLE `bookmanager`.`orders`
(
    `id_order` INT NOT NULL AUTO_INCREMENT,
    `id_user`  INT NULL,
    `id_book`  INT NULL,
    PRIMARY KEY (`id_order`),
    CONSTRAINT `id_user`
        FOREIGN KEY (`id_user`)
            REFERENCES `bookmanager`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `id_book`
        FOREIGN KEY (`id_book`)
            REFERENCES `bookmanager`.`books` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);




