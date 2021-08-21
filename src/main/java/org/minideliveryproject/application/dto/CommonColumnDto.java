package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommonColumnDto {

    private Timestamp insDate;
    private String insUser;
    private Timestamp updDate;
    private String updUser;
}
