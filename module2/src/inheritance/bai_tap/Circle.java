package inheritance.bai_tap;

public class Circle {
    final double PI=3.14;
    private double radius=1.0;
    private String color="red";

    public Circle(){
    }
    public Circle(double radius, String color){
        this.radius=radius;
        this.color=color;
    }

    public double getArea(){
        return PI*Math.pow(radius,2);
    }
    public double getPerimeter(){
        return PI*radius*2;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString(){
        return "Radius= "+radius+" color= "+color;
    }
}
