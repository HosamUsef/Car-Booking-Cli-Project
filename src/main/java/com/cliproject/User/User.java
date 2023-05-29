package com.cliproject.User;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String firsname;
    private String lastname;
    private String email;

    public User(UUID id, String firsname, String lastname, String email) {
        this.id = id;
        this.firsname = firsname;
        this.lastname = lastname;
        this.email = email;
    }

    public User() {
    }

    public User(String firsname, String lastname, String email) {
        this.id=UUID.randomUUID();
        this.firsname = firsname;
        this.lastname = lastname;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firsname='" + firsname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firsname, user.firsname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firsname, lastname, email);
    }
}
