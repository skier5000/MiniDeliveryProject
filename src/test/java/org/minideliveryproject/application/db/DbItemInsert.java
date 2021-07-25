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
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

@SpringBootTest
@Transactional
public class DbItemInsert {

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
    @Rollback(value = false)
    public void 아이템등록BBQ() {
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

        List<ItemMst> saveItemMst = new ArrayList<>();   // 저장할 데이터
        List<ItemMst> savedItemMst = new ArrayList<>();  // 저장된 데이터

        // given
        for (int i = 0; i < 10; i++) {
            ItemMst itemMst = new ItemMst();

            // 아이템 세팅
            itemMst.setItemName(bbqChicken+i);
            itemMst.setItemPrice(10000+(i*3000));
            itemMst.setItemCategory("MainMenu");
            itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

            // 프랜차이즈 세팅 (BBQ) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
            //itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("BBQ").get());
            itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(3L).get());

            // 아이템 중복 체크
            DbItemInsert dbItemInsert = new DbItemInsert();
            if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
                return;

            // 스토어 세팅 (BBQ) → 스토어 세팅은 개인적으로 추가하거나 개인점포일 경우 세팅?

            // 리스트에 삽입
            saveItemMst.add(itemMst);
        }

        // when
        savedItemMst = itemMstRepository.saveAll(saveItemMst);   // List 전체 저장(save 보다 속도빠름)

        // then
        assertThat(savedItemMst).isEqualTo(saveItemMst);

    }

    @Test
    @Rollback(value = false)
    public void 아이템등록kyochon허니콤보() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("허니콤보");
        itemMst.setItemPrice(15000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(1L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }

    @Test
    @Rollback(value = false)
    public void 아이템등록kyochon레드콤보() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("레드콤보");
        itemMst.setItemPrice(16000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(1L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }

    @Test
    @Rollback(value = false)
    public void 아이템등록kyochon콤보세트() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("콤보세트");
        itemMst.setItemPrice(18000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(1L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }

    @Test
    @Rollback(value = false)
    public void 아이템등록kyochon살살치킨() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("살살치킨");
        itemMst.setItemPrice(18000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(1L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }


    @Test
    @Rollback(value = false)
    public void 아이템등록OhThisHouse일반김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("일반김밥");
        itemMst.setItemPrice(2000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(2L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }

    @Test
    @Rollback(value = false)
    public void 아이템등록OhThisHouse참치김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("참치김밥");
        itemMst.setItemPrice(3500);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(2L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }

    @Test
    @Rollback(value = false)
    public void 아이템등록OhThisHouse불고기김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("불고기김밥");
        itemMst.setItemPrice(3500);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(2L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }

    @Test
    @Rollback(value = false)
    public void 아이템등록OhThisHouse치즈김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("치즈김밥");
        itemMst.setItemPrice(3000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        // 프랜차이즈 세팅 (교촌) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
        itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(2L).get());

        // 아이템 중복 체크
        DbItemInsert dbItemInsert = new DbItemInsert();
        if(dbItemInsert.itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장

        /* then*/
        assertThat(savedItemMst).isEqualTo(itemMst);
    }


    /**
     * 아이템 명 중복 확인
     */
    public String itemDuplicateCheck(ItemMst itemMst, ItemMstRepository itemMstRepository, FranchiseMstRepository franchiseMstRepository) {
        String result;
        Optional<ItemMst> byItemName = itemMstRepository.findByItemName(itemMst.getItemName());
        Optional<FranchiseMst> byFranchiseSeq = franchiseMstRepository.findBySeq(itemMst.getFranchiseMst().getSeq());

        // 아이템이 이미 존재하고 프랜차이즈 mst seq가 같고 store가 같으면 존재한다고 반환 (아직 store 개인 상품에 대한 로직 없음)
        if(!byItemName.isEmpty() && (byItemName.get().getFranchiseMst().getSeq().equals(byFranchiseSeq.get().getSeq())))
            return result="EXIST";
        else
            return result="EMPTY";
    }

}
