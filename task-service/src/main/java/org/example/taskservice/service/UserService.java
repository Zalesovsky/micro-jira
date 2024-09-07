package org.example.taskservice.service;

import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void add(UserDto userDto);

    User getById(UUID id);

    List<User> getAll();

    void update(UserDto userDto);

    void remove(UUID id);

}
