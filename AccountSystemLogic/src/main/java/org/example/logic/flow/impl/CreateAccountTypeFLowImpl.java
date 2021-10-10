package org.example.logic.flow.impl;

import org.example.logic.flow.CreateAccountTypeFlow;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTypeDto;

import javax.transaction.Transactional;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFLowImpl implements CreateAccountTypeFlow {
    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        return null;
    }
}
