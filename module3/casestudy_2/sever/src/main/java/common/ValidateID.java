package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateID {
    private static final String ID_CUSTOMER="^KH-\\d{4}$";
    private static final String ID_SERVICE="^DV-\\d{4}$";

    public static boolean checkIdCustomer(String idCustomer){
        Pattern pattern=Pattern.compile(ID_CUSTOMER);
        Matcher matcher=pattern.matcher(idCustomer);
        return matcher.matches();
    }

    public static boolean checkIdService(String idService){
        Pattern pattern=Pattern.compile(ID_SERVICE);
        Matcher matcher=pattern.matcher(idService);
        return matcher.matches();
    }
}
