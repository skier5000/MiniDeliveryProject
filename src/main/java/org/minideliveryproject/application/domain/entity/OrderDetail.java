package org.minideliveryproject.application.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_mst_seq")
    private ItemMst itemMst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_mst_seq")
    private OrderMst orderMst;

    private Integer itemQuantity;    // 수량
    private Integer itemPrice;       // 가격

    public void saveOrderMst(OrderMst orderMst) {
        this.orderMst = orderMst;
        orderMst.getOrderDetailList().add(this);
    }

}
