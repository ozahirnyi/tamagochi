--ПОСІБНИК ORACLE SQL DEVELOPER
--2.1_1. Базовий синтаксис SELECT
--SELECT [DISTINCT] список_столбцов 
--FROM источник 
--WHERE фильтр 
--ORDER BY --выражение_сортировки

SELECT employee_id, first_name, last_name, hire_date FROM hr.employees WHERE hire_date > '01.01.2000' ORDER BY last_name;
/

SELECT employee_id, first_name, last_name, hire_date as red FROM hr.employees WHERE hire_date > '01.01.2000' ORDER BY last_name;
/

SELECT q'{ІМ'Я}', last_name as ФАМИЛИЯ,  salary, 'ЗАРПЛАТА', salary*1.2 as GПРТО FROM hr.EMPLOYees ; 

/* особливості застосування оператора */
-- q':

SELECT DISTINCT q'[ІМ'Я]', last_name  FROM employees
/
SELECT 10*13 FROM employees
/
SELECT 10*23 FROM DUAL
/
SELECT first_name ||'  '|| last_name FROM hr.employees
/

SELECT last_name ||' '|| first_name as ФИО,
salary as ОКЛАД, salary-salary*0.13 as "Оклад минус подоходный"
FROM employees WHERE salary>10000;
/

/* ALL -- порівняння буде проводитися з усіма записами, які повертає підзапит
(або просто зі всіма значеннями в наборі). TRUE вернеться тільки в тому випадку, якщо всі записи, які повертає підзапит,
будуть задовольняти вказаним вами умовам. Крім того, в Oracle значення True повертається в ситуації,
коли підзапит не поверне ні одного запису */

select * from hr.employees
where salary <= ALL(SELECT salary FROM hr.employees WHERE job_id = 'SH_CLERK')
/

/* ANY  -- порівняння поверне True, якщо умові буде задовольняти будь-який запис з набору (або підзапиту).
Наприклад, такий запит поверне всіх користувачів, зарплата яких збігається з зарплатою клерка */

select * from hr.employees
where salary = ANY(SELECT salary FROM hr.employees WHERE job_id = 'SH_CLERK')
/

/* SOME -- порівняння поверне True, якщо умові будуть задовольняти деякі записи з набору (або підзапиту)*/

select * from hr.employees
where salary = SOME(SELECT salary FROM hr.employees WHERE job_id = 'SH_CLERK')
/

SELECT first_name ИМЯ, last_name ФАМИЛИЯ, salary ОКЛАД, hire_date "Дата прийома на работу" 
FROM employees WHERE hire_date<=ANY(SELECT hire_date FROM employees WHERE department_id=70)
/


/* Приклад 20 (схема scott)
Показати інформацію про робітників, котрі отримують зарплату більшу,
ніж будь-який робітник відділу 30.
Запит повинен виконати дві дії: знайти заробітні плати 30-го відділу,
а потім вибрати усіх робітників, які отримують більше,
ніж сама мінімальна заробітна плата.
Оскільки найменша заробітна плата у 30-му відділі дорівнює $950,
основний запит повертає усіх робітників, у кого зарплата більше цієї суми.*/
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

SELECT first_name ИМЯ, last_name ФАМИЛИЯ, salary ОКЛАД,
hire_date "Дата прийома на работу" 
FROM employees
WHERE hire_date<=ANY(SELECT hire_date FROM employees WHERE department_id=70)
/

SELECT first_name ИМЯ, last_name ФАМИЛИЯ, salary ОКЛАД,
 COMMISSION_PCT  "СТАВКА_КОМИСИИ"
FROM employees
WHERE salary >10000  AND  NOT COMMISSION_PCT is  NULL
/

SELECT last_name FROM employees
WHERE last_name like  'Ra_%' ;
/

/*  ВИКОРИСТАННЯ USING */

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

--ВИКОРИСТАННЯ ШАБЛОНУ 'X%' , 'X_'....
select salary , job_title
from employees, jobs
where employees.job_id=jobs.job_id
and JOB_title LIKE 'P%'
/
--РЕГУЛЯРНІ ВИРАЗИ REGEXP_LIKE (ВИВЧАЮТЬСЯ ОКРЕМО)
SELECT first_name AS "Имя", last_name As
"Фамилия", PHONE_NUMBER As "Телефон"
FROM hr.employees WHERE NOT REGEXP_LIKE(PHONE_NUMBER, '\d{3}\.\d{3}\.\d{4}')
/

