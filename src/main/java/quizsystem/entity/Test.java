package quizsystem.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id) &&
                Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
