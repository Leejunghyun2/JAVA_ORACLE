desc employees;

select * from employees;

select first_name,last_name from employees;

select * from departments;

select (first_name|| '/' ||last_name) as name from employees;

select first_name,hire_date,salary , salary * 12 as "1" from employees;

select first_name,hire_date,salary , nvl(commission_pct,0), salary * 12 as "1" from employees;

select first_name,hire_date,salary, salary * 12 + nvl(commission_pct,0) as commisoin from employees;

select 1000 + 2000 from employees;

select mod(100, 30) from dual;

select salary ,salary + 5000000 from employees;

select * from employees where department_id = 10;

select * from employees where first_name like '%L%';

select count(*) as 학생수 from employees;

desc employee;

select e.employee_id, d.department_id from employees e, departments d where e.department_id = d.department_id;

desc departments;

select *
from employees
where SUBSTR(hire_date, 1, 2) = 05;

select substr(hire_date ,1 ,2)
from employees;

select * from employees
where substr(hire_date ,1 ,2)>=5 and department_id = 60 and salary <= 15000;

select * from employees
where commission_pct in (0.1,0.25,0.3);


select * from employees
where salary not between 15000 and 20000;

select * from employees
where not (salary >=15000 and salary <= 20000);

select * from employees where first_name like '%N%';

select * from employees where lower(first_name) like '%n%';

select * from employees where commission_pct is null;

select first_name from employees where first_name like '%a';

select first_name from employees where substr(first_name , length(first_name)-1 ,2) = 'na';

select * from employees where substr(hire_date,1,2) = 05;

select ceil(34.5678) from dual;

select trunc(abs(months_between('2019/04/04','2019/04/15')),2) from dual;

select first_name,hire_date, sysdate, round(abs(months_between(sysdate,hire_date))) as between_date from employees;

select sysdate,NEXT_DAY(SYSDATE, '금요일') from dual;

select first_name, floor(months_between(sysdate,hire_date)/12)|| '년' as 근속년수
from employees;

select to_char(sysdate -100, 'day'), sysdate + 100 from dual;

select rownum,rowid, employee_id, first_name from employees
order by employee_id asc;


-- 숫자를 원화 단위로 변경하는 방법
select first_name, salary, to_char(salary, 'L999,999') from employees;

select first_name, hire_date, to_date('20051025','yyyymmdd')
from employees;

--오라클에서 시분초 표시다하기위한 방법
select to_char(to_date('2005-12-31 14:00:05','yyyy-MM-dd hh24:mi:ss'),'yyyy-MM-dd hh24:mi:ss') from dual;

--decode(컬럼명,조건,실행,조건,실행,디폴트)
--case(when 조건 then 실행 else 나머지) end

select sum(salary) from employees;


select count(distinct job_id) from employees;

select department_id ,sum(salary) as 급여합계,floor(avg(salary)) as 평균급여, count(*) as 부서별인원수 , job_id
from employees 
group by department_id, job_id
order by department_id asc;

select department_id,sum(salary) 
from employees
group by department_id
having sum(salary) >= 3000
order by department_id asc;

select job_id, sum(salary) as 급여합계
from employees
where job_id <> 'IT_PROG'
group by job_id
having sum(salary) >=5000
order by job_id asc;

select max(avg(salary))
from employees
group by department_id;

select first_name , salary
from employees
where salary > (select salary from employees where first_name = 'Lex');

select first_name , salary
from employees
where department_id = (select department_id from employees where first_name = 'Lex');

select first_name,job_id,salary
from employees
where salary = (select min(salary) from employees);

select first_name,department_id
from employees
where department_id = (select department_id from employees where first_name = 'Steven' and last_name = 'King');

select first_name, salary, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

select first_name, job_id, (select job_title from jobs where jobs.job_id = employees.job_id) as job_title
from employees;

select first_name, e.job_id, j.job_title
from employees e, jobs j
where e.job_id = j.job_id;

select min(salary), department_id, (
select department_name from departments where departments.department_id = employees.department_id
) department_name
from employees
group by department_id;

select min(salary), e.department_id, d.department_name
from employees e,departments d
where e.department_id = d.department_id
group by e.department_id,d.department_name;

select first_name || ' '||last_name as name, job_id,  salary
from employees
where salary = (select min(salary) from employees);

select (select first_name from employees where salary = ), min(salary)
from employees
group by job_id
having min(salary) = (select min(salary) from employees);

select first_name,e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;


select employee_id,first_name,e.department_id,department_name
from employees e, departments d;

select d.department_id
       ,count(e.salary)
       ,sum(e.salary) as salary_ord
from departments d left outer join employees e on d.department_id = e.department_id
group by d.department_id
order by d.department_id;

select first_name || ' ' || last_name as name,e.department_id , d.department_name
from employees e, departments d
where e.department_id = d.department_id and e.first_name = 'Steven' and e.last_name = 'King';

select first_name , d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where e.first_name = 'Steven' and e.last_name = 'King';

select first_name, d.department_name, l.street_address , l.city
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id;



select first_name, d.department_name, l.street_address , l.city
from employees e inner join  departments d 
on e.department_id = d.department_id inner join locations l
on d.location_id = l.location_id;



select e.first_name , d.department_name, l.city ,e.commission_pct
from employees e left outer join departments d
on e.department_id= d.department_id left outer join employees e2
on e.department_id = e2.department_id and e.employee_id = e2.employee_id , locations l 
where d.location_id = l.location_id and e.commission_pct is not null;


select * from departments;

--사원 이름 a포함된 모든사원 이름 부서명
select e.first_name|| ' ' || e.last_name name, d.department_name
from employees e, departments d
where e.department_id = d.department_id and upper(e.first_name) like '%A%';

select e.first_name|| ' ' || e.last_name name, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id 
where upper(e.first_name) like '%A%';

--us에 근무하는 사원 출력
--오라클 이너조인
select e.first_name, d.department_name, l.country_id
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id and l.country_id = 'US';
--오라클 아우터조인
select e.first_name, d.department_name, l.country_id
from employees e, departments d, locations l
where e.department_id = d.department_id(+) and d.location_id = l.location_id(+) and l.country_id = 'US';
--ANSI 표준 아우터조인
select e.first_name, d.department_name, l.country_id
from employees e left outer join departments d
on e.department_id = d.department_id left outer join  locations l 
on d.location_id = l.location_id 
where l.country_id = 'US';
--ANSI 표준 inner 조인
select e.first_name, d.department_name, l.country_id
from employees e inner join departments d
on e.department_id = d.department_id inner join locations l 
on d.location_id = l.location_id 
where l.country_id = 'US';

select * from employees;

-- 제네바 사는 이름 업무 부서번호 부서명
--오라클 이너조인
select e.first_name, e.job_id , e.department_id, d.department_name, l.city, l.street_address
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id and l.city = 'Seattle';
--오라클 아우터조인
selecte.first_name, e.job_id , e.department_id, d.department_name, l.city, l.street_address
from employees e, departments d, locations l
where e.department_id = d.department_id(+) and d.location_id = l.location_id(+) and l.country_id = 'US';
--ANSI 표준 아우터조인
select e.first_name, e.job_id , e.department_id, d.department_name, l.city, l.street_address
from employees e left outer join departments d
on e.department_id = d.department_id left outer join  locations l 
on d.location_id = l.location_id 
where l.country_id = 'US';
--ANSI 표준 inner 조인
select e.first_name, e.job_id , e.department_id, d.department_name, l.city, l.street_address
from employees e inner join departments d
on e.department_id = d.department_id inner join locations l 
on d.location_id = l.location_id 
where l.city = 'Seattle';
 -- 사원의 부서장이름
 select e1.employee_id, e1.first_name ,e2.employee_id, e2.first_name
 from employees e1, employees e2
 where e2.employee_id = e1.manager_id
 order by e1.employee_id asc;

 select e1.employee_id, e1.first_name ,e2.employee_id as 부서장아이디, e2.first_name as 부서장이름
 from employees e1, employees e2
 where e2.employee_id = e1.manager_id(+) and e1.employee_id is not null
 order by e1.employee_id asc;
 
select *from employees;

create table testMember(
memberNO number not null,
memberId varchar2(50) not null,
memberName varchar2(50) not null,
regiDate date not null
);

create sequence seq_testMember
start with 1
increment by 1
nomaxvalue
nocache; 

alter table testMember
add primary key(memberId);

--카피는 하지만 제약조건은 복사x
create table testDepartments as select *from departments;

-- 제약조건 연결된거 까지 다지우는거 ( 안 쓰는게 좋음)
drop table testDepartments cascade constraints;

select * from tab;



alter table testMember
add unique(memberNo);

create table testEmployees as select * from employees where department_id = 20;

select * from testEmployees;

drop table testEmployees;

create table testEmployees as select * from employees where 1<>1;

select*from testEmployees;

desc testEmployees;


create table testProduct(
    no number not null, --상품번호, 시퀀스사용
    productId varchar2(50) not null,
    vendorId varchar(50) not null,
    productName varchar(50) not null,
    productPrice number not null,
    productDesc clob,
    wDate date default sysdate
);

create sequence seq_testProduct
start with 1
increment by 1
nomaxvalue
nocache;

select*from testProduct;

insert into testProduct(no, productId, vendorId, productName, productprice, productDesc, wDate)
values(seq_testProduct.nextval,'P001','SEC','무풍에어컨', 1400000,'바람없는 에어컨',sysdate);

insert into testProduct(no, productId, vendorId, productName, productprice, productDesc)
values(seq_testProduct.nextval,'P002','LG','창문에어컨', 700000,'창문에 설치하는 에어컨');

insert into testProduct(no, productId, vendorId, productName, productprice, productDesc)
values(seq_testProduct.nextval,'P003','Winia','위니아 에어컨', 1000000,'위니아 에어컨');

alter table testProduct add bigo varchar(50);

select * from testProduct;
--------------------------------------------------------------------------------------------
select constraint_name,table_name from user_constraints;

create table testExample1(
col1 varchar2(50),
col2 varchar2(50) not null
);

create table testExample2(
col1 varchar2(50),
col2 varchar2(50) constraint col2_notNull not null
);

create table testExample3(
col1 varchar2(50) unique,
col2 varchar2(50) unique not null,
col3 varchar2(50) constraint col3_unique unique
);

create table testExample06(
    col1 varchar2(10) not null,
    col2 varchar2(10) not null,
    primary key(col1)
);

create table testExample07(
    col3 varchar2(10) not null,
    col4 varchar2(10) not null,
    col5 varchar2(10) not null,
    primary key(col3),
    foreign key (col5) references testExample06(col1)
);
insert into testExample06 (col1,col2) values('1','11');

insert into testExample07 (col3, col4, col5) values('a','b','1');

--자료형 변경하는 방법
alter table testExample07 modify col3 varchar2(100);
alter table testExample08 modify col4 number;
alter table testExample08 rename column col4 to col6;

create table testExample08(
    col3 varchar2(10) not null,
    col4 varchar2(10) not null,
    col5 varchar2(10) not null,
    primary key(col3),
    foreign key (col5) references testExample06(col1)
);

alter table testExample08
set unused (col5);

alter table testExample08
drop unused columns;

alter table testExample08
set use (col5);

select * from testExample08;

create table test1 as select * from employees where 1<>1;

insert into test1 select*from employees;

truncate table test1;

create view v_employees(사번,사원이름,부서번호,담당업무)
as select employee_id, first_name, department_id, job_id from employees;

create view vv_employees(사번)
as select 사번 from v_employees;

select * from v_employees;

select * from v_employees;

create table t_employees as select* from employees;
create table t_departments as select * from departments;

select * from t_employees natural join t_departments;

create view v_test
as
 select * from t_employees natural join t_departments;
 
 select * from v_test;
 
 --뷰에서 집계함수는 반드시 별칭을 써야함
 create view v_employees_salary02
 as
    select department_id, sum(salary) sum_sal, avg(salary) avg_sal
    from t_employees
    group by department_id;

select * from v_employees_salary02;    

--with check option 을 사용하면 뷰를 통해 업데이트 삽입 가능
--with read only를 사용하면 select만 가능 
--view 생성시 마지막에 붙여서 사용함
select *
from (select rownum a, e.*
from employees e
order by salary asc)
where a = 2;

drop table t_employees;
drop table t_departments;
drop table testmember;
-- ---------------------------------------------------------
--프로시저 : 스토어드프로시저, Stored Procedure
select (select count(*) from employees)+(select count(*) from departments)
from dual;




set serveroutput on;
execute p_counter;






-- 쌍으로 다님 3개가
drop procedure p_counter;

select * from user_source;

create or replace procedure p_counter
as
    var1 int;
    var2 int;
begin
    select count(*) into var1 from employees;
    select count(*) into var2 from departments;
    DBMS_OUTPUT.PUT_LINE(var1 + var2);
end;










