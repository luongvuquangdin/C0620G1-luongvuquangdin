package introduction_to_java;
import java.util.Scanner;
public class CheckLeapYear {
    public static void main(String[] args) {
        boolean isLeapYear = false;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập năm muốn kiểm tra năm nhuận: ");
        int year=scanner.nextInt();
        boolean isDivisibleBy4 = year % 4 == 0;
        if(isDivisibleBy4){
            boolean isDivisibleBy100 = year % 100 == 0;
            if(isDivisibleBy100){
                boolean isDivisibleBy400 = year % 400 == 0;
                if(isDivisibleBy400){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d là năm nhuận", year);
        } else {
            System.out.printf("%d không phải là năm nhuận", year);
        }

    }
}
