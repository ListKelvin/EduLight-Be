package com.example.edulightbe.dtos.courses;

import com.example.edulightbe.core.DtoBase;
import com.example.edulightbe.entities.Account;
import com.example.edulightbe.entities.Course;
import com.example.edulightbe.utils.enums.AccountGenderEnum;
import com.example.edulightbe.utils.enums.AccountRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCourseDto implements DtoBase<Course> {

    @NotBlank(message = "Title must be not blank")
    private String title;
    @NotBlank(message = "Title must be not blank")
    private String description;


    @Override
    public Course toEntity() {
        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        return course;
    }
}
