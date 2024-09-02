package org.example.userservice.entity.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface Mappable<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(E entity, @MappingTarget D dto);

}
