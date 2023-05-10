REM   Script: Activity4
REM   ALTER and Update statements for 'salesman' table

CREATE TABLE salesman( 
    salesman_id int,  
    salesman_name varchar2(20), 
    salesman_city varchar2(20), 
    commission int 
);

INSERT ALL  
INTO salesman VALUES(5001,'James Hoog','New York',15) 
INTO salesman VALUES(5002,'Nail Knite','Paris',13) 
INTO salesman VALUES(5005,'Pit Alex','London',11) 
INTO salesman VALUES(5006,'McLyon','Paris',14) 
INTO salesman VALUES(5007,'Paul Adam','Rome',13) 
INTO salesman VALUES(5003,'Lauson Hen','San Jose',12) 
SELECT 1 FROM DUAL;

ALTER TABLE salesman 
ADD grade int;

UPDATE salesman 
SET grade=100;

SELECT * from salesman;

