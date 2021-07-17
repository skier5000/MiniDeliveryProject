package org.minideliveryproject.application.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_mst_seq")
    private StoreMst storeMst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mst_seq")
    private UserMst userMst;

    private String reviewTitle;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private Double reviewGrade;
    private String replyContent;
    private LocalDateTime replyDate;




}
