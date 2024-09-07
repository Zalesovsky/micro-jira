package org.example.taskservice.service;

import org.example.taskservice.entity.Project;
import org.example.taskservice.entity.dto.ProjectDto;

import java.util.List;
import java.util.UUID;

public interface ProjectService {

    void add(ProjectDto projectDto);

    Project getById(UUID id);

    Project getByName(String name);

    List<Project> getAll();

    void update(ProjectDto projectDto);

    void remove(UUID id);

}
