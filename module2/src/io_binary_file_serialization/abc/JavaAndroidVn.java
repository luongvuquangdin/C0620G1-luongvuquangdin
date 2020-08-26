package io_binary_file_serialization.abc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class JavaAndroidVn {

    public static void main(String[] args) throws IOException {
        SinhVien a = new SinhVien();
        a.setHoTen("Vũ Văn T");
        a.setTuoi(21);
        SinhVien b = new SinhVien();
        b.setHoTen("Nguyễn Văn A");
        b.setTuoi(22);

        try {
            FileOutputStream f = new FileOutputStream("E:\\sinhvien.dat");
            ObjectOutputStream oOT = new ObjectOutputStream(f); // Sử dụng để ghi file theo từng Object
            oOT.writeObject(a); // Ghi  Object là đối tượng a xuống file
            oOT.writeObject(b);
            oOT.close();
            f.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra!");
        }

        SinhVien a1 =null; //Tạo đối tượng a1 mới, để phía dưới gán bằng đối tượng ta lấy được ra từ file
        try {
            FileInputStream f = new FileInputStream("E:\\sinhvien.dat");
            ObjectInputStream oIT = new ObjectInputStream(f); // Sử dụng để đọc file theo từng Object
            boolean check=true;
            while (check) {
                try {
                    a1 = (SinhVien) oIT.readObject(); //Đọc Object đầu tiên ép kiểu về kiểu SinhVien sau đó gán bằng đối tượng a1
                    System.out.println("Thông tin sinh vien a1 đọc ra là: \nTên: " + a1.getHoTen() + "\nTuổi: " +a1.getTuoi());
                }catch (Exception e){
                    break;
                }
            }
            oIT.close();
            f.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra!");
        }

        System.out.println("Tôi là ai");
    }
}