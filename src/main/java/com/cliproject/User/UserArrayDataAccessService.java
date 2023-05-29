package com.cliproject.User;


import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;

public class UserArrayDataAccessService implements UserDAO {
    private static final List<User> users ;
    static {
        users = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            Faker faker = new Faker();
            users.add(new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress()));
        }
    }

    public List<User> getUsers () {
            return users;
        }
    }
