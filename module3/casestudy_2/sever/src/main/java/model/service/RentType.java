package model.service;

public class RentType {
    String rentTypeId;
    String rentTypeName;

    public RentType(String rentTypeId, String rentTypeName) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
    }

    public String getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(String rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }
}
