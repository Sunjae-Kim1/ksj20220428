DROP TABLE REVIEW;
DROP TABLE BOOKING;
DROP TABLE SCREEN;
DROP TABLE SEAT;

DROP TABLE movie;
DROP TABLE member;
-------

CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	age NUMBER NOT NULL
)
 
CREATE TABLE film(
 	filmNo NUMBER PRIMARY KEY,
 	filmName VARCHAR2(100) NOT NULL,
 	content CLOB NOT NULL,
 	openDate DATE NOT NULL,
 	ageLimit NUMBER NOT NULL,
 	director VARCHAR2(100) NOT NULL,
 	produceYear DATE NOT NULL
 )
 
 DROP TABLE seat;
 
CREATE  TABLE seat(
	seatNo NUMBER PRIMARY KEY,
	xSeat NUMBER NOT NULL,
	ySeat NUMBER NOT NULL
)

 DROP TABLE review;
 
 CREATE TABLE review(
 	id VARCHAR2(100),
 	movieNo NUMBER,
 	star NUMBER NOT NULL,
 	review CLOB,
 	CONSTRAINT fk_member_movie PRIMARY  KEY (id, movieNo)
 )

DROP TABLE timetable;

CREATE TABLE timetable(
	timetableNo NUMBER PRIMARY KEY,
	filmNo NUMBER NOT NULL,
	showTime DATE NOT NULL,
	CONSTRAINT fk_film FOREIGN KEY (filmNo) REFERENCES film(filmNo)
)

CREATE TABLE booking(
	bookNo NUMBER PRIMARY KEY,
	timetableNo NUMBER NOT NULL,
	id VARCHAR2(100) NOT NULL,
	seatNo NUMBER NOT NULL,
	bookTime DATE NOT NULL,
	CONSTRAINT fk_timetable FOREIGN KEY (timetableNo) REFERENCES timetable(timetableNo),
	CONSTRAINT fk_member FOREIGN KEY (id) REFERENCES member(id),
	CONSTRAINT fk_seat FOREIGN KEY (seatNo) REFERENCES seat(seatNo)
)








