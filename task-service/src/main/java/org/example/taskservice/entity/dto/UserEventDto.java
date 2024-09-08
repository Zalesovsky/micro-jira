package org.example.taskservice.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }

    public boolean isCreateEvent() {
        return EventType.CREATE.equals(eventType);
    }

    public boolean isUpdateEvent() {
        return EventType.UPDATE.equals(eventType);
    }

    public boolean isDeleteEvent() {
        return EventType.DELETE.equals(eventType);
    }

}