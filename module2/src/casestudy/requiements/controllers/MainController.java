package casestudy.requiements.controllers;

import casestudy.requiements.models.House;
import casestudy.requiements.models.Room;
import casestudy.requiements.models.Services;
import casestudy.requiements.models.Villa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class MainController {
    private static final String HEAD="Id,NameServices,Area,FeeServices,MaxNumberPeople,TypeRent";
    private static final String HEADVILLA=HEAD+",Standard,TheFacility,AreaOfSwimmingPool,NumberOfFloor";
    private static final String HEADHOUSE=HEAD+",Standard,TheFacility,NumberOfFloor";
    private static final String HEADROOM=HEAD+",FreeServices";
    private static final String COMMA=",";
    private static final String ENTER="\n";
    private static Villa villa;
    private static House house;
    private static Room room;
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        writerHead(new File("Villa.csv"),HEADVILLA);
        writerHead(new File("House.csv"),HEADHOUSE);
        writerHead(new File("Room.csv"),HEADROOM);

        displayMainMenu();

    }
    private static void displayMainMenu(){
        System.out.println("MENU:");
        System.out.println("1. Add New Services\n"+
        "2. Show Services\n"+
        "3. Add New Customer\n"+
        "4. Show Information of Customer\n"+
        "5. Add New Booking\n"+
        "6. Show Information of Employee\n"+
        "7. Exit");
        System.out.print("Enter choose: ");
        int choose=Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                addNewServices();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }
    }

    private static void addNewServices(){
        System.out.println("MENU ADD NEW SERVICES:");
        System.out.println("1. Add New Villa\n"+
                "2. Add New House\n"+
                "3. Add New Room\n"+
                "4. Back to Menu\n"+
                "5. Exit\n");
        System.out.println("Enter choose: ");
        int choose=Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1:
                villa=new Villa();
                System.out.println("Enter New Villa: ");
                inputVilla(villa);
                writer("Villa.csv",villa);
                break;
            case 2:
                house=new House();
                System.out.println("Enter New House: ");
                inputHouse(house);
                writer("House.csv",house);
                break;
            case 3:
                room=new Room();
                System.out.println("Enter New Room: ");
                inputRoom(room);
                writer("Room.csv",room);
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private static void writerHead(File file,String str) {
        if (file.length() == 0) {
            FileWriter writer = null;
            BufferedWriter bufferedWriter = null;
            StringBuilder string = null;
            try {
                //Mở file để ghi
                writer = new FileWriter(file);
                bufferedWriter = new BufferedWriter(writer);

                //Tạo ra một chuỗi để ghi vào file
                string = new StringBuilder();
                string = string.append(str).append("\n");

                //Ghi File
                bufferedWriter.write(string.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //Đóng file
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    //Ham Ghi file
    private static void writer(String file,Services name){
        FileWriter writer=null;
        BufferedWriter bufferedWriter=null;
        StringBuilder string=null;
        try {
            //Mở file để ghi
            writer=new FileWriter(file,true);
            bufferedWriter=new BufferedWriter(writer);

            //Tạo ra một chuỗi để ghi vào file
            string=new StringBuilder();
            string=string.append(name.toString()).append("\n");

            //Ghi File
            bufferedWriter.write(string.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //Đóng file
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }

    //Input Room
    public static void inputRoom(Room name){
        System.out.print("Enter id: ");
        String id=scanner.nextLine();
        name.setId(id);

        input(name);

        System.out.print("Enter freeServices: ");
        String freeServices=scanner.nextLine();
        name.setFreeServices(freeServices);
    }

    //Input House
    private static void inputHouse(House name){
        System.out.print("Enter id: ");
        String id=scanner.nextLine();
        name.setId(id);

        input(name);

        System.out.print("Enter standard: ");
        String standard=scanner.nextLine();
        name.setStandard(standard);

        System.out.print("Enter theFacility: ");
        String theFacility=scanner.nextLine();
        name.setTheFacility(theFacility);

        System.out.print("Enter numberOfFloor: ");
        int numberOfFloor=Integer.parseInt(scanner.nextLine());
        name.setNumberOfFloor(numberOfFloor);
    }

    //Input Villa
    private static void inputVilla(Villa name){
        System.out.print("Enter id: ");
        String id=scanner.nextLine();
        name.setId(id);

        input(name);

        System.out.print("Enter standard: ");
        String standard=scanner.nextLine();
        name.setStandard(standard);

        System.out.print("Enter theFacility: ");
        String theFacility=scanner.nextLine();
        name.setTheFacility(theFacility);

        System.out.print("Enter areaOfSwimmingPool: ");
        double areaOfSwimmingPool=Double.parseDouble(scanner.nextLine());
        name.setAreaOfSwimmingPool(areaOfSwimmingPool);

        System.out.print("Enter numberOfFloor: ");
        int numberOfFloor=Integer.parseInt(scanner.nextLine());
        name.setNumberOfFloor(numberOfFloor);
    }

    //Input
    private static void input(Services name){
        System.out.print("Enter nameServices: ");
        String nameServices=null;
        nameServices=scanner.nextLine();
        name.setNameServices(nameServices);


        System.out.print("Enter area: ");
        double area=Double.parseDouble(scanner.nextLine());
        name.setArea(area);

        System.out.print("Enter feeServices: ");
        double feeServices=Double.parseDouble(scanner.nextLine());
        name.setFeeServices(feeServices);

        System.out.print("Enter maxNumberPeople: ");
        int maxNumberPeople=Integer.parseInt(scanner.nextLine());
        name.setMaxNumberPeople(maxNumberPeople);

        System.out.print("Enter typeRent: ");
        String typeRent=scanner.nextLine();
        name.setTypeRent(typeRent);
    }

}
