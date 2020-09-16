use khu_nghi_duong_furama;

-- Hiển thị các tên bắt đầu bằng ký tự H hoặc K hoặc T và có chiều dài tối đa là 20 ký tự
select length(ho_ten) as 'chieu_dai_ten', nhan_vien.*
from nhan_vien
where ho_ten regexp binary '(H|K|T)[:alpha:]+$' and length(ho_ten)<=20;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where ((year(now())-year(ngay_sinh)) between 18 and 50)
and dia_chi in ('Đà Nẵng','Quảng Trị');

/* Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được 
sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond” */
select count(d.id_khach_hang) as 'so_lan_dat_phong',k.*,l.ten_loai_khach
from hop_dong d
right join khach_hang k on d.id_khach_hang=k.id_khach_hang
inner join loai_khach l on l.id_loai_khach=k.id_loai_khach
group by k.id_khach_hang
having l.ten_loai_khach='Diamond'
order by count(d.id_khach_hang);

select count(d.id_khach_hang) as 'so_lan_dat_phong',k.*,l.ten_loai_khach
from hop_dong d
right join khach_hang k on d.id_khach_hang=k.id_khach_hang
inner join loai_khach l on l.id_loai_khach=k.id_loai_khach
group by d.id_khach_hang;


