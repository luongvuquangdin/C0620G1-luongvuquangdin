package mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class CheckPass {
//Ứng dụng đếm số lượng sinh viên thi đỗ
    public static void main(String[] args) {
//Khai báo các biến, nhập và kiểm tra kích thước mảng
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);
//Nhập giá trị cho các phần tử của mảng
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
//Sử dụng vòng lặp for để in ra danh sách điểm vừa nhập, đồng thời đếm số lượng sinh viên thi đỗ
        int count = 0;
        System.out.print("List of mark: ");
        for (int value : array) {
            System.out.print(value + "\t");
            if (value >= 5 && value <= 10)
                count++;
        }
        System.out.print("\n The number of students passing the exam is " + count);
    }
}
