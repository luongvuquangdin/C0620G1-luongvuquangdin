package lop_va_doi_tuong_trong_java.thuc_hanh;

import java.util.Scanner;

public class Rect {
//    static class Rect1 {
        private double width;
        private double height;

        //Constructor
        public Rect() {
        }

        public Rect(double width, double height) {
            this.width = width;
            this.height = height;
        }

        //Area
        public double getArea() {
            return this.width * this.height;
        }

        //Perimeter
        public double getPerimeter() {
            return (this.width + this.height) * 2;
        }

        //Display properties
        public String display() {
            return "Rectangle{" + "width=" + width + ", height=" + height + "}";
        }

        //Get và Set properties
        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the width:");
//        double width = scanner.nextDouble();
//        System.out.print("Enter the height:");
//        double height = scanner.nextDouble();
//        Rect1 rectangle = new Rect1(width, height);
//        System.out.println("Your Rectangle \n"+ rectangle.display());
//        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
//        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
//
//    }

