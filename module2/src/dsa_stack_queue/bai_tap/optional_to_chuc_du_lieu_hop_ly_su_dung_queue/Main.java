package dsa_stack_queue.bai_tap.optional_to_chuc_du_lieu_hop_ly_su_dung_queue;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng nhân viên
        NhanVien[] arrayNhanVien=new NhanVien[6];
        arrayNhanVien[0]=new NhanVien("Nữ","Châu",20,"17/02/1996");
        arrayNhanVien[1] =new NhanVien("Nữ","Khánh",20,"15/02/1996");
        arrayNhanVien[2] =new NhanVien("Nam","Đạt",20,"13/02/1996");
        arrayNhanVien[3] =new NhanVien("Nữ","Vân",20,"12/02/1996");
        arrayNhanVien[4] =new NhanVien("Nam","Cường",20,"14/02/1996");
        arrayNhanVien[5] =new NhanVien("Nữ","Điệp",20,"14/02/1996");

        //Đưa đối tượng là nữ vào linkedList nu
        //Đưa đối tượng là nam vào linkedList nam
        LinkedList<NhanVien> nam=new LinkedList<NhanVien>();
        LinkedList<NhanVien> nu=new LinkedList<NhanVien>();
        for (int i=0;i<arrayNhanVien.length;i++){
            if (arrayNhanVien[i].getGioiTinh().equalsIgnoreCase("nữ")){
                nu.add(arrayNhanVien[i]);
            }else nam.add(arrayNhanVien[i]);
        }
        //Sắp xếp theo thú tự tăng dần theo ngày sinh
        Collections.sort(nu);
        Collections.sort(nam);
        //Viết vào file
        try{
            FileOutputStream fOnput=new FileOutputStream("quanlynhan.txt");
            ObjectOutputStream obOutput=new ObjectOutputStream(fOnput);
            for (int i=0;i<arrayNhanVien.length;i++){
                    obOutput.writeObject(arrayNhanVien[i]);
            }
            obOutput.close();
            fOnput.close();
         //Đọc file
            FileInputStream fInput=new FileInputStream("quanlynhan.txt");
            ObjectInputStream obIutput=new ObjectInputStream(fInput);

            while (fInput.available()>0){
                NhanVien obj = (NhanVien)obIutput.readObject();
                System.out.println(obj);
            }
            fInput.close();
            obIutput.close();
        }catch (Exception e){

        }

    }
}
