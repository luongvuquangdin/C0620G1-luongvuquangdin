package com.casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "user_name")
    String userName;
    @Column(name = "`password`")
    String password;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Employee employee;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns =@JoinColumn(name = "user_name",referencedColumnName = "user_name") ,
            inverseJoinColumns =@JoinColumn(name = "role_id",referencedColumnName = "role_id"))
    List<Role> rolesUser;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Role> getRolesUser() {
        return rolesUser;
    }

    public void setRolesUser(List<Role> rolesUser) {
        this.rolesUser = rolesUser;
    }
}
