package main.java.by.epam.web.service.validation;

public class UserInputDataValidator {

    public static boolean validate(String name, String surname) {
        if (name == null || name.isEmpty()) {
            return false;
        } else if (surname == null || surname.isEmpty()) {
            return false;
        }
        return true;
    }

}
