package org.minideliveryproject.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.CommonColumn;
import org.minideliveryproject.application.domain.entity.ItemMst;
import org.minideliveryproject.application.domain.entity.OrderDetail;
import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;
import org.minideliveryproject.application.domain.repository.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Configuration
@Component("DbOrderInsert")
@DependsOn("DbItemInsert")
public class DbOrderInsert {

    private final UserMstRepository userMstRepository;

    private final StoreMstRepositoryImpl storeMstRepository;

    private final OrderMstRepository orderMstRepository;

    private final ItemMstRepository itemMstRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final UserMstRepositoryImpl userMstRepositoryImpl;


    /**
     * Order Insert
     */
    /**
     * 일반김밥 1개 주문
     */
    @PostConstruct
    @Bean
    public void 바로그집주문등록1() {
        /* given */
        // 주문1개
        OrderMst orderMst = new OrderMst();
        orderMst.setStoreMst(storeMstRepository.findByStoreName("바로그집한밭대점")); // 바로그집
        orderMst.setUserMst(userMstRepositoryImpl.findByUserName("나는야고객1000")); // 나는야고객1000
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.CARD);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(2000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        // 불고기, 참치, 치즈 김밥 각 1개씩
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemQuantity(1);
        orderDetail.setItemPrice(2000);
        orderDetail.setOrderMst(orderMst);
        Optional<ItemMst> findByItemName = itemMstRepository.findByItemName("일반김밥");
        orderDetail.setItemMst(findByItemName.get()); //일반김밥

        orderDetailList.add(orderDetail);
        orderMst.setOrderDetailList(orderDetailList);

        /* when */
        orderMstRepository.save(orderMst);
        orderDetailRepository.save(orderDetail);
    }

    /**
     * 불고기김밥 1개, 참치김밥 1개, 치즈김밥 1개 주문
     */
    @PostConstruct
    @Bean
    public void 바로그집주문등록2() {
        /* given */
        // 주문1개
        OrderMst orderMst = new OrderMst();
        orderMst.setStoreMst(storeMstRepository.findByStoreName("바로그집한밭대점")); // 바로그집한밭대점
        orderMst.setUserMst(userMstRepositoryImpl.findByUserName("나는야고객1002")); // 나는야고객1002
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.NAVERPAY);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(10000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        // 불고기, 참치, 치즈 김밥 각 1개씩
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setItemQuantity(1);
        orderDetail1.setItemPrice(3500);
        orderDetail1.setOrderMst(orderMst);
        Optional<ItemMst> findByItemName1 = itemMstRepository.findByItemName("불고기김밥");
        orderDetail1.setItemMst(findByItemName1.get()); // 불고기김밥
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setItemQuantity(1);
        orderDetail2.setItemPrice(3500);
        orderDetail2.setOrderMst(orderMst);
        Optional<ItemMst> findByItemName2 = itemMstRepository.findByItemName("참치김밥");
        orderDetail2.setItemMst(findByItemName2.get()); // 참치김밥
        orderDetailList.add(orderDetail2);

        OrderDetail orderDetail3 = new OrderDetail();
        orderDetail3.setItemQuantity(1);
        orderDetail3.setItemPrice(3000);
        orderDetail3.setOrderMst(orderMst);
        Optional<ItemMst> findByItemName3 = itemMstRepository.findByItemName("치즈김밥");
        orderDetail3.setItemMst(findByItemName3.get()); // 치즈김밥
        orderDetailList.add(orderDetail3);


        orderMst.setOrderDetailList(orderDetailList);

        /* when */
        orderMstRepository.save(orderMst);
        orderDetailRepository.saveAll(orderDetailList);
    }

    /**
     * 살살치킨 1마리 주문
     */
    @PostConstruct
    @Bean
    public void 교촌치킨주문등록1() {
        /* given */
        // 주문1개
        OrderMst orderMst = new OrderMst();
        orderMst.setStoreMst(storeMstRepository.findByStoreName("BBQ불당점")); // 교촌치킨
        orderMst.setUserMst(userMstRepositoryImpl.findByUserName("나는야고객1001")); // 나는야고객1001
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.KAKAOPAY);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(18000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        // 살살치킨
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemQuantity(1);
        orderDetail.setItemPrice(18000);
        orderDetail.setOrderMst(orderMst);
        Optional<ItemMst> findByItemName = itemMstRepository.findByItemName("살살치킨");
        orderDetail.setItemMst(findByItemName.get()); // 살살치킨

        orderDetailList.add(orderDetail);
        orderMst.setOrderDetailList(orderDetailList);

        /* when */
        orderMstRepository.save(orderMst);
        orderDetailRepository.save(orderDetail);
    }
}
