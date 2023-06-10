package com.easybank.backend.service.impl;

import com.easybank.backend.entity.Notice;
import com.easybank.backend.repository.NoticeRepository;
import com.easybank.backend.service.NoticeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> findAllActiveNotice() {
        LocalDate now = LocalDate.now();
        return noticeRepository.findAllByNoticeBeginDateBeforeAndNoticeEndDateAfter(now, now);
    }
}
