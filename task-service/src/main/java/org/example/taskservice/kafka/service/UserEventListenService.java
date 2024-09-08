package org.example.taskservice.kafka.service;

import org.example.taskservice.entity.dto.UserEventDto;

public interface UserEventListenService {

    void listen(UserEventDto userEventDto);

}
