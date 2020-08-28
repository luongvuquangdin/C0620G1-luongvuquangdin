package casestudy.requiements.models;

public class House extends Services {
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
        numberOfFloor = numberOfFloor;
    }

    @Override
    public void showInformation() {
        System.out.println("ID: " + this.getId() +
                "\nServices's name: " + this.getNameServices() +
                "\nArea: " + this.getArea() +
                "\nRent's fee: " + this.getFeeServices() +
                "\nMaximum People: " + this.getMaxNumberPeople() +
                "\nType of rent: " + this.getTypeRent() +
                "\nStandard: " + this.standard +
                "\nThe Facility: " + this.theFacility +
                "\nNumber of floor: " + this.numberOfFloor);
    }


    @Override
    public String toString() {
        return super.toString()+","+ "," + standard +","+ theFacility+
                "," + numberOfFloor;
    }
}
