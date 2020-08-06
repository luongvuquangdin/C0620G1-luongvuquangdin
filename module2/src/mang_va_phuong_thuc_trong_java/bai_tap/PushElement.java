package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class PushElement {
    public static void main(String[] args) {
        int[] number= new int[]{10,4,6,7,8,0,0,0,0,0};
        String arrNumber= Arrays.toString(number);
        System.out.println("Mảng ban đầu Array="+arrNumber);
        System.out.println();
        int length=number.length;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập giá trị số nguyên muốn thêm vào mảng: ");
        int number1=sc.nextInt();
        System.out.print("\nNhập vị trí muốn thêm giá trị: ");
        int index=sc.nextInt();
        if (index>=length-1||index<0){
            System.out.println("\nkhông có vị trí ");
            System.exit(0);
        }else {
            /*
             for (int i=length-1;i>index;i--){
                number[i]=number[i-1];
            }
            number[index]=number1;
             */
            System.arraycopy(number, index, number, index + 1, length - 1 - index);
            number[index]=number1;
        }
        System.out.println("Mảng sau khi thêm phần tử "+ number1 +" ở vị trí "+index+":");
        System.out.println("new Array="+Arrays.toString(number));
    }
}
