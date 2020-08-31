package casestudy.furama_resort.controllers;

import casestudy.furama_resort.commons.Add;
import casestudy.furama_resort.commons.ReadFile;
import casestudy.furama_resort.commons.WriteFile;
import casestudy.furama_resort.models.*;

import java.util.*;

public class MainController {
    //Head
    private static final String HEAD = "Id, NameServices, Area,FeeServices, MaxNumberPeople, TypeRent";
    private static final String HEAD_VILLA = HEAD + ", Standard, TheFacility, AreaOfSwimmingPool, NumberOfFloor";
    private static final String HEAD_HOUSE = HEAD + ", Standard, TheFacility, NumberOfFloor";
    private static final String HEAD_ROOM = HEAD + ", FreeServices";
    private static final String HEAD_CUSTOMER = "NameOfCustomer, DayOfBirth, gender, Passport, PhoneNumber, Email, TypeOfCustomer, Address";
    //Link file
    private static final String FILE_VILLA = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Villa.csv";
    private static final String FILE_HOUSE = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\House.csv";
    private static final String FILE_ROOM = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Room.csv";
    private static final String FILE_CUSTOMER = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Customer.csv";
    //Object
    private static Villa villa;
    private static House house;
    private static Room room;
    private static Customer customer;
    //method nhap
    private static Scanner scanner = new Scanner(System.in);
    //List de hien thi
    private static List<Services> list = new ArrayList<>();
    private static List<Customer> listCustomer = new ArrayList<>();

    //    private static TreeMap<String,Services> tree=new TreeMap<>();
    public static void displayMainMenu() {
        villa = new Villa();
        house = new House();
        room = new Room();
        customer = new Customer();
        WriteFile.writerHead(FILE_CUSTOMER, HEAD_CUSTOMER);
        WriteFile.writerHead(FILE_VILLA, HEAD_VILLA);
        WriteFile.writerHead(FILE_HOUSE, HEAD_HOUSE);
        WriteFile.writerHead(FILE_ROOM, HEAD_ROOM);
        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Exit");
            System.out.print("Enter choose: ");
            String choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
                    break;
                case "3":
                    System.out.println("Input new Customer");
                    Add.inputCustomer(customer);
                    WriteFile.writerCustomer(FILE_CUSTOMER, customer);
                    break;
                case "4":
                    listCustomer = ReadFile.getAllCustomer(FILE_CUSTOMER);
                    Collections.sort(listCustomer);
                    for (Customer customer_1 : listCustomer) {
                        customer_1.showInformation();
                    }
                    listCustomer.clear();
                    break;
                case "5":
                    addNewBooking();
                    break;
                case "6":
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu don't have your choose");
                    break;
            }
        }
    }

    public static void addNewServices() {
        boolean loop = true;
        while (loop) {
            System.out.println("MENU ADD NEW SERVICES:");
            System.out.println("1. Add New Villa\n" +
                    "2. Add New House\n" +
                    "3. Add New Room\n" +
                    "4. Back to Menu\n" +
                    "5. Exit\n");
            System.out.print("Enter choose: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Input New Villa: ");
                    Add.inputVilla(villa);
                    WriteFile.writerServices(FILE_VILLA, villa);
                    break;
                case "2":
                    System.out.println("Input New House: ");
                    Add.inputHouse(house);
                    WriteFile.writerServices(FILE_HOUSE, house);
                    break;
                case "3":
                    System.out.println("Input New Room: ");
                    Add.inputRoom(room);
                    WriteFile.writerServices(FILE_ROOM, room);
                    break;
                case "4":
                    loop = false;
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu don't have your choose");
                    break;
            }
        }
    }

    //
//
//
    //Show Services
    private static void showServices() {
        boolean loop = true;
        while (loop) {
            System.out.println("MENU SHOW SERVICES:");
            System.out.println("1. Show all Villa\n" +
                    "2. Show all House\n" +
                    "3. Show all Room\n" +
                    "4. Show all Name Villa not Duplicate\n" +
                    "5. Show all Name House not Duplicate\n" +
                    "6. Show all Name Room not Duplicate\n" +
                    "7. Back to menu\n" +
                    "8. Exit\n");
            System.out.print("Enter choose: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    list = ReadFile.getAllVilla(FILE_VILLA);
                    for (Services services : list) {
                        services.showInformation();
                    }
                    list.clear();
                    break;
                case "2":
                    list = ReadFile.getAllHouse(FILE_HOUSE);
                    for (Services services : list) {
                        services.showInformation();
                    }
                    list.clear();
                    break;
                case "3":
                    list = ReadFile.getAllRoom(FILE_ROOM);
                    for (Services services : list) {
                        services.showInformation();
                    }
                    list.clear();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    loop = false;
                    break;
                case "8":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu don't have your choose");
                    break;
            }
        }
    }

    private static void addNewBooking() {
        System.out.println("List Customer:");
        //Lấy danh sách Customer
        listCustomer = ReadFile.getAllCustomer(FILE_CUSTOMER);
        //Sắp xếp
        Collections.sort(listCustomer);
        //Hiển thị theo thứ tự
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ": ");
            listCustomer.get(i).showInformation();
        }
        //Chọn Customer để booking
        System.out.print("Choose Customer: ");
        String choose = scanner.nextLine();
        customer = listCustomer.get(Integer.parseInt(choose) - 1);
        //Hiển thị danh sách để
        System.out.println("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room");
        System.out.print("Choose Services: ");
        String choose_1 = scanner.nextLine();
        switch (choose) {
            case "1":
                list=ReadFile.getAllVilla(FILE_VILLA);
                for (int i=0;i<list.size();i++){
                    System.out.print((i+1)+": ");
                    list.get(i).showInformation();
                }
                list.clear();
                break;
            case "2":
                list=ReadFile.getAllHouse(FILE_HOUSE);
                for (int i=0;i<list.size();i++){
                    System.out.print((i+1)+": ");
                    list.get(i).showInformation();
                }
                list.clear();
                break;
            case "3":
                list=ReadFile.getAllRoom(FILE_ROOM);
                for (int i=0;i<list.size();i++){
                    System.out.print((i+1)+": ");
                    list.get(i).showInformation();
                }
                list.clear();
                break;
        }

        listCustomer.clear();
    }
}

