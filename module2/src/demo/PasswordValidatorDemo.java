package demo;

public class PasswordValidatorDemo {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        // true
        System.out.println(validator.validate("Oxus20.2014"));
        System.out.println(validator.validate("Oxus.20_14"));
        System.out.println(validator.validate("OXUS20@Herat"));
        System.out.println(validator.validate("Oxus20@2014"));
        // false
        System.out.println(validator.validate("Oxus202014"));
        System.out.println(validator.validate("Oxus20"));
        System.out.println(validator.validate("Oxus@20"));
        System.out.println(validator.validate("Oxus20@"));
    }
}
