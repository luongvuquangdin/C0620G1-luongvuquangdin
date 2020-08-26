package io_binary_file_serialization.bai_tap.quan_ly;

import java.io.IOException;
import java.util.Scanner;

public class MainProduct {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file source name: ");
        String file = scanner.nextLine();
        Management management = new Management(file);
        boolean reset = true;
        while (reset) {
            Thread.sleep(500);
            System.out.println("Menu chose product");
            System.out.println("1 . Add product");
            System.out.println("2 . Display product");
            System.out.println("3 . Search product");
            System.out.println("4 . Exit");
            System.out.print("Enter your chose: ");
            int chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    try {
                        management.add(id, name, manufacturer, price);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    try {
                        management.display();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    Scanner src = new Scanner(System.in);
                    System.out.print("Enter name to find :");
                    String string = src.nextLine();
                    try {
                        management.find(string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your chose are Error");
                    break;
            }
        }
    }
}
