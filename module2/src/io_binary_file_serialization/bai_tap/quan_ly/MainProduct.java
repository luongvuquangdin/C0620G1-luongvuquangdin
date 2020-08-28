package io_binary_file_serialization.bai_tap.quan_ly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainProduct {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        List<Product> list = new ArrayList<>();
        System.out.print("Enter file source name: ");
        String file = scanner.nextLine();
        Management management = new Management(file);
        boolean reset = true;
        while (reset) {
            Thread.sleep(500);
            menu();
            int chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                //add
                case 1:
                    management.add();
                    break;
                //Display
                case 2:
                    management.display();
                    break;
                //Search
                case 3:
                    System.out.print("Enter name you want to search: ");
                    String name = scanner.nextLine();
                    management.Search(name);
                    break;
                //Exit
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your chose are Error");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Menu chose product");
        System.out.println("1 . Add product");
        System.out.println("2 . Display product");
        System.out.println("3 . Search product");
        System.out.println("4 . Exit");
        System.out.print("Enter your chose: ");
    }
}
