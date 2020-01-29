package testingsystem.entity;

public class Answer {
    String answerOption;
    boolean isCorrect;

    public Answer(String answerOption, boolean isCorrect) {
        this.answerOption = answerOption;
        this.isCorrect = isCorrect;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
