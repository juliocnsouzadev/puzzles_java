/*
Query the list of CITY names ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain duplicates.
 */
 SELECT DISTINCT CITY FROM STATION 
 WHERE 
 SUBSTRING(CITY,LENGTH(CITY),1) IN('a','e','i','o','u')

 /*
 Query the list of CITY names from STATION which have vowels (i.e., a, e, i, o, and u) 
 as both their first and last characters. Your result cannot contain duplicates.
 */
SELECT DISTINCT CITY FROM STATION 
WHERE 
SUBSTRING(CITY,1,1) IN('a','e','i','o','u')
AND
SUBSTRING(CITY,LENGTH(CITY),1) IN('a','e','i','o','u')

/*
Query the list of CITY names from STATION that do not start with vowels. 
Your result cannot contain duplicates.
*/
SELECT DISTINCT CITY FROM STATION 
WHERE 
SUBSTRING(CITY,1,1) NOT IN('a','e','i','o','u')

/*
Query the list of CITY names from STATION that do not end with vowels. 
Your result cannot contain duplicates.
*/
SELECT DISTINCT CITY FROM STATION
WHERE
SUBSTRING(CITY, LENGTH(CITY), 1) NOT IN('a','e','i','o','u')

/*
Query the list of CITY names from STATION that either do not start 
with vowels or do not end with vowels. Your result cannot contain duplicates.
*/
SELECT DISTINCT CITY FROM STATION
WHERE 
SUBSTRING(CITY, 1, 1) NOT IN ('a','e','i','o','u')
OR
SUBSTRING(CITY, LENGTH(CITY), 1) NOT IN ('a','e','i','o','u')

/*
Query the list of CITY names from STATION that do not start with 
vowels and do not end with vowels. Your result cannot contain duplicates.
*/
SELECT DISTINCT CITY FROM STATION
WHERE
SUBSTRING(CITY, 1, 1) NOT IN ('a','e', 'i', 'o', 'u')
AND
SUBSTRING(CITY, LENGTH(CITY), 1) NOT IN ('a','e', 'i', 'o', 'u')

/*
Query the Name of any student in STUDENTS who scored higher than 75 Marks. 
Order your output by the last three characters of each name. 
If two or more students both have names ending in the same 
last three characters (i.e.: Bobby, Robby, etc.), secondary sort them by ascending ID.
*/
SELECT NAME FROM STUDENTS 
WHERE MARKS > 75 
ORDER BY SUBSTRING(NAME, (LENGTH(NAME) - 2), 3), ID

/*
Write a query that prints a list of 
employee names (i.e.: the name attribute) 
from the Employee table in alphabetical order.
*/
SELECT NAME FROM EMPLOYEE ORDER BY NAME

/*
Write a query that prints a list of employee names (i.e.: the name attribute) 
for employees in Employee having a salary greater than 2000 per month who 
have been employees for less than 10 months. Sort your result by ascending employee_id.
*/
SELECT NAME FROM EMPLOYEE
WHERE
SALARY > 2000
AND
MONTHS < 10
ORDER BY EMPLOYEE_ID

/*
Write a query identifying the type of each record in the TRIANGLES 
table using its three side lengths. Output one of the following statements 
for each record in the table:

Equilateral: It's a triangle with  sides of equal length.
Isosceles: It's a triangle with  sides of equal length.
Scalene: It's a triangle with  sides of differing lengths.
Not A Triangle: The given values of A, B, and C don't form a triangle.
*/
SELECT CASE             
            WHEN A + B > C AND B + C > A AND A + C > B THEN
                CASE 
                    WHEN A = B AND B = C THEN 'Equilateral'
                    WHEN A = B OR B = C OR A = C THEN 'Isosceles'
                    ELSE 'Scalene'
                END
            ELSE 'Not A Triangle'
        END
FROM TRIANGLES;

SELECT CASE             
            WHEN A + B <= C THEN
                'Not A Triangle'
            ELSE 
                CASE 
                    WHEN A = B AND B = C THEN 'Equilateral'
                    WHEN A = B OR B = C OR A = C THEN 'Isosceles'
                    ELSE 'Scalene'
                END
        END
FROM TRIANGLES;

/* Generate the following two result sets:
Query an alphabetically ordered list of all names in 
OCCUPATIONS, immediately followed by the first letter of 
each profession as a parenthetical (i.e.: enclosed in parentheses). 
For example: AnActorName(A), ADoctorName(D), AProfessorName(P), and ASingerName(S).
Query the number of ocurrences of each occupation in OCCUPATIONS. 
Sort the occurrences in ascending order, and output them in the following format:

There are a total of [occupation_count] [occupation]s.
where [occupation_count] is the number of occurrences of an occupation 
in OCCUPATIONS and [occupation] is the lowercase occupation name. 
If more than one Occupation has the same [occupation_count], they should be ordered alphabetically.

Note: There will be at least two entries in the table for each type of occupation. */
SELECT CONCAT(NAME,"(",SUBSTRING(OCCUPATION,1,1),")") AS O FROM OCCUPATIONS ORDER BY NAME;

SELECT SUBQUERY.RESULT FROM (
    SELECT OCCUPATION, COUNT(OCCUPATION) AS COUNT, CONCAT("There are a total of ", COUNT(OCCUPATION)," ",LOWER(OCCUPATION),"s.") AS RESULT FROM OCCUPATIONS GROUP BY OCCUPATION ORDER BY COUNT
) AS SUBQUERY;

/* Given the table schemas below, write a query to print the company_code, founder name, 
total number of lead managers, total number of senior managers, total number of managers, 
and total number of employees. 
Order your output by ascending company_code. */
SELECT COMPANY.COMPANY_CODE, COMPANY.FOUNDER, 
(
    SELECT COUNT(DISTINCT(LEAD_MANAGER.LEAD_MANAGER_CODE)) FROM LEAD_MANAGER WHERE LEAD_MANAGER.COMPANY_CODE = COMPANY.COMPANY_CODE
),
(
    SELECT COUNT(DISTINCT(SENIOR_MANAGER.SENIOR_MANAGER_CODE)) FROM SENIOR_MANAGER WHERE SENIOR_MANAGER.COMPANY_CODE = COMPANY.COMPANY_CODE
),
(
    SELECT COUNT(DISTINCT(MANAGER.MANAGER_CODE)) FROM MANAGER WHERE MANAGER.COMPANY_CODE = COMPANY.COMPANY_CODE
),
(
    SELECT COUNT(DISTINCT(EMPLOYEE.EMPLOYEE_CODE)) FROM EMPLOYEE WHERE EMPLOYEE.COMPANY_CODE = COMPANY.COMPANY_CODE
)
FROM COMPANY
GROUP BY COMPANY.COMPANY_CODE, COMPANY.FOUNDER
ORDER BY COMPANY.COMPANY_CODE;

/*
Query the difference between the maximum and minimum populations in CITY.
Input Format
The CITY table is described as follows:
CITY
Field           Type
ID              NUMBER
NAME            VARCHAR2 ( 17 )
COUNTRYCODE     VARCHAR2 ( 3 )
DISTRICT        VARCHAR2 ( 20 )
POPULATION      NUMBER
*/
select max(population) - min(population) as difference from CITY