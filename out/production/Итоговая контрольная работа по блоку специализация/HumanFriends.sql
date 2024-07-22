-- Создание базы данных
DROP DATABASE IF EXISTS humanFriends;
CREATE DATABASE IF NOT EXISTS humanFriends;
USE humanFriends;

-- создание таблицы "Питомцы"
DROP TABLE IF EXISTS pets;
CREATE TABLE IF NOT EXISTS pets
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` VARCHAR(45) NOT NULL,
`birthDate` DATE NOT NULL,
`commands` TEXT
);

-- создание таблицы "Вьючные животные"
DROP TABLE IF EXISTS packAnimals;
CREATE TABLE IF NOT EXISTS packAnimals
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` VARCHAR(45) NOT NULL,
`birthDate` DATE NOT NULL,
`commands` TEXT
);

-- заполнение таблицы с питомцами
INSERT INTO pets (`name`, `type`, `birthDate`, `commands`)
VALUES ('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
	   ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
       ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
       ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
       ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
       ('Peanut', 'Hamster', '2021-08-01','Roll, Spin'),
       ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
       ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

-- заполнение таблицы с вьючными животными
INSERT INTO packAnimals (`name`, `type`, `birthDate`, `commands`)
VALUES ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
	   ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
       ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
       ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
       ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
       ('Burro', 'Donkey', '2022-01-23', 'Walk, Bray, Kick'),
       ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
       ('Sahara', 'Camel', '2021-08-14', 'Walk, Run');

-- SELECT * FROM pets;
SELECT * FROM packAnimals;

-- удаление верблюдов
DELETE FROM packAnimals
WHERE `type`='Camel';

SELECT * FROM packAnimals;

-- объединить таблицы с лошадьми и ослами

-- сначала создадим отдельную таблицу с лошадьми
DROP TABLE IF EXISTS `horses`;
CREATE TABLE IF NOT EXISTS `horses`
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` VARCHAR(45) NOT NULL,
`birthDate` DATE NOT NULL,
`commands` TEXT
);
-- заполняем ее из вьючных животных
INSERT INTO `horses` (`name`, `type`, `birthDate`, `commands`)
SELECT `name`, `type`, `birthDate`, `commands` FROM PackAnimals
WHERE Type='Horse';

SELECT * FROM `horses`;

-- теперь создадим таблицу с ослами
DROP TABLE IF EXISTS `donkeys`;
CREATE TABLE IF NOT EXISTS `donkeys`
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` VARCHAR(45) NOT NULL,
`birthDate` DATE NOT NULL,
`commands` TEXT
);
-- заполняем из вьючных животных
INSERT INTO `donkeys` (`name`, `type`, `birthDate`, `commands`)
SELECT `name`, `type`, `birthDate`, `commands` FROM PackAnimals
WHERE Type='Donkey';

SELECT * FROM `donkeys`;
-- создаем таблицы - объединение лошадей и ослов
DROP TABLE IF EXISTS `horsesAndDonkeys`;
CREATE TABLE IF NOT EXISTS `horsesAndDonkeys`
SELECT * FROM `horses`
	UNION
SELECT * FROM `donkeys`;

SELECT * FROM `horsesAndDonkeys`;

-- создаем таблицу с животными от 1 до 3 лет из таблиц pets и packAnimals
DROP TABLE IF EXISTS `youngAnimals`;
CREATE TABLE IF NOT EXISTS `youngAnimals`
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` VARCHAR(45) NOT NULL,
`birthDate` DATE NOT NULL,
`commands` TEXT,
`ageAnimlas` INT
);

-- добавляем подходящих животных из двух таблиц
INSERT INTO `youngAnimals` (`name`, `type`, `birthDate`, `commands`,`ageAnimlas`)
SELECT `name`, `type`, `birthDate`, `commands`, TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) 
AS `ageAnimlas` FROM PackAnimals
WHERE TIMESTAMPDIFF(YEAR, birthDate, CURDATE()) BETWEEN 1 And 3
	UNION
SELECT `name`, `type`, `birthDate`, `commands`, TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) 
AS `ageAnimlas` FROM pets
WHERE TIMESTAMPDIFF(YEAR, birthDate, CURDATE()) BETWEEN 1 And 3;

SELECT * FROM `youngAnimals`;

-- создаем таблицу со всеми животными с сохранением информации об исходной таблице
DROP TABLE IF EXISTS `allAnimals`;
CREATE TABLE IF NOT EXISTS `allAnimals`
(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` VARCHAR(45) NOT NULL,
`birthDate` DATE NOT NULL,
`commands` TEXT,
`origintable` VARCHAR(45)
);

-- добавляем подходящих животных из двух таблиц
INSERT INTO `allAnimals` (`name`, `type`, `birthDate`, `commands`, `origintable`)
SELECT `name`, `type`, `birthDate`, `commands`, 'packAnimals'
AS `origintable` FROM packAnimals
	UNION
SELECT `name`, `type`, `birthDate`, `commands`, 'pets'
AS `origintable` FROM pets;

SELECT * FROM `allAnimals`;