package dsa_stack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        //bStack chứa dấu ngoặc "("
        Stack<Character> bStack = new Stack<>();
        boolean isUsedCorrectly=true;
        //Nhập một đoạn muốn kiểu tra
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expression you want to check bracket : ");
        //Kiểm tra cặp dấu ngoặc
        String string = sc.nextLine();
        for (int i = 0; i < string.length(); i++) {
            //nếu là dấu ngoặc '(' thì đưa vào stack
            if (string.charAt(i) == '(') {
                bStack.push('(');
                continue;
            }
            //nếu là dấu ')' thì sánh và lấy dấu '(' trong stack để thành 1 cặp '()'
            if (string.charAt(i) == ')') {
                if (bStack.isEmpty()) {
                    isUsedCorrectly=false;
                    break;
                } else {
                    bStack.pop();
                }
            }
        }
        //Kiểm tra xem có đủ cặp '()' không
        if (bStack.isEmpty()&&isUsedCorrectly){
            System.out.println("Use correctly");
        }else System.out.println("improper use");
    }
}

