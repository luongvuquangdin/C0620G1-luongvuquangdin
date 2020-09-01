package casestudy.furama_resort.views;

import casestudy.furama_resort.commons.ReadFile;
import casestudy.furama_resort.models.Customer;
import casestudy.furama_resort.models.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowServices {
    public static void show(List<Services> listServices){
        for (int i = 0; i < listServices.size(); i++) {
            System.out.print((i + 1) + ": ");
            listServices.get(i).showInformation();
        }
    }
}
