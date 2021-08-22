package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDetailDto {

    private long seq;

    private ItemMstDto itemMstDto;

    private Integer itemQuantity;    // 수량
    private Integer itemPrice;       // 가격

    // itemMst
    private int itemMstSeq;

    // orderMst
    private int orderMstSeq;

//    private String deleteType;
//    private LocalDate orderDate;
//    private String payment;
//    private String requests;
//    private Integer totalPrice;

    // CommonColumn
    private Timestamp insDate;
    private String insUser;
    private Timestamp updDate;
    private String updUser;

}
