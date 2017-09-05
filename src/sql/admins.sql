BEGIN TRANSACTION;
DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
	`name`	TEXT NOT NULL,
	`surname`	TEXT NOT NULL,
	`password`	TEXT NOT NULL,
	`login`	TEXT NOT NULL,
	`mail`	TEXT NOT NULL
);
INSERT INTO `admins` (name,surname,password,login,mail) VALUES ('Cristiano','Ronaldo','3333','ronaldo1204','ron@gmail.com'),
 ('Leo','Messi','2222','messi1203','messi@gmail.com');
COMMIT;
