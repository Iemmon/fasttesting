package testingsystem.entity;

import java.util.List;

public class Question {
    private Long id;
    private String question;
    private List<Answer> multiChoice;

    public Question(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public Question(Long id, String question, List<Answer> multiChoice) {
        this.id = id;
        this.question = question;
        this.multiChoice = multiChoice;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getMultiChoice() {
        return multiChoice;
    }
}
