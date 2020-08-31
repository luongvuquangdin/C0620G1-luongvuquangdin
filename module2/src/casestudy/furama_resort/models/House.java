package casestudy.furama_resort.models;

public class House extends Services implements Comparable<House>{
    //Tiêu chuẩn phòng
    private String standard;
    //Mô tả tiện nghi
    private String theFacility;
    //Số tầng
    private int numberOfFloor;
    public House(){}

    public House(String id, String nameServices, double area, double feeServices, int maxNumberPeople, String typeRent, String standard, String theFacility, int numberOfFloor) {
        super(id, nameServices, area, feeServices, maxNumberPeople, typeRent);
        this.standard = standard;
        this.theFacility = theFacility;
        numberOfFloor = numberOfFloor;
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
                ", Number of floor: " + this.numberOfFloor);
    }


    @Override
    public String toString() {
        return super.toString()+","+ standard +","+ theFacility+
                "," + numberOfFloor;
    }

    @Override
    public int compareTo(House o) {
        return this.getNameServices().compareTo(o.getNameServices());
    }
}
