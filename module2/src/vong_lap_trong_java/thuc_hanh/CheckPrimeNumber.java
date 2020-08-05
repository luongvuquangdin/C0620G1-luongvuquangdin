package vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập nguyên muốn kiểm tra là số nguyên tố: ");
        long number=sc.nextLong();
        // Nếu nhỏ hơn 2 thì không phải số nguyên tố
        if (number < 2)
            System.out.println(number + " is not a prime");
        else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " is a prime");
            else
                System.out.println(number + " is not a prime");
        }
    }
}
