package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {

    private Long seq;

    private ItemMstDto itemMstDto;

    private OrderMstDto orderMstDto;

    private Integer itemQuantity;    // 수량
    private Integer itemPrice;       // 가격

}
