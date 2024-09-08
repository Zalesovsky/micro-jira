package org.example.userservice.entity.mapper;

import org.example.userservice.entity.User;
import org.example.userservice.entity.dto.UserEventDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEventMapper extends Mappable<User, UserEventDto> {

}
