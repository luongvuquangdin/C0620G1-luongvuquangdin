package abstract_class_interface.bai_tap.trien_khai_interface_resizeable_cho_lop_hinh_hoc;

import inheritance.thuc_hanh.Circle;
import inheritance.thuc_hanh.Rectangle;
import inheritance.thuc_hanh.Shape;
import inheritance.thuc_hanh.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shape= new Shape[4];
        shape[0]= new Circle();
        shape[1]= new Rectangle();
        shape[2]= new Square();
        shape[3]= new Circle("blue", true, 100);
        for (Shape element:shape){
            if (element instanceof Colorable){
                ((Colorable) element).howToColor();
                continue;
            }
            System.out.println("Area = "+element.getArea());
        }
    }
}
