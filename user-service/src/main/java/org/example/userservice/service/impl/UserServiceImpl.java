package org.example.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userservice.entity.User;
import org.example.userservice.entity.dto.UserDto;
import org.example.userservice.entity.dto.UserEventDto;
import org.example.userservice.entity.mapper.UserEventMapper;
import org.example.userservice.entity.mapper.UserMapper;
import org.example.userservice.repository.UserRepository;
import org.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final UserEventMapper userEventMapper;
    private final KafkaTemplate<String, UserEventDto> kafkaTemplate;

    @Value("${spring.kafka.topic.user-topic}")
    private String userTopicName;


    @Override
    public void add(UserDto userDto) {

        User user = userMapper.toEntity(userDto);
        userRepository.saveAndFlush(user);

        UserEventDto userEventDto = userEventMapper.toDto(user);
        userEventDto.setEventType(UserEventDto.EventType.CREATE);
        kafkaTemplate.send(userTopicName, userEventDto);
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
        User findedUser = getById(userDto.getId());
        userMapper.updateEntityFromDto(findedUser, userDto);
        User updatedUser = userRepository.saveAndFlush(findedUser);
        UserEventDto userEventDto = userEventMapper.toDto(updatedUser);
        userEventDto.setEventType(UserEventDto.EventType.UPDATE);
        kafkaTemplate.send(userTopicName, userEventDto);
    }

    @Override
    public void remove(UUID id) {
        User findedUser = getById(id);
        userRepository.delete(findedUser);
        userRepository.flush();
        UserEventDto userEventDto = userEventMapper.toDto(findedUser);
        userEventDto.setEventType(UserEventDto.EventType.DELETE);
        kafkaTemplate.send(userTopicName, userEventDto);
    }

}
