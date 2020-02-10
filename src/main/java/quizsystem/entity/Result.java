package quizsystem.entity;

public class Result {
    private Long id;
    private Test test;
    private Long userId;
    private Integer score;

    public Result(Long resultId, Integer score, Test test, Long userId) {
        this.id = resultId;
        this.score = score;
        this.test = test;
        this.userId = userId;
    }

    public Result(Integer score, Test test, Long userId){
        this.score = score;
        this.test = test;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }
}
