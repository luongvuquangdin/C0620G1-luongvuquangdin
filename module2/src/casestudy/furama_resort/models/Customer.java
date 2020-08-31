package casestudy.furama_resort.models;

import javax.sound.midi.MidiFileFormat;

public class Customer implements Comparable<Customer>{
    //Tên Customer
    private String nameOfCustomer;
    //Ngày sinh
    private String dayOfBirth;
    //Giới tính
    private String gender;
    //Chứng minh nhân dân
    private String passport;
    //Số điện thoại
    private String phoneNumber;
    //Email
    private String email;
    //Loại khách hàng
    private String typeOfCustomer;
    //Địa chỉ
    private String address;
    //Sử dụng dịch vụ gì
    private Services services;

    public Customer(String nameOfCustomer, String dayOfBirth, String gender, String passport, String phoneNumber, String email
            , String typeOfCustomer, String address, Services services) {
        this.nameOfCustomer = nameOfCustomer;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.passport = passport;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.services = services;
    }

    public Customer(String nameOfCustomer, String dayOfBirth, String gender, String passport, String phoneNumber
            , String email, String typeOfCustomer, String address) {
        this.nameOfCustomer = nameOfCustomer;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.passport = passport;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public Customer() {
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInformation(){
        System.out.println( "nameOfCustomer= " + nameOfCustomer +
                ", dayOfBirth= " + dayOfBirth +
                ", gender= " + gender +
                ", passport= " + passport +
                ", phoneNumber= " + phoneNumber +
                ", email= " + email + '\'' +
                ", typeOfCustomer= " + typeOfCustomer +
                ", address= " + address);

    }

    @Override
    public String toString() {
        return nameOfCustomer + "," + dayOfBirth + "," + gender + "," + passport + "," + phoneNumber +
                "," + email + "," + typeOfCustomer + "," + address;
    }

    @Override
    public int compareTo(Customer o) {
        if (this.nameOfCustomer.equals(o.getNameOfCustomer())){
            //Lấy năm sinh
            String yearThis=this.dayOfBirth.substring(6,this.dayOfBirth.length());
            String yearO=o.dayOfBirth.substring(6,o.dayOfBirth.length());
            return yearThis.compareTo(yearO);
        }
        return this.nameOfCustomer.compareTo(o.getNameOfCustomer());
    }
}
