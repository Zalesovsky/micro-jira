package org.example.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userservice.entity.Role;
import org.example.userservice.entity.dto.RoleDto;
import org.example.userservice.entity.mapper.RoleMapper;
import org.example.userservice.repository.RoleRepository;
import org.example.userservice.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public void add(RoleDto roleDto) {
        roleRepository.save(roleMapper.toEntity(roleDto));
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name).orElseThrow();
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void update(RoleDto roleDto) {
        roleRepository.findById(roleDto.getId()).ifPresentOrElse(
                findedRole -> {
                    roleMapper.updateEntityFromDto(findedRole, roleDto);
                    roleRepository.save(findedRole);
                },
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

    @Override
    public void remove(Integer id) {
        roleRepository.findById(id).ifPresentOrElse(
                roleRepository::delete,
                () -> {
                    throw new NoSuchElementException("No value present");
                }
        );
    }

}
