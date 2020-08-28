package string__regex.bai_tap.validate_so_dien_thoai;

public class PhoneNumberTest {
    private static String[] phoneNumber={"(84)-(0978489648)","(a8)-(22222222)"};
    public static void main(String[] args) {
        RegexPhoneNumber test=new RegexPhoneNumber();
        for (String phone:phoneNumber){
            System.out.println(test.regex(phone));
        }

    }
}
