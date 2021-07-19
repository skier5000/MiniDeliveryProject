package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class FranchiseMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_mst_seq")
    private Long seq;

    private String franchiseName; // 프랜차이즈 명
    private String franchiseIssue; // 프랜차이즈 이슈사항

    @Embedded
    private CommonColumn commonColumn;

}
