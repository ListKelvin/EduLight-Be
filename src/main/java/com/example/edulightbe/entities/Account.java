package com.example.edulightbe.entities;

import com.example.edulightbe.core.ResponsibleEntity;
import com.example.edulightbe.dtos.accounts.AccountCreatorDto;
import com.example.edulightbe.dtos.response.AccountResponseDto;
import com.example.edulightbe.utils.enums.AccountGenderEnum;
import com.example.edulightbe.utils.enums.AccountRoleEnum;
import com.example.edulightbe.utils.enums.AccountStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Account implements ResponsibleEntity<AccountResponseDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false)
    private AccountRoleEnum role;

    @Column(nullable = false)
    private AccountGenderEnum gender;

    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String fname;

    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String lname;

    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String avt;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    private AccountStatusEnum status;

    @CreatedBy
    @ManyToOne
    private Account createdBy;

    @Override
    public AccountResponseDto toResponseDto() {
        AccountResponseDto responseDto = new AccountResponseDto();
        responseDto.setId(id);
        responseDto.setEmail(email);
        responseDto.setRole(role);
        responseDto.setGender(gender);
        responseDto.setFname(fname);
        responseDto.setLname(lname);
        responseDto.setPhone(phone);
        responseDto.setAvt(avt);
        responseDto.setCreatedAt(createdAt);
        responseDto.setStatus(status);
        if (createdBy != null) {
            responseDto.setCreatedBy(createdBy.toCreatorDto());
        }

        return responseDto;
    }

    public AccountCreatorDto toCreatorDto() {
        AccountCreatorDto creatorDto = new AccountCreatorDto();
        creatorDto.setId(id);
        creatorDto.setEmail(email);
        creatorDto.setFname(fname);
        creatorDto.setLname(lname);
        creatorDto.setPhone(phone);
        return creatorDto;
    }
}
