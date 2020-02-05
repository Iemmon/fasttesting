package quizsystem.entity;

public class Answer {
    private String answerOption;
    private boolean isCorrect;

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

    @Override
    public String toString() {
        return "\n" + answerOption;
    }
}
