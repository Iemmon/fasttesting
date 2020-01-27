package testingsystem.service.validator;

public enum Pattern {
    PASSWORD_PATTERN("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}"),
    EMAIL_PATTERN("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[\\.][a-z]+$");

    String pattern;

    @Override
    public String toString() {
        return pattern;
    }

    Pattern(String pattern){
        this.pattern = pattern;
    }
}
