package introduction_to_java.bai_tap;
import java.util.Scanner;
public class DisplayHelloName {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.printf("Hello %s", name);
    }
}
