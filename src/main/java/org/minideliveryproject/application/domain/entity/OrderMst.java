package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;

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

    @Enumerated(EnumType.STRING)
    private PaymentType payment;         //결제수단

    private LocalDateTime orderDate;
    private Integer totalPrice;
    private String requests;





}
