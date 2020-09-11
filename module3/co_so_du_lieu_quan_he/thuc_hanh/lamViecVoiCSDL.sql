-- Sử dụng kết nối với database 
use classicmodels;

-- Hiển thị column 4 cái customer, phone, city, country và giới hạn 30 row trong table customers
select `customername`, `phone`, `city`, `country`
from customers
limit 0,30;

-- Hiển thị 30 row trong trong table customers
select *
from customers
limit 0,30;

-- Hiển thị tất cả data của cột customerName có chứa ký tự a trong customers
select *
from customers
where customerName
like '%A%' 
limit 0,10; 

-- Hiển thị tất cả data của cột city có chứa Nantes hoặc Las Vegas hoặc .... trong table customers
select *
from customers
where city
in(
'Nantes', 'Las Vegas', 'Warszawa', 'NYC'
)
limit 0,10;

-- Hiển thị 2 columns ordernumber, orderDate và giới hạn 10 row trong table orders
select ordernumber, orderDate
from orders
limit 0,10;

-- Hiển thị 10 row trong trong table orders
select *
from orders
limit 0,10;

-- Hiển thị giới hạn 10 row trong orders mà nằm trong khoản value 10100 - 10110 của column ordernumber
select *
from orders
where ordernumber 
between '10100' and '10110'
limit 0,10;

-- Hiển thị thông tin khách hàng có orderDate nhỏ hơn hoặc bằng ngày 2003-03-03 và có status là shipped.
select *
from orders
where `orderDate` <= '2003-03-03' and `status` like '%shipped%' ;






