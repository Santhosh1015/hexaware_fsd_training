create database fsd_java;
use fsd_java;

CREATE TABLE employee (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(100),
    branch ENUM('CHENNAI','MUMBAI' , 'PUNE'),
    city VARCHAR(50),
    department ENUM('ADMIN', 'DEV', 'FINANCE')
);
INSERT INTO employee (name, branch, city, department)
VALUES
('John', 'CHENNAI', 'CHENNAI', 'DEV'),
('Hermione Granger', 'MUMBAI', 'MUMBAI', 'FINANCE'),
('Harry Potter', 'PUNE', 'PUNE', 'ADMIN');

select * from employee;
-- create a procedure (CAP) to display all employee records

DELIMITER $$

CREATE PROCEDURE all_emp()
BEGIN
    SELECT * FROM employee;
END
$$

-- CAP to fetch employee names baseed on given department

DELIMITER $$
CREATE PROCEDURE emp_by_department(IN p_dept varchar(255))
BEGIN
	if p_dept = '' then
		signal sqlstate "45000" ## we r telling the db , that i signal you to throw a exception here
        set message_text = 'department name should not be empty';
	end if;
    if not exists (select 1 from employee where department = p_dept) then
		signal sqlstate "45000" ## we r telling the db , that i signal you to throw a exception here
        set message_text = 'invalid input for the procedure';
    end if;
    -- sql
	SELECT name from employee where department= p_dept;
END
$$
DROP procedure emp_by_branch;

CALL all_emp;
CALL emp_by_department('FINANCE');
CALL emp_by_department('ADMIN');
CALL emp_by_department('');
CALL emp_by_department('HR');

-- CAP to update the branch of the employee based on the id
DELIMITER $$
CREATE PROCEDURE update_branch_by_id(IN p_id int , IN p_branch varchar(255))
BEGIN
	-- validate for the ID
	if p_id = '' then
		signal sqlstate "45000"
        set message_text = 'ID should not be empty';
    end if;
    if not exists(select 1 from employee where id = p_id) then
		signal sqlstate "45000" ## we r telling the db , that i signal you to throw a exception here
        set message_text = 'invalid input , PLEASE input valid ID';
    end if;
    -- validate for the branch
    if p_branch is null or p_branch = '' then
		signal sqlstate "45000"
        set message_text = 'branch should not be empty';
    end if;

    if p_branch not in('CHENNAI', 'MUMBAI', 'PUNE') then
		signal sqlstate "45000" ## we r telling the db , that i signal you to throw a exception here
        set message_text = 'invalid input , PLEASE enter valid branch';
    end if;
	-- sql
    update employee set branch = p_branch where id = p_id;
END
$$

drop procedure update_branch_by_id;
call update_branch_by_id('1', 'NEW YORK');

 SELECT * FROM employee;

-- CAP to return the count of the employee in each department
DELIMITER $$
CREATE PROCEDURE count_emp_by_dept(IN p_dept varchar(255) , OUT p_ctn int)
BEGIN
	if p_dept = '' then
		signal sqlstate "45000" ## we r telling the db , that i signal you to throw a exception here
        set message_text = 'department name should not be empty';
	end if;
    if not exists (select 1 from employee where department = p_dept) then
		signal sqlstate "45000" ## we r telling the db , that i signal you to throw a exception here
        set message_text = 'invalid input for the procedure';
    end if;
    -- sql
	SELECT count(id) INTO p_ctn from employee where department= p_dept;
END
$$

call count_emp_by_dept('ADMIN' , @count_emp); ## session variaable @

SELECT @count_emp;

/*
select using procedures
DELIMITER $$
IN param
OUT param
@ session variable and INTO
if condition then end if to use exceptions
*/

## views(hide attributes / coloumns / rows)
create view v_emp as
select id , name , branch , department
from employee
where department not in ('ADMIN');

SELECT * FROM v_emp_dev;
SELECT * FROM employee;

SHOW TABLES;

create view v_emp_dev as
select *
from employee
where department = 'DEV'
WITH CHECK OPTION; 
-- WITH CHECK OPTION blocks any INSERT/UPDATE via this view that
-- would result in a row no longer matching department = 'DEV'

update v_emp-dev
set department = 'FINANCE'
where id = 1;

drop view v_emp_dev;

-- Triggers case study : Ecom project

create table product(
 id int primary key auto_increment,
 title varchar(255),
 price double,
 stock_qty int
);

create table orders
(
	order_id int primary key auto_increment,
    product_id int,
    order_qty int,
    foreign key (product_id) references product(id)
);
INSERT INTO product (title, price, stock_qty) VALUES ('Some headphones', 540, 3);
INSERT INTO product (title, price, stock_qty) VALUES ('Some laptop', 45540, 1);

DELIMITER $$
CREATE TRIGGER trg_chech_stock_qty
BEFORE INSERT ON orders
FOR EACH ROW
BEGIN
	declare v_stock_qty int;
    if not exists(select 1 from product where id = new.product_id) then
		signal sqlstate "45000"
        set message_text = "product id invalid";
	end if;
    
	select stock_qty into v_stock_qty
    from product
    where id = NEW.product_id;
    
    if v_stock_qty < new.order_qty then
		signal sqlstate "45000"
        set message_text = "Stock not available";
	end if;
END
$$
DELIMITER $$
CREATE TRIGGER trg_update_stock_qty
AFTER INSERT ON orders
FOR EACH ROW
BEGIN
	update product
    set stock_qty = stock_qty - new.order_qty
    where id = new.product_id;
END
$$
 insert into orders (product_id , order_qty) values (1 , 3);
select * from orders;