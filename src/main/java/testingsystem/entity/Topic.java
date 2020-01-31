package testingsystem.entity;

public class Topic {
    private Long id;
    private String topicName;

    public Topic(Long id, String topicName) {
        this.topicName = topicName;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }
}
