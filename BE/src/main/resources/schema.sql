DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `player`;

CREATE TABLE `team`
(
    `id`   BIGINT      NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `player`
(
    `id`              BIGINT      NOT NULL AUTO_INCREMENT,
    `name`            VARCHAR(45) NULL,
    `batting_average` INT         NULL,
    PRIMARY KEY (`id`)
);
