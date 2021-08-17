package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommonColumnDto {

    private LocalDateTime insDate; // 입력일자
    private String insUser; // 입력자
    private LocalDateTime udpDate; // 수정일자
    private String udpUser; // 수정자

}
