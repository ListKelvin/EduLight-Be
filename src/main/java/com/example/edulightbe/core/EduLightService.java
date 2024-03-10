package com.example.edulightbe.core;

import com.example.edulightbe.errors.EduLightException;

import java.util.List;

public interface EduLightService<EntityType, IdType, CreateDto extends DtoBase<EntityType>, UpdateDto extends DtoBase<EntityType>> {
//    FilterDto dto
    List<EntityType> findAll();
    EntityType findById(IdType id) throws EduLightException;
    EntityType create(CreateDto dto) throws EduLightException;
    EntityType update(IdType id, UpdateDto dto) throws EduLightException;
    EntityType delete(IdType id) throws EduLightException;
}
