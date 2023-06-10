package com.easybank.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notice_detail")
public class Notice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_begin_date")
    private LocalDate noticeBeginDate;

    @Column(name = "notice_end_date")
    private LocalDate noticeEndDate;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
