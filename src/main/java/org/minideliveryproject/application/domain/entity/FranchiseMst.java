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

    private String franchiseName;
    private String franchiseIssue;

    @Embedded
    private CommonColumn commonColumn;

}
