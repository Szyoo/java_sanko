create user hogemon_user identified by systemsss;
GRANT {ALL PRIVILEGES} TO hogemon_user;

CREATE TABLE hogemon(
    hogemon_no NUMBER primary key,
    hogemon_name VARCHAR2(30) not null,
    type VARCHAR2(15) not null,
    evolution_level NUMBER(2)
);

INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(1,'フシギカナ','plant',25);
INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(2,'フシギッポイ','plant',50);
INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(3,'フシギバナナ','plant',null);
INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(4,'ニョース','normal',35);
INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(5,'アビシニアン','normal',null);
INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(6,'ベカチュウ','electric',35);
INSERT INTO hogemon(hogemon_no,hogemon_name,type,evolution_level) VALUES(7,'ナイチュウ','electric',null);

SELECT * FROM hogemon ORDER BY hogemon_no;

SELECT * FROM hogemon WHERE hogemon_no = 6;

SELECT hogemon_no as "ホゲモン図鑑NO", hogemon_name as "ホゲモン名" FROM hogemon ORDER BY hogemon_no;

SELECT DISTINCT type FROM hogemon ORDER BY type DESC;

UPDATE hogemon SET hogemon_name = 'フシギコイバナ' WHERE hogemon_no = 3;

DELETE FROM hogemon WHERE hogemon_no = 4;
SELECT * FROM hogemon ORDER BY hogemon_no;

