package dsa_stack_queue.bai_tap.optional_to_chuc_du_lieu_hop_ly_su_dung_queue;

public class NhanVien {
    private String gioiTinh;
    private String ten;
    private int tuoi;

    public NhanVien() {
    }

    public NhanVien(String gioiTinh, String ten, int tuoi) {
        this.gioiTinh = gioiTinh;
        this.ten = ten;
        this.tuoi = tuoi;
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
}
