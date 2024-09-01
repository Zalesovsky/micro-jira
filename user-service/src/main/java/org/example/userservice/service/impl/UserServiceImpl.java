package org.example.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userservice.entity.User;
import org.example.userservice.repository.UserRepository;
import org.example.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void add(User user) {

    }

    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void remove(UUID id) {

    }

}
