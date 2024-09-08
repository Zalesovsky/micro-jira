package org.example.taskservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.UserEventDto;
import org.example.taskservice.entity.mapper.UserEventMapper;
import org.example.taskservice.repository.UserRepository;
import org.example.taskservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEventMapper userEventMapper;

    @Override
    public void add(UserEventDto userEventDto) {
        userRepository.save(userEventMapper.toEntity(userEventDto));
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
    public void update(UserEventDto userEventDto) {
        userRepository.findById(userEventDto.getId()).ifPresentOrElse(
                findedUser -> {
                    userEventMapper.updateEntityFromDto(findedUser, userEventDto);
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
