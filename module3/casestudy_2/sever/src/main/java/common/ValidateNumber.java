package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumber {
    private static final String REGEX_PHONE="^((\\(84\\)(90|91))\\+|(090|091))[\\d]{7}$";
    private static final String ID_CARD="^\\d{9}$";
    private static final String POSITIVE_INTEGER="^[\\d]+$";
    private static final String POSITIVE_NUMBER="^[\\d]+(\\.)?[\\d]*$";

    public static boolean checkPhone(String phone){
        Pattern pattern= Pattern.compile(REGEX_PHONE);
        Matcher matcher=pattern.matcher(phone);
        return matcher.matches();
    }
    public static boolean checkIdCard(String idCard){
        Pattern pattern= Pattern.compile(ID_CARD);
        Matcher matcher=pattern.matcher(idCard);
        return matcher.matches();
    }
    public static boolean checkPositiveInteger(String number){
        Pattern pattern= Pattern.compile(POSITIVE_INTEGER);
        Matcher matcher=pattern.matcher(number);
        return matcher.matches();
    }
    public static boolean checkPositiveNumber(String number){
        Pattern pattern= Pattern.compile(POSITIVE_NUMBER);
        Matcher matcher=pattern.matcher(number);
        return matcher.matches();
    }
}
