declare
num int:=&num;
res int;
function fact(num IN int) 
return int
AS
f int;
begin
f:=1;
for i in 1..num loop
  f:=f*i;
end loop;
return f;
end fact;
begin
dbms_output.put_line('FINDING FACTORIAL OF:'||num);
res:=fact(num);
dbms_output.put_line('FACTORIAL IS:'||res);
end;
/

create table empl11(eno number(10),basic number(8,2),hra number(8,2),da number(8,2),tot_deduction number(8,2),netsal number(8,2),grosssal number(8,2));
insert into empl11(eno,basic,hra,da,tot_deduction) values(3,20000,8000,2000,3000);

Declare
no number;
totsal1 number:=0;
gross number;
cursor ec(n number)is select * from empl11 where eno<=n;
rw ec%rowtype;
begin
no:=&no;
open ec(no);
loop
fetch ec into rw;
exit when ec%notfound;
totsal1:=rw.basic+rw.hra+rw.da;
gross:=totsal1-rw.tot_deduction;
update empl11 set netsal=totsal1 where eno=no;
update empl11 set grosssal=gross where eno=no;
end loop;
dbms_output.put_line('total salary of'||no||'employee is'||totsal1);
dbms_output.put_line('total salary of'||no||'employee is'||gross);
end;
/


create table empswa(eno number(10),ename varchar2(20),designation varchar2(20), dno number(5),salary number(8,2));
insert into empswa values(&eno,'&ename','&designation',&dno,&salary);

declare
cursor cur is select * from empswa;
details empswa%rowtype;
begin
open cur;
loop
fetch cur into details;
exit when cur%notfound;
end loop;
dbms_output.put_line('the no of records in employee table are'||cur%rowcount);
end;
/
