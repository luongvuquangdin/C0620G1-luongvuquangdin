package dsa_stack_queue.bai_tap.optional_kiem_tra_chuoi_palindrome_su_dung_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Palindrome {
    public static void main(String[] args) {
        String string="Able was I ere I saw elbA";
        Queue<Character> queueString=new ArrayDeque<Character>(50);
        String string_2="";
        int length = string.length();
        for (int i = 0; i< length; i++){
            queueString.add(string.charAt(i));
        }
        for (int i = string.length()-1; i>=0; i--){
            string_2+=(queueString.remove());
        }
            if (string_2.equalsIgnoreCase(string)){
                System.out.printf("%s là chuỗi palindrome",string);
        }else System.out.printf("%s không phải là chuỗi palindrome",string);
    }
}
