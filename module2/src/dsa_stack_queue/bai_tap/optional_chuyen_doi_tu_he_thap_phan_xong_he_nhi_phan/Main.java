package dsa_stack_queue.bai_tap.optional_chuyen_doi_tu_he_thap_phan_xong_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Convert Decimal to Binary");
        System.out.println("---------------------------");
        //Nhập số hệ thập phân muốn chuyển đổi
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number decimal : ");
        int decimal = sc.nextInt();
        DecimalToBinary.decimalToBinary(decimal);


    }
}
