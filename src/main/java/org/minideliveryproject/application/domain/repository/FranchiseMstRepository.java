package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FranchiseMstRepository extends JpaRepository<FranchiseMst, Long> {

    Optional<FranchiseMst> findByFranchiseName(String franchiseName);
    Optional<FranchiseMst> findBySeq(Long seq);
}
