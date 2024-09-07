package org.example.taskservice.entity.mapper;

import org.example.taskservice.entity.Issue;
import org.example.taskservice.entity.Project;
import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.IssueDto;
import org.example.taskservice.service.ProjectService;
import org.example.taskservice.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class IssueMapper implements Mappable<Issue, IssueDto> {

    private ProjectService projectService;
    private UserService userService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "projectId", target = "project", qualifiedByName = "mapProjectFromId")
    @Mapping(source = "reporterUserId", target = "reporter", qualifiedByName = "mapUserFromId")
    @Mapping(source = "assigneeUserId", target = "assignee", qualifiedByName = "mapUserFromId")
    public abstract Issue toEntity(IssueDto issueDto);

    @Override
    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "reporter.id", target = "reporterUserId")
    @Mapping(source = "assignee.id", target = "assigneeUserId")
    public abstract IssueDto toDto(Issue issue);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "projectId", target = "project", qualifiedByName = "mapProjectFromId")
    @Mapping(source = "reporterUserId", target = "reporter", qualifiedByName = "mapUserFromId")
    @Mapping(source = "assigneeUserId", target = "assignee", qualifiedByName = "mapUserFromId")
    public abstract void updateEntityFromDto(@MappingTarget Issue issue, IssueDto issueDto);

    @Named("mapProjectFromId")
    protected Project mapProjectFromId(UUID projectId) {
        return projectService.getById(projectId);
    }

    @Named("mapUserFromId")
    protected User mapUserFromId(UUID userId) {
        return userService.getById(userId);
    }

}
