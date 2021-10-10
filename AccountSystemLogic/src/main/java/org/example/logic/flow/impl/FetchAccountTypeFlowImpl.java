package org.example.logic.flow.impl;

import org.example.logic.flow.FetchAccountTypeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        return accountTypeTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        return accountTypeTranslator.getAllAccountTypes();
    }


}
