package za.ac.nwu.translator.impl;

import org.example.persistence.AccountTransactionRepository;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTransactionDto;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountTransaction;
import za.ac.nwu.domain.persistence.AccountType;
import org.example.persistence.AccountTypeRepository;
import za.ac.nwu.translator.AccountTransactionTranslator;
import za.ac.nwu.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransaction() {
        List<AccountTransactionDto> accountTransactionDto = new ArrayList<>();

        try{
            for(AccountTransaction accountTransaction : accountTransactionRepository.findAll()){
                accountTransactionDto.add(new AccountTransactionDto(accountTransaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB",e);
        }
        return null;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTransactionDto.getAccountTransaction());
            return new AccountTransactionDto(accountTransaction);
        } catch(Exception e){
            throw new RuntimeException("Unable to save to DB", e);
        }
    }

    @Override
    public AccountTransactionDto getAccountTransactionByMnemonicNativeQuery(String mnemonic){
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.getAccountTransactionByMnemonicNativeQuery(mnemonic);
            return new AccountTransactionDto(accountTransaction);
        } catch(Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTransactionDto getAccountTransactionByMnemonic(String mnemonic){
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.getAccountTransactionByMnemonic(mnemonic);
            return new AccountTransactionDto(accountTransaction);
        } catch(Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTransactionDto getAccountTransactionDtoByMnemonic(String mnemonic) {
        try{
            AccountTransactionDto accountTransaction = accountTransactionRepository.getAccountTransactionDtoByMnemonic(mnemonic);
            return new AccountTransactionDto(accountTransaction);
        } catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
