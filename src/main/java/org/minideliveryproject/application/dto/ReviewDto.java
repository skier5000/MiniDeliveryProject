package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDto {

    private Long seq;

    private StoreMstDto storeMstDto;

    private UserMstDto userMstDto;

    private String reviewTitle;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private Double reviewGrade;
    private String replyContent;
    private LocalDateTime replyDate;

}
