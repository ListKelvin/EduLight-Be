package com.example.edulightbe.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true, length = 60)
    private String title;

//    @Column()
    private String description;

    // make this prop as an enum
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
   private String level;

    //(foreign key references User.user_id)
    private  Account instructor_id ;

    private Float price ;
    @Column(name = "image")
    private String image;

    @Column(name = "created_by")
    private String createdBy;


    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "createdDate")
    private Date createdDate;


}
