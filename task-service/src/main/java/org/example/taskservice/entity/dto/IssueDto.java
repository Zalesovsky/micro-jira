package org.example.taskservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {

    private UUID id;

    private String title;

    private String description;

    @NonNull
    private UUID projectId;

    private ProjectDto project;

    @NonNull
    private UUID reporterUserId;

    private UUID assigneeUserId;

}
