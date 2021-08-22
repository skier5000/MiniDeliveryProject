package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;
import org.minideliveryproject.application.dto.OrderMstDto;
import org.minideliveryproject.application.platform.dto.OrderMstSearchDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderMstRepository extends JpaRepository<OrderMst, Long> {

    public Optional<OrderMst> findByPayment(PaymentType paymentType);

    @Query(nativeQuery = true, value =
            "SELECT sm.STORE_TYPE AS storeType" +
            "     , TO_CHAR(om.STORE_MST_SEQ) AS storeMstSeq" +
            "     , sm.STORE_NAME AS storeName" +
            "     , sm.STORE_TEL AS storeTel" +
            "     , TO_CHAR(sm.CONT_RENEW_DATE, 'YYYYMMDD') AS contRenewDate" +
            "     , TO_CHAR(COUNT(om.STORE_MST_SEQ)) AS allOrder" +
            "     , TO_CHAR(COUNT(CASE WHEN sm.DELETE_TYPE= 'NO' THEN 1 END)) AS allOrderDeleteNo" +
            "     , TO_CHAR(COUNT(CASE WHEN sm.DELETE_TYPE= 'YES' THEN 1 END)) AS allOrderDeleteYes" +
            "  FROM ORDER_MST om" +
            "    INNER JOIN ORDER_DETAIL od" +
            "        ON om.ORDER_MST_SEQ = od.ORDER_MST_SEQ" +
            "    INNER JOIN STORE_MST sm" +
            "        ON om.STORE_MST_SEQ = sm.STORE_MST_SEQ" +
            " WHERE 1=1" +
            "   AND TO_CHAR(om.ORDER_DATE, 'YYYYMMDD') BETWEEN ?1 AND ?2" +
            "   AND sm.STORE_NAME LIKE %?3%"+
            " GROUP BY om.STORE_MST_SEQ"
    )
    public List<Object[]> findByStartEndStoreNm(String startContract, String endContract, String storeNm);

    @Query(nativeQuery = true, value = "" +
            "SELECT sm.STORE_TYPE" +
            "     , om.STORE_MST_SEQ" +
            "     , sm.STORE_NAME" +
            "     , sm.STORE_TEL" +
            "     , sm.CONT_RENEW_DATE" +
            "     , COUNT(om.STORE_MST_SEQ) AS ALL_ORDER" +
            "     , COUNT(CASE WHEN sm.DELETE_TYPE= 'NO' THEN 1 END) AS ALL_ORDER_DELETE_NO" +
            "     , COUNT(CASE WHEN sm.DELETE_TYPE= 'YES' THEN 1 END) AS ALL_ORDER_DELETE_YES" +
            "  FROM ORDER_MST om" +
            "    INNER JOIN ORDER_DETAIL od" +
            "        ON om.ORDER_MST_SEQ = od.ORDER_MST_SEQ" +
            "    INNER JOIN STORE_MST sm" +
            "        ON om.STORE_MST_SEQ = sm.STORE_MST_SEQ" +
            " WHERE 1=1" +
            "   AND sm.STORE_MST_SEQ = ?1" +
            " GROUP BY om.STORE_MST_SEQ"
    )
    public List<OrderMstDto> findByStoreCode(Long storeCode);


//    @Query(value = "SELECT om.ORDER_MST_SEQ" +
//            "            , om.STORE_MST_SEQ" +
//            "            , sm.STORE_TYPE" +
//            "            , sm.STORE_NAME" +
//            "            , sm.STORE_TEL" +
//            "            , sm.CONT_DATE" +
//            "         FROM ORDER_MST om" +
//            "           INNER JOIN ORDER_DETAIL od" +
//            "               ON om.ORDER_MST_SEQ = od.ORDER_MST_SEQ" +
//            "           INNER JOIN STORE_MST sm" +
//            "               ON om.STORE_MST_SEQ = sm.STORE_MST_SEQ" +
//            "        WHERE 1=1"
//            , nativeQuery = true)
//    public <S extends OrderMst> Iterable<S> testFindByOrderMstSearchDto();
//
//    @Query(nativeQuery = true, value =
//            "SELECT ORDER_MST_SEQ" +
//            "     , COUNT(*) AS CNT" +
//            "  FROM ORDER_MST" +
//            " GROUP BY ORDER_MST_SEQ")
//    public <S extends OrderMst> Iterable<S> testFindByOrderMstSearchDto2();
}
