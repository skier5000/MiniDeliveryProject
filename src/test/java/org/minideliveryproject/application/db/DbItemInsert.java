package org.minideliveryproject.application.db;

import org.junit.jupiter.api.Test;
import org.minideliveryproject.application.domain.entity.*;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
import org.minideliveryproject.application.domain.repository.ItemMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DbItemInsert {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ItemMstRepository itemMstRepository;

    @Autowired
    StoreMstRepository storeMstRepository;

    @Autowired
    FranchiseMstRepository franchiseMstRepository;


    /**
     * 해당하는 프랜차이즈가 있어야 테스트 실행 가능
     */
    @Test
    @Rollback(value = true)
    public void 아이템등록() {
        HashMap<Long, ItemMst> hm = new HashMap<>();
        String bbqChicken = "bbqChicken";
        String kyochonChicken = "kyochonChicken";
        String ohThisHouseSnack = "ohThisHouseSnack";
//        String koreanFood = "korean_food";
//        String chineseFood = "chinese_food";
//        String japaneseFood = "japanese_food";
//        String pizza = "pizza";
//        String porkFeet = "porkfeet";
//        String bossam = "bossam";
//        String foodBox = "foodbox";
//        String fastFood = "fastfood";

        // given
        for (int i = 0; i < 10; i++) {
            ItemMst itemMst = new ItemMst();
            FranchiseMst franchiseMst = new FranchiseMst();

            // 아이템 세팅
            itemMst.setItemName(bbqChicken+i);
            itemMst.setItemPrice(10000+(i*3000));
            itemMst.setItemCategory("MainMenu");
            itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

            ItemMst itemMstSaveList = itemMstRepository.save(itemMst);
            Long itemMstSaveSeq = itemMstRepository.findBySeq(itemMstSaveList.getSeq());
//            hm.put(saveSeq, itemMst);


            // 프랜차이즈 코드가 이미 존재한다고 가정하고 실행
//            Optional<FranchiseMst> franchiseExistByName = franchiseMstRepository.findByFranchiseName("BBQ");
        }

        // when, then
////        em.flush(); // 영속성 컨텍스트(Persistence Context) 의 변경 내용을 DB에 반영
////        em.clear(); // 영속성 컨텍스트(Persistence Context) 초기화
//        Iterator<Long> iteratorHm = hm.keySet().iterator();
//        while(iteratorHm.hasNext()){
//            Long key = iteratorHm.next();
//            ItemMst keyValue = hm.get(key); // 해시맵에 value
//
//            ItemMst findItemListBySeq = itemMstRepository.findBySeq(key); // 그 키값으로 찾은 값
//            assertThat(keyValue).isEqualTo(findItemListBySeq);
//        }


    }
}
