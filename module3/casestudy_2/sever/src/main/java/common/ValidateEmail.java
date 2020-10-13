package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String REGEX_EMAIL="^[A-Za-z0-9]+@gmail\\.com$";

    public static boolean checkEmail(String email){
        Pattern pattern= Pattern.compile(REGEX_EMAIL);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
