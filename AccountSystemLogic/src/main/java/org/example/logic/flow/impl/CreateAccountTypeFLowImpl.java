package org.example.logic.flow.impl;

import org.example.logic.flow.CreateAccountTypeFlow;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFLowImpl implements CreateAccountTypeFlow {
    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        if(null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }

    private final AccountTypeTranslator accountTypeTranslator;

    private CreateAccountTypeFLowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }


}
