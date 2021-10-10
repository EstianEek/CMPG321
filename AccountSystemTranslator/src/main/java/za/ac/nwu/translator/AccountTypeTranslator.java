package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);
}
