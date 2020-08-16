package dsa_stack_queue.bai_tap.optional_to_chuc_du_lieu_hop_ly_su_dung_queue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //Tạo đối tượng nhân viên
        NhanVien[] arrayNhanVien=new NhanVien[6];
        arrayNhanVien[1]=new NhanVien("Nữ","Châu",20);
        arrayNhanVien[2] =new NhanVien("Nữ","Khánh",20);
        arrayNhanVien[3] =new NhanVien("Nam","Đạt",20);
        arrayNhanVien[4] =new NhanVien("Nữ","Vân",20);
        arrayNhanVien[5] =new NhanVien("Nam","Cường",20);
        arrayNhanVien[6] =new NhanVien("Nữ","Điệp",20);

        //Đọc file
        ArrayDeque<NhanVien> nam=new ArrayDeque<>(20);
        ArrayDeque<NhanVien> nu=new ArrayDeque<>(20);
        for (int i=0;i<arrayNhanVien.length;i++){
            if (arrayNhanVien[i].getGioiTinh().equalsIgnoreCase("nữ")){
                nu.add(arrayNhanVien[i]);
            }else nam.add(arrayNhanVien[i]);
        }
        PrintWriter ghi=new PrintWriter("quanlynhavien.txt","UTF-8");
        ghi.a

    }
}
