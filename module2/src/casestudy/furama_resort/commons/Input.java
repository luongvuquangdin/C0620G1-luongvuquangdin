package casestudy.furama_resort.commons;

import casestudy.furama_resort.Exception.*;
import casestudy.furama_resort.models.*;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    private static void input(Services name) {
        //Nhập tên dịch vụ Chữ đầu hoa chữ sau thường
        String nameServices = null;
        do {
            System.out.print("Enter nameServices: ");
            nameServices = scanner.nextLine();
        } while (!nameServices.matches("^[A-Z][a-z\\d]+$"));
        name.setNameServices(nameServices);

        //Nhập diện tích sử dụng là số thực lớn hơn 30m2
        double area = 0.0;
        do {
            System.out.print("Enter area: (area>30.0)");
            area = Double.parseDouble(scanner.nextLine());
        } while (!String.valueOf(area).matches("^(([3-9]\\d*(\\.\\d+)?)|([1-3]\\d{2,}(\\.\\d+)?))$"));
        name.setArea(area);

        //Chi phí phải trả là số dương
        double feeServices = 0.0;
        do {
            System.out.print("Enter feeServices: (feeServices>0)");
            feeServices = Double.parseDouble(scanner.nextLine());
        } while (!String.valueOf(feeServices).matches("^([1-9]\\d*)(\\.\\d+)?$"));
        name.setFeeServices(feeServices);

        //Số người tối đa là số nguyên dương
        int maxNumberPeople = 0;
        do {
            System.out.print("Enter maxNumberPeople (0<maxNumberPeople<20): ");
            maxNumberPeople = Integer.parseInt(scanner.nextLine());
        } while (!String.valueOf(maxNumberPeople).matches("^(([1-9])|(1\\d))$"));
        name.setMaxNumberPeople(maxNumberPeople);

        //Kiểu thuê Phải ghi hoa chữ cái đầu.Còn lại là ký tự thường
        String typeRent = null;
        do {
            System.out.print("Enter typeRent: ");
            typeRent = scanner.nextLine();
        } while (!typeRent.matches("^[A-Z][a-z]+$"));
        name.setTypeRent(typeRent);
    }

    //Input class
    public static void inputVilla(Villa name) {
        //Id SVXX-YY
        String id = null;
        do {
            System.out.print("Enter id (SVVL-YYYY): ");
            id = scanner.nextLine();
        } while (!id.matches("^(SVVL-)\\d{4}$"));
        name.setId(id);

        input(name);

        System.out.print("Enter standard: ");
        String standard = scanner.nextLine();
        name.setStandard(standard);

        System.out.print("Enter theFacility: ");
        String theFacility = scanner.nextLine();
        name.setTheFacility(theFacility);

        //Diện tích hồ bơi là số thực và lớn hơn 30m2
        double areaOfSwimmingPool = 0.0;
        do {
            System.out.print("Enter areaOfSwimmingPool (area>30): ");
            areaOfSwimmingPool = Double.parseDouble(scanner.nextLine());
        } while (!String.valueOf(areaOfSwimmingPool).matches("^(([3-9][1-9]\\d*(\\.\\d+)?)|([1-3]\\d{2,}(\\.\\d+)?))$"));
        name.setAreaOfSwimmingPool(areaOfSwimmingPool);

        //Số tầng phải là số nguyên dương
        int numberOfFloor = 0;
        do {
            System.out.print("Enter numberOfFloor (numberOfFloor>0): ");
            numberOfFloor = Integer.parseInt(scanner.nextLine());
        } while (!String.valueOf(numberOfFloor).matches("^[1-9]+$"));
        name.setNumberOfFloor(numberOfFloor);
    }

    //Input House
    public static void inputHouse(House name) {
        //ID
        String id = null;
        do {
            System.out.print("Enter id (SVHO-YYYY): ");
            id = scanner.nextLine();

        } while (!id.matches("^(SVHO-)\\d{4}$"));
        name.setId(id);

        input(name);

        System.out.print("Enter standard : ");
        String standard = scanner.nextLine();
        name.setStandard(standard);

        System.out.print("Enter theFacility: ");
        String theFacility = scanner.nextLine();
        name.setTheFacility(theFacility);

        //Số tầng phải là số nguyên dương
        int numberOfFloor = 0;
        do {
            System.out.print("Enter numberOfFloor (numberOfFloor>0): ");
            numberOfFloor = Integer.parseInt(scanner.nextLine());
        } while (!String.valueOf(numberOfFloor).matches("^[1-9]+$"));
        name.setNumberOfFloor(numberOfFloor);
    }

    //Input Room
    public static void inputRoom(Room name) {
        //ID
        String id = null;
        do {
            System.out.print("Enter id (SVRO-YYYY): ");
            id = scanner.nextLine();
        } while (!id.matches("^(SVRO-)\\d{4}$"));
        name.setId(id);

        input(name);

        //Dịch vụ miễn phí đi kèm
        String freeServices = null;
        do {
            System.out.print("Enter freeServices (massage, karaoke, food, drink, car): ");
            freeServices = scanner.nextLine();
        } while (!freeServices.matches("^(massage|karaoke|food|drink|car)$"));
        name.setFreeServices(freeServices);
    }

    //Input Customer
    public static void inputCustomer(Customer name) {
        String nameOfCustomer;
        boolean loop=true;

        do {

            loop=true;
            System.out.print("Enter name: ");
            nameOfCustomer=scanner.nextLine();
            if (!nameOfCustomer.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}*)+$")){
                try {
                    throw new NameException();
                } catch (NameException e) {
                    System.out.println(e.getError());
                    loop=false;
                }
            }
        }while (!loop);
        name.setNameOfCustomer(nameOfCustomer);

        //Ngày sinh
        String dayOfBirth=null;
        do {
            loop=true;
            System.out.print("Enter BirthDay: ");
            dayOfBirth=scanner.nextLine();
            if (!dayOfBirth.matches("^((0[1-9])|(1\\d)|(2\\d)|(3[01]))/((0[1-9])|(1[12]))/((190[1-9])" +
                    "|(19[1-9]\\d)|(200[012]))$")){
                try {
                    throw new BirthdayException();
                } catch (BirthdayException e) {
                    System.out.println(e.getError());
                    loop=false;
                }
            }
        }while (!loop);
        name.setDayOfBirth(dayOfBirth);

        //Giới tính
        String gender;
        do {
            loop=true;
            System.out.print("Enter Gender: ");
            gender=scanner.nextLine();
            gender=gender.toLowerCase();
            String temp="";
            temp+=Character.toUpperCase(gender.charAt(0));
            for (int i=1;i<gender.length();i++){
                temp+=gender.charAt(i);
            }
            gender=temp;
            if (!gender.matches("^(Male|Female|Unknown)$")){
                try {
                    throw new GenderException();
                } catch (GenderException e) {
                    System.out.println(e.getError());
                    loop=false;
                }
            }
        }while (!loop);
        name.setGender(gender);


        //Chứng minh nhân dân
        String passport;
        do {
            loop=true;
            System.out.print("Enter PassPort: ");
            passport=scanner.nextLine();
            if (!passport.matches("^\\d{3}\\s\\d{3}\\s\\d{3}$")){
                try {
                    throw new IdCardException();
                } catch (IdCardException e) {
                    System.out.println(e.getError());
                    loop=false;
                }
            }
        }while (!loop);
        name.setPassport(passport);

        //Số điện thoại
        System.out.print("Enter Phone Number: ");
        String phoneNumber;
        phoneNumber=scanner.nextLine();
        name.setPhoneNumber(phoneNumber);

        //Email
        String email;
        do {
            loop=true;
            System.out.print("Enter Email: ");
            email=scanner.nextLine();
            if (!email.matches("^\\w+@\\w+\\.\\w+$")){
                try {
                    throw new EmailException();
                } catch (EmailException e) {
                    System.out.println(e.getError());
                    loop=false;
                }
            }
        }while (!loop);
        name.setEmail(email);

        //Loại khách hàng
        System.out.print("Enter Type Of Customer: ");
        String typeOfCustomer;
        typeOfCustomer=scanner.nextLine();
        name.setTypeOfCustomer(typeOfCustomer);

        //Địa chỉ
        System.out.print("Enter Address: ");
        String address;
        address=scanner.nextLine();
        name.setAddress(address);
    }
}
