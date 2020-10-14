package vaildate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {
    private static final String REGEX_EMAIL="^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
    public static boolean checkEmail(String email){
        Pattern pattern= Pattern.compile(REGEX_EMAIL);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
