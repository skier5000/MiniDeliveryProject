package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemMstDto {

    private Long seq;

    private StoreMstDto storeMstDto;

    private FranchiseMstDto franchiseMstDto;

    private String itemName;
    private Integer itemPrice;
    private String itemCategory;

    private CommonColumnDto commonColumn;

}
