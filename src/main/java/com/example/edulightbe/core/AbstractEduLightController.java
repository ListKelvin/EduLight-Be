package com.example.edulightbe.core;

import com.example.edulightbe.errors.EduLightException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEduLightController<EntityType extends ResponsibleEntity<ResponseType>, IdType, CreateDto extends DtoBase<EntityType>, UpdateDto extends DtoBase<EntityType>, ResponseType> implements EduLightController<EntityType, IdType, CreateDto, UpdateDto, ResponseType> {
    @Autowired
    protected EduLightService<EntityType, IdType, CreateDto, UpdateDto> service;

    @Override
    public List<ResponseType> doGetMany() throws EduLightException {
//        Page<EntityType> entityPage = service.findAll(filter);
//        GetManyResponse<ResponseType> response = new GetManyResponse<>();
//        response.setPage(entityPage.getNumber()+1);
//        response.setPerPage(entityPage.getSize());
//        response.setTotalPage(entityPage.getTotalPages());
//        response.setTotalRecord(entityPage.getTotalElements());
        List<ResponseType> objs = new ArrayList<>();
//        for (EntityType entityType : entityPage.toList()) {
//            objs.add(entityType.toResponseDto());
//        }
//        response.setData(objs);
        List<EntityType> list = service.findAll();
        for (EntityType entityType : list) {
            objs.add(entityType.toResponseDto());
        }
        return objs;
    }

    @Override
    public ResponseType doGet(IdType id) throws EduLightException {
        EntityType entity = service.findById(id);
        return entity.toResponseDto();
    }

    @Override
    public ResponseType doPost(CreateDto dto) throws EduLightException {
        EntityType entity = service.create(dto);
        return entity.toResponseDto();
    }

    @Override
    public ResponseType doPut(IdType id, UpdateDto dto) throws EduLightException {
        EntityType entity = service.update(id, dto);
        return entity.toResponseDto();
    }

    @Override
    public ResponseType doDelete(IdType id) throws EduLightException {
        EntityType entity = service.delete(id);
        return entity.toResponseDto();
    }

}
