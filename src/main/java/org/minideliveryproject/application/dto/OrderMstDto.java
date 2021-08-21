package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.minideliveryproject.application.domain.entity.OrderMst;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderMstDto{

    private int orderMstSeq;

    private String deleteType;
    private Timestamp orderDate;
    private String payment;
    private String requests;
    private Integer totalPrice;
    private Long storeMstSeq;
    private Long userMstSeq;

    private CommonColumnDto commonColumnDto;

}
