package org.example.taskservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.Project;
import org.example.taskservice.entity.dto.ProjectDto;
import org.example.taskservice.entity.mapper.ProjectMapper;
import org.example.taskservice.repository.ProjectRepository;
import org.example.taskservice.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void add(ProjectDto projectDto) {
        projectRepository.save(projectMapper.toEntity(projectDto));
    }

    @Override
    public Project getById(UUID id) {
        return id != null ? projectRepository.findById(id).orElseThrow() : null;
    }

    @Override
    public Project getByName(String name) {
        return name != null ? projectRepository.findByName(name).orElseThrow() : null;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public void update(ProjectDto projectDto) {
        projectRepository.findById(projectDto.getId()).ifPresentOrElse(
                findedProject -> {
                    projectMapper.updateEntityFromDto(findedProject, projectDto);
                    projectRepository.save(findedProject);
                },
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

    @Override
    public void remove(UUID id) {
        projectRepository.findById(id).ifPresentOrElse(
                projectRepository::delete,
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

}
