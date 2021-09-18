package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

public interface ItemMstDto {

    Long getSeq();             // 개인점포코드
    String getStoreName();     // 개인점포명
    String getItemName();      // 상품명
    Integer getItemPrice();    // 상품가격
    String getItemCategory();  // 상품구분



}
