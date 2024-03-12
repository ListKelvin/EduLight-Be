/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.edulightbe.core;

import com.example.edulightbe.errors.EduLightException;
import com.example.edulightbe.errors.EntityNotFoundErrorReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Le Thanh Long
 */
public abstract class AbstractEduLightService<EntityType, IdType, CreateDto extends DtoBase<EntityType>, UpdateDto extends DtoBase<EntityType>> implements EduLightService<EntityType, IdType, CreateDto, UpdateDto> {
    @Autowired
    protected JpaRepository<EntityType, IdType> repository;
    
    protected abstract void beforeCreate(EntityType entity) throws EduLightException;
    protected abstract void beforeUpdate(EntityType oldEntity, EntityType newEntity) throws EduLightException;
    
    @Override
    public List<EntityType> findAll() {
//        Page<EntityType> entityPage;
//        if (dto.toEntity() != null) {
//            entityPage = repository.findAll(Example.of(dto.toEntity()), dto.getPageRequest());
//        } else {
//            entityPage = repository.findAll(dto.getPageRequest());
//        }
        List<EntityType> entities;
//        if (dto.toEntity() != null) {
//            entities = repository.findAll(Example.of(dto.toEntity()));
//        } else {
            entities = repository.findAll();
//        }
        return entities;
    }

    @Override
    public EntityType findById(IdType id) throws EduLightException {
        Optional<EntityType> findResult = repository.findById(id);
        if (findResult.isPresent()) {
            return findResult.get();
        }
        throw new EduLightException(new EntityNotFoundErrorReport("id", id.toString()));
    }

    @Override
    public EntityType create(CreateDto dto) throws EduLightException {
        EntityType entity = dto.toEntity();
        beforeCreate(entity);
        entity = repository.save(entity);
        return entity;
    }

    @Override
    public EntityType update(IdType id, UpdateDto dto) throws EduLightException {
        EntityType oldEntity = findById(id);
        EntityType newEntity = dto.toEntity();
        beforeUpdate(oldEntity, newEntity);
        oldEntity = repository.save(oldEntity);
        return oldEntity;
    }
}
