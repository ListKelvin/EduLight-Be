package com.example.edulightbe.entities;

import com.example.edulightbe.utils.enums.AccountStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    @CreatedDate
    private Instant createdAt;

    @Column(nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    private String status;

    @OneToMany
    private Account account;

    @OneToMany
    private Course course;


}
