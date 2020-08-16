package dsa_stack_queue.bai_tap;

import java.util.Map;
import java.util.TreeMap;

public class dem_so_lan_xuat_hien_su_dung_map {
    public static void main(String[] args) {
        String string="anh là ai và anh là ai";
        String[] arrString=string.split("\\s");
        TreeMap<String,Integer> cout=new TreeMap<>();
        String key;
        int value;
        for (int i=0;i<arrString.length;i++){
            key=arrString[i];
            value=1;
            for (int j=i+1;j<arrString.length;i++){
                if (arrString[j].equals(arrString[i])){
                    value++;
                }
            }

        }

        for (Map.Entry<String,Integer> entry: cout.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
