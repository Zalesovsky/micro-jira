package org.example.userservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEventDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private EventType eventType;


    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }

}