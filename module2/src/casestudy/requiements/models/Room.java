package casestudy.requiements.models;

import java.math.RoundingMode;

public class Room extends Services {
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
                "\nServices's name: " + this.getNameServices() +
                "\nArea: " + this.getArea() +
                "\nRent's fee: " + this.getFeeServices() +
                "\nMaximum People: " + this.getMaxNumberPeople() +
                "\nType of rent: " + this.getTypeRent() +
                "\nFree Services: "+this.freeServices);
    }


    @Override
    public String toString() {
        return super.toString()+","+ freeServices;
    }
}
