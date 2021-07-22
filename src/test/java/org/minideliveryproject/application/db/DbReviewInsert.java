package org.minideliveryproject.application.db;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DbReviewInsert {


    @Test
    @Rollback(value = false)
    public void 리뷰데이터생성() {


    }
}
