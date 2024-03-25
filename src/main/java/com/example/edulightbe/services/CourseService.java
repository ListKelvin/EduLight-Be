package com.example.edulightbe.services;

import com.example.edulightbe.core.AbstractEduLightService;
import com.example.edulightbe.dtos.courses.CreateCourseDto;
import com.example.edulightbe.dtos.courses.UpdateCourseDto;
import com.example.edulightbe.entities.Account;
import com.example.edulightbe.entities.Course;
import com.example.edulightbe.errors.EduLightException;
import org.springframework.stereotype.Service;

@Service
public class CourseService  extends AbstractEduLightService<Course, String, CreateCourseDto, UpdateCourseDto> {




    @Override
    public Course delete(String id) throws EduLightException {
        return null;
    }

    @Override
    protected void beforeCreate(Course entity) throws EduLightException {

    }

    @Override
    protected void beforeUpdate(Course oldEntity, Course newEntity) throws EduLightException {

    }
}
