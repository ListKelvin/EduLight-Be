package com.example.edulightbe.dtos.courses;

import com.example.edulightbe.core.DtoBase;
import com.example.edulightbe.entities.Course;
import com.example.edulightbe.utils.IsEnum;
import com.example.edulightbe.utils.enums.CourseCategoryEnum;
import com.example.edulightbe.utils.enums.CourseLevelEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCourseDto implements DtoBase<Course> {
    @NotBlank(message = "Title must be not blank")
    private String title;

    @NotBlank(message = "Title must be not blank")
    private String description;

    @NotBlank(message = "Please select the category for this course")
    @IsEnum(enumClass = CourseCategoryEnum.class)
    private String category;

    @NotBlank(message = "Please select the level for this course")
    @IsEnum(enumClass = CourseLevelEnum.class)
    private String level;

    @NotBlank(message = "Please enter the price for this course")
    private Float price;

    private String thumbnail;

    @Override
    public Course toEntity() {
        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setCategory(category);
        course.setLevel(level);
        course.setPrice(price);
        course.setThumbnail(thumbnail);
        return course;
    }
}
