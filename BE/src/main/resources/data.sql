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

INSERT INTO player (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '양성우', 168, true);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '손광민', 214, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '김태균', 400, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '정진호', 167, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '하주석', 167, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '손광민', 214, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '김태균', 400, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '정진호', 167, false);
INSERT INTO `player` (`team_id`, `name`, `batting_average`, `is_pitcher`)
VALUES (1, '하주석', 167, false);


INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '박건우', 319, true);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '이홍련', 310, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '오재일', 293, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '허경민', 288, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '김재환', 283, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '오재일', 293, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '허경민', 288, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '김재환', 283, false);
INSERT INTO `player` (team_id, name, batting_average, is_pitcher)
VALUES (2, '오재일', 293, false);
