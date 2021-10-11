package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.AccountTransactionDto;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllAccountTransaction();

    AccountTransactionDto create(AccountTypeDto accountTransaction);

    AccountTransactionDto getAccountTransactionByMnemonicNativeQuery(String mnemonic);

    AccountTransactionDto getAccountTransactionByMnemonic(String mnemonic);

    AccountTransactionDto getAccountTransactionDtoByMnemonic(String mnemonic);
}