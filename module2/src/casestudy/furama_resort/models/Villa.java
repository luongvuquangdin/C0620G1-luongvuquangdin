package casestudy.furama_resort.models;

public class Villa extends Services implements Comparable<Villa> {
    //Tiêu chuẩn phòng
    private String standard;
    //Mô tả tiện nghi
    private String theFacility;
    //Diện tích hồ bơi
    private double areaOfSwimmingPool;
    //Số tầng
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String id, String nameServices, double area, double feeServices, int maxNumberPeople, String typeRent, String standard, String theFacility, double areaOfSwimmingPool, int numberOfFloor) {
        super(id, nameServices, area, feeServices, maxNumberPeople, typeRent);
        this.standard = standard;
        this.theFacility = theFacility;
        this.areaOfSwimmingPool = areaOfSwimmingPool;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getTheFacility() {
        return theFacility;
    }

    public void setTheFacility(String theFacility) {
        this.theFacility = theFacility;
    }

    public double getAreaOfSwimmingPool() {
        return areaOfSwimmingPool;
    }

    public void setAreaOfSwimmingPool(double areaOfSwimmingPool) {
        this.areaOfSwimmingPool = areaOfSwimmingPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public void showInformation() {
        System.out.println("ID: " + this.getId() +
                ", Services's name: " + this.getNameServices() +
                ", Area: " + this.getArea() +
                ", Rent's fee: " + this.getFeeServices() +
                ", Maximum People: " + this.getMaxNumberPeople() +
                ", Type of rent: " + this.getTypeRent() +
                ", Standard: " + this.standard +
                ", The Facility: " + this.theFacility +
                ", Area of swimming pool: " + this.areaOfSwimmingPool +
                ", Number of floor: " + this.numberOfFloor);
    }

    @Override
    public String toString() {
        return super.toString()+","+standard +","+theFacility+","+ areaOfSwimmingPool +"," + numberOfFloor;
    }

    @Override
    public int compareTo(Villa o) {
        return this.getNameServices().compareTo(o.getNameServices());
    }
}
