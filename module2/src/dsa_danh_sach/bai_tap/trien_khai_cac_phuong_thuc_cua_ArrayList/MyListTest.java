package dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_cua_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> abc= new MyList<Integer>();
        abc.add(0,0);
        abc.add(1,1);
        abc.add(2,2);
        abc.add(3,3);
        abc.add(4,4);
        for (int i=0;i<abc.size();i++){
            System.out.println(abc.get(i));
        }


    }
}
