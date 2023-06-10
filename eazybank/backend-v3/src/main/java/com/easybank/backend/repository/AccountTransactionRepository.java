package com.easybank.backend.repository;

import com.easybank.backend.entity.AccountTransaction;
import com.easybank.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
	
	List<AccountTransaction> findAllByUserOrderByTransactionDateDesc(User user);

}
