create table book_all(
    id number not null,
    subject varchar2(50) not null,
    author varchar2(50) not null,
    created date not null,
    profile varchar2(50) not null
);
insert  into book_02 values(seq_book_02.nextval,'���� �� ���̽�','2019-07-14',20) ;
insert  into book_02 values(seq_book_02.nextval,'���� �� �ڹ�','2018-08-25',20) ;
insert  into book_02 values(seq_book_02.nextval,'�� ������ �̿��� �ڿ��� ó�� �Թ�','2019-07-12',21) ;
insert  into book_02 values(seq_book_02.nextval,'������ ����������Ʈ','2019-04-05',22);
insert  into book_02 values(seq_book_02.nextval,'������ ���� ORACLE 11g','2019-07-12',23) ;
insert  into book_02 values(seq_book_02.nextval,'�ֽ� ������ �̱�� ������ �ڵ��Ÿ�','2019-03-16',24);
insert  into book_02 values(seq_book_02.nextval,'��Ʈ���� ������ ���̵�','2018-02-24',25);
insert  into book_02 values(seq_book_02.nextval,'�̱� �������� ����','2019-07-12',24);
insert  into book_02 values(seq_book_02.nextval,'Deep Inside VBA,','2019-04-27',26);
insert  into book_02 values(seq_book_02.nextval,'CentOS �����','2016-10-19',20);
insert  into book_02 values(seq_book_02.nextval,'Windows Server �����','2017-08-09',20);
commit;

        
           
select * from book_all
where profile in('���α׷���','�ֽ�','VBA');

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

insert into book_01 values(seq_book_01.nextval, '������' , '���α׷���');
insert into book_01 values(seq_book_01.nextval, 'WJY' , '���α׷���');
insert into book_01 values(seq_book_01.nextval, 'Donghoon' , '����');
insert into book_01 values(seq_book_01.nextval, '�ʷϿ��' , '����Ÿ���̽�');
insert into book_01 values(seq_book_01.nextval, '������' , '�ֽ�');
insert into book_01 values(seq_book_01.nextval, 'Soori' , '����');
insert into book_01 values(seq_book_01.nextval, '������' , 'VBA');
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
update book_01 set profile = 'PG' where author = '������';




