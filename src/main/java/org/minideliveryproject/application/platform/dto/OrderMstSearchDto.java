package org.minideliveryproject.application.platform.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMstSearchDto {
    private long seq;
    private String storeType;
    private int storeMstSeq;
    private String storeName;
    private String storeTel;
    private String contDate;
    private int allOrder;
    private int allOrderDeleteNo;
    private int allOrderDeleteYes;
}
