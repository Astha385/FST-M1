REM   Script: Activity5
REM   More UPDATE statements for 'salesman' table

UPDATE salesman 
SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman 
SET salesman_name='Pierre' WHERE salesman_name='McLyon';

UPDATE salesman 
SET grade=300 WHERE salesman_name='James Hoog';

SELECT * FROM salesman;

