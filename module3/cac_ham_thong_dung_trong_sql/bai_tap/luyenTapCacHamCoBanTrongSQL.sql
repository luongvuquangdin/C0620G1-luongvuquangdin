create database cac_ham_thong_dung;
use cac_ham_thong_dung;
create table khoa_hoc(
id int primary key auto_increment,
ten varchar(50),
tuoi int,
khoahoc varchar(5),
sotien int);

insert into khoa_hoc(ten,tuoi,khoahoc,sotien)
values
('Hoang',21,'CNTT',400000),
('Viet',19,'DTVT',320000),
('Thanh',18,'KTDN',400000),
('Nhan',19,'CK',450000),
('Huong',20,'TCNH',500000),
('Huong',20,'TCNH',200000);

-- Hiển thị tất cả các dòng có tên là Huong
select *
from khoa_hoc
where ten='Huong';

-- Lấy ra tổng số tiền của Huong
select sum(sotien)
from khoa_hoc
where ten='Huong';

-- Lấy ra tên danh sách của tất cả học viên, không trùng lặp
select *
from khoa_hoc
group by `ten`;

