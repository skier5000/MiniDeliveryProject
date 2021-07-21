package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.OrderMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMstRepository extends JpaRepository<OrderMst, Long> {

}
