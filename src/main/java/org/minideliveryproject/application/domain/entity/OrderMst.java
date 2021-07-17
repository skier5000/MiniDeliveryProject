package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class OrderMst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_mst_seq")
    private Long seq;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "store_mst_seq")
    private StoreMst storeMst;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mst_seq")
    private UserMst userMst;

    @OneToMany(mappedBy = "orderMst")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @Embedded
    private CommonColumn commonColumn;

    private LocalDateTime orderDate;
    private Integer totalPrice;
    private String payment;         //결제수단
    private String requests;





}
