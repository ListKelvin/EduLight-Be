package com.example.edulightbe.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
