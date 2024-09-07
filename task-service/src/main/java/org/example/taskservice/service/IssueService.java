package org.example.taskservice.service;

import org.example.taskservice.entity.Issue;
import org.example.taskservice.entity.dto.IssueDto;

import java.util.List;
import java.util.UUID;

public interface IssueService {

    void add(IssueDto issueDto);

    Issue getById(UUID id);

    Issue getByTitle(String title);

    List<Issue> getAll();

    void update(IssueDto issueDto);

    void remove(UUID id);

}
