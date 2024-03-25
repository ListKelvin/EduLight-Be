package com.example.edulightbe.controllers;

import com.example.edulightbe.core.AbstractEduLightController;
import com.example.edulightbe.dtos.courses.CreateCourseDto;
import com.example.edulightbe.dtos.courses.UpdateCourseDto;
import com.example.edulightbe.dtos.response.CourseResponseDto;
import com.example.edulightbe.entities.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController  extends AbstractEduLightController<Course, String, CreateCourseDto, UpdateCourseDto, CourseResponseDto> {
}
