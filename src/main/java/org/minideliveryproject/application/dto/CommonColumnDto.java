package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonColumnDto {

    private String insDate; // 입력일자
    private String insUser; // 입력자
    private String udpDate; // 수정일자
    private String udpUser; // 수정자

}
