package thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MaxSTring {
    public static void main(String[] args) {
        // Tạo một Scanner
        Scanner input = new Scanner(System.in);

        // Yêu cầu người dùng nhập một chuỗi
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        //Tạo một LinkedList để lưu một chuỗi lớn nhất
        LinkedList<Character> max = new LinkedList<Character> ();

        //Tạo một TreeMap để lưu trữ chuỗi hiện tại
        LinkedList<Character>  list=new LinkedList<>();;
        //Tìm chuỗi lớn nhất
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            for (Character stringnew:list){
                System.out.print(stringnew);
            }
            System.out.println();

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }


        for (Character stringnew:max){
            System.out.print(stringnew);
        }

    }
}
