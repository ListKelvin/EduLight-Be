package com.example.edulightbe.dtos.response;

import com.example.edulightbe.dtos.accounts.AccountCreatorDto;
import com.example.edulightbe.utils.enums.AccountGenderEnum;
import com.example.edulightbe.utils.enums.AccountRoleEnum;
import com.example.edulightbe.utils.enums.AccountStatusEnum;
import lombok.Data;

import java.time.Instant;

@Data
public class AccountResponseDto  {
    private String id;
    private String email;
    private AccountRoleEnum role;
    private AccountGenderEnum gender;
    private String fname;
    private String lname;
    private String phone;
    private String avt;
    private Instant createdAt;
    private AccountStatusEnum status = AccountStatusEnum.ACTIVE;
    private AccountCreatorDto createdBy;
}
