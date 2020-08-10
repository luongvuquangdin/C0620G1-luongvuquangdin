package access_modifier_static_proprety_static_method.thuc_hanh;

public class AccessModifierPrivate {

        private int data=40;

        private void msg(){System.out.println("Hello java");}

    public static void main(String args[]){

        AccessModifierPrivate obj=new AccessModifierPrivate();

        System.out.println(obj.data);//Compile Time Error

        obj.msg();//Compile Time Error

    }

    }


