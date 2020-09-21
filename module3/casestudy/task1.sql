use khu_nghi_duong_furama;

-- 1. Hiển thị các tên bắt đầu bằng ký tự H hoặc K hoặc T và có chiều dài tối đa là 20 ký tự
SELECT 
    CHAR_LENGTH(ho_ten) AS 'chieu_dai_ten', nhan_vien.*
FROM
    nhan_vien
WHERE
    ho_ten REGEXP BINARY '(H|K|T)\w+$'
        AND CHAR_LENGTH(ho_ten) <= 15;

-- 2. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    YEAR(NOW()) - YEAR(ngay_sinh) AS 'tuoi', khach_hang.*
FROM
    khach_hang
WHERE
    ((YEAR(NOW()) - YEAR(ngay_sinh)) BETWEEN 18 AND 50)
        AND dia_chi IN ('Đà Nẵng' , 'Quảng Trị');

/*4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/
SELECT 
    COUNT(kh.id_khach_hang) AS 'so_lan_dat_phong',
    kh.*,
    lk.ten_loai_khach
FROM
    khach_hang kh
        LEFT JOIN
    hop_dong hd ON kh.id_khach_hang = hd.id_khach_hang
        LEFT JOIN
    loai_khach lk ON kh.id_loai_khach = lk.id_loai_khach
GROUP BY kh.id_khach_hang
HAVING lk.ten_loai_khach = 'Diamond'
ORDER BY so_lan_dat_phong;

/*5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
SELECT 
    kh.id_khach_hang,
    kh.ho_ten,
    lk.ten_loai_khach,
    hd.id_hop_dong,
    dv.ten_dich_vu,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    SUM(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) AS 'tong_tien'
FROM
    khach_hang kh
        LEFT JOIN
    loai_khach lk ON kh.id_loai_khach = lk.id_loai_khach
        LEFT JOIN
    hop_dong hd ON hd.id_khach_hang = kh.id_khach_hang
        LEFT JOIN
    dich_vu dv ON hd.id_dich_vu = dv.id_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.id_hop_dong = hd.id_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
GROUP BY kh.id_khach_hang;

/*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
SELECT ldv.id_loai_dich_vu, dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, ldv.ten_loai_dich_vu, hd.ngay_lam_hop_dong
FROM loai_dich_vu ldv
	LEFT JOIN dich_vu dv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
	LEFT JOIN hop_dong hd ON hd.id_dich_vu = dv.id_dich_vu
WHERE ldv.id_loai_dich_vu NOT IN (
    SELECT ldv.id_loai_dich_vu
	FROM loai_dich_vu ldv
		LEFT JOIN dich_vu dv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
		LEFT JOIN hop_dong hd ON hd.id_dich_vu = dv.id_dich_vu
        WHERE YEAR(hd.ngay_lam_hop_dong) >= '2019');

/*7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018
nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.*/
SELECT 
    dv.id_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    loai_dich_vu ldv
        INNER JOIN
    dich_vu dv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
        INNER JOIN
    hop_dong hd ON hd.id_dich_vu = dv.id_dich_vu
WHERE
    YEAR(hd.ngay_lam_hop_dong) = '2018'
        AND ldv.id_loai_dich_vu NOT IN (SELECT 
            ldv.id_loai_dich_vu
        FROM
            loai_dich_vu ldv
                INNER JOIN
            dich_vu dv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
                INNER JOIN
            hop_dong hd ON hd.id_dich_vu = dv.id_dich_vu
        WHERE
            YEAR(hd.ngay_lam_hop_dong) = '2019');

/*8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.*/
SELECT DISTINCT
    ho_ten
FROM
    khach_hang;

-- cách 2
SELECT 
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten;

-- cách 3
SELECT 
    ho_ten
FROM
    khach_hang 
UNION SELECT 
    ho_ten
FROM
    khach_hang;

/*9.	Thực hiện thống kê doanh thu theo tháng,
nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng*/
SELECT 
    table_thang.thang,
    IFNULL(SUM(hd.tong_tien), 0) AS 'Tong_doanh_thu'
FROM
    (SELECT '1' AS 'thang' 
    UNION 
    SELECT '2' AS 'thang'
    UNION 
    SELECT '3' AS 'thang'
    UNION 
    SELECT '4' AS 'thang' 
    UNION 
    SELECT '5' AS 'thang' 
    UNION 
    SELECT '6' AS 'thang' 
    UNION 
    SELECT '7' AS 'thang' 
    UNION 
    SELECT '8' AS 'thang' 
    UNION 
    SELECT '9' AS 'thang' 
    UNION 
    SELECT '10' AS 'thang' 
    UNION 
    SELECT '11' AS 'thang' 
    UNION 
    SELECT '12' AS 'thang') 
    AS table_thang
LEFT JOIN hop_dong hd ON table_thang.thang = MONTH(hd.ngay_lam_hop_dong)
        AND YEAR(hd.ngay_lam_hop_dong) = '2019'
GROUP BY table_thang.thang;

/*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem
(được tính dựa trên việc count các IDHopDongChiTiet).*/
select hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, ifnull(sum(hdct.so_luong),0) as 'so luong dich vu di kem'
from hop_dong hd 
left join hop_dong_chi_tiet hdct on hd.id_hop_dong=hdct.id_hop_dong
group by hd.id_hop_dong;

/*11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
select dvdk.*
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
inner join hop_dong hd on hd.id_hop_dong=hdct.id_hop_dong
inner join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
inner join loai_khach lkh on lkh.id_loai_khach = kh.id_loai_khach
where lkh.ten_loai_khach = 'Diamond' and kh.dia_chi in ('Vinh','Quảng Ngãi')
group by dvdk.id_dich_vu_di_kem;

/*12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem
(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019
nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/

select hd.id_hop_dong, nv.ho_ten 'ho_ten_nhan_vien', kh.ho_ten 'ho_ten_khach_hang',kh.sdt, dv.ten_dich_vu, count(hdct.id_hop_dong_chi_tiet) as 'soluongdichvudikem', 
ifnull(sum(hd.tien_dat_coc),0) as 'Tiendatcoc'
from dich_vu dv
inner join hop_dong hd on hd.id_dich_vu= dv.id_dich_vu
inner join nhan_vien nv on nv.id_nhan_vien=hd.id_nhan_vien
inner join khach_hang kh on kh.id_khach_hang=hd.id_khach_hang
inner join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hdct.id_hop_dong
inner join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong)='2019' and month(hd.ngay_lam_hop_dong) in ('10','11','12')
group by dv.id_dich_vu;


/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

select *
from (
select dvdk.*,hdct.so_luong,sum(hdct.so_luong) as tong_so_luong
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
inner join hop_dong hd on hd.id_hop_dong = hdct.id_hop_dong
inner join khach_hang kh on hd.id_khach_hang=kh.id_khach_hang
group by dvdk.id_dich_vu_di_kem
) as so_luong_dvdk
inner join (
select max(tong_so_luong) as 'so_luong_lon_nhat'
from(
select dvdk.*,hdct.so_luong,sum(hdct.so_luong) as tong_so_luong
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
inner join hop_dong hd on hd.id_hop_dong = hdct.id_hop_dong
inner join khach_hang kh on hd.id_khach_hang=kh.id_khach_hang
group by dvdk.id_dich_vu_di_kem
) as so_luong_dvdk
) as so_luong_dvdk_lon_nhat
on so_luong_dvdk.tong_so_luong=so_luong_dvdk_lon_nhat.so_luong_lon_nhat;

/*14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
select hd.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.id_dich_vu_di_kem) as 'Solansudung'
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on dvdk.id_dich_vu_di_kem=hdct.id_dich_vu_di_kem
inner join hop_dong hd on hd.id_hop_dong=hdct.id_hop_dong
inner join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
inner join loai_dich_vu ldv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
group by dvdk.id_dich_vu_di_kem
having Solansudung=1;

/*15.	Hiển thi thông tin của tất cả nhân viên bao gồm
IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
select nv.id_nhan_vien, nv.ho_ten, td.trinh_do,bp.ten_bo_phan,nv.sdt,nv.dia_chi
from nhan_vien nv
left join trinh_do td on td.id_trinh_do=nv.id_trinh_do
left join bo_phan bp on bp.id_bo_phan=nv.id_bo_phan
inner join hop_dong hd on hd.id_nhan_vien=nv.id_nhan_vien
where year(hd.ngay_lam_hop_dong) in ('2018','2019') and nv.id_nhan_vien not in(
select nv.id_nhan_vien
from nhan_vien nv
left join trinh_do td on td.id_trinh_do=nv.id_trinh_do
left join bo_phan bp on bp.id_bo_phan=nv.id_bo_phan
inner join hop_dong hd on hd.id_nhan_vien=nv.id_nhan_vien
where year(hd.ngay_lam_hop_dong) >'2018' or year(hd.ngay_lam_hop_dong)>2019
)
group by nv.id_nhan_vien
having count(nv.id_nhan_vien)<=3;

/*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/
delete from  nhan_vien nv
where id_nhan_vien not in(
select bang_tam.nhanvien
from (
select distinct nv.id_nhan_vien as nhanvien
from nhan_vien nv
left join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where year(hd.ngay_lam_hop_dong) in ('2017','2018')
group by nv.id_nhan_vien
) as bang_tam
);

/*17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
 chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/
 
 update loai_khach
 set ten_loai_khach='Diamond'
 where ten_loai_khach='Platinium' and id_loai_khach in (
 select Tongtienthanhtoan_loai_khach.id_loai_khach
 from (
 select lk.id_loai_khach, sum(hd.tong_tien*23000) as tongtienthanhtoan
 from loai_khach lk
 inner join khach_hang kh on kh.id_loai_khach=lk.id_loai_khach
 inner join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
 where year(hd.ngay_lam_hop_dong)='2019'
 group by lk.id_loai_khach
 ) as Tongtienthanhtoan_loai_khach
 where Tongtienthanhtoan_loai_khach.tongtienthanhtoan>10000000
 );
 
 /*18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/
 -- Tìm kiếm khách hàng có hợp đồng trước năm 2016
 
 alter table hop_dong
 drop foreign key fk_khach_hang;
 
 alter table hop_dong
 add constraint fk_khach_hang foreign key(id_khach_hang) references khach_hang(id_khach_hang) on delete cascade
 on update cascade;
 
 alter table hop_dong_chi_tiet
 drop foreign key fk_hop_dong;
 
 alter table hop_dong_chi_tiet
 add constraint fk_hop_dong foreign key(id_hop_dong) references hop_dong(id_hop_dong) on delete cascade
 on update cascade;
 
delete from khach_hang
where id_khach_hang in (
select bang_tam.ma_so
from(
select kh.id_khach_hang as ma_so
from khach_hang kh
inner join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang and year(hd.ngay_lam_hop_dong)<'2016'
)as bang_tam
);

/*19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.*/
update dich_vu_di_kem
set gia=gia*2
where id_dich_vu_di_kem in (
select bang_tam.id_dich_vu_di_kem
from (
select dvdk.id_dich_vu_di_kem, ifnull(sum(hdct.so_luong),0) as 'soluong'
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct using(id_dich_vu_di_kem)
inner join hop_dong using (id_hop_dong)
group by dvdk.id_dich_vu_di_kem
)as bang_tam
where bang_tam.soluong>10
);

 /*20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
 thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/
 select nv.id_nhan_vien, nv.ho_ten, nv.email, nv.sdt, nv.ngay_sinh, nv.dia_chi, 'nhân viên' as loại
 from nhan_vien nv
 union all
 select kh.id_khach_hang, kh.ho_ten, kh.email, kh.sdt, kh.ngay_sinh, kh.dia_chi, 'khách hàng' as loại
 from khach_hang kh;
 
 /*21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có 
 địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019” */
create view v_nhan_vien as
select nv.*
from nhan_vien nv
inner join hop_dong hd using(id_nhan_vien)
where nv.dia_chi='Hải Châu' and hd.ngay_lam_hop_dong='2019-12-12';

/*22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.*/
update v_nhan_vien
set dia_chi='Liên Chiều'
where id_nhan_vien='Hải Châu';

/*23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1*/
delimiter //
drop procedure if exists Sp_1//
create procedure Sp_1(id int)
begin
delete from khach_hang
where id_khach_hang=id;
end//
delimiter ;

/*24.	Tạp Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
 với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan*/
delimiter //
drop procedure if exists Sp_2//
create procedure Sp_2(new_id_hop_dong int,
new_id_nhan_vien int,
new_id_khach_hang int,
new_id_dich_vu int,
new_ngay_lam_hop_dong date,
new_ngay_ket_thuc date,
new_tien_dat_coc int,
new_tong_tien int)
begin
-- Tạo biến để kiểm tra 
declare kiem_tra_id_hop_dong int default(-1);
declare kiem_tra_id_nhan_vien int default(-1);
declare kiem_tra_id_khach_hang int default(-1);
declare kiem_tra_id_dich_vu int default(-1);
-- ---------------------------------set value cho biến kiểm tra id_hop_dong
select id_hop_dong
into kiem_tra_id_hop_dong
from hop_dong
where id_hop_dong=new_id_hop_dong;
-- --------------------------------set value cho biến kiểm tra id_nhan_vien
select id_nhan_vien
into kiem_tra_id_nhan_vien
from nhan_vien
where id_nhan_vien=new_id_nhan_vien;
-- --------------------------------set value cho biến kiểm tra kiem_tra_id_khach_hang
select id_khach_hang
into kiem_tra_id_khach_hang
from khach_hang
where id_khach_hang=new_id_khach_hang;
-- --------------------------------set value cho biến kiểm tra kiem_tra_id_dich_vu
select id_dich_vu
into kiem_tra_id_dich_vu
from dich_vu
where id_dich_vu=new_id_dich_vu;
-- Kiểm tra điều kiện toàn vẹn tham chiếu
if ((new_id_hop_dong<=0) or (kiem_tra_id_hop_dong<>-1)) then select concat('Hợp đồng ',new_id_hop_dong,' Nhỏ hơn 1 hoặc đã tồn tại') as 'status';
elseif ((new_id_nhan_vien<=0) or (kiem_tra_id_nhan_vien=-1)) then select concat('Id nhân viên = ',new_id_nhan_vien,' Nhỏ hơn 1 hoặc không tồn tại') as 'status';
elseif ((new_id_khach_hang<=0) or (kiem_tra_id_khach_hang=-1)) then select concat('Id khách hàng = ',new_id_khach_hang,' Nhỏ hơn 1 hoặc không tồn tại') as 'status';
elseif ((new_id_dich_vu<=0) or (kiem_tra_id_dich_vu=-1)) then select concat('Id dịch vụ = ',new_id_dich_vu,' Nhỏ hơn 1 hoặc không tồn tại') as 'status';
else 
select 'Đã thêm' as 'status';
insert into hop_dong
value (new_id_hop_dong, new_id_nhan_vien, new_id_khach_hang, new_id_dich_vu, new_ngay_lam_hop_dong, new_ngay_ket_thuc,
new_tien_dat_coc, new_tong_tien);
end if;
end//
delimiter ;
call Sp_2(-4,13,3,4,'2019-11-20','2019-12-20',100,200);

/*25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong
 ra giao diện console của database*/
 delimiter //
drop procedure if exists hien_thi//
create procedure hien_thi(inout soluong int)
begin
select soluong;
end//
delimiter ;

 
 delimiter //
 drop trigger if exists Tr_1//
 create trigger Tr_1
 after delete
 on hop_dong for each row
 begin
 select count(id_hop_dong) as 'số lượng bản ghi còn lại trong hop_dong'
 into @soluong
 from hop_dong;
 end//
 delimiter ;
 
 delete from hop_dong
 where id_hop_dong=3;
 select @soluong;
 
 /*26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không,
 với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
 Nếu dữ liệu hợp lệ thì cho phép cập nhật,
 nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database*/
delimiter //
 drop trigger if exists Tr_2//
 create trigger Tr_2
 before update
 on hop_dong for each row
 begin
  if ((day(new.ngay_ket_thuc)-day(old.ngay_lam_hop_dong))>2) then set new.ngay_ket_thuc=new.ngay_ket_thuc;
  select 'Đã cập nhập' into @trang_thai;
  else select 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày' into @trang_thai;
  end if;
 end//
 delimiter ;
 
 update hop_dong
 set ngay_ket_thuc='2015-04-22'
 where id_hop_dong=4;
 select @trang_thai;
 
 /*27.	Tạo user function thực hiện yêu cầu sau:
a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất
tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ 
(lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
Mã của Khách hàng được truyền vào như là 1 tham số của function này.
*/
-- -------------------------------------------------a
delimiter //
drop function if exists func_1//
create function func_1()
returns int
deterministic
begin
declare so_dich_vu_co_tong_tien_lon_hon_2000000 int default(0);
select count(bang_tam.tongtien)
into so_dich_vu_co_tong_tien_lon_hon_2000000 
from(
select sum(hd.tong_tien*23000) as 'tongtien'
from dich_vu dv 
inner join hop_dong hd using(id_dich_vu) 
group by dv.id_dich_vu
having tongtien>2000000
) as bang_tam;
return so_dich_vu_co_tong_tien_lon_hon_2000000;
end//
delimiter ;

select func_1() as 'Các dịch vụ đã được sử dụng với Tổng tiền lớn hơn 2000000 VNĐ';

/*b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất
tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ 
(lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
Mã của Khách hàng được truyền vào như là 1 tham số của function này.*/
delimiter //
drop function if exists func_2//
create function func_2(ma_khach_hang int)
returns varchar(50)
deterministic
begin
-- kiểm trả mã số khách hàng nhập vào
declare kiem_tra_ma_khach_hang int default(-1);
declare khoang_thoi_gian_dai_nhat int default(0);
select id_khach_hang
into kiem_tra_ma_khach_hang
from khach_hang 
where id_khach_hang=ma_khach_hang;
-- kiểm trả mã số khách hàng nhập vào
if ((ma_khach_hang<=0) or (kiem_tra_ma_khach_hang=-1)) then return concat('không có khách hàng có mã khách hàng là ',ma_khach_hang );
else
-- lấy thời gian dài nhất
select max(bang_tam.thoigian)
into khoang_thoi_gian_dai_nhat 
from(
select datediff(hd.ngay_ket_thuc,hd.ngay_lam_hop_dong) as 'thoigian'
from khach_hang kh
inner join hop_dong hd using(id_khach_hang)
where kh.id_khach_hang=ma_khach_hang
) as bang_tam;
return concat(khoang_thoi_gian_dai_nhat,' ngày');
end if;
end//
delimiter ;

select func_2(6) as 'trạng thái';

/*28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” 
từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó 
(tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan 
(tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.*/

delimiter //
drop procedure if exists Sp_3;
create procedure Sp_3()
begin
end//
delimiter ;