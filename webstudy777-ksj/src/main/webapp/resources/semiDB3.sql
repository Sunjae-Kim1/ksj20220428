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
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(4,'라라랜드','황홀한 사랑, 순수한 희망, 격렬한 열정… 이 곳에서 모든 감정이 폭발한다!

꿈을 꾸는 사람들을 위한 별들의 도시 ‘라라랜드’. 재즈 피아니스트 ‘세바스찬’(라이언 고슬링)과 배우 지망생 ‘미아’(엠마 스톤),

인생에서 가장 빛나는 순간 만난 두 사람은 미완성인 서로의 무대를 만들어가기 시작한다.',TO_DATE('2022.05.12','yyyy.mm.dd'),12,'다미엔 차젤레',TO_DATE('2020.12.31','yyyy.mm.dd'));
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(5,'반지의 제왕','모든 힘을 지배할 악의 군주 ‘사우론’의 절대반지가 깨어나고
악의 세력이 세상을 지배해가며 중간계는 대혼란에 처한다.

호빗 ‘프로도’와 그의 친구들, 엘프 ‘레골라스’, 인간 전사 ‘아라곤’과 ‘보로미르’
드워프 ‘김리’ 그리고 마법사 ‘간달프’로 구성된 반지원정대는
평화를 지키기 위해 절대반지를 파괴할 유일한 방법인
반지가 만들어진 모르도르를 향해 목숨을 건 여정을 떠난다.

한편, 점점 세력을 넓혀온 사우론과의 피할 수 없는 전쟁을 앞둔
반지원정대는 드디어 거대한 최후의 전쟁을 시작하는데...',TO_DATE('2022.05.14','yyyy.mm.dd'),12,'피터 잭슨',TO_DATE('2017.01.25','yyyy.mm.dd'));
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(6,'록키','“져도 상관없어. 내가 원하는 건 끝까지 버텨보는 거야”

필라델피아 뒷골목 4회전 복서 록키.
고리대금 업자의 하수인 노릇으로 생계를 이어가던 그는 짝사랑 하던 여인 에이드리언과 연인이 되며 새로운 미래를 꿈꾼다.
그러던 어느 날 세계 챔피언 아폴로 크리드가 미국 독립 200주년을 기념해 무명의 복서에게 도전권을 주는 이벤트를 준비하고, 그 상대로 록키가 지목 되는데…',TO_DATE('2022.05.13','yyyy.mm.dd'),12,'존 G. 어빌드센',TO_DATE('2017.11.29','yyyy.mm.dd'));
 insert into film(filmNo, filmName, content,openDate,ageLimit,director,produceYear) values(7,'신세계','너, 나하고 일 하나 같이 하자
경찰청 수사 기획과 강과장(최민식)은 국내 최대 범죄 조직인 ''골드문''이 기업형 조직으로 그 세력이 점점 확장되자 신입경찰 이자성(이정재)에게 잠입 수사를 명한다. 그리고 8년, 자성은 골드문의 2인자이자 그룹 실세인 정청(황정민)의 오른팔이 되기에 이른다.

우리 브라더는 그냥 딱, 이 형님만 믿으면 돼야!
골드문 회장이 갑자기 사망하자, 강과장(최민식)은 후계자 결정에 직접 개입하는 ''신세계'' 작전을 설계한다. 피도 눈물도 없는 후계자 전쟁의 한 가운데, 정청(황정민)은 8년 전, 고향 여수에서 처음 만나 지금까지 친형제처럼 모든 순간을 함께 해 온 자성(이정재)에게 더욱 강한 신뢰를 보낸다.

약속 했잖습니까... 이번엔 진짜 끝이라고
한편, 작전의 성공만 생각하는 강과장(최민식)은 계속해서 자성(이정재)의 목을 조여만 간다. 시시각각 신분이 노출될 위기에 처한 자성(이정재)은 언제 자신을 배신할 지 모르는 경찰과, 형제의 의리로 대하는 정청(황정민) 사이에서 갈등하게 되는데…',TO_DATE('2022.05.18','yyyy.mm.dd'),18,'박훈정',TO_DATE('2020.05.21','yyyy.mm.dd'));
 
update film set content='‘알 이즈 웰’을 외치던 유쾌한 세 남자가 돌아왔다!

천재들만 간다는 일류 명문대 ICE, 성적과 취업만을 강요하는 학교를 발칵 뒤집어 놓은 대단한 녀석 란초! ?
아버지가 정해준 꿈, `공학자`가 되기 위해 정작 본인이 좋아하는 일은 포기하고 공부만 하는 파파보이 파르한!
찢어지게 가난한 집, 병든 아버지와 식구들을 책임지기 위해 무조건 대기업에 취직해야만 하는 라주! ?
친구라는 이름으로 뭉친 `세 얼간이`! 삐딱한 천재들의 진정한 꿈을 찾기 위한 세상 뒤집기 한판이 시작된다!' where filmNo=1;
update film set content='마침내 역사상 가장 치열한 최강의 전쟁이 시작된다!

사나운 용 스마우그가 빼앗아간 동쪽의 ‘외로운 산’ 에레보르 왕국을 되찾기 위해 뜻하지 않은 여정을 떠나게 된 호빗 ‘빌보 배긴스’와 ‘간달프’, 
난쟁이족 왕족의 후예 ‘소린’이 이끄는 13명의 난쟁이족. 
‘레골라스’와 그의 파트너 ‘타우리엘’이 속해있는 엘프족의 합세로 더욱 강해진 원정대는 
외로운 산으로 가는 길에 어둠의 숲에서 모습을 자유자재로 바꾸는 베오른과 거대한 거미떼를 만나고, 
난쟁이들에게 적대적인 엘프족에게 잡혔다가 도망쳐 호수마을을 지나는 등 다양한 모험을 하게 된다. 
그리고 마침내 에레보르의 외로운 산에 거의 다다랐을 때, 그들이 지금껏 만났던 그 어떤 존재보다도 위험하고 
모두의 용기와 우정, 지혜의 한계를 시험에 들게 한 용 스마우그와 맞닥뜨리게 되는데….' where filmNo=2;
update film set content='모든 것을 초월한, 역사상 가장 강력한 히어로가 온다!

불의의 사고로 절망에 빠진 천재 외과의사 ‘닥터 스트레인지(베네딕트 컴버배치)’.
마지막 희망을 걸고 찾아 간 곳에서 ‘에인션트 원(틸다 스윈튼)’을 만나 세상을 구원할 강력한 능력을 얻게 되면서,
모든 것을 초월한 최강의 히어로로 거듭나는데...' where filmNo=3;

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
 
<<<<<<< HEAD
 insert into review values('java', 1, 4, '볼 만 하네요');

=======
 select id, movieNo, star, review from review where movieNo = 1;
 
 
>>>>>>> branch 'main' of https://github.com/Sunjae-Kim1/ksj20220428.git
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

SELECT showTime FROM timetable WHERE filmNo=3
select timetableNo from timetable WHERE filmNo=1 and showTime= to_date('20220517 15:10:00', 'yymmdd hh24:mi:ss');

<<<<<<< HEAD
select to_char(sysdate, 'yy-mm-dd') as today, max(showtime)
from (
	select TO_CHAR(showTime,'yy-mm-dd') as showtime from timetable where filmNo=1
)

SELECT * FROM timetable 

=======
select * from booking
DROP TABLE booking;
>>>>>>> branch 'main' of https://github.com/Sunjae-Kim1/ksj20220428.git
CREATE TABLE booking(
	bookNo NUMBER PRIMARY KEY,
	timetableNo NUMBER NOT NULL,
	id VARCHAR2(100) NOT NULL,
	seatNo VARCHAR2(100) NOT NULL,
	bookTime DATE NOT NULL,
	CONSTRAINT fk_timetable FOREIGN KEY (timetableNo) REFERENCES timetable(timetableNo),
	CONSTRAINT fk_member FOREIGN KEY (id) REFERENCES member(id)
)
<<<<<<< HEAD
SELECT * FROM film WHERE filmNo = 2

select timetableNo 
from timetable 
where filmNo=1 
and showtime=to_date('20220516 07:05:00','yyyymmdd hh24:mi:ss');

=======
>>>>>>> branch 'main' of https://github.com/Sunjae-Kim1/ksj20220428.git
create sequence booking_seq;
drop sequence booking_seq;

<<<<<<< HEAD
insert into booking values(booking_seq.nextval, (
	select timetableNo 
	from timetable 
	where filmNo=1 
	and showtime=to_date('20220516 07:05:00','yyyymmdd hh24:mi:ss')
), 'java', '2', sysdate);
=======
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

select rnum, avgStar, filmNo, filmName
from(
	select ROW_NUMBER() OVER(order by filmName ) as rnum, avgStar, filmNo, filmName
	from(
		select  nvl(ROUND(AVG(star),1),0) as avgStar, filmNo,filmName, openDate
		from(
		select r.star, f.filmNo, f.filmName, f.openDate
		from review r
		right outer join film f on r.movieNo=f.filmNo
		)
		group by filmNo, filmName, openDate
	)
)
where rnum between 4 and 6
select openDate, filmName from film
order by openDate;

select  nvl(ROUND(AVG(star),1),0) as savg, filmNo,filmName
from(
	select r.star, f.filmNo, f.filmName
	from review r
	right outer join film f on r.movieNo=f.filmNo
)
group by filmNo, filmName

order by savg desc





--select nvl(AVG(star),0), filmNo,filmName from(select r.star, f.filmNo, f.filmName from review r right outer join film f on r.movieNo=f.filmNo) where filmNo between 1 and 3 group by filmNo, filmName order by filmNo asc

select r.star, f.filmNo, f.filmName
from review r
inner join film f on r.movieNo=f.filmNo





>>>>>>> branch 'main' of https://github.com/Sunjae-Kim1/ksj20220428.git

select bookNo, timeTableNo, seatNo, to_date(booktime, 'yy.mm.dd hh24:mi:ss') from booking where id='java';

select bookNo, timeTableNo, seatNo, bookTime from booking where id='java' order by bookTime;

select filmNo, showTime from timeTable where timeTableNo=5;

select * from booking;

select * from review;

select nvl(AVG(star),0) as avgStar, filmNo,filmName, openDate
from(
	select r.star, f.filmNo, f.filmName, f.openDate
	from review r 
	right outer join film f on r.movieNo=f.filmNo
	) 
where filmNo between 1 and 4 group by filmNo, filmName, openDate
order by openDate desc

select nvl(ROUND(AVG(star),1),0) as avgStar, filmNo,filmName
from(
	select r.star, f.filmNo, f.filmName
	from review r right outer join film f on r.movieNo=f.filmNo
	) 
where filmNo between 1 and 7 group by filmNo, filmName
order by avgStar desc


