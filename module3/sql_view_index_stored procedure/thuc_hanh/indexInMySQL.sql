use classicmodels;

--  Tìm thông tin của Julie King (mã số 175) không sử có index
select *
from customers
where customerNumber=175;

-- Theo dõi kết quả tốc độ mà bạn đang làm khi không có index
EXPLAIN SELECT * FROM customers WHERE contactLastName = 'King' and contactFirstName='Julie';

-- Tao index phuc hop
create index idx_name
on customers(contactLastName, contactFirstName);

-- Theo dõi tốc độ tìm khi đã có index
explain select *
from customers where contactLastName = 'King' and contactFirstName='Julie';