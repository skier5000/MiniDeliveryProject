package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.minideliveryproject.application.domain.entity.OrderMst;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class StoreMstDto {

    private long seq;
    private Integer contCnt;
    private LocalDate contDate;
    private LocalDate contExpDate;
    private LocalDate contRenewDate;
    private String deleteType;
    private String foodType;
    private Integer MinOrdPrice;
    private LocalTime storeHop;
    private String storeImgUrl;
    private String storeName;
    private String storeState;
    private String storeTel;
    private String storeType;

    // UserMst
    private Long userMstSeq;
    private String userId;
    private String userName;
    private String phoneNumber;
    private String email;

    // FranchiseMst
    private Long franchiseMstSeq;
    private String franchiseName;     // 프랜차이즈 명
    private String franchiseIssue;    // 프랜차이즈 이슈사항
    private String franchiseRemark;   // 프랜차이즈 비고

    // Address
    private String addressBasic;
    private String addressDetail;
    private String city;
    private String zipcode;

    // CommonColumn
    private Timestamp insDate;
    private String insUser;
    private Timestamp updDate;
    private String updUser;
}
