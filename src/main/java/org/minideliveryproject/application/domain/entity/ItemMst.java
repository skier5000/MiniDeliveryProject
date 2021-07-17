package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ItemMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_mst_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_mst_seq")
    private StoreMst storeMst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_mst_seq")
    private FranchiseMst franchiseMst;

    private String itemName;
    private Integer itemPrice;
    private String itemCategory;

    @Embedded
    private CommonColumn commonColumn;



}
