package testingsystem.domain;

import java.util.List;

public class Question {
    private String question;
    private List<Option> multiChoice;

    public Question(String question, List<Option> multiChoice) {
        this.question = question;
        this.multiChoice = multiChoice;
    }
}
