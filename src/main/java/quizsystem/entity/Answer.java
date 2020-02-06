package quizsystem.entity;

public class Answer {
    private Long id;
    private String answerOption;
    private boolean isCorrect;

    public Answer(Long id, String answerOption, boolean isCorrect) {
        this.answerOption = answerOption;
        this.isCorrect = isCorrect;
        this.id = id;
    }

    public Long getId() {
        return id;
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
