create table book_all(
    id number not null,
    subject varchar2(50) not null,
    author varchar2(50) not null,
    created date not null,
    profile varchar2(50) not null
);
insert  into book_02 values(seq_book_02.nextval,'점프 투 파이썬','2019-07-14',20) ;
insert  into book_02 values(seq_book_02.nextval,'점프 투 자바','2018-08-25',20) ;
insert  into book_02 values(seq_book_02.nextval,'딥 러닝을 이용한 자연어 처리 입문','2019-07-12',21) ;
insert  into book_02 values(seq_book_02.nextval,'공이의 수학정리노트','2019-04-05',22);
insert  into book_02 values(seq_book_02.nextval,'예제로 배우는 ORACLE 11g','2019-07-12',23) ;
insert  into book_02 values(seq_book_02.nextval,'주식 시장을 이기는 마법의 자동매매','2019-03-16',24);
insert  into book_02 values(seq_book_02.nextval,'비트코인 개발자 가이드','2018-02-24',25);
insert  into book_02 values(seq_book_02.nextval,'미국 금융공학 유학','2019-07-12',24);
insert  into book_02 values(seq_book_02.nextval,'Deep Inside VBA,','2019-04-27',26);
insert  into book_02 values(seq_book_02.nextval,'CentOS 만들기','2016-10-19',20);
insert  into book_02 values(seq_book_02.nextval,'Windows Server 만들기','2017-08-09',20);
commit;

        
           
select * from book_all
where profile in('프로그래밍','주식','VBA');

create table book_01(
id number not null,
author varchar2(50) null,
profile varchar2(50) null
);

create table book_02(
id number not null,
subject varchar2(100) not null,
created date not null,
author_id number not null,
PRIMARY key (id)
);

alter table book_all
add primary key(id);

select * from book_01;
create sequence seq_book_01 start with 20 increment by 1 minvalue 1;
create sequence seq_book_02 start with 50 increment by 1 minvalue 1;

drop sequence seq_book_01;

insert into book_01 values(seq_book_01.nextval, '박응용' , '프로그래밍');
insert into book_01 values(seq_book_01.nextval, 'WJY' , '프로그래밍');
insert into book_01 values(seq_book_01.nextval, 'Donghoon' , '수학');
insert into book_01 values(seq_book_01.nextval, '초록우산' , '데이타베이스');
insert into book_01 values(seq_book_01.nextval, '엑슬론' , '주식');
insert into book_01 values(seq_book_01.nextval, 'Soori' , '금융');
insert into book_01 values(seq_book_01.nextval, '곽승주' , 'VBA');
commit;
truncate table book_01;
select * from book_01;

select * from book_02;

select b2.id, b2.subject,  b1.author,b2.created, b1.profile
from book_01 b1, book_02 b2
where b1.id = b2.author_id;

select b2.id, b2.subject,  b1.author,b2.created, b1.profile
from book_01 b1 inner join book_02 b2
on b1.id = b2.author_id
where substr(b2.created,1,2) = 19;

select b2.* , (select author from book_01 where book_01.id = b2.author_id)
from book_02 b2
where substr(b2.created,1,2) = 19;



commit;
update book_01 set profile = 'PG' where author = '박응용';




