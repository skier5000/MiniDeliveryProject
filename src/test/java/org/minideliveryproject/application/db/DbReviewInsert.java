package org.minideliveryproject.application.DB;

import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.entity.Review;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DbReviewInsert {


    @Test
    @Rollback(value = false)
    public void 리뷰데이터생성() {
        /* given */

        /* when */

        /* then */
    }
}
