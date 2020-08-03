package introduction_to_java;
import java.util.Scanner;
public class CountBmi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Chương trình tính chỉ số BMI của cơ thể");
        System.out.print("Nhập chiều cao (mét): ");
        double height=scanner.nextDouble();
        System.out.print("Nhập chiều cân nặng (kilogam): ");
        double weight=scanner.nextDouble();
        double bmi = weight / Math.pow(height, 2);
        System.out.printf("Chiều cao là: %f \nCân nặng là: %f",height, weight);
        if (bmi < 18)
            System.out.printf("\nBMI= %f \nPhân loại là: %s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("\nBMI= %f \nPhân loại là: %s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("\nBMI= %f \nPhân loại là: %s", bmi, "Overweight");
        else
            System.out.printf("\nBMI= %f \nPhân loại là: %s", bmi, "Obese");
    }
}
