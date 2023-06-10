package com.easybank.backend.repository;

import com.easybank.backend.entity.Loan;
import com.easybank.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	List<Loan> findAllByUserOrderByStartDateDesc(User user);

}
