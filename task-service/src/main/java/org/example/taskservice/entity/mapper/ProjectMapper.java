package org.example.taskservice.entity.mapper;

import org.example.taskservice.entity.Project;
import org.example.taskservice.entity.dto.ProjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends Mappable<Project, ProjectDto> {

}
