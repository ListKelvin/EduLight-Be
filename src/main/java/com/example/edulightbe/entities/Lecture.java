package com.example.edulightbe.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String title;

    @Column(nullable = false, columnDefinition = "NTEXT")
    private String description;


    @Column
    private String  video_url;

    @Column
    private Integer order_number;

    @ManyToOne
    private Course course;

}
