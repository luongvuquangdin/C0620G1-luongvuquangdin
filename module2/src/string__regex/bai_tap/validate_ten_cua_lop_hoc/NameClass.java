package string__regex.bai_tap.validate_ten_cua_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static final String CLASS_REGEX="^[ACP]{1}[\\d]{4}[GHIKLM]$";
    public boolean regex(String regex){
        Pattern pattern=Pattern.compile(CLASS_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
