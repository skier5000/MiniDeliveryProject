package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface FranchiseMstRepositoryImpl extends JpaRepository<FranchiseMst, Long>, FranchiseMstRepository {

    @Override
    Optional<FranchiseMst> findByFranchiseName(String franchiseName);


}
