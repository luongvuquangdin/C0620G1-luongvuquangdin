package mang_va_phuong_thuc_trong_java.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class SumCols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        do {
            System.out.print("Nhập vào số dòng của ma trận: ");
            rows = sc.nextInt();
        } while (rows < 1);
        int cols;
        do {
            System.out.print("Nhập vào số cột của ma trận: ");
            cols = sc.nextInt();
        } while (cols < 1);
//Tạo mảng 2 chiều để lưu giá trị của ma trận
        double[][] arrDouble = new double[cols][rows];
        for (int index = 0; index < arrDouble.length; index++) {
            arrDouble[index] = new double[rows];
            for (int index1 = 0; index1 < arrDouble[index].length; index1++) {
                System.out.printf("Giá trị ở vị trí [%d][%d]: ", index, index1);
                arrDouble[index][index1] = sc.nextDouble();
            }
        }
        int index;
        do {
            System.out.print("Tính tổng của ma trận ở cột thứ: ");
            index=sc.nextInt();
        }while (index<0);
        double sum=0;
        for (double[] element : arrDouble) {
            sum += element[index];
        }
        System.out.println("Ma trận vừa nhập là:");
        for (double[] element : arrDouble) {
            System.out.println(Arrays.toString(element));
        }
        System.out.printf("Tổng của cột thứ %d là: %f",index,sum);
    }
}
