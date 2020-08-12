package clean_code_refactoring.thuc_hanh.refactoring_tach_phuong_thuc;

public class CylinderTest {
    public static void main(String[] args) {
        double perimeter=Cylinder.getPerimeter(10);
        double baseArea=Cylinder.getBaseArea(10);
        double volume=Cylinder.getVolume(10,10);
        System.out.printf("perimete = %f \nbaseArea = %f \nvolume = %f",perimeter,baseArea,volume);
    }
}
