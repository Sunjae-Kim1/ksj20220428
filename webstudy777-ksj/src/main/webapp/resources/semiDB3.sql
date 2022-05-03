DROP TABLE REVIEW;
DROP TABLE BOOKING;
DROP TABLE timetable;
DROP TABLE SEAT;

DROP TABLE film;
DROP TABLE member;
-------

CREATE TABLE member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	age NUMBER NOT NULL
)
select * from member;
insert into member(id, password, name,age) values('java','a','아이유',28);
insert into member(id, password, name,age) values('spring','a','박보검',28);
insert into member(id, password, name,age) values('kosta','a','정동원',15);

CREATE TABLE film(
 	filmNo NUMBER PRIMARY KEY,
 	filmName VARCHAR2(100) NOT NULL,
 	content CLOB NOT NULL,
 	openDate DATE NOT NULL,
 	ageLimit NUMBER NOT NULL,
 	director VARCHAR2(100) NOT NULL,
 	produceYear DATE NOT NULL
 )
 --재확인용--
 select * from film;
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(1,'세 얼간이','인도풍 뮤지컬 영화',TO_DATE('2022.05.02','yyyy.mm.dd'),12,'라지쿠마르 히라니',TO_DATE('2009.12.25','yyyy.mm.dd'));
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(2,'호빗 ','난장이가 용잡으러 가는 영화',TO_DATE('2022.05.03','yyyy.mm.dd'),12,'피터 잭슨',TO_DATE('2013.12.12','yyyy.mm.dd'));
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(3,'닥터 스트레인지','인도풍 뮤지컬 영화',TO_DATE('2022.05.01','yyyy.mm.dd'),12,'스콧 데릭슨',TO_DATE('2016.10.25','yyyy.mm.dd'));
 
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
create sequence timetable_seq;
insert into timetable values (timetable_seq.nextval, 1, to_date('220516 07:05:00', 'yymmdd hh:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220516 09:25:00', 'yymmdd hh:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220516 12:00:00', 'yymmdd hh:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220516 14:45:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220516 17:10:00', 'yymmdd hh24:mi:ss'));

insert into timetable values (timetable_seq.nextval, 1, to_date('220517 15:10:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220518 22:05:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220519 16:30:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220520 09:00:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('220521 23:55:00', 'yymmdd hh24:mi:ss'));

select * from timetable;
SELECT showTime FROM timetable WHERE filmNo=1;

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
SELECT * FROM film WHERE filmNo = 1







