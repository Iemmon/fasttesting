package testingsystem.entity;

public class Result {
    Long id;
    Test test;
    Integer score;

    public Result(Long resultId, Integer score) {
        this.id = resultId;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Test getTest() {
        return test;
    }

    public Integer getScore() {
        return score;
    }
}
