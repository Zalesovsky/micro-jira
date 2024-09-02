package org.example.userservice.service;

import org.example.userservice.entity.User;
import org.example.userservice.entity.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void add(UserDto userDto);

    User get(UUID id);

    List<User> getAll();

    void update(UserDto userDto);

    void remove(UUID id);

}
