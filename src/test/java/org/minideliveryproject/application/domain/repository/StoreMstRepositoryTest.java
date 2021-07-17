package org.minideliveryproject.application.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StoreMstRepositoryTest {

    @Autowired
    StoreMstRepository storeMstRepository;
    @PersistenceContext
    EntityManager em;


    @Test
    @Rollback(value = false)
    public void 가게등록() {
        //given
        FranchiseMst franchiseMst = new FranchiseMst();
        franchiseMst.setFranchiseName("BBQ");
        em.persist(franchiseMst);

        UserMst userMst = new UserMst();
        userMst.setUserId("BBQ사장");
        userMst.setUserPassword("BBQ");
        userMst.setUserName("BBQ KING");
        userMst.setUserRoleType(UserRoleType.STORE);
        Address address = new Address("우편번호", "천안시", "충남 천안시 서북구","디테일 주소");
        userMst.setAddress(address);
        userMst.setPhoneNumber("010-9556-9925");
        userMst.setEmail("hanwoodww@naver.com");
        userMst.setJoinDate(LocalDate.now());
        CommonColumn commonColumn = new CommonColumn(LocalDateTime.now(), "ADMIN", LocalDateTime.now(), "ADMIN");
        userMst.setCommonColumn(commonColumn);
        em.persist(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setMinOrdPrice(24000);
        storeMst.setStoreName("BBQ천안점");
        storeMst.setStoreType(StoreType.FRANCHISE);


        //when
        Long saveSeq = storeMstRepository.save(storeMst);
        em.flush();
        em.clear();
        StoreMst findStoreMst = storeMstRepository.findBySeq(saveSeq);

        //then
        Assertions.assertThat(findStoreMst.getSeq()).isEqualTo(saveSeq);
        Assertions.assertThat(findStoreMst.getFranchiseMst().getSeq()).isEqualTo(franchiseMst.getSeq());
        Assertions.assertThat(findStoreMst.getFranchiseMst().getFranchiseName()).isEqualTo(franchiseMst.getFranchiseName());
        Assertions.assertThat(findStoreMst.getUserMst().getSeq()).isEqualTo(userMst.getSeq());
    }
}
