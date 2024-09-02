package org.example.userservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private UUID id;

    private String firstName;

    private String lastName;

//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;

}
