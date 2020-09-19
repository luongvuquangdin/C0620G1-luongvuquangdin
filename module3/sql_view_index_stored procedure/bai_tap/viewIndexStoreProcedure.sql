drop database if exists demo;
create database demo;
use demo;
create table products(
id int primary key,
productCode varchar(50),
productName varchar(50),
productPrice int,
productAmount int,
productDescription varchar(100),
productStatus varchar(100)
);

insert into products
values
(1,'11','1969 Harley Davidson Ultimate Choppe',81,6066,' Comes with 4 masts','OK'),
(2,'12','18th Century Vintage Horse Carriage',5942,6012,'4 masts','OK'),
(3,'13','1900s Vintage Bi-Plane',100,1242,' 5 masts','NOT'),
(4,'14','1900s Vintage Tri-Plane',200,4124,'6 masts','OK'),
(5,'15','1903 Ford Model A',400,124124,'7 masts','OK');

alter table products
modify productCode varchar(50) unique;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index uni_idx_product
on products(productCode);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products
add index composite_idx(productName ,productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select  *
from products;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view view_products as
select productCode, productName, productPrice, productStatus
from products;

-- Tiến hành sửa đổi view
update view_products
set productStatus ='Not'
where productCode =11;

-- Xoa view
drop view view_products;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
drop procedure if exists display_products//
create procedure display_products()
begin
select *
from products;
end //
delimiter ;

call display_products();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
drop procedure if exists insert_products//
create procedure insert_products(
id int,
productCode varchar(50),
productName varchar(50),
productPrice int,
productAmount int,
productDescription varchar(100),
productStatus varchar(100)
)
begin
insert into products
value(id,productCode,productName,productPrice,productAmount,productDescription,productStatus);
end //
delimiter ;

call insert_products(6,'16','khanh 1996',300,43212,'8 masts','Not');

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
drop procedure if exists update_products//
create procedure update_products(
id int,
productCode varchar(50),
productName varchar(50),
productPrice int,
productAmount int,
productDescription varchar(100),
productStatus varchar(100)
)
begin
update products p
set p.productCode=productCode,p.productName=productName,p.productPrice=productPrice,
p.productAmount=productAmount,p.productDescription=productDescription,p.productStatus=productStatus
where p.id=id;
end //
delimiter ;

call update_products(7,'16','khanh 2000',100,456223,'8 masts','OK');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
drop procedure if exists delete_products//
create procedure delete_products(id int)
begin
delete from products where products.id=id;
end //
delimiter ;

call delete_products(1);