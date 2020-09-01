package casestudy.furama_resort.views;

import casestudy.furama_resort.models.Customer;

import java.util.Queue;

public class ShowCinemaCustomer {
    public static void show(Queue<Customer> customerQueue){
        for (Customer customer:customerQueue){
            customer.showInformation();
        }
    }
}
