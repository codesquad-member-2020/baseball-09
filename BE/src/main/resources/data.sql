INSERT INTO `team` (`name`, `match_id`, `is_selected`)
VALUES ('Captin', 1, true);
INSERT INTO `team` (`name`, `match_id`, `is_selected`)
VALUES ('Marvel', 1, true);
INSERT INTO `team` (`name`, `match_id`)
VALUES ('Twins', 2);
INSERT INTO `team` (`name`, `match_id`)
VALUES ('Tigers', 2);
INSERT INTO `team` (`name`, `match_id`)
VALUES ('Rockets', 3);
INSERT INTO `team` (`name`, `match_id`)
VALUES ('Doggers', 3);
INSERT INTO `team` (`name`, `match_id`)
VALUES ('Lotte', 4);
INSERT INTO `team` (`name`, `match_id`)
VALUES ('NC', 4);

INSERT INTO `match` (`home_team_id`, `away_team_id`, `is_started`)
VALUES (1, 2, true);
INSERT INTO `match` (`home_team_id`, `away_team_id`)
VALUES (3, 4);
INSERT INTO `match` (`home_team_id`, `away_team_id`)
VALUES (5, 6);
INSERT INTO `match` (`home_team_id`, `away_team_id`)
VALUES (7, 8);

INSERT INTO `user` (`email`)
VALUES ('home@gmail.com');
INSERT INTO `user` (`email`)
VALUES ('away@gmail.com');

INSERT INTO `game` (`match_id`)
VALUES (1);

INSERT INTO `score_board` (`game_id`, `team_id`, `inning`, `score`)
VALUES (1, 1, 1, 1);
INSERT INTO `score_board` (`game_id`, `team_id`, `inning`, `score`, `is_bottom`)
VALUES (1, 2, 1, 3, true);
INSERT INTO `score_board` (`game_id`, `team_id`, `inning`, `score`)
VALUES (1, 1, 2, 3);
INSERT INTO `score_board` (`game_id`, `team_id`, `inning`, `score`, `is_bottom`)
VALUES (1, 2, 2, 0, true);



