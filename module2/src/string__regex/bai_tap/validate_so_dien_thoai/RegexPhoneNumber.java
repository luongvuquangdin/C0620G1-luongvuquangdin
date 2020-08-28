package string__regex.bai_tap.validate_so_dien_thoai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPhoneNumber {
    private static final String PHONE_REGEX="^\\([\\d]{2}\\)-\\(0[\\d]{9}\\)$";

    public boolean regex(String string){
        Pattern pattern=Pattern.compile(PHONE_REGEX);
        Matcher matcher=pattern.matcher(string);
        return matcher.matches();
    }
}
