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



    @Query(value = "SELECT om.ORDER_MST_SEQ" +
            "            , om.STORE_MST_SEQ" +
            "            , sm.STORE_TYPE" +
            "            , sm.STORE_NAME" +
            "            , sm.STORE_TEL" +
            "            , sm.CONT_DATE" +
            "         FROM ORDER_MST om" +
            "           INNER JOIN ORDER_DETAIL od" +
            "               ON om.ORDER_MST_SEQ = od.ORDER_MST_SEQ" +
            "           INNER JOIN STORE_MST sm" +
            "               ON om.STORE_MST_SEQ = sm.STORE_MST_SEQ" +
            "        WHERE 1=1"
            , nativeQuery = true)
    public <S extends OrderMst> Iterable<S> testFindByOrderMstSearchDto();
}
