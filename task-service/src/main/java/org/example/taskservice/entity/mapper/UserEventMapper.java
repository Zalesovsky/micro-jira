package org.example.taskservice.entity.mapper;

import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.UserEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEventMapper extends Mappable<User, UserEventDto> {

    @Override
    @Mapping(target = "id", ignore = false)
    User toEntity(UserEventDto dto);

}
