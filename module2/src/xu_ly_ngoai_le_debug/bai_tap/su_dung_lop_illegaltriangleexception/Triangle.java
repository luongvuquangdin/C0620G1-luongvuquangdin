package xu_ly_ngoai_le_debug.bai_tap.su_dung_lop_illegaltriangleexception;

public class Triangle {
    public Triangle(double a, double b, double c) throws IllegalTriangleException {
        if (a > 0 && b > 0 && c > 0 && ((a + b) > c && (a + c) > b) && (b + c) > a) {
            System.out.println(a + " " + b + " " + c + " là một tam giác");
        }else throw new IllegalTriangleException(a + " " + b + " " + c + " không phải là một tam giác");
    }
}
