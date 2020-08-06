package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SearchMin {
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    int size;
    int[] arr;
        do {
            System.out.print("Nhập vào số phần tử của mảng: ");
            size=scanner.nextInt();
        }while (size<1);
    arr= new int[size];
    //Duyệt mảng để nhập phần tử của mảng
        System.out.println("Nhập giá trị của phần tử thứ :");
        for (int index=0;index<arr.length;index++){
            System.out.printf("[%d]: ",index);
            arr[index]=scanner.nextInt();
    }
    //Tìm min trong mảng
    int min=arr[0];
    int index=0;
        for (int index1=0;index1<arr.length;index1++){
            if (min>arr[index1]){
                min=arr[index1];
                index=index1;
            }
    }
        System.out.println("Ma trận vừa nhập là:"+Arrays.toString(arr));
        System.out.printf("Giá trị nhỏ nhất là %d",min);
        System.out.printf("\nNằm ở vị trí [%d]",index);
}
}
