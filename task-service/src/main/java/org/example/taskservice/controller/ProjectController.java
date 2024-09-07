package org.example.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.Project;
import org.example.taskservice.entity.dto.ProjectDto;
import org.example.taskservice.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody ProjectDto projectDto) {
        projectService.add(projectDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Project> getByUsername(@PathVariable String name) {
        return ResponseEntity.ok(projectService.getByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody ProjectDto projectDto) {
        projectService.update(projectDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") UUID id) {
        projectService.remove(id);
        return ResponseEntity.ok().build();
    }

}
