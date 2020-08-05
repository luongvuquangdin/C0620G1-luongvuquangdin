package vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] args) {
        boolean check=true;
        int choice;
        while(check) {
            System.out.println("Menu");
            System.out.println("1. In hình chữ nhật.");
            System.out.println("2. In hình tam giác vuông.");
            System.out.println("3. In hình tam giác cân.");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("In hình chữ nhật.");
                    for (int index=0;index<3;index++){
                        for (int index1=0;index1<7;index1++){
                            System.out.print("*\t");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("In hình tam giác vuông.");
                    System.out.println("In hình tam giác vuông, có cạnh góc vuông ở botton-left");
                    for (int index=0;index<6;index++){
                        for (int index1=0;index1<=index;index1++){
                            System.out.print("*\t");
                        }
                        System.out.println();
                    }
                    System.out.println("In hình tam giác vuông, có cạnh góc vuông ở top-left");
                    for (int index=6;index>0;index--){
                        for (int index1=index;index1>0;index1--){
                            System.out.print("*\t");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("In hình tam giác cân");
                        for (int index=1;index<=7;index+=2){
                            for(int index1=((7-index)/2);index1>0;index1--){
                                System.out.print("\t");
                            }
                            for (int index2=0;index2<index;index2++){
                                System.out.print("*\t");
                            }
                            System.out.println();
                        }
                    break;
                case 4:
                    System.exit(0);
                    check=false;
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không có trong menu");
                    break;
            }
        }

    }
}
