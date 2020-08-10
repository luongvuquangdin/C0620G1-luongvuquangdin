package access_modifier_static_proprety_static_method.thuc_hanh;
import access_modifier_static_proprety_static_method.bai_tap.DefaultA;
public class DefaultB extends DefaultA {
    public static void main(String args[]) {

        DefaultB obj = new DefaultB();//Compile Time Error

        obj.msg();//Compile Time Error
    }
}

