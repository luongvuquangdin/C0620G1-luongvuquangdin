package string__regex.bai_tap.validate_ten_cua_lop_hoc;

public class NameClassTest {
    private static String[] class_1={"C0318G","M0318G","P0323A"};

    public static void main(String[] args) {
        NameClass test=new NameClass();
        for (String string:class_1){
            System.out.println(test.regex(string));
        }
    }

}
