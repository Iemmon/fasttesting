package testingsystem.entity;

import java.util.List;

public class Test {
    Long id;
    String name;
    List<Question> listOfQuestions;

    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
