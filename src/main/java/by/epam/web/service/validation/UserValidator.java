package main.java.by.epam.web.service.validation;

import main.java.by.epam.web.domain.User;
import main.java.by.epam.web.service.exception.ServiceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private final static String EMAIL_REGEX = "^([a-zA-Z0-9]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    private final static String PHONE_NUMBER_REGEX = "\\+375(29|33|44)[0-9]{7}";

    public boolean validateUser(User user) throws ServiceException {
        if (!checkUserNames(user)) {
            throw new ServiceException("User data from has wrong format");
        }
        if (!checkEmail(user.getEmail())) {
            throw new ServiceException("User email from has wrong format");
        }
        if (!checkPhoneNumber(user.getPhoneNumber())) {
            throw new ServiceException("User phone number from has wrong format");
        }
        return true;
    }

    private boolean checkUserNames(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return false;
        }else if (user.getSurname() == null || user.getSurname().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean checkEmail(String field) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(field);
        return matcher.matches();
    }

    private boolean checkPhoneNumber(String field) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);// зачем ты каждый раз создаешь абсолюно обинаковый объект pattern?
        Matcher matcher = pattern.matcher(field);
        return matcher.matches();
    }

}
