package org.example.taskservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskservice.entity.Issue;
import org.example.taskservice.entity.dto.IssueDto;
import org.example.taskservice.entity.mapper.IssueMapper;
import org.example.taskservice.repository.IssueRepository;
import org.example.taskservice.service.IssueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final IssueMapper issueMapper;

    @Override
    public void add(IssueDto issueDto) {
        issueRepository.save(issueMapper.toEntity(issueDto));
    }

    @Override
    public Issue getById(UUID id) {
        return id != null ? issueRepository.findById(id).orElseThrow() : null;
    }

    @Override
    public Issue getByTitle(String title) {
        return title != null ? issueRepository.findByTitle(title).orElseThrow() : null;
    }

    @Override
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    @Override
    public void update(IssueDto issueDto) {
        issueRepository.findById(issueDto.getId()).ifPresentOrElse(
                findedIssue -> {
                    issueMapper.updateEntityFromDto(findedIssue, issueDto);
                    issueRepository.save(findedIssue);
                },
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

    @Override
    public void remove(UUID id) {
        issueRepository.findById(id).ifPresentOrElse(
                issueRepository::delete,
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

}
