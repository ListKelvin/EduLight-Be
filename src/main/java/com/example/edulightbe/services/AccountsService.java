package com.example.edulightbe.services;

import com.example.edulightbe.core.AbstractEduLightService;
import com.example.edulightbe.dtos.accounts.CreateAccountDto;
import com.example.edulightbe.dtos.accounts.UpdateAccountDto;
import com.example.edulightbe.entities.Account;
import com.example.edulightbe.errors.EduLightException;
import com.example.edulightbe.errors.ValidationError;
import com.example.edulightbe.errors.ValidationErrorReport;
import com.example.edulightbe.repositories.AccountsRepository;
import com.example.edulightbe.utils.enums.AccountStatusEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountsService extends AbstractEduLightService<Account, String, CreateAccountDto, UpdateAccountDto> {
//    @Autowired
//    private AuthenticationService authenticationService;

    @Override
    public List<Account> findAll() {
//        Account currentUser = authenticationService.getCurrentUser();
//        if (currentUser.getRole() == AccountRoleEnum.STAFF) {
//            filterAccountDto.setCreatedById(currentUser.getId());
//        }
        return super.findAll();
    }

    @Override
    protected void beforeCreate(Account entity) throws EduLightException {
        AccountsRepository repository = (AccountsRepository) this.repository;
        List<ValidationError> errors = new ArrayList<>();
        Optional<Account> findResult;

        // Check unique email
        findResult = repository.findByEmail(entity.getEmail());
        if (findResult.isPresent()) {
            errors.add(new ValidationError("email", entity.getEmail(), "Email already existed"));
        }

        // Check unique phone number
        findResult = repository.findByPhone(entity.getPhone());
        if (findResult.isPresent()) {
            errors.add(new ValidationError("phone", entity.getPhone(), "Phone number already existed"));
        }

        if (!errors.isEmpty()) {
            throw new EduLightException(new ValidationErrorReport(errors));
        }

        entity.setStatus(AccountStatusEnum.ACTIVE);
    }

    @Override
    protected void beforeUpdate(Account oldEntity, Account newEntity) throws EduLightException {
        AccountsRepository repository = (AccountsRepository) this.repository;
        List<ValidationError> errors = new ArrayList<>();
        Optional<Account> findResult;

        // Check unique phone number
        findResult = repository.findByPhone(newEntity.getPhone());
        if (findResult.isPresent() && !findResult.get().getId().equals(oldEntity.getId())) {
            errors.add(new ValidationError("phone", newEntity.getPhone(), "Phone number already existed"));
        }

        if (!errors.isEmpty()) {
            throw new EduLightException(new ValidationErrorReport(errors));
        }

        oldEntity.setGender(newEntity.getGender());
        oldEntity.setFname(newEntity.getFname());
        oldEntity.setLname(newEntity.getLname());
        oldEntity.setPhone(newEntity.getPhone());
        oldEntity.setAvt(newEntity.getAvt());
    }

    @Override
    public Account delete(String id) throws EduLightException {
        return null;
    }

//    public Account updateStatus(String id, UpdateStatusDto dto) throws ZooManagementException{
//        Account currentUser = authenticationService.getCurrentUser();
//        AccountsRepository repository = (AccountsRepository) this.repository;
//        Account account = findById(id);
//        if (account.getId().equals(currentUser.getId())) {
//            throw new ZooManagementException(new ErrorReport<>("Cannot update status of your own account!", account.getId()));
//        }
//        account.setStatus(dto.toEntity().getStatus());
//        account= repository.save(account);
//        return account;
//    }
}
