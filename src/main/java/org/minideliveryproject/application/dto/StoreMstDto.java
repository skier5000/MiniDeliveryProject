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
    private String addressBasic;
    private String addressDetail;
    private String city;
    private String zipcode;
    private Integer contCnt;
    private Date contDate;
    private Date contExpDate;
    private Date contRenewDate;
    private String deleteType;
    private String foodType;
    private Integer MinOrdPrice;
    private Date storeHop;
    private String storeImgUrl;
    private String storeName;
    private String storeState;
    private String storeTel;
    private String storeType;
    private Long userMstSeq;

    private Long franchiseMstSeq;
    private String franchiseName;     // 프랜차이즈 명
    private String franchiseIssue;    // 프랜차이즈 이슈사항
    private String franchiseRemark;   // 프랜차이즈 비고

    private CommonColumnDto commonColumnDto;
}
