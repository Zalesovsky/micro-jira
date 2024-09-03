package org.example.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userservice.entity.User;
import org.example.userservice.entity.dto.UserDto;
import org.example.userservice.entity.mapper.UserMapper;
import org.example.userservice.repository.UserRepository;
import org.example.userservice.service.UserService;
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
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
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
                    throw new NoSuchElementException();
                }
        );
    }

    @Override
    public void remove(UUID id) {
        userRepository.findById(id).ifPresentOrElse(
                userRepository::delete,
                () -> {
                    throw new NoSuchElementException();
                }
        );
    }

}
