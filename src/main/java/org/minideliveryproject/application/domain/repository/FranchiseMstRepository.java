package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FranchiseMstRepository {

    List<FranchiseMst> findAll();
    Optional<FranchiseMst> findByFranchiseName(String franchiseName);
    void deleteAll();
}
