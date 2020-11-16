package com.casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`position`")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    Integer positionId;
    @Column(name = "position_name")
    String positionName;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    List<Employee> employeesPosition;

    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeesPosition() {
        return employeesPosition;
    }

    public void setEmployeesPosition(List<Employee> employeesPosition) {
        this.employeesPosition = employeesPosition;
    }
}
