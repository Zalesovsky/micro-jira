package org.example.taskservice.service;

import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.UserEventDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void add(UserEventDto userEventDto);

    User getById(UUID id);

    List<User> getAll();

    void update(UserEventDto userEventDto);

    void remove(UUID id);

}
