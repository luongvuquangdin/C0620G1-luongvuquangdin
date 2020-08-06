package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int index;
        double sum=0;
        do {
            System.out.print("Nhập Size của ma trận vuông: ");
            index=scanner.nextInt();
        }while (index<=0);
//Tạo mảng 2 chiều để lưu giá trị của ma trận
        double[][] arr= new double[index][index];
        for (int i=0;i<index;i++){
            arr[i]=new double[index];
            for (int j=0;j<index;j++){
                System.out.printf("Giá trị ở vị trí [%d][%d]: ",i,j);
                arr[i][j]=scanner.nextDouble();
            }
        }
        for (int i=0;i<index;i++){
            sum+=arr[i][i]+arr[i][arr.length-(i+1)];
        }
        System.out.println("Ma trận vừa nhập là:");
        for (double[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
        System.out.printf("Tổng các số của đường chéo chính là %-10.2f",sum);
    }
}
