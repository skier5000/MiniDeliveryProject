package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
public class CommonColumn {

    private LocalDateTime insDate;
    private String insUser;
    private LocalDateTime udpDate;
    private String udpUser;

    public CommonColumn(LocalDateTime insDate, String insUser, LocalDateTime udpDate, String udpUser) {
        this.insDate = insDate;
        this.insUser = insUser;
        this.udpDate = udpDate;
        this.udpUser = udpUser;
    }
}
