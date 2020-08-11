package access_modifier_static_proprety_static_method.bai_tap;

public class Circle {
    public double radius=1.0;
    private String color ="red";
//Constructor
    public Circle(){
    }
    public Circle(double radius,String color){
        this.radius=radius;
        this.color=color;
    }
//Area
    public double getArea(){
        return Math.pow(this.radius,2)*3.14;
    }

//Get Set Property
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
//Display
    public void Display(){
        System.out.printf("radius=%3.1f color=%s\n",this.radius,this.color);
    }
}
//class TestCircle{
//    public static void main(String[] args) {
//        Circle circle=new Circle();
//        Circle circle1=new Circle(123122.3, "blue");
//        circle.Display();
//    }
//}
