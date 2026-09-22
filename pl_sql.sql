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

