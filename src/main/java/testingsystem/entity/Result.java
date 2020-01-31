package testingsystem.entity;

public class Result {
    private Long id;
    private Test test;
    private Integer score;

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
