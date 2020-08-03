package introduction_to_java;

import java.util.Scanner;

public class CountDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tháng muốn biết số ngày: ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 11:
                System.out.println("Tháng " + month + " có 31 ngày");
                break;
            case 2:
                System.out.println(" tháng 2 có 28 hoặc 29 ngày tùy theo năm nhuận hay không");
                break;
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 30 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
                break;
        }
    }
}
