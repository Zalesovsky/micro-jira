package org.example.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.userservice.entity.Role;
import org.example.userservice.entity.dto.RoleDto;
import org.example.userservice.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody RoleDto roleDto) {
        roleService.add(roleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Role> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(roleService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Role> getByName(@PathVariable String name) {
        return ResponseEntity.ok(roleService.getByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody RoleDto roleDto) {
        roleService.update(roleDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Integer id) {
        roleService.remove(id);
        return ResponseEntity.ok().build();
    }

}
