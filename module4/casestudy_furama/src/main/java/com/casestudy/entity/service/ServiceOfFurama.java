package com.casestudy.entity.service;

import com.casestudy.entity.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "service")
public class ServiceOfFurama {
    @Id
    @Column(name = "service_id")
    @NotBlank(message = "Service id can't left blank")
    @Pattern(regexp = "^DV-\\d{4}$", message = "Service id format is DV-XXXX (X is number from 0 to 9)")
    String serviceId;
    @Column(name = "service_name")
    @NotBlank(message = "Name can't left blank")
    String serviceName;
    @Column(name = "service_area")
    @Min(value = 1,message = "Area > 0 and quantity is positive integer")
    Integer serviceArea;
    @Column(name = "service_cost")
    @Min(value = 0,message = "Cost>=0")
    Double serviceCost;
    @Column(name = "service_max_people")
    @Min(value = 1,message = "Max people > 0 and quantity is positive integer")
    Integer serviceMaxPeople;
    @Column(name = "standard_room")
    String standardRoom;
    @Column(name = "description_other_convenience")
    String descriptionOtherConvenience;
    @Column(name = "pool_area")
    @Min(value = 0,message = "Area>=0")
    Double poolArea;
    @Column(name = "number_of_floors")
    @Min(value = 1,message = "Floor > 0 and quantity is positive integer")
    Integer numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    RentType rentTypeService;
    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    ServiceType serviceTypeOfService;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<Contract> contractsOfService;


    public ServiceOfFurama() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentTypeService() {
        return rentTypeService;
    }

    public void setRentTypeService(RentType rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    public ServiceType getServiceTypeOfService() {
        return serviceTypeOfService;
    }

    public void setServiceTypeOfService(ServiceType serviceTypeOfService) {
        this.serviceTypeOfService = serviceTypeOfService;
    }

    public List<Contract> getContractsOfService() {
        return contractsOfService;
    }

    public void setContractsOfService(List<Contract> contractsOfService) {
        this.contractsOfService = contractsOfService;
    }
}
