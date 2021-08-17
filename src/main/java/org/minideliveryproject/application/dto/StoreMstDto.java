package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class StoreMstDto {

    private Long seq;

    private FranchiseMstDto franchiseMstDto;

    private UserMstDto userMstDto;

    private String storeType;

    private String foodType; // 업종

    private String storeState;

    private AddressDto addressDto;

    private String deleteType;

    private CommonColumnDto commonColumn;

    private String storeName;
    private String storeImgUrl;
    private String storeTel;
    private LocalTime storeHop;          // 영업시간
    private Integer minOrdPrice;      // 최소주문금액
    private LocalDate contDate;       // 계약일자
    private LocalDate contExpDate;    // 계약만료일자
    private LocalDate contRenewDate;  // 재계약일자
    private Integer contCnt;          // 계약횟수


}
