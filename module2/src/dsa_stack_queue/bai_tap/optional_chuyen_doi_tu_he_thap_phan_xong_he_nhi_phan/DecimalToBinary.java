package dsa_stack_queue.bai_tap.optional_chuyen_doi_tu_he_thap_phan_xong_he_nhi_phan;

import java.util.Stack;

public class DecimalToBinary {
    public static void decimalToBinary(int number){
        Stack<Integer> convert = new Stack<>();
        int tempDecimal = Math.abs(number);
        System.out.println(number + " convert binary is: ");
        while (tempDecimal != 0) {
            int mob=tempDecimal % 2;
            convert.push(mob);
            tempDecimal = tempDecimal / 2;
        }

        //Đưa giá trị sau khi chuyển sang hệ nhị phân 16 bit
        //Nếu số hệ thập phân là số dương
           if (number>=0){
               while (!convert.isEmpty()){
                   System.out.print(convert.pop());
            }
        } else {
            //nếu số hệ thập phân là số âm
                while (!convert.empty()) {
                    if (convert.pop() == 0) {
                        System.out.print("1");;
                    } else System.out.print("0");
            }
        }
    }
}
