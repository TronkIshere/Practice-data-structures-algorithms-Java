-- Duplicates Emails
SELECT email
FROM (
    SELECT email, COUNT(id) as cnt
    FROM Person
    GROUP BY email
    HAVING COUNT(id) > 1
) as subquery;

-- Customer who never order
SELECT c.Name as Customers
FROM Customers c
WHERE c.id not in (
    SELECT o.CustomerId FROM Orders o
);

-- Combine Two Tables
SELECT FirstName, LastName, City, State
FROM Person
LEFT JOIN Address
ON Person.PersonId = Address.PersonId

-- Delete duplicates emails
WITH cte AS (
  SELECT
    id,
    ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
  FROM Person
)
DELETE FROM Person
WHERE id IN (
    SELECT id FROM cte WHERE rn > 1
)