package org.minideliveryproject.application.domain.repository;

import lombok.RequiredArgsConstructor;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class UserMstRepository {

    private final EntityManager em;

    public Long save(UserMst userMst) {
        em.persist(userMst);
        return userMst.getSeq();
    }

    public UserMst findBySeq(Long seq) {
        return em.find (UserMst.class, seq);
    }
}
