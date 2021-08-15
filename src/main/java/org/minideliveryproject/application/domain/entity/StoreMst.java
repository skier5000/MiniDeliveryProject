package org.minideliveryproject.application.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.entity.embeded.FoodType;
import org.minideliveryproject.application.domain.entity.embeded.StoreState;
import org.minideliveryproject.application.domain.entity.embeded.StoreType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@Entity
public class StoreMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_mst_seq")
    private Long seq;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_mst_seq")
    private FranchiseMst franchiseMst;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mst_seq")
    private UserMst userMst;

    @Enumerated(EnumType.STRING)
    private StoreType storeType;

    @Enumerated(EnumType.STRING)
    private FoodType foodType; // 업종

    @Enumerated(EnumType.STRING)
    private StoreState storeState;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeleteType deleteType;

    @Embedded
    private CommonColumn commonColumn;



    private String storeName;
    private String storeImgUrl;
    private String storeTel;
    private LocalTime storeHop;          // 영업시간
    private Integer minOrdPrice;      // 최소주문금액
    private LocalDate contDate;       // 계약일자
    private LocalDate contExpDate;    // 계약만료일자
    private LocalDate contRenewDate;  // 재계약일자
    private Integer contCnt;          // 계약횟수
}
