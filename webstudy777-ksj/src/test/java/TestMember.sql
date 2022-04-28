select * from MVC_MEMBER;

drop table mvc_member;

create table mvc_member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	birthday DATE NOT NULL,
	regdate DATE NOT NULL
)

insert into mvc_member(id , password , name , address , birthday , regdate)
values('java' , 'a' , '아이유' , '오리' , TO_DATE('2001-03-11','YYYY-MM-DD') , SYSDATE);

insert into mvc_member(id , password , name , address , birthday , regdate)
values('queen' , 'a' , '프레디' , '오리' , TO_DATE('1970-02-11','YYYY-MM-DD') , SYSDATE);

insert into mvc_member(id , password , name , address , birthday , regdate)
values('beatles' , 'a' , '존레논' , '용인' , TO_DATE('1980-11-23','YYYY-MM-DD') , SYSDATE);

insert into mvc_member(id , password , name , address , birthday , regdate)
values('spring' , 'a' , '박보검' , '경기도' , TO_DATE('1985-11-11','YYYY-MM-DD') , SYSDATE);

insert into mvc_member(id , password , name , address , birthday , regdate)
values('servlet' , 'a' , '손흥민' , '한국' , TO_DATE('1970-05-05','YYYY-MM-DD') , SYSDATE);

update mvc_member set id = '' where id = '';

select count(*) from MVC_MEMBER where id = 'java';