create user test_user identified by systemsss;
GRANT {ALL PRIVILEGES} TO test_user;

CREATE TABLE like_book(
    book_id NUMBER primary key,
    book_name VARCHAR2(60) not null,
    author VARCHAR2(60)
);

COMMENT ON COLUMN like_book.book_id IS '図書NO';
COMMENT ON COLUMN like_book.book_name IS '図書名';
COMMENT ON COLUMN like_book.author IS '図書NO';

INSERT INTO like_book(book_id,book_name,author) VALUES(1,'不思議の国のアリス','ルイス・キャロル');
INSERT INTO like_book(book_id,book_name,author) VALUES(2,'緋色の研究','コナン・ドイル');
INSERT INTO like_book(book_id,book_name,author) VALUES(3,'コナン・ドイル','江戸川乱歩');


INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(001,'鈴木 仁',null,TO_DATE('2000/01/01','YYYY/MM/DD'),600000,'PL');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(002,'佐藤 幸助','鈴木 仁',TO_DATE('2000/03/22','YYYY/MM/DD'),350000,'ブリッジSE');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(003,'高橋 ひとみ',null,TO_DATE('2000/01/01','YYYY/MM/DD'),500000,'PL');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(004,'大前 貢','鈴木 仁',TO_DATE('2000/04/01','YYYY/MM/DD'),320000,'SE');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(005,'真田 博之','鈴木 仁',TO_DATE('2001/04/01','YYYY/MM/DD'),300000,'SE');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(006,'大城 勉','鈴木 仁',TO_DATE('2001/04/01','YYYY/MM/DD'),300000,'SE');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(007,'神城 陣','高橋 ひとみ',TO_DATE('2001/04/01','YYYY/MM/DD'),280000,'PG');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(008,'結城 瞳','高橋 ひとみ',TO_DATE('2002/04/01','YYYY/MM/DD'),280000,'PG');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(009,'博多 弁','高橋 ひとみ',TO_DATE('2003/04/01','YYYY/MM/DD'),260000,'PG');
INSERT INTO emp(empno,ename,superior,hiredate,sal,job) VALUES(010,'小山 浩','高橋 ひとみ',TO_DATE('2006/04/01','YYYY/MM/DD'),180000,'デザイナー');

SELECT * FROM like_book;
SELECT * FROM like_book t WHERE t.book_id = 3;
SELECT ename,superior,sal FROM emp;
SELECT DISTINCT job FROM emp;

UPDATE like_book t SET ename = '鏡の国のアリス' WHERE t.booke_id = 1;

DELETE FROM like_book t WHERE t.book_id = 3;