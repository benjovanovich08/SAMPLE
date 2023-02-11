INSERT INTO employees
set first_name='Joe',last_name='Burrow',salary=120000,department_id=103;

select * from employees;

INSERT INTO products
set price=1100.00,product_desc='Advanced compatibility software package';

INSERT INTO departments
set department_id=104,dept_name='Manufacturing',dept_description='Manufacturing department';

INSERT INTO sales_records
set sale_id=2001,product_num=1001,sale_total=2750;

UPDATE employees set department_id=102
where id=9;

SELECT * from employees e
join sales_records sr on e.id = sr.sales_num;

