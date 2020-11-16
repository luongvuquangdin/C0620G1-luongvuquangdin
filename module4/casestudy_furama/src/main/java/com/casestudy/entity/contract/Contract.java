package com.casestudy.entity.contract;

import com.casestudy.entity.customer.Customer;
import com.casestudy.entity.employee.Employee;
import com.casestudy.entity.service.ServiceOfFurama;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    Integer contractId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "contract_start_date")
    LocalDate contractStartDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "contract_end_date")
    LocalDate contractEndDate;
    @Column(name = "contract_deposit")
    @Min(value = 0,message = "Deposit>=0")
    Double contractDeposit;
    @Column(name = "contract_total_money")
    @Min(value = 0,message = "Total money>=0")
    Double contractTotalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    ServiceOfFurama service;

    public Contract() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceOfFurama getService() {
        return service;
    }

    public void setService(ServiceOfFurama service) {
        this.service = service;
    }


}
