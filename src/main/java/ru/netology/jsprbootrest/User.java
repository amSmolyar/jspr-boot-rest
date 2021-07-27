package ru.netology.jsprbootrest;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Validated
public class User {
    @Size(min = 4, max = 15)
    private String user;
    @Size(min = 6, max = 20)
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return user.equals(user1.user) &&
                password.equals(user1.password);
    }

    @Override
    public int hashCode() {
        return user.hashCode() + password.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
