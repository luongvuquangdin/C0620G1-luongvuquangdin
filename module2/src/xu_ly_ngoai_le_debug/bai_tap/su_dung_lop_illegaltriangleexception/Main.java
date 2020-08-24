package xu_ly_ngoai_le_debug.bai_tap.su_dung_lop_illegaltriangleexception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Chương trình kiểm tra xem ba cạnh nhập vào có phải là một tam giác hay không");
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập vào cạnh a= ");
        double a = nhap.nextDouble();
        System.out.print("Nhập vào cạnh b= ");
        double b = nhap.nextDouble();
        System.out.print("Nhập vào cạnh c= ");
        double c = nhap.nextDouble();
        try{
            Triangle triangle=new Triangle(a,b,c);
        }catch (IllegalTriangleException e){
            System.err.println(e.getMessage());
        }
    }
}
