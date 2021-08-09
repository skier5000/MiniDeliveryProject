package org.minideliveryproject.application.platform.repository;

import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformFranchiseRepository extends JpaRepository<FranchiseMst, Long> {

}
