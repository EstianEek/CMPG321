package org.example.logic.flow;

import za.ac.nwu.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();

    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
