package casestudy.furama_resort.controllers;

import casestudy.furama_resort.commons.*;
import casestudy.furama_resort.models.*;
import casestudy.furama_resort.views.ShowCinemaCustomer;
import casestudy.furama_resort.views.ShowCustomer;
import casestudy.furama_resort.views.ShowEmployee;
import casestudy.furama_resort.views.ShowServices;

import java.util.*;

public class MainController {
    //Head
    private static final String HEAD = "Id, NameServices, Area,FeeServices, MaxNumberPeople, TypeRent";
    private static final String HEAD_VILLA = HEAD + ", Standard, TheFacility, AreaOfSwimmingPool, NumberOfFloor";
    private static final String HEAD_HOUSE = HEAD + ", Standard, TheFacility, NumberOfFloor";
    private static final String HEAD_ROOM = HEAD + ", FreeServices";
    private static final String HEAD_CUSTOMER = "NameOfCustomer, DayOfBirth, gender, Passport, PhoneNumber, Email, TypeOfCustomer, Address";
    private static final String HEAD_BOOKING = HEAD_CUSTOMER + ",Services";
    //Link file
    private static final String FILE_VILLA = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Villa.csv";
    private static final String FILE_HOUSE = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\House.csv";
    private static final String FILE_ROOM = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Room.csv";
    private static final String FILE_CUSTOMER = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Customer.csv";
    private static final String FILE_BOOKING = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Booking.csv";
    private static final String FILE_EMPLOYESS = "D:\\New folder\\C0620G1-luongvuquangdin\\module2\\src\\casestudy\\furama_resort\\data\\Employee.csv";
    //Object
    private static Villa villa;
    private static House house;
    private static Room room;
    private static Customer customer;
    //Số vé xem phim
    private static int ticket=4;
    //method nhap
    private static Scanner scanner = new Scanner(System.in);
    //List để lưu Services
    private static List<Services> list = new ArrayList<>();
    //List để lư Customer
    private static List<Customer> listCustomer = new ArrayList<>();
    //Map để lưu Name và Services để hiển thị không trùng tên
    private static Map<String, Services> treeMap = new TreeMap<>();
    //Map để lưu Id và Employee
    private static Map<String, Employee> linkedHashMap = new LinkedHashMap<>();
    //Queue để lưu những Customer đặt vé xem phim
    private static Queue<Customer> cinemaCustomer=new ArrayDeque<>();
    //Tử hồ sơ để lưu nhân viên
    private static FileCabinets fileCabinest=new FileCabinets();



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
                    "7. Search Employee with Id\n"+
                    "8. Exit");
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
                    Input.inputCustomer(customer);
                    WriteFile.writerCustomer(FILE_CUSTOMER, customer);
                    break;
                case "4":
                    listCustomer = ReadFile.getAllCustomer(FILE_CUSTOMER);
                    ShowCustomer.show(listCustomer);
                    listCustomer.clear();
                    break;
                case "5":
                    addNewBooking();
                    break;
                case "6":
                    linkedHashMap = ReadNameFileNotDuplicate.readEmployee(FILE_EMPLOYESS);
                    ShowEmployee.show(linkedHashMap);
                    linkedHashMap.clear();
                    break;
                case "7":
                    fileCabinest.add(ReadFile.readEmployee(FILE_EMPLOYESS));
                    String id=null;
                    do {
                        System.out.print("Insert Id you want to search: (XXX example: 001)");
                        id=scanner.nextLine();
                    }while (!id.matches("^\\d{3}$"));
                    fileCabinest.search(id);
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
                    Input.inputVilla(villa);
                    WriteFile.writerServices(FILE_VILLA, villa);
                    break;
                case "2":
                    System.out.println("Input New House: ");
                    Input.inputHouse(house);
                    WriteFile.writerServices(FILE_HOUSE, house);
                    break;
                case "3":
                    System.out.println("Input New Room: ");
                    Input.inputRoom(room);
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
                    ShowServices.show(list);
                    list.clear();
                    break;
                case "2":
                    list = ReadFile.getAllHouse(FILE_HOUSE);
                    ShowServices.show(list);
                    list.clear();
                    break;
                case "3":
                    list = ReadFile.getAllRoom(FILE_ROOM);
                    ShowServices.show(list);
                    list.clear();
                    break;
                case "4":
                    treeMap = ReadNameFileNotDuplicate.readVilla(FILE_VILLA);
                    for (Map.Entry<String, Services> entry : treeMap.entrySet()) {
                        System.out.println(entry.toString());
                    }
                    treeMap.clear();
                    break;
                case "5":
                    treeMap = ReadNameFileNotDuplicate.readHouse(FILE_HOUSE);
                    for (Map.Entry<String, Services> entry : treeMap.entrySet()) {
                        System.out.println(entry.toString());
                    }
                    treeMap.clear();
                    break;
                case "6":
                    treeMap = ReadNameFileNotDuplicate.readRoom(FILE_ROOM);
                    for (Map.Entry<String, Services> entry : treeMap.entrySet()) {
                        System.out.println(entry.toString());
                    }
                    treeMap.clear();
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
        customer = ChooseCustomer.chooseCustomer(FILE_CUSTOMER);
        String choose = null;
        boolean loop = true;
        while (loop) {
            System.out.println("1. Booking Services\n" +
                    "2. Booking Cinema Ticket\n" +
                    "3. Back Menu\n" +
                    "4. Exit");
            System.out.print("Enter choose: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    bookingServices();
                    loop=false;
                    break;
                case "2":
                    bookingCinemaTicket();
                    loop=false;
                    break;
                case "3":
                    loop=false;
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu don't have your choose");
                    break;
            }
        }


    }

    private static void bookingServices() {
        WriteFile.writerHead(FILE_BOOKING, HEAD_BOOKING);
        boolean loop = true;
        String choose_1=null;
        //Hiển thị danh sách để Booking Services
        while (loop) {
            System.out.println("1. Booking Villa\n" +
                    "2. Booking House\n" +
                    "3. Booking Room\n" +
                    "4. Back Menu\n" +
                    "5. Exit");
            System.out.print("Choose Services: ");
            choose_1 = scanner.nextLine();
            String choose_2 = null;
            switch (choose_1) {
                case "1":
                    //Hiển thị danh sách Villa
                    list = ReadFile.getAllVilla(FILE_VILLA);
                    ShowServices.show(list);
                    //Chọn Villa
                    choose_2 = scanner.nextLine();
                    villa = (Villa) list.get(Integer.parseInt(choose_2) - 1);
                    //Lưu Villa cho Customer
                    customer.setServices(villa);
                    //Ghi customer Cùng với Services vào booking
                    WriteFile.writerBooking(FILE_BOOKING, customer);
                    list.clear();
                    loop=false;
                    break;
                case "2":
                    //Hiển thị danh sách House
                    list = ReadFile.getAllHouse(FILE_HOUSE);
                    ShowServices.show(list);
                    //Chọn House
                    choose_2 = scanner.nextLine();
                    house = (House) list.get(Integer.parseInt(choose_2) - 1);
                    //Lưu House cho Customer
                    customer.setServices(house);
                    //Ghi customer Cùng với Services vào booking
                    WriteFile.writerBooking(FILE_BOOKING, customer);
                    list.clear();
                    loop=false;
                    break;
                case "3":
                    //Hiển thị danh sách Room
                    list = ReadFile.getAllRoom(FILE_ROOM);
                    ShowServices.show(list);
                    //Chọn Room
                    choose_2 = scanner.nextLine();
                    room = (Room) list.get(Integer.parseInt(choose_2) - 1);
                    //Lưu Room cho Customer
                    customer.setServices(room);
                    //Ghi customer Cùng với Services vào booking
                    WriteFile.writerBooking(FILE_BOOKING, customer);
                    list.clear();
                    loop=false;
                    break;
                case "4":
                    loop=false;
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu don't have your choose");
                    break;
            }
            listCustomer.clear();
        }
    }


    private static void bookingCinemaTicket(){
        if (ticket>0) {
            cinemaCustomer.add(customer);
            ticket--;
        }else ShowCinemaCustomer.show(cinemaCustomer);
    }
}

