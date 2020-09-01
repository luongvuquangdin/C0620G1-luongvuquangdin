package casestudy.furama_resort.views;

import casestudy.furama_resort.models.Customer;
import casestudy.furama_resort.models.Employee;
import casestudy.furama_resort.models.Services;

import java.util.Collections;
import java.util.Map;

public class ShowEmployee {
    public static void show(Map<String, Employee> map){
        for (Map.Entry<String, Employee> entry:map.entrySet()){
            System.out.println(entry.toString());
        }
    }
}
