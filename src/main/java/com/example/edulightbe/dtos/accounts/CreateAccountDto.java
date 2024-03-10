package com.example.edulightbe.dtos.accounts;

import com.example.edulightbe.core.DtoBase;
import com.example.edulightbe.entities.Account;
import com.example.edulightbe.utils.IsEnum;
import com.example.edulightbe.utils.enums.AccountGenderEnum;
import com.example.edulightbe.utils.enums.AccountRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAccountDto implements DtoBase<Account> {
    @NotBlank(message = "Email must be not blank")
    @Email(message = "Invalid email")
    private String email;

    @IsEnum(enumClass = AccountRoleEnum.class)
    private String role;

    @IsEnum(enumClass = AccountGenderEnum.class)
    private String gender;

    @NotBlank(message = "First name must be not blank")
    @Size(max = 30, message = "Length of first name must not exceed 30")
    private String fname;

    @NotBlank(message = "Last name must be not blank")
    @Size(max = 30, message = "Length of last name must not exceed 30")
    private String lname;

    @NotBlank(message = "Phone number must be not blank")
    @Pattern(regexp = "(84|0[35789])+([0-9]{8})\\b", message = "Invalid phone number")
    private String phone;

    private String avt;

    @Override
    public Account toEntity() {
        Account account = new Account();
        account.setEmail(email);
        account.setRole(AccountRoleEnum.valueOf(role));
        account.setGender(AccountGenderEnum.valueOf(gender));
        account.setFname(fname);
        account.setLname(lname);
        account.setPhone(phone);
        account.setAvt(avt);
        return account;
    }
}
