package org.example.userservice.service;


import org.example.userservice.entity.Role;
import org.example.userservice.entity.dto.RoleDto;

import java.util.List;

public interface RoleService {

    void add(RoleDto roleDto);

    Role getById(Integer id);

    Role getByName(String name);

    List<Role> getAll();

    void update(RoleDto roleDto);

    void remove(Integer id);


}
