use classicmodels;

-- Quan sát các trường dữ liệu customername, phone, city, country của bảng customer
select customername, phone, city, country
from customers;

-- Quan sát các trường dữ liệu của bảng customer
select *
from customers;

-- Hiện thị thông tin của của customer có customerNam là Atelier graphique
select *
from customers
where customername ='Atelier graphique';

--  Hiển thị thông tin khách hàng có tên chứa ký tự A.
select *
from customers
where customername like '%A%';

-- hiển thị thông tin khách hàng có city ở một trong những vùng Nantes, Las Vegas, Warszawa, NYC.
select *
from customers
where city
in(
'Nantes',' Las Vegas',' Warszawa','NYC'
)

--

