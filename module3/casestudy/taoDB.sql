drop database if exists khu_nghi_duong_furama;
create database khu_nghi_duong_furama;
use khu_nghi_duong_furama;

-- -------------------------------------Nhân viên
-- Tạo bảng vị trí nhân viên
create table vi_tri(
id_vi_tri int,
ten_vi_tri varchar(45) not null,
constraint pk_vi_tri primary key(id_vi_tri)
);

-- Tạo bảng Trình độ nhân viên
create table trinh_do(
id_trinh_do int,
trinh_do varchar(45) not null,
constraint pk_trinh_do primary key(id_trinh_do)
);

-- Tạo bảng bộ phân
create table bo_phan(
id_bo_phan int,
ten_bo_phan varchar(45) not null,
constraint pk_bo_phan primary key(id_bo_phan)
);

-- Tạo bảng Nhân viên
create table nhan_vien(
id_nhan_vien int,
ho_ten varchar(50) not null,
id_vi_tri int not null,
id_trinh_do int not null,
id_bo_phan int not null,
ngay_sinh date not null,
so_CMND varchar(45) not null,
luong int not null,
sdt varchar(10) not null,
email varchar(45),
dia_chi varchar(45) not null,
constraint pk_nhan_vien primary key(id_nhan_vien),
constraint fk_vi_tri foreign key(id_vi_tri) references vi_tri(id_vi_tri),
constraint fk_trinh_do foreign key(id_trinh_do) references trinh_do(id_trinh_do),
constraint fk_bo_phan foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

-- -----------------------------------------------------Khách hàng
-- Tạo bảng loại khách hàng
create table loai_khach(
id_loai_khach int,
ten_loai_khach varchar(45) not null,
constraint pk_loai_khach primary key(id_loai_khach)
);

-- Tạo bảng khách hàng
create table khach_hang(
id_khach_hang int,
id_loai_khach int not null,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_CMTND varchar(45) not null,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45) not null,
constraint pk_khach_hang primary key(id_khach_hang),
constraint fk_loai_khach foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);

-- --------------------------------------------------Dịch vụ
-- Tạo bảng kiểu thuê
create table kieu_thue(
id_kieu_thue int,
ten_kieu_thue varchar(45) not null,
gia int not null,
constraint pk_kieu_thue primary key(id_kieu_thue)
);

-- Tạo bảng loại dịch vụ
create table loai_dich_vu(
id_loai_dich_vu int,
ten_loai_dich_vu varchar(45) not null,
constraint pk_loai_dich_vu primary key(id_loai_dich_vu)
);

-- Tạo bảng dịch vụ
create table dich_vu(
id_dich_vu int,
ten_dich_vu varchar(45) not null,
dien_tich int not null,
so_tang int not null,
so_nguoi_toi_da int not null,
chi_phi_thue int not null,
id_kieu_thue int not null,
id_loai_dich_vu int not null,
trang_thai varchar(45) not null,
constraint pk_dich_vu primary key(id_dich_vu),
constraint fk_kieu_thue foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
constraint fk_loai_dich_vu foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

-- -------------------------------------------------------------------Hợp đồng
-- tạo bảng dịch vụ đi kèm
create table dich_vu_di_kem(
id_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(45) not null,
gia int not null,
don_vi varchar(10) not null,
trang_thai_kha_dung varchar(45),
constraint pk_dich_vu_di_kem primary key(id_dich_vu_di_kem)
);

-- Tạo bảng hợp đồng
create table hop_dong(
id_hop_dong int,
id_nhan_vien int not null,
id_khach_hang int not null,
id_dich_vu int not null,
ngay_lam_hop_dong date not null,
ngay_ket_thuc date not null,
tien_dat_coc int not null,
tong_tien int not null,
constraint pk_hop_dong primary key(id_hop_dong),
constraint fk_nhan_vien foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
constraint fk_khach_hang foreign key(id_khach_hang) references khach_hang(id_khach_hang),
constraint fk_dich_vu foreign key(id_dich_vu) references dich_vu(id_dich_vu)
);

-- Tạo bảng Hợp đồng chi tiết
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int,
id_hop_dong int not null,
id_dich_vu_di_kem int not null,
so_luong int not null,
constraint pk_hop_dong_chi_tiet primary key(id_hop_dong_chi_tiet),
constraint fk_hop_dong foreign key(id_hop_dong) references hop_dong(id_hop_dong),
constraint fk_dich_vu_di_kem foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);



