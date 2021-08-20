package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.minideliveryproject.application.domain.entity.OrderMst;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderMstDto {

    private Long seq;

    private String storeMstDto;

    private UserMstDto userMstDto;

    private List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();

    private CommonColumnDto commonColumn;

    private String payment;         //결제수단

    private LocalDateTime orderDate;
    private Integer totalPrice;
    private String requests;


}
