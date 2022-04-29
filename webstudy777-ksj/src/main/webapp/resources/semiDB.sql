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

DROP TABLE seat;

CREATE  TABLE seat(
	seatNo NUMBER PRIMARY KEY,
	xSeat NUMBER NOT NULL,
	ySeat CHAR NOT NULL
)
INSERT INTO seat(seatNo, xSeat, ySeat) VALUES(1, 2, 'A');

DROP TABLE screen;

CREATE TABLE screen(
	screenNo NUMBER PRIMARY KEY,
	seatNo NUMBER NOT NULL,
	movieNo NUMBER NOT NULL,
	showTime DATE NOT NULL,
 	CONSTRAINT fk_seat FOREIGN KEY (seatNo) REFERENCES seat(seatNo),
	CONSTRAINT fk_movie FOREIGN KEY (movieNo) REFERENCES movie(movieNo)
)
SELECT TO_CHAR(showTime, 'HH:MI:SS') FROM screen;
INSERT INTO screen(screenNo, seatNo, movieNo, showTime) VALUES(1, 1, 3, SYSDATE);
DELETE FROM screen;

CREATE TABLE booking(
	bookNo NUMBER PRIMARY KEY,
	screenNo NUMBER NOT NULL,
	id VARCHAR2(100) NOT NULL,
	bookTime DATE NOT NULL,
	CONSTRAINT fk_screen FOREIGN KEY (screenNo) REFERENCES screen(screenNo),
	CONSTRAINT fk_member FOREIGN KEY (id) REFERENCES member(id)
)


--------------------------------------------
--INSERT DATA 2 

--------------------------------------------
--INSERT DATA 2 








