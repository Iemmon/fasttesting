package quizsystem.service.validator;

public interface Validator<T> {
    boolean validate(T entity);

    boolean validateEmail(String email);

    boolean validatePassword(String password);
}
