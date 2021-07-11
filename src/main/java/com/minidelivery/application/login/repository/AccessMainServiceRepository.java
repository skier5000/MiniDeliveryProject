package com.minidelivery.application.login.repository;

import com.minidelivery.application.domain.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessMainServiceRepository extends JpaRepository<UserMst, Long>, AccessMainRepository {
    @Override
    Optional<UserMst> findByName(String name);
    // JPQL : select m from Member m where m.name = ?
    // 자동으로 JPQL 생성
}
