--3.1. РОБОТА ІЗ РЯДКОВИМИ ФУНКЦІЯМИ
--UPPER(), CONCAT(), SUBSTR() 
/*3101. Вам потрібно було створити для кожного співробітника ідентифікатор,
який повинен виглядати як 3 перших символів імені плюс двох перших символів сім'ї.
Всі символи цього ідентифікатора повинні бути представлені у верхньому регістрі.
Напишіть запит, який повертає з таблиці hr.employees інформацію про ім'я та прізвище
співробітника, а також ідентифікатор співробітника відповідно до поставлених умов*/
SELECT first_name "ІМ'Я", last_name ПРІЗВИще,
UPPER(CONCAT(SUBSTR(first_name,1,3),
SUBSTR (last_name,1,2))) AS "ІДЕНТИФІКАop"
FROM employees
/
--3101а. Сл.7
SELECT empno, ename, deptno FROM emp WHERE
LOWER(ename) = 'blake';
--311б. Сл.9
SELECT ename, CONCAT(ename, job),
LENGTH(ename),INSTR(ename, 'A')
FROM emp
WHERE SUBSTR(job,1,5) = 'SALES';

--3.4. ЧИСЛОВІ ФУНКЦІЇ ROUND TRUNC MOD
--3401.ROUND
SELECT
ROUND(45.923,2) a1,  -- рез. 45.92
ROUND(45.923,0) b2,  -- рез. 46	
ROUND(45.923,-1) c3  -- рез. 50
FROM DUAL;
--3402. TRUNC
SELECT 
TRUNC(45.923,2) a,  -- рез. 45.92
TRUNC(45.923) b,    -- рез. 45
TRUNC(45.923,-1) c  -- рез. 40 (усікання до десятків, якщо -2, до сотень)
FROM DUAL;
--3403.MOD
SELECT ename, sal, comm, 
MOD(sal , comm ) 
FROM EMP
WHERE job='SALESMAN';
--3404.MOD. Остаток від ділення 
SELECT MOD(1600,300) FROM DUAL; --рез. 100

--3.5.ФУНКЦІЇ РОБОТИ З ДАТАМИ
-- 3501. Прогляд поточної дати, параметра NLS, уставновка параметра NLS
SELECT SYSDATE FROM DUAL;
SELECT PARAMETER, VALUE FROM v$nls_parameters where parameter='NLS_DATE_FORMAT'; -- прогляд установки параметра NLS
ALTER SESSION SET nls_date_format='DD-MON-yyYY'; -- установка формата даты NLS

--3502. Визначити число  місяців між датами(з округленням до 4-х знаків)
SELECT ROUND(MONTHS_BETWEEN('02-NOV-2019','01-NOV-1999'),4)
"ВСЬОГО МІСЯЦІВ" FROM DUAL; -- Результат 240,0323

--3503.Додавання календарних місяців до дати
SELECT  ADD_MONTHS ('11-JAN-2019',6)
FROM DUAL;  -- результат 11-JUL-2019

--3504. Найближча дата, коли наступить заданий день тижня
SELECT NEXT_DAY('01-NOV-2019','FRIDAY')	-- або 5 або 'FRIDAY'
FROM DUAL;  --  результат 08-NOV-2019

--3505. Оcтання дата місяця, що вміщує вказану у запиті дату
SELECT LAST_DAY('01-NOV-2019') FROM DUAL; -- рез. 30-NOV-2019

--3506. Округлення дати до  заданого формату (у прикладі до місяця)
SELECT ROUND(TO_DATE('25-NOV-2019'),'MONTH')  FROM DUAL; -- рез. 01-DEC-2019
--3507. Округлення дати до року
SELECT ROUND(TO_DATE('25-JUL-2019'),'YEAR') FROM DUAL;   -- рез. 01-JAN-2020
--3508. Усікання дати до формату указаного у запиті ( у прикладі до місяця)
SELECT TRUNC(TO_DATE('25-NOV-2019'),'MONTH') FROM DUAL; -- рез. 01-NOV-2019
--3509.Усікання дати до формату указаного у запиті ( у прикладі до року)
SELECT TRUNC(TO_DATE('25-JUL-2019'),'YEAR') FROM DUAL;	 -- рез. 01-JAN-2019
--3510
SELECT TRUNC(TO_DATE(SYSDATE), 'MONTH') AS RESULT FROM DUAL;
/
-- 3511 Приклад длдя схеми SCOTT 
SELECT ename, (SYSDATE-hiredate)/7 WEEKS
FROM EMP
WHERE deptno=10;

/*ЛР.3.2.
3512.Напишіть запит, який міститиме інформацію про імена та прізвища співробітників
з таблиці hr.employees, а також про дату прийому кожного співробітника на роботу
і кількість повних місяців, які кожен співробітник відпрацював до цього часу
(даний час визначається по часам вашого комп'ютера)*/
SELECT first_name AS "Имя", last_name As "Фамилия",
Salary AS "Оклад", HIRE_DATE As "Дата прийому на работу",
TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "Відпрацьовано місяців"
FROM hr.employees;
/
--3513
SELECT CHR(82) FROM DUAL;
/

--3.6. ФУНКЦІЇ ПЕРЕТВОРЕННЯ  TO_CHAR  TO_NUMBER  TO_DATE
--  TO_CHAR
/*ЛР3.3. CЛ.86-93.
3601. Необхідно представити інформацію з таблиць сервера Oracle у
відповідності з прийнятими на підприємстві стандартом виведення даних,
який виглядає як рік / місяць / число, наприклад,2008/02/20. Напишіть запит,
який виводить із таблиці hr.employees інформацію про ім'я. прізвища та дату прийому
на роботу співробітників відповідно до описаного формату. В першу чергу повинні
виводитися ті, хто був прийнятий роботу пізніше. Лаб.3.3-1.*/
 SELECT first_name AS "Ім'я", last_name As "Прізвище",
 TO_CHAR(HIRE_DATE, 'year-MONTH-dd') As "Дата прийому на работу"
 FROM hr.employees ORDER BY HIRE_DATE DESC
/

/*сл. 91.
3602.*/
SELECT first_name AS "Имя", last_name As "Фамилия",
TO_CHAR(SALARY, '999999999.99L') As "Оклад"
FROM hr.employees ORDER BY SALARY DESC
/
--3603.
SELECT first_name AS "Имя", last_name As "Фамилия",
TO_CHAR(HIRE_DATE, 'DD-MM-YYYY') As "Оклад"
FROM hr.employees ORDER BY SALARY DESC
/
--3603.
SELECT  TO_CHAR(salary, '99,999.99') SALARY_
FROM employees WHERE last_name LIKE 'A%'
/

--NVL. Перетворює невизначене значення в дійсне
/*ЛР. 3.5 
Напишіть запит, який виводить інформацію про ім'я та прізвище працівників
з таблиць hr.employees а також ставку комісії (колонка COMMISSION_PCT для співробітника.
При цьому для тих співробітників, для яких комісія не визначена, необхідно вивести
значення 0 */
--3604.
SELECT last_name , COMMISSION_PCT, NVL(COMMISSION_PCT,0) AS "СТАВКА КОМІСІЇ"
FROM employees
/
/*DECODE сл. 95 */
--3605.
SELECT first_name AS "Имя", last_name As "Фамилия",
DECODE(JOB_ID, 'SA_REP', 'Торговый представитель', 'SA_MAN', 'Менеджер по продажам', 'Другое' )
AS "Должность" FROM hr.employees
/

-- ВКЛАДЕНІ ФУНКЦІЇ 
--Вивід  дати першої пятниці чеерез 6 місяців з дати влаштування
SELECT	TO_CHAR(NEXT_DAY(ADD_MONTHS(hire_date, 6),'FRIDAY'),
'fmDay, Month ddth, YYYY') 	"Next 6 Month Review"
FROM employees
ORDER BY hire_date;



--Лh 4.1 Створення простого з'єднання
/*Створіть запит, який би повертав інформацію з таблиць employees і jobs схеми hr.
При цьому повинна повертатися інформація:
• про ім'я співробітника (таблиця employees);
• про прізвища співробітника (таблиця employees);
• про різницю між максимальною заробітної плати для даної посади (з таблиці jobs)
і реальною заробітною платою (з таблиці employees).
При цьому співробітники, для яких така різниця максимальна,
повинні виводитися першими.
*/
SELECT first_name AS "Имя", last_name As "Фамилия", Job_Title
As "Должность", (max_salary - salary) AS "Разница с максимальной"
FROM hr.employees, hr.jobs WHERE (hr.employees.job_id = hr.jobs.JOB_ID)
ORDER BY "Разница с максимальной" DESC
/
/*Лр 4.2 З'єднання больше ніж двох таблиць
Напишіть запит, який повертав би інформацію з таблиць employees і countries схеми hr.
При цьому для кожного співробітника повинна повертатися інформація:
• про ім'я співробітника (таблиця employees);
• про прізвища співробітника (таблиця employees);
• про країну, в якій він знаходиться (таблиця countries).
Переконайтеся, що в результаті виконання вашого запиту не виходить декартовий добуток
(має повернутися всього 106 записів).
Для написання цього запиту необхідно самостійно проаналізувати зв'язки між таблицями
в схемі hr, використовуючи, наприклад, засоби Oracle SQL Developer */

select employees.first_name As "Ім'я", employees.last_name As "Прізвище",
countries.country_name As "Країна"
from hr.employees, hr.departments, hr.locations, hr.countries
where hr.departments.department_id = hr.employees.department_id
and hr.locations.location_id = hr.departments.location_id
and hr.countries.country_id = hr.locations.country_id;
/

/*Лр. 4.3 Не екві-зєднання
Напишіть запит на основі інформації з таблиць
employees і jobs схеми hr.
При цьому повинна повертатися інформація:
• про ім'я співробітника (таблиця employees);
• про прізвища співробітника (таблиця employees);
• про його заробітну плату (стовпець salary в таблиці employees);
• про мінімальну заробітну плату для його посади
(стовпець min_salary в таблиці jobs).
При цьому інформація повинна повертатися тільки для тих співробітників,
чия заробітна плата відрізняється від мінімальної
для даної посади не більше ніж на 20 відсотків
(для перевірки: має повернутися 38 записів) */
select e.last_name, e.salary, j.min_salary
from employees e, jobs j --, --departments d
--departments d
WHERE j.job_id = e.job_id
--e.employee_id = d.department_id
--AND
--j.job_id = e.job_id
AND e.salary <= j.min_salary*1.2
/

select employees.first_name As "Имя", employees.last_name
As "Фамилия", employees.salary
As "Оклад", jobs.min_salary As "Минимальный оклад"
FROM hr.employees, hr.jobs
WHERE hr.employees.job_id = hr.jobs.job_id
AND hr.employees.salary <= hr.jobs.min_salary*1.2
/

/*Лр. 4.4 Зовнішні обєднання  OUTER, FULL, LEFT, RIGHT */
--ЗОВНІШНЄ З'ЄДНАННЯ
select departments.department_name
AS "Отдел", employees.first_name As "Имя",
employees.last_name As "Фамилия"
FROM hr.employees, hr.departments
WHERE employees.department_id  = departments.department_id (+)
ORDER BY "Отдел"
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

/*Лабораторна робота 12.1
Работа із змінними
Використовуючи можливості PL/SQL, змінюйте команду на вставку запису для нового співробітника,
створеного на попередніх лабораторних (див. Нижче) таким чином, щоб:
• для додаваннЯ значень використовувалися змінні;
• змінним присвоювалися значення за допомогою діалогових вікон;
• інформація про посаду співробітника була запитана  тільки один раз;
• проводилася фіксація транзакції.
Переглянути інформацію про структуру таблиці hr.employees можна за допомогою команди
DESCRIBE або графічними засобами Oracle SQL Developer.
*/
--Попередня лабораторна
insert into hr.employees values(employees_seq.nextval,
'&Имя_сотрудника', '&Фамилия_сотрудника', '&Адрес_электронной_почты',
'&Номер_телефона' ,sysdate, '&Должность_сотрудника', (SELECT MIN(SALARY)
from hr.employees where job_id='&Должность_сотрудника'), null, null, null)
/

select * from employees
--WHERE last_name='Смирнов';

--Рішення
/
DECLAREsFirstName varchar2(20) := '&Имя_сотрудника';
LastName varchar2(25) := '&Фамилия_сотрудника';
sEmail  varchar2(25) := '&Адрес_электронной_почты';
sPhoneNumber varchar2(20) := '&Номер_телефона';
sJobId varchar2(10) := '&Должность_сотрудника';
BEGIN
insert into hr.employees values(employees_seq.nextval, sFirstName, sLastName, sEmail,
sPhoneNumber, sysdate, sJobId, (SELECT MIN(SALARY)
from hr.employees
where job_id=sJobId), null,null, null);
commit;
END;
/

