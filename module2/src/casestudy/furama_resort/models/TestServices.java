package casestudy.furama_resort.models;

import java.util.ArrayList;
import java.util.List;

public class TestServices {
    public static void main(String[] args) {
        Services villa=new Villa("12","Villa",20.2,2000.2,20,
                "Day","Vip","Vip",5.2,5);
        Services house=new House("11","House",10.2,500.2,10,
                "Day","House","House",3);
        Services room=new Room("10","Room",5,100,4,
                "Day","game");

        List<Services> abc=new ArrayList<>();
        abc.add(villa);
        abc.add(house);
        abc.add(room);
//        Services villa=new Villa();
//        Services house=new House();
//        Services room=new Room();
//        System.out.println("Villa");
//        villa.input();
//        System.out.println("House");
//        house.input();
//        System.out.println("Room");
//        room.input();


        for (Services ab:abc){
            ab.showInformation();
        }

    }
}
