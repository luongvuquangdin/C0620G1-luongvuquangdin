package services.impl;

import org.springframework.stereotype.Service;
import services.FormatEmail;
import vaildate.EmailValidate;
@Service
public class FormatEmailImpl implements FormatEmail {
    @Override
    public String validateEmail(String email) {
        String message="OK";
        if (!EmailValidate.checkEmail(email)) message="Email is format abc@abc.abc";
        return message;
    }
}
