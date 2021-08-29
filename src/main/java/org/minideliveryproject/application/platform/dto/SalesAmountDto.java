package org.minideliveryproject.application.platform.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

public interface SalesAmountDto {

    // 마스터
    String getStoreType();
    BigInteger getStoreMstSeq();
    String getStoreName();
    Date getContDate();
    Date getContRenewDate();
    String getStoreTel();
    BigInteger getTotalPriceByOrder();
    BigInteger getTotalPrice();

    // 디테일
    BigInteger getOrderMstSeq();
    Timestamp getOrderDate();
    BigInteger getUserMstSeq();
    String getUserName();
    BigInteger getItemMstSeq();
    String getItemName();
    Integer getItemPrice();
}
