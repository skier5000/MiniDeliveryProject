package com.minidelivery.application.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <pre>
 * Entity 생성
 * <pre>
 *
 * @author LJB
 * @since 2021.06.20
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용3
 * ------------------------------------------------
 * 2021.06.20.		LJB			최초작성
 */
@Entity
@Getter
@Setter
public class UserMst {

    @Id // Indentity 전략
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeq; //id 시퀀스번호 (PK)
    private String id;
    private String password;
    private String userName;
    private String accessCd; //접근권한 코드
//    private String insUser  ; //Insert User
//    private LocalDateTime insDate; //Insert Date
//    private String updUser; //Update User
//    private LocalDateTime updDate; //Update Date


//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    protected Team team;


}
