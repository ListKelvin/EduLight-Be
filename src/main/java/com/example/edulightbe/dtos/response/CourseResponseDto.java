package com.example.edulightbe.dtos.response;

import com.example.edulightbe.dtos.accounts.AccountCreatorDto;
import com.example.edulightbe.entities.Account;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
public class CourseResponseDto {
    private Integer id;

    private String title;

    private String description;

    private String category;

    private String level;

    private Float price;

    private String thumbnail;

    private AccountCreatorDto createdBy;

    private AccountCreatorDto updatedBy;

    private Instant updatedAt;

    private Instant createdAt;

}
