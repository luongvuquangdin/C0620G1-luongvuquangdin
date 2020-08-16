package dsa_stack_queue.bai_tap.optional_kiem_tra_chuoi_palindrome_su_dung_queue;

import java.util.ArrayDeque;

public class Palindrome {
    public static void main(String[] args) {
        boolean isPalindrome=true;
        String string="Able was I ere I saw Elba";
        ArrayDeque<Character> queueString_1=new ArrayDeque<Character>(50);
        ArrayDeque<Character> queueString_2=new ArrayDeque<Character>(50);
        int length = string.length() / 2;
        for (int i = 0; i< length; i++){
            queueString_1.add(string.charAt(i));
        }
        for (int i = string.length()-1; i> length; i--){
            queueString_2.add(string.charAt(i));
        }
        for (int i=0;i<length;i++){
            if (queueString_1.poll().equals(queueString_2.poll())){
                continue;
            }
            isPalindrome=false;
            break;
        }
        if (isPalindrome){
            System.out.printf("%s là chuỗi palindrome",string);
        }else System.out.printf("%s không phải là chuỗi palindrome",string);
    }
}
