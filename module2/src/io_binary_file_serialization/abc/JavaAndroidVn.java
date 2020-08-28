package io_binary_file_serialization.abc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaAndroidVn {

    public static void main(String[] args) throws IOException {
        SinhVien a = new SinhVien();
        a.setHoTen("Vũ Văn T");
        a.setTuoi(21);
        SinhVien b = new SinhVien();
        b.setHoTen("Nguyễn Văn A");
        b.setTuoi(22);

        SinhVien f = new SinhVien();
        f.setHoTen("Nguyễn Văn f");
        f.setTuoi(22);
        SinhVien c = new SinhVien();
        c.setHoTen("Nguyễn Văn c");
        c.setTuoi(22);
        SinhVien d = new SinhVien();
        d.setHoTen("Nguyễn Văn d");
        d.setTuoi(22);
        SinhVien h = new SinhVien();
        h.setHoTen("Nguyễn Văn h");
        h.setTuoi(22);
        SinhVien g = new SinhVien();
        g.setHoTen("Nguyễn Văn g");
        g.setTuoi(22);

        try {
            FileOutputStream fOT = new FileOutputStream("E:\\sinhvien.dat");
            ObjectOutputStream oOT = new ObjectOutputStream(fOT); // Sử dụng để ghi file theo từng Object
            oOT.writeObject(a); // Ghi  Object là đối tượng a xuống file
            oOT.writeObject(b);
            oOT.writeObject(f);
            oOT.writeObject(c);
            oOT.writeObject(g);
            oOT.writeObject(h);
            oOT.writeObject(d);
            oOT.flush();
            oOT.close();
            fOT.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra!");
        }

        SinhVien a1 =null; //Tạo đối tượng a1 mới, để phía dưới gán bằng đối tượng ta lấy được ra từ file

        try {
            FileInputStream fIT = new FileInputStream("E:\\sinhvien.dat");
            ObjectInputStream oIT = new ObjectInputStream(fIT); // Sử dụng để đọc file theo từng Object
            boolean check=true;
            while (check) {
                try {

                    a1 = (SinhVien) oIT.readObject(); //Đọc Object đầu tiên ép kiểu về kiểu SinhVien sau đó gán bằng đối tượng a1
                    System.out.println("Thông tin sinh vien a1 đọc ra là: \nTên: " + a1.getHoTen() + "\nTuổi: " +a1.getTuoi());
                }catch (EOFException e){
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            oIT.close();
            fIT.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra!");
        }

    }
}