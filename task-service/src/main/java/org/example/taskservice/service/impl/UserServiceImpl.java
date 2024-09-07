package org.example.taskservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.UserDto;
import org.example.taskservice.entity.mapper.UserMapper;
import org.example.taskservice.repository.UserRepository;
import org.example.taskservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void add(UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public User getById(UUID id) {
        return id != null ? userRepository.findById(id).orElseThrow() : null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(UserDto userDto) {
        userRepository.findById(userDto.getId()).ifPresentOrElse(
                findedUser -> {
                    userMapper.updateEntityFromDto(findedUser, userDto);
                    userRepository.save(findedUser);
                },
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

    @Override
    public void remove(UUID id) {
        userRepository.findById(id).ifPresentOrElse(
                userRepository::delete,
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

}
