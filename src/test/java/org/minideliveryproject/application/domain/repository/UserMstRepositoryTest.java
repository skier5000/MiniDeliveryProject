package org.minideliveryproject.application.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.entity.Address;
import org.minideliveryproject.application.domain.entity.CommonColumn;
import org.minideliveryproject.application.domain.entity.embeded.UserRoleType;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;


@SpringBootTest
@Transactional
class UserMstRepositoryTest {

    @Autowired
    UserMstRepository userMstRepository;

    @Test
    @Rollback(value = false)
    public void 유저등록() {
        UserMst userMst = new UserMst();
        userMst.setUserId("mini");
        userMst.setUserPassword("mini");
        userMst.setUserName("미니미니");
        userMst.setUserRoleType(UserRoleType.CUSTOMER);
        Address address = new Address("우편번호", "천안시", "충남 천안시 서북구","디테일 주소");
        userMst.setAddress(address);
        userMst.setPhoneNumber("010-9556-9925");
        userMst.setEmail("hanwoodww@naver.com");
        userMst.setJoinDate(LocalDate.now());
        CommonColumn commonColumn = new CommonColumn(LocalDateTime.now(), "ADMIN", LocalDateTime.now(), "ADMIN");
        userMst.setCommonColumn(commonColumn);

        Long userSeq = userMstRepository.save(userMst);

        UserMst findUser = userMstRepository.findBySeq(userSeq);

        Assertions.assertThat(findUser.getUserId()).isEqualTo(userMst.getUserId());
        Assertions.assertThat(findUser.getSeq()).isEqualTo(userSeq);


    }


}