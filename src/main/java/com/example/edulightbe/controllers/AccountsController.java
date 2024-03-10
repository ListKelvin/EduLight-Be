package com.example.edulightbe.controllers;

import com.example.edulightbe.core.AbstractEduLightController;
import com.example.edulightbe.dtos.accounts.CreateAccountDto;
import com.example.edulightbe.dtos.accounts.UpdateAccountDto;
import com.example.edulightbe.dtos.response.AccountResponseDto;
import com.example.edulightbe.entities.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController extends AbstractEduLightController<Account, String, CreateAccountDto, UpdateAccountDto, AccountResponseDto> {

}
