package introduction_to_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên muốn đọc: ");
        short number = scanner.nextShort();
        String read="" , read1="", read2="";
//Trường hợp có 1 chữ số
        if (number < 10 && number > 0) {
            switch (number) {
                case 1:
                    read = "one";
                    break;
                case 2:
                    read = "two";
                    break;
                case 3:
                    read = "three";
                    break;
                case 4:
                    read = "four";
                    break;
                case 5:
                    read = "five";
                    break;
                case 6:
                    read = "six";
                    break;
                case 7:
                    read = "seven";
                    break;
                case 8:
                    read = "eight";
                    break;
                case 9:
                    read = "nine";
                    break;
            }
//Trường hợp có 2 chữ số nhỏ hơn 20
        } else if (number < 20) {
            switch (number) {
                case 10:
                    read = "ten";
                    break;
                case 11:
                    read = "eleven";
                    break;
                case 12:
                    read = "twelve";
                    break;
                case 13:
                    read = "thirteen";
                    break;
                case 14:
                    read = "fourteen";
                    break;
                case 15:
                    read = "fifteen";
                    break;
                case 16:
                    read = "sixteen";
                    break;
                case 17:
                    read = "seventeen";
                    break;
                case 18:
                    read = "eightteen";
                    break;
                case 19:
                    read = "nineteen";
                    break;
            }
        } else if (number < 1000) {
            int number1 = number % 10;
            int number2 = ((number % 100) - number1) / 10;
            int number3 = number / 100;
            switch (number1) {
                case 0:
                    read1 = "";
                    break;
                case 1:
                    read1 = "one";
                    break;
                case 2:
                    read1 = "two";
                    break;
                case 3:
                    read1 = "three";
                    break;
                case 4:
                    read1 = "four";
                    break;
                case 5:
                    read1 = "five";
                    break;
                case 6:
                    read1 = "six";
                    break;
                case 7:
                    read1 = "seven";
                    break;
                case 8:
                    read1 = "eight";
                    break;
                case 9:
                    read1 = "nine";
                    break;
            }
            switch (number2) {
                case 0:
                    read2 = "";
                    break;
                case 2:
                    read2 = "twenty " + read1;
                    break;
                case 3:
                    read2 = "thirty " + read1;
                    break;
                case 4:
                    read2 = "forty " + read1;
                    break;
                case 5:
                    read2 = "fifty " + read1;
                    break;
                case 6:
                    read2 = "sixty " + read1;
                    break;
                case 7:
                    read2 = "seventy " + read1;
                    break;
                case 8:
                    read2 = "eightty " + read1;
                    break;
                case 9:
                    read2 = "ninety " + read1;
                    break;
            }
            switch (number3) {
                case 0:
                    read = read2;
                    break;
                case 1:
                    read = "one hundred " + read2;
                    break;
                case 2:
                    read = "two hundred " + read2;
                    break;
                case 3:
                    read = "three hundred " + read2;
                    break;
                case 4:
                    read = "four hundred " + read2;
                    break;
                case 5:
                    read = "five hundred " + read2;
                    break;
                case 6:
                    read = "six hundred " + read2;
                    break;
                case 7:
                    read = "seven hundred " + read2;
                    break;
                case 8:
                    read = "eight hundred " + read2;
                    break;
                case 9:
                    read = "nine hundred " + read2;
                    break;
            }
        }else {
            System.out.println("out of ability");
        return;}
        System.out.println("Read "+number+" is "+ read);
    }
}
