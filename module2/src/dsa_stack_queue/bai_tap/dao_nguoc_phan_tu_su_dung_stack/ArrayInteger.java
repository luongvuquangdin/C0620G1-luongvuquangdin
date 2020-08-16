package dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_su_dung_stack;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ArrayInteger {
    public static void main(String[] args) {
        /**Tạo mảng số nguyên
         *
         */
        Stack<Integer> arr= new Stack();
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);
        arr.push(6);
        arr.push(7);
        System.out.printf("Array = %s",arr.toString());
        /**Tạo một mảng mới lưu mảng arr khi đảo ngược
         *
         */
        System.out.println("\nSau khỉ đảo ngược mảng: ");
        Stack<Integer> newArr= new Stack<>();
        while (!arr.isEmpty()){
            newArr.push(arr.pop());
        }
        System.out.printf("Array = %s\n",newArr.toString());


        /**Chuỗi String ban đầu
         *
         */
        String str="Ở đây chúng tôi không làm thế";
        System.out.printf("String = \"%s\"",str);
        /**Một biến kiểu Stack lưu các ký tự của Str
         *
         */
        System.out.println("\nSau khỉ đảo ngược chuỗi: ");
        String[] arrStr=str.split("\\s");
        Stack<String> string=new Stack<>();
        for (int i=0;i<arrStr.length;i++){
            string.push(arrStr[i]);
        }

        System.out.print("String =\"");
        while (!string.isEmpty()){
            System.out.printf("%s ",string.pop());
        }
        System.out.print("\"");

    }




}
