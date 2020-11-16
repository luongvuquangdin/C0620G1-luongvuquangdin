package com.casestudy.entity.employee;

import com.casestudy.entity.contract.Contract;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Integer employeeId;
    @Column(name = "employee_name")
    @NotBlank(message = "Name can't left blank")
    String employeeName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Birthday can not left blank")
    @Past(message = "Are you from the future?")
    @Column(name = "employee_birthday")
    LocalDate employeeBirthday;
    @Column(name = "employee_id_card")
    @Pattern(regexp = "^\\d{9}$", message = "IdCard format is XXXXXXXXX (X is number from 0 to 9)")
    String employeeIdCard;
    @Column(name = "employee_salary")
    @Min(value = 0, message = "Salary>=0")
    Double employeeSalary;
    @Column(name = "employee_phone")
    @Pattern(regexp = "^((\\(84\\)\\+)|0)((90)|(91))\\d{7}$", message = "Phone number format is (84)+90XXXXXXX" +
            "or (84)+91XXXXXXX or 090XXXXXXX or 091XXXXXXX")
    String employeePhone;
    @Column(name = "employee_email")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$", message = "Email format is abc@abc.abc")
    String employeeEmail;
    @Column(name = "employee_address")
    String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    Position position;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    Division division;
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id")
    EducationDegree educationDegree;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    User user;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Contract> contractsOfEmployee;

    public Employee() {
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(LocalDate employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContractsOfEmployee() {
        return contractsOfEmployee;
    }

    public void setContractsOfEmployee(List<Contract> contractsOfEmployee) {
        this.contractsOfEmployee = contractsOfEmployee;
    }
}
