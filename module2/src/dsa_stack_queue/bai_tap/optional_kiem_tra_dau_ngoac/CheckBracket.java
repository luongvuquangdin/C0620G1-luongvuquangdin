package dsa_stack_queue.bai_tap.optional_kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static boolean checkBracket(String string) {
        //bStack chứa dấu ngoặc "("
        Stack<Character> bStack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            //nếu là dấu ngoặc '(' thì đưa vào stack
            if (string.charAt(i) == '(') {
                bStack.push('(');
                continue;
            }
            //nếu là dấu ')' thì sánh và lấy dấu '(' trong stack để thành 1 cặp '()'
            if (string.charAt(i) == ')') {
                if (bStack.isEmpty()) {
                    return false;
                }
                    bStack.pop();
                }
            }
        return bStack.isEmpty();
        }
        //Kiểm tra xem có đủ cặp '()' không
    }

