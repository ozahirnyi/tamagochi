--��Ѳ���� ORACLE SQL DEVELOPER
--2.1_1. ������� ��������� SELECT
--SELECT [DISTINCT] ������_�������� 
--FROM �������� 
--WHERE ������ 
--ORDER BY --���������_����������

SELECT employee_id, first_name, last_name, hire_date FROM hr.employees WHERE hire_date > '01.01.2000' ORDER BY last_name;
/

SELECT employee_id, first_name, last_name, hire_date as red FROM hr.employees WHERE hire_date > '01.01.2000' ORDER BY last_name;
/

SELECT q'{��'�}', last_name as �������,  salary, '��������', salary*1.2 as G���� FROM hr.EMPLOYees ; 

/* ���������� ������������ ��������� */
-- q':

SELECT DISTINCT q'[��'�]', last_name  FROM employees
/
SELECT 10*13 FROM employees
/
SELECT 10*23 FROM DUAL
/
SELECT first_name ||'  '|| last_name FROM hr.employees
/

SELECT last_name ||' '|| first_name as ���,
salary as �����, salary-salary*0.13 as "����� ����� ����������"
FROM employees WHERE salary>10000;
/

/* ALL -- ��������� ���� ����������� � ���� ��������, �� ������� �������
(��� ������ � ���� ���������� � �����). TRUE ��������� ����� � ���� �������, ���� �� ������, �� ������� �������,
������ ������������ �������� ���� ������. ��� ����, � Oracle �������� True ����������� � ��������,
���� ������� �� ������� � ������ ������ */

select * from hr.employees
where salary <= ALL(SELECT salary FROM hr.employees WHERE job_id = 'SH_CLERK')
/

/* ANY  -- ��������� ������� True, ���� ���� ���� ������������ ����-���� ����� � ������ (��� ��������).
���������, ����� ����� ������� ��� ������������, �������� ���� �������� � ��������� ������ */

select * from hr.employees
where salary = ANY(SELECT salary FROM hr.employees WHERE job_id = 'SH_CLERK')
/

/* SOME -- ��������� ������� True, ���� ���� ������ ������������ ���� ������ � ������ (��� ��������)*/

select * from hr.employees
where salary = SOME(SELECT salary FROM hr.employees WHERE job_id = 'SH_CLERK')
/

SELECT first_name ���, last_name �������, salary �����, hire_date "���� ������� �� ������" 
FROM employees WHERE hire_date<=ANY(SELECT hire_date FROM employees WHERE department_id=70)
/


/* ������� 20 (����� scott)
�������� ���������� ��� ��������, ���� ��������� �������� �����,
�� ����-���� ������� ����� 30.
����� ������� �������� �� 䳿: ������ ������� ����� 30-�� �����,
� ���� ������� ��� ��������, �� ��������� �����,
�� ���� �������� �������� �����.
������� �������� �������� ����� � 30-�� ���� ������� $950,
�������� ����� ������� ��� ��������, � ���� �������� ����� ���� ����.*/
SELECT sal, job, ename, deptno
      FROM emp
    WHERE sal> any
              (SELECT sal
                 FROM emp
                 WHERE deptno = 30)
                 ORDER BY sal desc
/

SELECT * FROM hr.employees WHERE NOT department_id = 110
/

SELECT * FROM locations WHERE  postal_code is NOT NULL
/

SELECT order_num, stock_num, manu_code, total_price
      FROM items
     WHERE total_price < ALL
           (SELECT total_price
              FROM  items
            WHERE order_num = 1023 )
/

SELECT first_name ���, last_name �������, salary �����,
hire_date "���� ������� �� ������" 
FROM employees
WHERE hire_date<=ANY(SELECT hire_date FROM employees WHERE department_id=70)
/

SELECT first_name ���, last_name �������, salary �����,
 COMMISSION_PCT  "������_�������"
FROM employees
WHERE salary >10000  AND  NOT COMMISSION_PCT is  NULL
/

SELECT last_name FROM employees
WHERE last_name like  'Ra_%' ;
/

/*  ������������ USING */

SELECT first_name, last_name, job_title
FROM employees 
   JOIN departments USING (department_id)
   JOIN JOBS USING   (JOB_ID)
   WHERE JOB_TITLE LIKE 'Ad%' OR first_name  LIKE '%t%'
/


SELECT job_title, salary,  END_DATE
FROM JOBS
JOIN employees USING (job_id)
JOIN JOB_HISTORY USING (job_id)
WHERE job_title LIKE  'A%'
/

SELECT salary,last_name , job_id
FROM EMPLOYEES WHERE job_id LIKE 'A%'
AND job_id LIKE '%MGR%'
/

--������������ ������� 'X%' , 'X_'....
select salary , job_title
from employees, jobs
where employees.job_id=jobs.job_id
and JOB_title LIKE 'P%'
/
--�������Ͳ ������ REGEXP_LIKE (���������� ������)
SELECT first_name AS "���", last_name As
"�������", PHONE_NUMBER As "�������"
FROM hr.employees WHERE NOT REGEXP_LIKE(PHONE_NUMBER, '\d{3}\.\d{3}\.\d{4}')
/

