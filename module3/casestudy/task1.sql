use khu_nghi_duong_furama;

-- Hiển thị các tên bắt đầu bằng ký tự H hoặc K hoặc T và có chiều dài tối đa là 20 ký tự
select length(ho_ten) as 'chieu_dai_ten', nhan_vien.*
from nhan_vien
where ho_ten regexp binary '(H|K|T)[:alpha:]+$' and length(ho_ten)<=20;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (year(now())-year(ngay_sinh)) in (18,50);

select dia_chi
from khach_hang;
