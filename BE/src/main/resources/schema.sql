DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `player`;
DROP TABLE IF EXISTS `match`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `game`;
DROP TABLE IF EXISTS `score_board`;
DROP TABLE IF EXISTS `strike_ball_out_hit_board`;
DROP TABLE IF EXISTS `batting_log`;

CREATE TABLE `team`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45) NULL,
    `is_selected` BOOLEAN DEFAULT FALSE,
    `match_id`    BIGINT      NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `player`
(
    `id`              BIGINT      NOT NULL AUTO_INCREMENT,
    `team_id`         BIGINT      NOT NULL,
    `name`            VARCHAR(45) NULL,
    `batting_average` INT         NULL,
    `is_pitcher`      BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `match`
(
    `id`           BIGINT NOT NULL AUTO_INCREMENT,
    `home_team_id` BIGINT NOT NULL,
    `away_team_id` BIGINT NOT NULL,
    `is_started`   BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user`
(
    `id`    BIGINT       NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(100) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `game`
(
    `id`       BIGINT NOT NULL AUTO_INCREMENT,
    `match_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `score_board`
(
    `id`        BIGINT NOT NULL AUTO_INCREMENT,
    `game_id`   BIGINT,
    `team_id`   BIGINT,
    `inning`    INT,
    `score`     INT,
    `is_bottom` BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`),
    UNIQUE (`game_id`, `team_id`, `inning`)
);

CREATE TABLE `batting_log`
(
    `id`        BIGINT NOT NULL AUTO_INCREMENT,
    `game_id`   BIGINT,
    `player_id` BIGINT,
    `inning`    INT,
    `status`    INT,
    PRIMARY KEY (`id`)
);

CREATE TABLE `strike_ball_out_hit_board`
(
    `id`      BIGINT NOT NULL AUTO_INCREMENT,
    `game_id` BIGINT,
    `inning`  INT,
    `strike`  INT,
    `ball`    INT,
    `out`     INT,
    `hit`     INT,
    PRIMARY KEY (`id`),
    UNIQUE (`game_id`, `inning`)
);


