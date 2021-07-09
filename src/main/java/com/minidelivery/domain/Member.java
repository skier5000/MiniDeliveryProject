package com.minidelivery.minidelivery.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.06.20.		LJB			최초작성
 */
@Entity
@Data
public class Member {

    @Id
    // Indentity 전략
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeq; //id 시퀀스번호 (PK)
    private String id;
    private String password;
    private String name; //닉네임
    private Integer accessCd; //접근권한 코드
    private Date insDate; //회원가입일자
    private Date pwUpdDate; //패스워드 업데이트 일자


    // Getter and Setter
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
