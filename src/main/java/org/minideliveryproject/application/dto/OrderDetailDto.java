package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDetailDto {

    // findOrderDetailListByStoreMstSeq
    private BigInteger orderMstSeq;

    private String storeName;
    private BigInteger storeMstSeq;
    private Timestamp orderDate;
    private String itemName;
    private BigInteger itemMstSeq;
    private Integer itemQuantity;
    private Integer itemPrice;
    private String requests;
    private String payment;
    private BigInteger userMstSeq;
}
