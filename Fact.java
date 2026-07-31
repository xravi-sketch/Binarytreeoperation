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
