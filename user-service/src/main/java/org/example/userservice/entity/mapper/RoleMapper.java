package org.example.userservice.entity.mapper;

import org.example.userservice.entity.Role;
import org.example.userservice.entity.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends Mappable<Role, RoleDto> {

}
