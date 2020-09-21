-- ------------------------------------------Chèn dữ liệu vào bảng--------------------------------------------------

-- ---------------------------------------------- Nhân viên
use khu_nghi_duong_furama;
-- Chèn dữ liệu vào vị trí nhân viên
insert into vi_tri(id_vi_tri,ten_vi_tri)
values
(1,'Lễ tân'),
(2,'Phục vụ'),
(3,'Chuyên viên'),
(4,'Giám sát'),
(5,'Quản lý'),
(6,'Giám đốc');
select * from vi_tri;

-- Chèn dữ liệu vào trình độ nhân viên
insert into trinh_do
values
(1,'Trung cấp'),
(2,'Cao đẳng'),
(3,'Đại học'),
(4,'Sau đại học');
select * from trinh_do;

-- Chèn dữ liệu vào bộ phân nhân sự nhân viên
insert into bo_phan
values
(1,'Sale – Marketing'),
(2,'Hành Chính'),
(3,'Phục vụ'),
(4,'Quản lý');
select * from bo_phan;

-- Chèn dữ liệu vào Nhân viên
insert into nhan_vien(id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_CMND, luong, sdt, email, dia_chi)
values
('1', 'Nguyễn Quốc Gia', '6', '4', '4', '1986-12-31', '202750450', '1000', '374934170', 'gia@gmail.com', 'Đà Nẵng'),
('2', 'Lương Phú Tài', '2', '1', '3', '1999-11-14', '202400450', '200', '379430312', 'tai@gmail.com', 'Hà Nội'),
('3', 'Nguyễn Quang Nhật Thực', '1', '2', '3', '1990-02-04', '2021100450', '300', '349504923', 'thuc@gmail.com', 'Quảng Nam'),
('4', 'Hồ Thị Quỳnh', '3', '3', '2', '1994-04-10', '202540450', '450', '372837482', 'quynh@gmail.com', 'Đà Nẵng'),
('5', 'Trần Khánh Hải', '4', '3', '4', '1990-10-08', '202794050', '600', '362312383', 'hai@gmail.com', 'Quảng Nam'),
('6', 'Võ Thị Quỳnh Thi', '4', '3', '4', '1993-04-19', '202234450', '600', '370329103', 'thi@gmail.com', 'Hà Nội'),
('7', 'Hào Quốc Khánh', '4', '3', '4', '1991-03-21', '202512450', '600', '379582012', 'khanh@gmail.com', 'Sài Gòn'),
('8', 'Nguyễn Nhật', '5', '3', '4', '1995-02-28', '202503450', '400', '382930402', 'nhat@gmail.com', 'Quảng Ngãi'),
('9', 'Đỗ Kỳ Hà', '5', '3', '4', '1998-08-03', '202704250', '400', '359283851', 'ha@gmail.com', 'Quảng Ngãi'),
('10', 'Đặng Hào Nam', '2', '2', '3', '1992-05-06', '202922450', '200', '374385921', 'nam@gmail.com', 'Khánh Hòa'),
('11', 'Nguyễn Thị Nguyên', '5', '3', '1', '1998-12-30', '202493013', '150', '974923512', 'nam@gmail.com', 'Hải Châu'),
('12', 'Đỗ Như Quỳnh', '5', '4', '1', '1995-04-10', '202591910', '150', '978742134', 'nam@gmail.com', 'Khánh Hòa'),
('13', 'Trương Thị Phượng', '5', '2', '1', '1996-06-01', '202651910', '150', '374298641', 'nam@gmail.com', 'Hải Châu');
select * from nhan_vien;

-- -------------------------------- khách hàng
-- Chèn dữ liệu vào bảng loại khách hàng
insert into loai_khach
values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');
select * from loai_khach;

-- Chèn dữ liệu vào bản khách hàng
insert into khach_hang(id_khach_hang, id_loai_khach, ho_ten, ngay_sinh, so_CMTND, sdt, email, dia_chi)
values
('1', '1', 'Nguyễn Văn Tòng', '2000-09-10', '212421321', '0978871464', 'tong@gmail.com', 'Quảng Ngãi'),
('2', '2', 'Võ Thị Tâm', '1994-02-25', '202593212', '0923422014', 'tam@gmail.com', 'Sài Gòn'),
('3', '3', 'Trần Quốc Khánh', '2001-12-23', '212493913', '0384235911', 'khanh@gmail.com', 'Đà Nẵng'),
('4', '4', 'Lương Khang', '1997-02-21', '202421234', '0369696600', 'khang@gmail.com', 'Hà Nội'),
('5', '4', 'Đỗ Thánh', '1995-08-15', '202532125', '0367896600', 'thanh@gmail.com', 'Vinh');
select * from khach_hang;

-- -------------------------------- Dịch vụ
-- Chèn dữ liệu vào bảng loại dịch vụ
insert into loai_dich_vu
values
(1,'Villa'),
(2,'House'),
(3,'Room'),
(4,'Dịch vụ đi kèm');
select * from loai_dich_vu;

-- Chèn dữ liệu vào bảng kieu_thue
insert into kieu_thue
values
(1,'Theo năm',100000),
(2,'Theo tháng',11000),
(3,'Theo ngày',500),
(4,'Theo giờ',25);
select * from kieu_thue;

-- Chèn dữ liệu vào bảng dịch vụ
insert into dich_vu(id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai)
values
('1', 'Villa 2 tầng', '100', '2', '10', '500', '3', '1', 'Đang sử dụng'),
('2', 'House 1 tầng', '25', '1', '5', '250', '4', '2', 'Còn trống'),
('3', 'House 2 tầng', '50', '2', '10', '300', '4', '2', 'Hết phòng'),
('4', 'Room', '15', '1', '5', '700', '1', '3', 'Đang sử dụng'),
('5', 'Villa 4 tầng', '200', '4', '20', '1000', '2', '1', 'Còn Trống');
select * from dich_vu;

-- -------------------------------- Hợp đồng
-- Chèn dữ liệu vào bảng dich vụ đi kèm
insert into dich_vu_di_kem(id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi)
values
(1,'Massage',100,'USD'),
(2,'karaoke',100,'USD'),
(3,'Thức ăn',10,'USD'),
(4,'Nước uống',1,'USD'),
(5,'Thuê xe di chuyển tham quan resort',200,'USD');
select * from dich_vu_di_kem;

-- Chèn dữ liệu vào bảng hợp đồng
insert into hop_dong(id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, tong_tien)
values
('1', '11', '1', '1', '2018-09-15', '2018-09-16', '250', '500'),
('2', '12', '2', '2', '2019-08-15', '2019-09-16', '250', '250'),
('3', '13', '3', '3', '2019-04-14', '2019-09-16', '250', '500'),
('4', '13', '4', '4', '2015-04-19', '2015-06-19', '500', '700'),
('5', '11', '5', '5', '2018-11-15', '2018-12-15', '700', '1000'),
('6', '13', '1', '2', '2018-11-15', '2018-12-15', '900', '1200'),
('7', '12', '2', '2', '2017-05-15', '2017-06-15', '1200', '2000'),
('8', '13', '2', '3', '2019-12-12', '2020-01-12', '500', '1000');
select * from hop_dong;

-- Chèn dữ liệu vào hợp đồng chi tiết
insert into hop_dong_chi_tiet(id_hop_dong_chi_tiet, id_hop_dong, id_dich_vu_di_kem, so_luong)
values
('1', '1', '1', '11'),
('2', '2', '2', '2'),
('3', '3', '3', '2'),
('4', '4', '4', '4'),
('5', '5', '5', '14');
select * from hop_dong_chi_tiet;