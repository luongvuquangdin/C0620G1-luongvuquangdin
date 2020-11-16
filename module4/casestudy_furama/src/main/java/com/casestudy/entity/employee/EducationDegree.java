package com.casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    Integer educationDegreeId;
    @Column(name = "education_degree_name")
    String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    List<Employee> employeesEducation;

    public EducationDegree() {
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployeesEducation() {
        return employeesEducation;
    }

    public void setEmployeesEducation(List<Employee> employeesEducation) {
        this.employeesEducation = employeesEducation;
    }
}
