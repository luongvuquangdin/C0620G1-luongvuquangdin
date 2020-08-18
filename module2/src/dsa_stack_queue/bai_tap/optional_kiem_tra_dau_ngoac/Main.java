package dsa_stack_queue.bai_tap.optional_kiem_tra_dau_ngoac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Nhập một đoạn muốn kiểu tra
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expression you want to check bracket : ");
        //Kiểm tra cặp dấu ngoặc
        String string = sc.nextLine();
        CheckBracket.checkBracket(string);
    }
}
