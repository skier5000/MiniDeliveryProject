package org.minideliveryproject.application.db;

import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.repository.StoreMstRepository;
import org.minideliveryproject.application.domain.repository.UserMstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class DbOrderInsert {

    @Autowired
    UserMstRepository userMstRepository;

    @Autowired
    StoreMstRepository storeMstRepository;

    @Test
    @Rollback(value = true)
    public void 아이템등록BBQ() {

    }


}
