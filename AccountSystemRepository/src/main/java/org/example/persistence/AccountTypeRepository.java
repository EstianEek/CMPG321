package org.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {
}