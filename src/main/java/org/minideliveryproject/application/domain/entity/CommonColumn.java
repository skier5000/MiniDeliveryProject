package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
public class CommonColumn {

    private LocalDateTime insDate; // 입력일자
    private String insUser; // 입력자
    private LocalDateTime udpDate; // 수정일자
    private String udpUser; // 수정자

    public CommonColumn(LocalDateTime insDate, String insUser, LocalDateTime udpDate, String udpUser) {
        this.insDate = insDate;
        this.insUser = insUser;
        this.udpDate = udpDate;
        this.udpUser = udpUser;
    }
}
