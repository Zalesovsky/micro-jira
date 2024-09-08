package org.example.taskservice.kafka.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.dto.UserEventDto;
import org.example.taskservice.kafka.service.UserEventListenService;
import org.example.taskservice.service.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserEventListenServiceImpl implements UserEventListenService {

    private final UserService userService;

    @Override
    @KafkaListener(topics = "${spring.kafka.topic.user-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserEventDto userEventDto) {
        if (userEventDto.isCreateEvent()) {
            userService.add(userEventDto);
        } else if (userEventDto.isUpdateEvent()) {
            userService.update(userEventDto);
        } else if (userEventDto.isDeleteEvent()) {
            userService.remove(userEventDto.getId());
        }
    }

}
