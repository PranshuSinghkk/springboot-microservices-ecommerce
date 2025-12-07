package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private Long nextId = 1L;
    private List<User> userList= new ArrayList<>();

    public List<User> fetchAllUsers() {
        return userList;
    }

    public List<User> addUser(User user) {
        user.setId(nextId++);
        userList.add(user);
        return userList;
    }

    public Optional<User> fetchUser(Long id) {
        return  userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }


    //Stream through the user list → filter user by ID → get the first match → if found, update details and return true → otherwise return false.
    public boolean updateUser(Long id, User updatedUser) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);

    }
}
