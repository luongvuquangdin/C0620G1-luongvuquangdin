package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SearchMax {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int rows;
        do {
            System.out.print("Nhập vào số dòng của ma trận: ");
            rows=scanner.nextInt();
        }while (rows<1);
        int cols;
        do {
            System.out.print("Nhập vào số cột của ma trận: ");
            cols=scanner.nextInt();
        }while (cols<1);
//Tạo mảng 2 chiều để lưu giá trị của ma trận
        double[][] arrDouble= new double[cols][rows];
        for (int index=0;index<arrDouble.length;index++){
            arrDouble[index]=new double[rows];
            for (int index1=0;index1<arrDouble[index].length;index1++){
                System.out.printf("Giá trị ở vị trí [%d][%d]: ",index,index1);
                arrDouble[index][index1]=scanner.nextDouble();
            }
        }
//Tìm max trong mảng 2 chiều
        double max=arrDouble[0][0];
        int indexCols=0,indexRows=0;
        for (int index=0;index<arrDouble.length;index++){
            for (int index1=0;index1<arrDouble[index].length;index1++){
               if (max<arrDouble[index][index1]){
                   max=arrDouble[index][index1];
                   indexCols=index1;
                   indexRows=index;
               }
            }
        }
        System.out.println("Ma trận vừa nhập là:");
        for (double[] index : arrDouble) {
            System.out.println(Arrays.toString(index));
        }
        System.out.printf("Giá trị lớn nhất là %-10.2f",max);
        System.out.printf("\nNằm ở vị trí [%d][%d]",indexRows,indexCols);
    }
}
