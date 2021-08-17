package org.minideliveryproject.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchiseMstDto {

    private Long seq;

    private String franchiseName;     // 프랜차이즈 명
    private String franchiseIssue;    // 프랜차이즈 이슈사항
    private String franchiseRemark;   // 프랜차이즈 비고

    private CommonColumnDto commonColumn;

}
