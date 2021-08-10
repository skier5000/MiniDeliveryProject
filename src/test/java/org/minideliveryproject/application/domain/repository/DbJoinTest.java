package org.minideliveryproject.application.domain.repository;

import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@SpringBootTest
@Transactional
public class DbJoinTest {
    @Autowired
    StoreMstRepositoryImpl storeMstRepositoryImpl;

    @Autowired
    FranchiseMstRepository franchiseMstRepository;

    @PersistenceContext
    EntityManager em;


    @Test
    @Rollback(value = false)
    public void 프랜차이즈가게리스트조회() {
        List<StoreMst> storeMstList = storeMstRepositoryImpl.findAll();
        List<FranchiseMst> franchiseMstList = franchiseMstRepository.findAll();

        for (StoreMst storeMst : storeMstList) {
            System.out.println("storeMst = " + storeMst.getFranchiseMst().toString());
        }
    }
}
