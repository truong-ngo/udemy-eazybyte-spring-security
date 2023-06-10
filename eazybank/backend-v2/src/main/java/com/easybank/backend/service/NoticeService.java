package com.easybank.backend.service;

import com.easybank.backend.entity.Notice;

import java.time.LocalDate;
import java.util.List;

public interface NoticeService {
    List<Notice> findAllActiveNotice();
}
