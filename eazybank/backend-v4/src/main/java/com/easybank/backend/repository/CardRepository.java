package com.easybank.backend.repository;

import com.easybank.backend.entity.Card;
import com.easybank.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	
	List<Card> findAllByUser(User user);

}
