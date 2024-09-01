package org.example.userservice.service;

import org.example.userservice.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void add(User user);

    User get(UUID id);

    List<User> getAll();

    void update(User user);

    void remove(UUID id);

}
