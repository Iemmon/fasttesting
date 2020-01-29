package testingsystem.service.validator;

import testingsystem.entity.User;

public class UserValidator implements Validator<User>{
    @Override
    public boolean validate(User entity) {
        return validateEmail(entity.getEmail()) && validatePassword(entity.getPassword());
    }

    public boolean validateEmail(String email) {
        return email.matches(Pattern.EMAIL_PATTERN.toString());
    }

    public boolean validatePassword(String password) {
        return password.matches(Pattern.PASSWORD_PATTERN.toString());
    }
}
