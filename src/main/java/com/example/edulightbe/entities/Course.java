package com.example.edulightbe.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    @Column(nullable = false, unique = true, length = 60)
    private String title;

    @Column(name = "description")
    private String description;

    // make this prop as an enum
    @Column(nullable = false)
    private String category;

    @Column(name = "level",nullable = false)
    private String level;

    //(foreign key references User.user_id)
    @ManyToOne
    private  Account account ;

    @Column(nullable = false)
    private Float price ;

    @Column
    private String image;

    @ManyToOne
    @CreatedBy
    private Account createdBy;


    @ManyToOne
    @LastModifiedBy
    private Account updatedBy;

    @Column
    @LastModifiedDate
    private Instant updatedAt;

    @Column
    @CreatedDate
    private Instant createdAt;


}
