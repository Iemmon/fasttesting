package quizsystem.entity;

public class Test {
    private Long id;
    private String name;

    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Test(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
