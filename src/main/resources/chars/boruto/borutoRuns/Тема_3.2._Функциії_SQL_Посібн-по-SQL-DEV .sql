--3.1. ������ �� ��������� ����ֲ���
--UPPER(), CONCAT(), SUBSTR() 
/*3101. ��� ������� ���� �������� ��� ������� ����������� �������������,
���� ������� ��������� �� 3 ������ ������� ���� ���� ���� ������ ������� ��'�.
�� ������� ����� �������������� ������ ���� ����������� � ��������� ������.
�������� �����, ���� ������� � ������� hr.employees ���������� ��� ��'� �� �������
�����������, � ����� ������������� ����������� �������� �� ����������� ����*/
SELECT first_name "��'�", last_name �в�����,
UPPER(CONCAT(SUBSTR(first_name,1,3),
SUBSTR (last_name,1,2))) AS "������Բ��op"
FROM employees
/
--3101�. ��.7
SELECT empno, ename, deptno FROM emp WHERE
LOWER(ename) = 'blake';
--311�. ��.9
SELECT ename, CONCAT(ename, job),
LENGTH(ename),INSTR(ename, 'A')
FROM emp
WHERE SUBSTR(job,1,5) = 'SALES';

--3.4. �����² ����ֲ� ROUND TRUNC MOD
--3401.ROUND
SELECT
ROUND(45.923,2) a1,  -- ���. 45.92
ROUND(45.923,0) b2,  -- ���. 46	
ROUND(45.923,-1) c3  -- ���. 50
FROM DUAL;
--3402. TRUNC
SELECT 
TRUNC(45.923,2) a,  -- ���. 45.92
TRUNC(45.923) b,    -- ���. 45
TRUNC(45.923,-1) c  -- ���. 40 (������� �� �������, ���� -2, �� ������)
FROM DUAL;
--3403.MOD
SELECT ename, sal, comm, 
MOD(sal , comm ) 
FROM EMP
WHERE job='SALESMAN';
--3404.MOD. ������� �� ������ 
SELECT MOD(1600,300) FROM DUAL; --���. 100

--3.5.����ֲ� ������ � ������
-- 3501. ������� ������� ����, ��������� NLS, ���������� ��������� NLS
SELECT SYSDATE FROM DUAL;
SELECT PARAMETER, VALUE FROM v$nls_parameters where parameter='NLS_DATE_FORMAT'; -- ������� ��������� ��������� NLS
ALTER SESSION SET nls_date_format='DD-MON-yyYY'; -- ��������� ������� ���� NLS

--3502. ��������� �����  ������ �� ������(� ����������� �� 4-� �����)
SELECT ROUND(MONTHS_BETWEEN('02-NOV-2019','01-NOV-1999'),4)
"������ ̲��ֲ�" FROM DUAL; -- ��������� 240,0323

--3503.��������� ����������� ������ �� ����
SELECT  ADD_MONTHS ('11-JAN-2019',6)
FROM DUAL;  -- ��������� 11-JUL-2019

--3504. ��������� ����, ���� ��������� ������� ���� �����
SELECT NEXT_DAY('01-NOV-2019','FRIDAY')	-- ��� 5 ��� 'FRIDAY'
FROM DUAL;  --  ��������� 08-NOV-2019

--3505. �c����� ���� �����, �� ���� ������� � ����� ����
SELECT LAST_DAY('01-NOV-2019') FROM DUAL; -- ���. 30-NOV-2019

--3506. ���������� ���� ��  �������� ������� (� ������� �� �����)
SELECT ROUND(TO_DATE('25-NOV-2019'),'MONTH')  FROM DUAL; -- ���. 01-DEC-2019
--3507. ���������� ���� �� ����
SELECT ROUND(TO_DATE('25-JUL-2019'),'YEAR') FROM DUAL;   -- ���. 01-JAN-2020
--3508. ������� ���� �� ������� ��������� � ����� ( � ������� �� �����)
SELECT TRUNC(TO_DATE('25-NOV-2019'),'MONTH') FROM DUAL; -- ���. 01-NOV-2019
--3509.������� ���� �� ������� ��������� � ����� ( � ������� �� ����)
SELECT TRUNC(TO_DATE('25-JUL-2019'),'YEAR') FROM DUAL;	 -- ���. 01-JAN-2019
--3510
SELECT TRUNC(TO_DATE(SYSDATE), 'MONTH') AS RESULT FROM DUAL;
/
-- 3511 ������� ���� ����� SCOTT 
SELECT ename, (SYSDATE-hiredate)/7 WEEKS
FROM EMP
WHERE deptno=10;

/*��.3.2.
3512.�������� �����, ���� �������� ���������� ��� ����� �� ������� �����������
� ������� hr.employees, � ����� ��� ���� ������� ������� ����������� �� ������
� ������� ������ ������, �� ����� ���������� ���������� �� ����� ����
(����� ��� ����������� �� ����� ������ ����'�����)*/
SELECT first_name AS "���", last_name As "�������",
Salary AS "�����", HIRE_DATE As "���� ������� �� ������",
TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "³����������� ������"
FROM hr.employees;
/
--3513
SELECT CHR(82) FROM DUAL;
/

--3.6. ����ֲ� ������������  TO_CHAR  TO_NUMBER  TO_DATE
--  TO_CHAR
/*��3.3. C�.86-93.
3601. ��������� ����������� ���������� � ������� ������� Oracle �
���������� � ���������� �� ��������� ���������� ��������� �����,
���� ������� �� �� / ����� / �����, ���������,2008/02/20. �������� �����,
���� �������� �� ������� hr.employees ���������� ��� ��'�. ������� �� ���� �������
�� ������ ����������� �������� �� ��������� �������. � ����� ����� ������
���������� �, ��� ��� ��������� ������ �����. ���.3.3-1.*/
 SELECT first_name AS "��'�", last_name As "�������",
 TO_CHAR(HIRE_DATE, 'year-MONTH-dd') As "���� ������� �� ������"
 FROM hr.employees ORDER BY HIRE_DATE DESC
/

/*��. 91.
3602.*/
SELECT first_name AS "���", last_name As "�������",
TO_CHAR(SALARY, '999999999.99L') As "�����"
FROM hr.employees ORDER BY SALARY DESC
/
--3603.
SELECT first_name AS "���", last_name As "�������",
TO_CHAR(HIRE_DATE, 'DD-MM-YYYY') As "�����"
FROM hr.employees ORDER BY SALARY DESC
/
--3603.
SELECT  TO_CHAR(salary, '99,999.99') SALARY_
FROM employees WHERE last_name LIKE 'A%'
/

--NVL. ���������� ����������� �������� � �����
/*��. 3.5 
�������� �����, ���� �������� ���������� ��� ��'� �� ������� ����������
� ������� hr.employees � ����� ������ ���� (������� COMMISSION_PCT ��� �����������.
��� ����� ��� ��� �����������, ��� ���� ����� �� ���������, ��������� �������
�������� 0 */
--3604.
SELECT last_name , COMMISSION_PCT, NVL(COMMISSION_PCT,0) AS "������ ��̲Ѳ�"
FROM employees
/
/*DECODE ��. 95 */
--3605.
SELECT first_name AS "���", last_name As "�������",
DECODE(JOB_ID, 'SA_REP', '�������� �������������', 'SA_MAN', '�������� �� ��������', '������' )
AS "���������" FROM hr.employees
/

-- ������Ͳ ����ֲ� 
--����  ���� ����� ������� ������ 6 ������ � ���� �����������
SELECT	TO_CHAR(NEXT_DAY(ADD_MONTHS(hire_date, 6),'FRIDAY'),
'fmDay, Month ddth, YYYY') 	"Next 6 Month Review"
FROM employees
ORDER BY hire_date;



--�h 4.1 ��������� �������� �'�������
/*������� �����, ���� �� �������� ���������� � ������� employees � jobs ����� hr.
��� ����� ������� ����������� ����������:
� ��� ��'� ����������� (������� employees);
� ��� ������� ����������� (������� employees);
� ��� ������ �� ������������ �������� ����� ��� ���� ������ (� ������� jobs)
� �������� ��������� ������ (� ������� employees).
��� ����� �����������, ��� ���� ���� ������ �����������,
������ ���������� �������.
*/
SELECT first_name AS "���", last_name As "�������", Job_Title
As "���������", (max_salary - salary) AS "������� � ������������"
FROM hr.employees, hr.jobs WHERE (hr.employees.job_id = hr.jobs.JOB_ID)
ORDER BY "������� � ������������" DESC
/
/*�� 4.2 �'������� ������ �� ���� �������
�������� �����, ���� �������� �� ���������� � ������� employees � countries ����� hr.
��� ����� ��� ������� ����������� ������� ����������� ����������:
� ��� ��'� ����������� (������� employees);
� ��� ������� ����������� (������� employees);
� ��� �����, � ��� �� ����������� (������� countries).
�������������, �� � ��������� ��������� ������ ������ �� �������� ���������� �������
(�� ����������� ������ 106 ������).
��� ��������� ����� ������ ��������� ��������� ������������� ��'���� �� ���������
� ���� hr, ��������������, ���������, ������ Oracle SQL Developer */

select employees.first_name As "��'�", employees.last_name As "�������",
countries.country_name As "�����"
from hr.employees, hr.departments, hr.locations, hr.countries
where hr.departments.department_id = hr.employees.department_id
and hr.locations.location_id = hr.departments.location_id
and hr.countries.country_id = hr.locations.country_id;
/

/*��. 4.3 �� ���-�������
�������� ����� �� ����� ���������� � �������
employees � jobs ����� hr.
��� ����� ������� ����������� ����������:
� ��� ��'� ����������� (������� employees);
� ��� ������� ����������� (������� employees);
� ��� ���� �������� ����� (�������� salary � ������� employees);
� ��� �������� �������� ����� ��� ���� ������
(�������� min_salary � ������� jobs).
��� ����� ���������� ������� ����������� ����� ��� ��� �����������,
��� �������� ����� ����������� �� ��������
��� ���� ������ �� ����� �� �� 20 �������
(��� ��������: �� ����������� 38 ������) */
select e.last_name, e.salary, j.min_salary
from employees e, jobs j --, --departments d
--departments d
WHERE j.job_id = e.job_id
--e.employee_id = d.department_id
--AND
--j.job_id = e.job_id
AND e.salary <= j.min_salary*1.2
/

select employees.first_name As "���", employees.last_name
As "�������", employees.salary
As "�����", jobs.min_salary As "����������� �����"
FROM hr.employees, hr.jobs
WHERE hr.employees.job_id = hr.jobs.job_id
AND hr.employees.salary <= hr.jobs.min_salary*1.2
/

/*��. 4.4 ������ ��������  OUTER, FULL, LEFT, RIGHT */
--���Ͳ�ͪ �'�������
select departments.department_name
AS "�����", employees.first_name As "���",
employees.last_name As "�������"
FROM hr.employees, hr.departments
WHERE employees.department_id  = departments.department_id (+)
ORDER BY "�����"
/

select e.salary, j.job_id
FROM employees e
--FULL
--LEFT
--RIGHT
--OUTER
JOIN JOB_HISTORY j
ON e.employee_id=j.employee_id
/


Select e.last_name,
  (CASE extract (year from e.hire_date)
	WHEN 1996 THEN '5 years of service'
	WHEN 1991 THEN '10  years of service'
	WHEN 1986 THEN '15 years of service'
		ELSE    '     may be next year!'
	END) as "Awards for 2004"
From employees e;
/
--##########PL_SQL################################

/*����������� ������ 12.1
������ �� �������
�������������� ��������� PL/SQL, ������� ������� �� ������� ������ ��� ������ �����������,
���������� �� ��������� ������������ (���. �����) ����� �����, ���:
� ��� ��������� ������� ����������������� ����;
� ������ ������������� �������� �� ��������� ��������� ����;
� ���������� ��� ������ ����������� ���� ��������  ����� ���� ���;
� ����������� �������� ����������.
����������� ���������� ��� ��������� ������� hr.employees ����� �� ��������� �������
DESCRIBE ��� ���������� �������� Oracle SQL Developer.
*/
--��������� �����������
insert into hr.employees values(employees_seq.nextval,
'&���_����������', '&�������_����������', '&�����_�����������_�����',
'&�����_��������' ,sysdate, '&���������_����������', (SELECT MIN(SALARY)
from hr.employees where job_id='&���������_����������'), null, null, null)
/

select * from employees
--WHERE last_name='�������';

--г�����
/
DECLAREsFirstName varchar2(20) := '&���_����������';
LastName varchar2(25) := '&�������_����������';
sEmail  varchar2(25) := '&�����_�����������_�����';
sPhoneNumber varchar2(20) := '&�����_��������';
sJobId varchar2(10) := '&���������_����������';
BEGIN
insert into hr.employees values(employees_seq.nextval, sFirstName, sLastName, sEmail,
sPhoneNumber, sysdate, sJobId, (SELECT MIN(SALARY)
from hr.employees
where job_id=sJobId), null,null, null);
commit;
END;
/

