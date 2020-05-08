DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `player`;
DROP TABLE IF EXISTS `match`;

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

CREATE TABLE `match`
(
    `id`           BIGINT NOT NULL AUTO_INCREMENT,
    `home_team_id` BIGINT NOT NULL,
    `away_team_id` BIGINT NOT NULL,
    `started`      BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`)
);
