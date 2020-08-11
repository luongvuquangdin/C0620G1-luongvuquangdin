package inheritance.bai_tap;

public class Cylinder extends Circle {
    private double height=1.0;
    public Cylinder(){
    }
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height=height;
    }
    public double volume(){
        return super.getArea()*height;
    }
    @Override
    public double getArea(){
        return 2*super.getArea()*2*PI*super.getRadius()*height;
    }
    @Override
    public double getPerimeter(){
        return height*super.getPerimeter();
    }
    @Override
    public String toString(){
        return super.toString()+" Height= "+ height;
    }

}
