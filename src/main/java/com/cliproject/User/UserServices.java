package com.cliproject.User;

import java.util.List;
import java.util.UUID;

public class UserServices {

    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserServices(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public void getAllUsers() {
        List<User> users = userArrayDataAccessService.getUsers();
        for (User user : users) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    public User getSingleUser(UUID id) {
        List<User>  users = userArrayDataAccessService.getUsers();
        return users.stream().filter(user -> user.getId().equals(id))
                .findFirst().
                orElseThrow(()-> new IllegalArgumentException("Customer with  id [%s] not found")) ;
    }
}
