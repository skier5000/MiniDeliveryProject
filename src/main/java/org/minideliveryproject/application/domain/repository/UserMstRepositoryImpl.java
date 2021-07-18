package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMstRepositoryImpl extends JpaRepository<UserMst, Long> {
    public List<UserMst> findAll();

}
