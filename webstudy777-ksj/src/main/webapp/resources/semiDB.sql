DROP TABLE movie;
 
 CREATE TABLE movie(
 	movieNo NUMBER PRIMARY KEY,
 	openDate DATE NOT NULL,
 	ageLimit NUMBER NOT NULL,
 	content VARCHAR2(100) NOT NULL,
 	director VARCHAR2(100) NOT NULL,
 	produceYear DATE NOT NULL
 )

DROP TABLE board;
DROP TABLE member;

CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	age NUMBER NOT NULL
)

 DROP TABLE review;
 
 CREATE TABLE review(
 	id VARCHAR2(100),
 	movieNo NUMBER,
 	star NUMBER NOT NULL,
 	review VARCHAR2(100),
 	CONSTRAINT fk_member_movie PRIMARY  KEY (id, movieNo)
 )

SELECT * FROM review;

CREATE  TABLE seat(
	seatNo NUMBER PRIMARY KEY,
	xSeat VARCHAR2(100) NOT NULL,
	ySeat VARCHAR2(100) NOT NULL
)

CREATE TABLE screen(
	screenNo NUMBER PRIMARY KEY,
	seatNo NUMBER NOT NULL,
	movieNo NUMBER NOT NULL,
	showTime Date not null
)
 -- CONSTRAINT fk_seat FOREIGN KEY (seatNo) REFERENCES seat(seatNo),
	-- CONSTRAINT fk_movie FOREIGN KEY (movieNo) REFERENCES movie(movieNo)
drop table screen;

insert into screen (screenNo , seatNo , movieNo , showTime) values (1 , 1 , 1 , TO_CHAR(SYSDATE, 'HH24:MI:SS')) FROM DUAL;

select * from screen;







