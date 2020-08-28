package casestudy.requiements.models;

import java.util.Scanner;

public abstract class Services {
    //Id dich vu
    private String id;
    //Tên dịch vụ
    private String nameServices;
    //Diện tích sử dụng
    private double area;
    //Chi phí thuê
    private double feeServices;
    //Số người tối đa trong 1 phòng
    private int maxNumberPeople;
    //Kiểu thuê theo
    private String typeRent;

    public Services(){};

    public Services(String id, String nameServices, double area, double feeServices, int maxNumberPeople, String typeRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.area = area;
        this.feeServices = feeServices;
        this.maxNumberPeople = maxNumberPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getFeeServices() {
        return feeServices;
    }

    public void setFeeServices(double feeServices) {
        this.feeServices = feeServices;
    }

    public int getMaxNumberPeople() {
        return maxNumberPeople;
    }

    public void setMaxNumberPeople(int maxNumberPeople) {
        this.maxNumberPeople = maxNumberPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public abstract void showInformation() ;

    @Override
    public String toString() {
        return this.id+","+this.nameServices+","+this.area+","+this.feeServices+
                ","+this.maxNumberPeople+","+this.typeRent;
    }
}
