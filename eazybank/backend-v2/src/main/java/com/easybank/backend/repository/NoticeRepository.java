package com.easybank.backend.repository;

import com.easybank.backend.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	List<Notice> findAllByNoticeBeginDateBeforeAndNoticeEndDateAfter(LocalDate start, LocalDate end);

}
