package org.example.userservice.service;

import org.example.userservice.entity.User;
import org.example.userservice.entity.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void add(UserDto userDto);

    User getById(UUID id);

    User getByUsername(String username);

    List<User> getAll();

    void update(UserDto userDto);

    void remove(UUID id);

}
