package testingsystem.entity;

import java.util.List;

public class Topic {
    private Long id;
    private String topicName;
    private List<Test> listOfTests;

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

    public List<Test> getListOfTests() {
        return listOfTests;
    }
}
