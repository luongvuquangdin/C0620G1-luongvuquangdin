package com.casestudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`role`")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Integer roleId;
    @Column(name = "role_name")
    String roleName;
    @ManyToMany(mappedBy = "rolesUser")
    List<User> usersRole;

    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(List<User> usersRole) {
        this.usersRole = usersRole;
    }
}
