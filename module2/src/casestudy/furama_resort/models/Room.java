package casestudy.furama_resort.models;

public class Room extends Services implements Comparable<Room>{
    //Dịch vụ miễn phí đi kèm
    private String freeServices;

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(){}
    public Room(String id, String nameServices, double area, double feeServices, int maxNumberPeople, String typeRent, String freeServices) {
        super(id, nameServices, area, feeServices, maxNumberPeople, typeRent);
        this.freeServices = freeServices;
    }

    @Override
    public void showInformation() {
        System.out.println("ID: " + this.getId() +
                ", Services's name: " + this.getNameServices() +
                ", Area: " + this.getArea() +
                ", Rent's fee: " + this.getFeeServices() +
                ", Maximum People: " + this.getMaxNumberPeople() +
                ", Type of rent: " + this.getTypeRent() +
                ", Free Services: "+this.freeServices);
    }


    @Override
    public String toString() {
        return super.toString()+","+ freeServices;
    }

    @Override
    public int compareTo(Room o) {
        return this.getNameServices().compareTo(o.getNameServices());
    }
}
