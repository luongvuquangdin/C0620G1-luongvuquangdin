use khu_nghi_duong_furama;

-- 1. Hiển thị các tên bắt đầu bằng ký tự H hoặc K hoặc T và có chiều dài tối đa là 20 ký tự
select char_length(ho_ten) as 'chieu_dai_ten', nhan_vien.*
from nhan_vien
where ho_ten regexp binary '(H|K|T)\\w+$' and char_length(ho_ten)<=15;

-- 2. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select year(now())-year(ngay_sinh) as 'tuoi',khach_hang.*
from khach_hang
where ((year(now())-year(ngay_sinh)) between 18 and 50) and dia_chi in('Đà Nẵng','Quảng Trị');

/*4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/
select count(kh.id_khach_hang) as 'so_lan_dat_phong',kh.*,lk.ten_loai_khach
from khach_hang kh
left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
left join loai_khach lk on kh.id_loai_khach=lk.id_loai_khach
group by kh.id_khach_hang
having lk.ten_loai_khach='Diamond'
order by so_lan_dat_phong;

/*5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,
sum(dv.chi_phi_thue + hdct.so_luong*dvdk.gia) as 'tong_tien'
from khach_hang kh
left join loai_khach lk on kh.id_loai_khach=lk.id_loai_khach
left join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang
left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
left join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong 
left join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
group by kh.id_khach_hang;

/*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, ldv.ten_loai_dich_vu
from loai_dich_vu ldv
left join dich_vu dv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
left join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
where hd.id_hop_dong is null or not year(hd.ngay_lam_hop_dong)>'2019'  ;

/*7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018
nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.*/
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich,dv.so_nguoi_toi_da,dv.chi_phi_thue, ldv.ten_loai_dich_vu
from loai_dich_vu ldv
left join dich_vu dv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
left join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
where year(hd.ngay_lam_hop_dong)='2018';










