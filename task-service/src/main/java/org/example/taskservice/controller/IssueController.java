package org.example.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.Issue;
import org.example.taskservice.entity.dto.IssueDto;
import org.example.taskservice.service.IssueService;
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
@RequestMapping("/api/v1/issue")
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody IssueDto issueDto) {
        issueService.add(issueDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Issue> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Issue> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(issueService.getByTitle(title));
    }

    @GetMapping
    public ResponseEntity<List<Issue>> getAll() {
        return ResponseEntity.ok(issueService.getAll());
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody IssueDto issueDto) {
        issueService.update(issueDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") UUID id) {
        issueService.remove(id);
        return ResponseEntity.ok().build();
    }

}
