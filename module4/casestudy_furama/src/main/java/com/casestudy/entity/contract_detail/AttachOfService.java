package com.casestudy.entity.contract_detail;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
public class AttachOfService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    Integer attachServiceId;
    @Column(name = "attach_service_name")
    String attachServiceName;
    @Column(name = "attach_service_cost")
    Double attachServiceCost;
    @Column(name = "attach_service_unit")
    Integer attachServiceUnit;
    @Column(name = "attach_service_status")
    String attachServiceStatus;


    public AttachOfService() {
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
