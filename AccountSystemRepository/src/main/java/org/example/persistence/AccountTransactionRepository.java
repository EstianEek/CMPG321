package org.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountTransaction;
import za.ac.nwu.domain.persistence.AccountType;


@Repository
public interface AccountTransactionRepository extends JpaRepository <AccountTransaction, Long> {

    @Query(value = "SELECT " +
            "       TRANSACTION_ID" +
            "       MEMBER_ID" +
            "       TRANSACTION_DATE" +
            "       AMOUNT" +
            "   FROM" +
            "       ESTIAN.ACCOUNT_TRANSACTION" +
            "   WHERE MNEMONIC = :accountTypeId ", nativeQuery = true)
    AccountType getTransactionIdNativeQuery(Long accountTypeId);

    @Query(value = "SELECT" +
            "       t" +
            "   FROM" +
            "       AccountTransaction t" +
            "   WHERE t.accountTypeId = :accountTypeId")
    AccountType getAccountTypeByMnemonic(Long accountTypeId);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.AccountTypeDto(" +
            "       t.memberId" +
            "       t.amount" +
            "       t.transactionDate)" +
            "   FROM" +
            "       AccountTransaction t" +
            "   WHERE t.accountTypeId = :accountTypeId")
    AccountTypeDto getAccountTypeDtoByMnemonic(Long mnemonic);
}
