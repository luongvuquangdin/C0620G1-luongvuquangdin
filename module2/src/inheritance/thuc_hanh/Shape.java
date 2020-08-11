package inheritance.thuc_hanh;

import abstract_class_interface.bai_tap.trien_khai_interface_colorable_cho_lop_hinh_hoc.Resizeable;

public abstract class Shape implements Resizeable {
    private String color="green";
    private boolean filled=true;
    public Shape(){}
    public Shape(String color, boolean filled){
        this.color=color;
        this.filled=filled;
    }
    @Override
    public String toString(){
        return "A Shape with color of " + getColor() + " and " + (isFilled() ? "filled" : "not filled");
    }

    public boolean isFilled() {
        return filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void  resize(double percent);
}
//class Test{
//        public static void main(String[] args) {
//            Shape shape = new Shape();
//            System.out.println(shape);
//
//            shape = new Shape("red", false);
//            System.out.println(shape);
//        }
//    }

