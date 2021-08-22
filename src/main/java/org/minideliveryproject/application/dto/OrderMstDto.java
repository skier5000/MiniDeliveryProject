package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.minideliveryproject.application.domain.entity.*;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderMstDto {

    private long seq;

    private String deleteType;
    private LocalDateTime orderDate;
    private String payment;
    private String requests;
    private Integer totalPrice;
    private Long userMstSeq;

    // CommonColumn
    private LocalDateTime insDate;
    private String insUser;
    private LocalDateTime updDate;
    private String updUser;

    // GroupBy Column (findByStartEndStoreNm)
    private String storeType;
    private int storeMstSeq;
    private String storeName;
    private String storeTel;
    private String contRenewDate;
    private int allOrder;           // 주문(건수)
    private int allOrderDeleteNo;   // 주문취소(건수)
    private int allOrderDeleteYes;  // 결제(건수)
}