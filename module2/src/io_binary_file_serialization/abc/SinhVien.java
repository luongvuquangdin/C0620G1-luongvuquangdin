package io_binary_file_serialization.abc;

import java.io.Serializable;

class SinhVien implements Serializable {

    private String hoTen;
    private int tuoi;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}