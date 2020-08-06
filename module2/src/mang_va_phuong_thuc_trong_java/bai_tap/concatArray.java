package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class concatArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Mảng thứ nhất
        System.out.print("Nhập số phẩn tử của mảng thứ nhất: ");
        int length1,length2,length3;
        do {
            length1 = scanner.nextInt();
        } while (length1 <= 0);
        int[] arr1 = new int[length1];
        for (int index = 0; index < length1; index++) {
            System.out.print("Element " + index + ":");
            arr1[index] = scanner.nextInt();
        }
//Mảng thứ 2
        System.out.print("Nhập số phẩn tử của mảng thứ hai: ");
        do {
            length2 = scanner.nextInt();
        } while (length2 <= 0);
        int[] arr2 = new int[length2];
        for (int index = 0; index < length2; index++) {
            System.out.print("Element " + index + ":");
            arr2[index] = scanner.nextInt();
        }
//Mảng thứ 3 là mảng gộp của hai mảng thứ nhất và mảng thứ 2
        length3=length1+length2;
        int[] arr3=new int[length3];
        int i=0;
         for (int index = 0; index < length3; index++) {
            if (index>=length1){
                arr3[index] = arr2[i];
                i++;
                continue;
            }
             arr3[index] = arr1[index];
        }
        System.out.println("Array1= "+ Arrays.toString(arr1));
        System.out.println("Array2= "+ Arrays.toString(arr2));
        System.out.println("Array3=Array1 + Array2="+ Arrays.toString(arr3));
    }
}
