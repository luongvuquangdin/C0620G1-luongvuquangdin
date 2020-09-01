package casestudy.furama_resort.views;

import casestudy.furama_resort.models.Customer;

import java.util.Collections;
import java.util.List;

public class ShowCustomer {

    public static void show(List<Customer> listCustomer){
        Collections.sort(listCustomer);
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ": ");
            listCustomer.get(i).showInformation();
        }
    }
}
