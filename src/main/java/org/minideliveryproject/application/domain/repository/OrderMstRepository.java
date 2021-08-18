package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.embeded.PaymentType;
import org.minideliveryproject.application.platform.dto.OrderMstSearchDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderMstRepository extends JpaRepository<OrderMst, Long> {

    public Optional<OrderMst> findByPayment(PaymentType paymentType);

}
