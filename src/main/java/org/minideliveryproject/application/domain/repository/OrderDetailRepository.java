package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.OrderDetail;
import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.dto.OrderDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(nativeQuery = true, value = ""+
            "SELECT A.ORDER_MST_SEQ  AS orderMstSeq " +
            "     , C.STORE_NAME     AS storeName " +
            "     , C.STORE_MST_SEQ  AS storeMstSeq " +
            "     , A.ORDER_DATE     AS orderDate " +
            "     , D.ITEM_NAME      AS itemName " +
            "     , D.ITEM_MST_SEQ   AS itemMstSeq " +
            "     , B.ITEM_QUANTITY  AS itemQuantity " +
            "     , D.ITEM_PRICE     AS itemPrice " +
            "     , A.REQUESTS       AS requests " +
            "     , A.PAYMENT        AS payment " +
            "     , A.USER_MST_SEQ   AS userMstSeq " +
            "  FROM ORDER_MST A" +
            "    INNER JOIN ORDER_DETAIL B" +
            "        ON A.ORDER_MST_SEQ = B.ORDER_MST_SEQ" +
            "    INNER JOIN STORE_MST C" +
            "        ON A.STORE_MST_SEQ = C.STORE_MST_SEQ" +
            "    INNER JOIN ITEM_MST D" +
            "        ON B.ITEM_MST_SEQ = D.ITEM_MST_SEQ" +
            " WHERE 1=1" +
            "   AND C.STORE_MST_SEQ = :storeMstSeq" +
            " ORDER BY A.ORDER_DATE DESC")
    public List<Object[]> findOrderDetailListByStoreMstSeq(@Param(value = "storeMstSeq") Long storeMstSeq);

}
