package inheritance.thuc_hanh;

import abstract_class_interface.bai_tap.trien_khai_interface_colorable_cho_lop_hinh_hoc.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius=1.0;
    public Circle(){}
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(String color, boolean filled, double radius){
        super(color, filled);
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius*=percent;
    }
}

//class Test {
//    public static void main(String[] args) {
//        Circle circle = new Circle();
//        System.out.println(circle.toString());
//
//        circle = new Circle(3.5);
//        System.out.println(circle.toString());
//
//        circle = new Circle("indigo", false, 3.5);
//        System.out.println(circle.toString());
//    }
//}
