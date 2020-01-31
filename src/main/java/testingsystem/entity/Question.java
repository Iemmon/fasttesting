package testingsystem.entity;

import java.util.List;

public class Question {
    private Long id;
    private String question;
    private List<Answer> listOfAnswers;

    public Question(Long id, String question, List<Answer> listOfAnswers) {
        this.id = id;
        this.question = question;
        this.listOfAnswers = listOfAnswers;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getMultiChoice() {
        return listOfAnswers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Answer a : listOfAnswers){
            stringBuilder.append(a.toString());
        }
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                stringBuilder.toString();
    }
}
