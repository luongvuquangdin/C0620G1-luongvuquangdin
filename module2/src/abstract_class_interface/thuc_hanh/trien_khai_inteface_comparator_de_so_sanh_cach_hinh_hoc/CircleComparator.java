package abstract_class_interface.thuc_hanh.trien_khai_inteface_comparator_de_so_sanh_cach_hinh_hoc;
import java.util.Comparator;
import inheritance.thuc_hanh.Circle;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
