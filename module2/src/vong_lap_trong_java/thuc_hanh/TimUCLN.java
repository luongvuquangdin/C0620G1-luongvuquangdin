package vong_lap_trong_java.thuc_hanh;
import java.util.Scanner;
public class TimUCLN {
    public static void main(String[] args) {
        int number1;
        int number2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number1= ");
        number1 = input.nextInt();
        System.out.print("Enter number2= ");
        number2 = input.nextInt();
        //Lấy giá trị dương
        number1=Math.abs(number1);
        number2=Math.abs(number2);
        //Nếu a và b là số 0
        System.out.printf("Hai số đã nhập là number1=%d và number2=%d\n",number1,number2);
        if (number1==0 && number2==0){
            System.out.println("Không có số ước chung lớn nhất");
        }else {
            while (number1 != number2) {
                if (number1 > number2)
                    number1 = number1 - number2;
                else
                    number2 = number2 - number1;
            }
        }
        System.out.println("Ước chung lớn nhất là " + number1);
    }
}
