CREATE TABLE member(
    memberNO number not null,
    memberId varchar2(50) not null,
    memberPw varchar2(50) not null,
    memberName varchar2(50) not null,
    memberJumin varchar2(50) not null ,
    memberPhone varchar2(50) not null,
    memberEmail varchar2(50) not null,
    memberAddress varchar2(100) not null,
    regiDate date not null,
    primary key(memberId),
    unique (memberNO),
    unique (memberJumin)
);
create sequence seq_member
start with 1
increment by 1
nomaxvalue nocache;


select * from member;


create table sungjuk(
no number not null,
name varchar2(50) not null,
kor number not null,
eng number not null,
mat number not null,
tot number not null,
avg number not null,
grade varchar2(50) not null,
regDate date not null,
primary key(no)
);

create sequence seq_sungjuk
start with 1
INCREMENT by 1
NOMAXVALUE
NOCACHE;

commit;

select * from sungjuk;



create table product(
    productCode number not null,
    productName varchar2(50) not null,
    productPrice number not null,
    productContent clob not null,
    vender varchar2(50) not null,
    regiDate date not null,
    primary key (productCode)
);

create sequence seq_product
start with 1
increment by 1
nomaxvalue
nocache;








select * from product;
select count(*) from product;





















