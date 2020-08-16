package dsa_stack_queue.bai_tap.optional_chuyen_doi_tu_he_thap_phan_xong_he_nhi_phan;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Convert Decimal to Binary");
        System.out.println("---------------------------");
        //Biến kiểu stack để lưu giá trị nhị phân
        Stack<Integer> convert = new Stack<>();


        //Nhập số hệ thập phân muốn chuyển đổi
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number decimal : ");
        int decimal = sc.nextInt();


        //Đưa giá trị vào stack
        int tempDecimal = Math.abs(decimal);
        System.out.println(decimal + " convert binary is: ");
        while (tempDecimal != 0) {
            convert.push(tempDecimal % 2);
            tempDecimal = tempDecimal / 2;
        }


        //Đưa giá trị sau khi chuyển sang hệ nhị phân 16 bit
        String data_2 = "";
        String data_1 = "";
        String data = "";
        //Nếu số hệ thập phân là số dương
           if (decimal>0){
               for (int i = 0; i < 16; i++) {
                if (!convert.empty()) {
                    data_2 += convert.pop();
                } else data_1 += 0;
            }
            System.out.println(data_1 + data_2);
        } else {
            //nếu số hệ thập phân là số âm

            for (int i = 0; i < 16; i++) {
                if (!convert.empty()) {
                    if (convert.pop() == 0) {
                        data_2 += 1;
                    } else data_2 += 0;
                } else data_1 += 1;
            }
            System.out.println("số bù 1 : "+data_1 + data_2);
        }
    }
}
