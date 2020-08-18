package dsa_stack_queue.bai_tap.optional_to_chuc_du_lieu_hop_ly_su_dung_queue;

import java.io.Serializable;

public class NhanVien implements Serializable,Comparable<NhanVien> {
    private String gioiTinh;
    private String ten;
    private int tuoi;
    private String ngaySinh;

    public NhanVien() {
    }

    public NhanVien(String gioiTinh, String ten, int tuoi,String ngaySinh) {
        this.gioiTinh = gioiTinh;
        this.ten = ten;
        this.tuoi = tuoi;
        this.ngaySinh=ngaySinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    @Override
    public String toString(){
        return "Nhân viên tên: "+ten+"   tuổi: "+tuoi+"    giới tính: "+gioiTinh;
    }

    @Override
    public int compareTo(NhanVien o) {
        //giam dan
        return o.ngaySinh.compareTo(this.ngaySinh);
    }
}
