package casestudy.furama_resort.models;

import java.util.List;
import java.util.Stack;

public class FileCabinets {
    private Stack<Employee> fileEmployee;

    public FileCabinets() {
        fileEmployee=new Stack<>();
    }

    public void add(Stack<Employee> list){
        fileEmployee=list;
    }

    public void search(String id){
        Employee employee=null;
        while (!fileEmployee.isEmpty()){
            employee=fileEmployee.pop();
            if (employee.getId().equals(id)){
                System.out.println(employee.toString());
                return;
            }
        }
        System.out.println(id + " not exist");
    }
}
