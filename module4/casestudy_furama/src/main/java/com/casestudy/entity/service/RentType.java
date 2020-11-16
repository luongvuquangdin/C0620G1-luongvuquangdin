package com.casestudy.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    Integer rentTypeId;
    @Column(name = "rent_type_name")
    String rentTypeName;

    @OneToMany(mappedBy = "rentTypeService",cascade = CascadeType.ALL)
    List<ServiceOfFurama> servicesOfRentType;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<ServiceOfFurama> getServicesOfRentType() {
        return servicesOfRentType;
    }

    public void setServicesOfRentType(List<ServiceOfFurama> servicesOfRentType) {
        this.servicesOfRentType = servicesOfRentType;
    }
}
