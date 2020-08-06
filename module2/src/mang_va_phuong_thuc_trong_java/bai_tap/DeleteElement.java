package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,6,5,4,3,2,1};
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập phần tử muốn xóa: ");
        int number=sc.nextInt();
        System.out.println("Phần từ trong mảng: ");
        for (int index: array){
            System.out.printf("%-5d",index);
        }
        int check=deleteElement(array,number);
        if (check==0){
            System.out.println("\nkhông có phần tử "+number+" trong mảng");
        }else {
            System.out.println("\nMảng sau khi đã xóa phần tử " + number);
            for (int index : array) {
                System.out.printf("%-5d", index);
            }
        }
    }
    public static int deleteElement(int[] arr, int number) {
        int size = arr.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (number == arr[i]) {
                count++;
                for (int j = i; j < size-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[size-1]=0;
                i--;
            }
        }
        if (count != 0) {
            return 1;
        }else return 0;
    }
}
