package org.example.userservice.entity.mapper;

import org.example.userservice.entity.User;
import org.example.userservice.entity.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {

}
