package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.ItemMst;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMstRepositoryImpl extends JpaRepository<UserMst, Long> {
    public Optional<UserMst> findBySeq(Long seq);             // 유저 sequence 조회
    public Optional<UserMst> findByUserId(String userId);     // 유저 id 조회
    public Optional<UserMst> findByUserName(String userName); // 유저 name 조회

}
