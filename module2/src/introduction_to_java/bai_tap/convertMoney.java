package introduction_to_java.bai_tap;

import java.util.Scanner;

public class convertMoney {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int rate=23000;
        System.out.print("Nhập số tiền USA muốn chuyển sang VND: ");
        long dola=scanner.nextLong();
        long vietNamD=rate*dola;
        System.out.printf("%d USD tương ứng với %d VND",dola,vietNamD);


    }
}
