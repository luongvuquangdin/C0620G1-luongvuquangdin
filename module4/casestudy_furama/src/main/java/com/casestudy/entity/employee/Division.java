package com.casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    Integer divisionId;
    @Column(name = "division_name")
    String divisionName;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    List<Employee> employeesDivision;

    public Division() {
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployeesDivision() {
        return employeesDivision;
    }

    public void setEmployeesDivision(List<Employee> employeesDivision) {
        this.employeesDivision = employeesDivision;
    }
}
