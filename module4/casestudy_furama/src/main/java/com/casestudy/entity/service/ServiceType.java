package com.casestudy.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    Integer serviceTypeId;
    @Column(name = "service_type_name")
    String serviceTypeName;

    @OneToMany(mappedBy = "rentTypeService",cascade = CascadeType.ALL)
    List<ServiceOfFurama> servicesTypeOfService;

    public ServiceType() {
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<ServiceOfFurama> getServicesTypeOfService() {
        return servicesTypeOfService;
    }

    public void setServicesTypeOfService(List<ServiceOfFurama> servicesTypeOfService) {
        this.servicesTypeOfService = servicesTypeOfService;
    }
}
