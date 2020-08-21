package dsa_stack_queue.bai_tap.optional_kiem_tra_chuoi_palindrome_su_dung_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Palindrome {
    public static void main(String[] args) {
        String string="abccba";
        Queue<Character> queueString=new ArrayDeque<Character>(50);
        int length = string.length()/2;

        //Đưa ký tự của chuỗi vào queue từ vị trí đầu tới vị trí giữa
        for (int i = 0; i< length; i++){
            queueString.add(string.charAt(i));
        }
        //cờ để kiểm tra xem có phải là một chuỗi palindrome không
        boolean check = true;
        //duyêt string từ vị trí cuối tới vị trí giữa
        //lấy từng phần tử trong queue só sánh với từng ký tự từ cuối đến giữa của string
        for (int i = string.length()-1; i>length; i--){
            char indexQueue=queueString.poll();
            if (indexQueue==string.charAt(i)){
                continue;
            }
            //nếu có một ký tự ở nhánh bên trai khác so với ký tự ở nhánh bên phải cùng vị trí
            //đối số so với vị trí giữa khác nhau thì thoát và không phải là palindrome
            check=false;
        }

        if (check){
                System.out.printf("%s là chuỗi palindrome",string);
        }else System.out.printf("%s không phải là chuỗi palindrome",string);
    }
}
