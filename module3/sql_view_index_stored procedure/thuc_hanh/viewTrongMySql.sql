use classicmodels;

-- Tạo một bảng view 
CREATE VIEW customer_views AS
SELECT customerNumber, customerName, phone
FROM  customers;

-- Xem bản view customer_views
select * from customer_views;

-- Cập nhập view 
CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

-- xóa view 
drop view customer_views;