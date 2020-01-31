package testingsystem.entity;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Random;

public class User {
    private Long userId;
    private String email;
    private String password;
    private final String salt;
    private double averageMark;
    private Role role;

    public User(Builder builder) {
        this.userId = builder.id;
        this.email = builder.email;
        this.password = builder.password;

        this.salt = generateSalt();
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public Role getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private String generateSalt() {
        byte[] array = new byte[Byte.SIZE];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.averageMark, averageMark) == 0 &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, salt, averageMark, role);
    }

    public static class Builder {
        private Long id;
        private String email;
        private String password;
        private String salt;
        private double averageMark;
        private Role role;

        public User build() {
            return new User(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withSalt(String salt){
            this.salt = salt;
            return this;
        }

        public Builder withAverageMark(double averageMark){
            this.averageMark = averageMark;
            return this;
        }

        public Builder withRole(Role role){
            this.role = role;
            return this;
        }

    }
}
