package thuat_toan_tim_kiem.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxString {
        public static void main(String[] args) {
            // Create a Scanner
            Scanner input = new Scanner(System.in);
            LinkedList<Character> max = new LinkedList<>();
            LinkedList<Character> list = new LinkedList<>();

            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String string = input.nextLine();

            // Find the maximum consecutive increasingly ordered substring
            for (int i = 0; i < string.length(); i++) { 	//(n+1)lần
                if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                        list.contains(string.charAt(i))) {  //n lần
                    list.clear(); // Simple statement  // hằng số=>O(1)
                }

                list.add(string.charAt(i)); // Simple statement// n lần

                System.out.println();

                for (Character ch: list) { // single loop //n+1 lần
                    System.out.print(ch); // Simple statement//n lần
                }

                if (list.size() > max.size()) { // Simple statement // n lần
                    max.clear();   //hằng số
                    max.addAll(list);//hằng số
                }

            }

            // Display the maximum consecutive
            // increasingly ordered substring
            for (Character ch: max) { // single loop //n+1 lần
                System.out.print(ch); // Simple statement//n lần
            }
            System.out.println();//          1 lần
        }

/*********************************************************************************
 * 	Analyze the time complexity of your program:                                  *
 * 	1 single loop =4n+1;                                      *
 * 	1 single loop =2n+1;                                       *
 *                                                                                *
 * 	f(n) = 4n+1+2n+1=6n+1   => O(n) Linear time;                                                      *
 *********************************************************************************/
    }
