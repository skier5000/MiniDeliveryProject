package org.minideliveryproject.application.domain.repository;

import lombok.RequiredArgsConstructor;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class StoreMstRepository {

    private final EntityManager em;

    public Long save(StoreMst storeMst) {
        em.persist(storeMst);
        return storeMst.getSeq();
    }

    public StoreMst findBySeq(Long seq) {
        return em.find(StoreMst.class, seq);
    }

}
