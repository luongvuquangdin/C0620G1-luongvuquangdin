package inheritance.bai_tap;

import inheritance.thuc_hanh.Shape;

import java.util.Scanner;

public class Triangle extends Shape {
    private double s1=1.0;
    private double s2=1.0;
    private double s3=1.0;
//Constructor
    public Triangle(){
    }
    public Triangle(double s1,double s2, double s3){
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
    }
//Chu vi hình tiam giác
    public double getPerimeter(){
        return (s1+s2+s3);
    }

    @Override
    public void resize(double percent) {
    }

    //Diện tích tam giác khi biết ba cạnh là một phần hai chu vi nhân với tổng 3 cạnh
    public double getArea(){
        return (getPerimeter()*1/2);
    }
    public double getS1() {
        return s1;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }

    public double getS2() {
        return s2;
    }

    public void setS2(double s2) {
        this.s2 = s2;
    }

    public double getS3() {
        return s3;
    }

    public void setS3(double s3) {
        this.s3 = s3;
    }
    @Override
    public String toString(){
        return "s1 = "+s1+" s2 = "+s2+" s3 = "+s3+"\nMàu: "+super.getColor()+"\nDiện tích = "+
                getArea()+"\nChu vi = "+getPerimeter();
    }
}

class Test{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double s1=1;
        double s2=1;
        double s3=1;
        boolean check1=s1+s2>s3;
        boolean check2=s1+s3>s2;
        boolean check3=s2+s3>s1;
        System.out.println("Nhập vào chiều dài ba cạnh của một tam giác");
        do {
            System.out.println("Tổng của hai cạnh bất kỳ phải lớn hơn cạnh còn lại");
            System.out.print("Cạnh thức nhất: ");
            s1=scanner.nextDouble();
            System.out.print("Cạnh thức hai: ");
            s2=scanner.nextDouble();
            System.out.print("Cạnh thức ba: ");
            s3=scanner.nextDouble();
        }while (!(check1&&check2&&check3));
        System.out.print("Màu sắc của tam giác là: ");
        scanner.nextLine();
        String color=scanner.nextLine();
        Triangle a= new Triangle(s1,s2,s3);
        a.setColor(color);
        System.out.println(a);



    }
}
