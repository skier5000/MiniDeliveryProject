package org.minideliveryproject.application.db;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.entity.CommonColumn;
import org.minideliveryproject.application.domain.entity.OrderDetail;
import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;
import org.minideliveryproject.application.domain.repository.OrderMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepository;
import org.minideliveryproject.application.domain.repository.UserMstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

public class DbOrderInsert {

    @Autowired
    UserMstRepository userMstRepository;

    @Autowired
    StoreMstRepository storeMstRepository;

    @Autowired
    OrderMstRepository orderMstRepository;

    @Test
    @Rollback(value = true)
    public void 바로그집주문등록1() {

        OrderMst orderMst = new OrderMst();
        //orderMst.setStoreMst();
        //orderMst.setUserMst();
        //orderMst.setOrderDetailList();
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.CARD);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(10000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        OrderDetail orderDetail = new OrderDetail();
        //orderDetail.setItemMst();
        orderDetail.setOrderMst(orderMst);
        //orderDetail.setItemQuantity();
        //orderDetail.setItemPrice();
        orderDetail.saveOrderMst(orderMst);
    }


}
