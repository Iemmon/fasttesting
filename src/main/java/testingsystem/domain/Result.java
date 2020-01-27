package testingsystem.domain;

public class Result {
    Long resultId;
    Test test;
    User user;
    Integer score;

    public Result(Long resultId, Integer score) {
        this.resultId = resultId;
        this.score = score;
    }
}
