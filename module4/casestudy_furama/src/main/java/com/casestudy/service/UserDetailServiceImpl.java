package com.casestudy.service;

import com.casestudy.entity.employee.Role;
import com.casestudy.entity.employee.User;
import com.casestudy.service.employee_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=this.userService.findById(userName);
        if (user==null){
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found User: " + userName);
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        if (user.getRolesUser()!=null){
            for (Role role:user.getRolesUser()){
                GrantedAuthority granted=new SimpleGrantedAuthority(role.getRoleName());
                grantedAuthorities.add(granted);
            }
        }
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                grantedAuthorities);
        return userDetails;
    }
}
