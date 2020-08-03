package introduction_to_java;
import java.util.Scanner;
public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("Hãy nhập các tham số của phương trình bậc nhất ax+b=0");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a= ");
        double a=scanner.nextDouble();
        System.out.println("b= ");
        double b=scanner.nextDouble();
        double x= (-b/a);
        if (a==0){
            if (b==0){
                System.out.println("Phương trình có vô số nghiệm");
            }else System.out.println("Phương trình vô nghiệm");
        }else System.out.println("Phương trình có nghiệm x= "+x);
    }
}
