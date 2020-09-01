package casestudy.furama_resort.commons;

import casestudy.furama_resort.models.Customer;
import casestudy.furama_resort.views.ShowCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChooseCustomer {
    public static Customer chooseCustomer(String fileCustomer){
        List<Customer> listCustomer=null;
        Customer customer=null;
        Scanner scanner=new Scanner(System.in);
        String choose=null;
        System.out.println("List Customer:");
        //Lấy danh sách Customer và hiển thị
        listCustomer = ReadFile.getAllCustomer(fileCustomer);
        ShowCustomer.show(listCustomer);
        //Chọn Customer để booking
            System.out.print("Choose Customer: ");
            choose = scanner.nextLine();
        customer = listCustomer.get(Integer.parseInt(choose) - 1);
        return customer;
    }

}
