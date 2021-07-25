package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMstRepositoryImpl extends JpaRepository<UserMst, Long> {
    public List<UserMst> findAll();

}
