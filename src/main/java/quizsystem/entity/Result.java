package quizsystem.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(id, result.id) &&
                Objects.equals(test, result.test) &&
                Objects.equals(userId, result.userId) &&
                Objects.equals(score, result.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, test, userId, score);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", test=" + test +
                ", userId=" + userId +
                ", score=" + score +
                '}';
    }
}
