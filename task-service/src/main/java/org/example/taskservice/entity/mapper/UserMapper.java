package org.example.taskservice.entity.mapper;

import org.example.taskservice.entity.User;
import org.example.taskservice.entity.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {

}
