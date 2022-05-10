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
CREATE SEQUENCE seat_seq;
drop SEQUENCE seat_seq;


 DROP TABLE review;
 select * from review;
 CREATE TABLE review(
 	id VARCHAR2(100),
 	movieNo NUMBER,
 	star NUMBER NOT NULL,
 	review CLOB,
 	CONSTRAINT fk_member_movie PRIMARY  KEY (id, movieNo)
 )
 
 select id, movieNo, star, review from review where movieNo = 1;
 
 
DROP TABLE timetable;
select * from timetable
CREATE TABLE timetable(
	timetableNo NUMBER PRIMARY KEY,
	filmNo NUMBER NOT NULL,
	showTime DATE NOT NULL,
	CONSTRAINT fk_film FOREIGN KEY (filmNo) REFERENCES film(filmNo)
)
create sequence timetable_seq;
drop sequence timetable_seq;
insert into timetable values (timetable_seq.nextval, 1, to_date('20220516 07:05:00', 'yymmdd hh:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220516 09:25:00', 'yymmdd hh:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220516 12:00:00', 'yymmdd hh:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220516 14:45:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220516 17:10:00', 'yymmdd hh24:mi:ss'));

insert into timetable values (timetable_seq.nextval, 2, to_date('20220516 13:10:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 2, to_date('20220516 16:30:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 2, to_date('20220516 20:40:00', 'yymmdd hh24:mi:ss'));

insert into timetable values (timetable_seq.nextval, 1, to_date('20220517 15:10:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220518 22:05:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220519 16:30:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220520 09:00:00', 'yymmdd hh24:mi:ss'));
insert into timetable values (timetable_seq.nextval, 1, to_date('20220521 23:55:00', 'yymmdd hh24:mi:ss'));

SELECT showTime FROM timetable WHERE filmNo=1
select timetableNo from timetable WHERE filmNo=1 and showTime= to_date('20220517 15:10:00', 'yymmdd hh24:mi:ss');

select * from booking
DROP TABLE booking;
CREATE TABLE booking(
	bookNo NUMBER PRIMARY KEY,
	timetableNo NUMBER NOT NULL,
	id VARCHAR2(100) NOT NULL,
	seatNo VARCHAR2(100) NOT NULL,
	bookTime DATE NOT NULL,
	CONSTRAINT fk_timetable FOREIGN KEY (timetableNo) REFERENCES timetable(timetableNo),
	CONSTRAINT fk_member FOREIGN KEY (id) REFERENCES member(id)
)
create sequence booking_seq;
drop sequence booking_seq;

insert into booking(bookNo, timetableNo, id, seatNo, bookTime) values(booking_seq.nextval, 9,'java','A1',sysdate);
select id from booking where timetableNo = 1 and seatNo = 'B2'



--영화번호, 그 영화 리뷰 별점의 평균, 영화 제목 불러오는 SQL
--원하는 영화의 평균 불러오는 SQL (null이면 0으로 변환)

--영화번호, 평균, 제목 불러오는 SQL

select r.rnum,r.movieNo,f.filmName
from (
select nvl(AVG(star),0) as rnum,movieNo 
from review 
where movieNo between 1 and 3 
group by movieNo
) r,film f
where r.movieNo = f.filmNo

--select r.rnum,r.movieNo,f.filmName from ( select nvl(AVG(star),0) as rnum,movieNo from review where movieNo=1 group by movieNo) r,film f where r.movieNo = f.filmNo
--select filmNO,filmName,director from film where filmNO between ? and ?

select nvl(AVG(star),0) as savg, filmNo,filmName
from(
select r.star, f.filmNo, f.filmName
from review r
right outer join film f on r.movieNo=f.filmNo
)
where filmNo between 1 and 3 
group by filmNo, filmName
order by filmNo asc

--select nvl(AVG(star),0), filmNo,filmName from(select r.star, f.filmNo, f.filmName from review r right outer join film f on r.movieNo=f.filmNo) where filmNo between 1 and 3 group by filmNo, filmName order by filmNo asc

select r.star, f.filmNo, f.filmName
from review r
inner join film f on r.movieNo=f.filmNo








