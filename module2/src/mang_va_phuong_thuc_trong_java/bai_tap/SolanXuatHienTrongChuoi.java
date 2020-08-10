package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SolanXuatHienTrongChuoi {

    public static void main(String[] args) {
        String chuoi="Tôi tên là Nguyễn Thị A";
        int chieuDai=chuoi.length();
        int dem=0;
        Scanner nhap=new Scanner(System.in);
        System.out.print("Nhập ký tự muốn tìm");
        char kyTu=nhap.next().charAt(0);
        for (int index=0;index<chieuDai;index++){
            char kyTu1=chuoi.charAt(index);
            if (kyTu1==kyTu){
                dem++;
            }
        }
        System.out.println("Chuỗi ban đầu là "+chuoi);
        if (dem==0){
            System.out.printf("Ký tự \"%c\" không có trong chuỗi \"%s\"",kyTu,chuoi);
        }else
        System.out.printf("Số lần xuất hiện của \"%c\" trong chuỗi \"%s\" là\n%d",kyTu,chuoi,dem);
    }
}
