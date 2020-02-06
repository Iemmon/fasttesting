package quizsystem.entity;

public class Result {
    private Long id;
    private Long testId;
    private Long userId;
    private Integer score;

    public Result(Long resultId, Integer score, Long testId, Long userId) {
        this.id = resultId;
        this.score = score;
        this.testId = testId;
        this.userId = userId;
    }

    public Result(Integer score, Long testId, Long userId){
        this.score = score;
        this.testId = testId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getTestId() {
        return testId;
    }

    public Integer getScore() {
        return score;
    }

    public Long getUserId() {
        return userId;
    }
}
