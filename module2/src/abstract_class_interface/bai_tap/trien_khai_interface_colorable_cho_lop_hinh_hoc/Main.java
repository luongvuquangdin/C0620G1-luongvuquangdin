package abstract_class_interface.bai_tap.trien_khai_interface_colorable_cho_lop_hinh_hoc;

import inheritance.thuc_hanh.Circle;
import inheritance.thuc_hanh.Rectangle;
import inheritance.thuc_hanh.Shape;
import inheritance.thuc_hanh.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        System.out.println("Before: Area");
        for (Shape element:shapes){
            System.out.println(element.getArea());
        }
        double random=(Math.random()*(100-1)+1);
        for (Shape element:shapes){
            element.resize(random);
        }
        System.out.println("After: Area");
        for (Shape element:shapes){
            System.out.println(element.getArea());
        }
    }
}
