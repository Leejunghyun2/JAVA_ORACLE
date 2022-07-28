alter user hr account unlock;
alter user hr identified by 1234;
commit;

select * from hr_tables;