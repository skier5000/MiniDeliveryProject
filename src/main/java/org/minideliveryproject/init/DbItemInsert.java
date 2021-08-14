package org.minideliveryproject.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.CommonColumn;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.ItemMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.repository.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Order
@Configuration
@Component("DbItemInsert")
@DependsOn("DbUserInsert")
public class DbItemInsert {

    private final FranchiseMstRepository franchiseMstRepository;

    private final ItemMstRepository itemMstRepository;

    private final StoreMstRepositoryImpl storeMstRepository;

    /**
     * Item Insert
     */
    @PostConstruct
    @Bean
    public void 아이템등록BBQ() {
        String bbqChicken = "bbqChicken";

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

            itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("BBQ").get());

            // 아이템 중복 체크
            if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
                return;

            // 스토어 세팅 (BBQ) → 스토어 세팅은 개인적으로 추가하거나 개인점포일 경우 세팅?

            // 리스트에 삽입
            saveItemMst.add(itemMst);
        }

        // when
        savedItemMst = itemMstRepository.saveAll(saveItemMst);   // List 전체 저장(save 보다 속도빠름)
    }

    @PostConstruct
    @Bean
    public void 아이템등록kyochon허니콤보() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("허니콤보");
        itemMst.setItemPrice(15000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("Kyochon").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록kyochon레드콤보() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("레드콤보");
        itemMst.setItemPrice(16000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("Kyochon").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록kyochon콤보세트() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("콤보세트");
        itemMst.setItemPrice(18000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("Kyochon").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록kyochon살살치킨() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("살살치킨");
        itemMst.setItemPrice(18000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("Kyochon").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록OhThisHouse일반김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("일반김밥");
        itemMst.setItemPrice(2000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("OhThisHouse").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록OhThisHouse참치김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("참치김밥");
        itemMst.setItemPrice(3500);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("OhThisHouse").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록OhThisHouse불고기김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("불고기김밥");
        itemMst.setItemPrice(3500);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("OhThisHouse").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록OhThisHouse치즈김밥() {
        /* given */
        ItemMst itemMst = new ItemMst();

        // 아이템 세팅
        itemMst.setItemName("치즈김밥");
        itemMst.setItemPrice(3000);
        itemMst.setItemCategory("MainMenu");
        itemMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

        itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("OhThisHouse").get());

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록이영우치킨집() {
        List<ItemMst> itemMstList = new ArrayList<>();

        // 이영우 후라이드
        ItemMst itemMst1 = new ItemMst();
        itemMst1.setItemName("이영우후라이드치킨");
        itemMst1.setItemPrice(10000);
        itemMst1.setItemCategory("MainMenu");
        itemMst1.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst1.setStoreMst(storeMstRepository.findByStoreName("이영우치킨집"));
        itemMstList.add(itemMst1);

        // 이영우 양념
        ItemMst itemMst2 = new ItemMst();
        itemMst2.setItemName("이영우양념치킨");
        itemMst2.setItemPrice(11000);
        itemMst2.setItemCategory("MainMenu");
        itemMst2.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst2.setStoreMst(storeMstRepository.findByStoreName("이영우치킨집"));
        itemMstList.add(itemMst2);

        // 이영우 간장
        ItemMst itemMst3 = new ItemMst();
        itemMst3.setItemName("이영우간장치킨");
        itemMst3.setItemPrice(11000);
        itemMst3.setItemCategory("MainMenu");
        itemMst3.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst3.setStoreMst(storeMstRepository.findByStoreName("이영우치킨집"));
        itemMstList.add(itemMst3);

        itemMstRepository.saveAll(itemMstList);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록이준범피자집() {
        List<ItemMst> itemMstList = new ArrayList<>();

        // 이영우 후라이드
        ItemMst itemMst1 = new ItemMst();
        itemMst1.setItemName("이준범콤비네이션피자");
        itemMst1.setItemPrice(18000);
        itemMst1.setItemCategory("MainMenu");
        itemMst1.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst1.setStoreMst(storeMstRepository.findByStoreName("이준범피자집"));
        itemMstList.add(itemMst1);

        // 이영우 양념
        ItemMst itemMst2 = new ItemMst();
        itemMst2.setItemName("이준범페퍼로니피자");
        itemMst2.setItemPrice(18000);
        itemMst2.setItemCategory("MainMenu");
        itemMst2.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst2.setStoreMst(storeMstRepository.findByStoreName("이준범피자집"));
        itemMstList.add(itemMst2);

        // 이영우 간장
        ItemMst itemMst3 = new ItemMst();
        itemMst3.setItemName("이준범시그니처피자");
        itemMst3.setItemPrice(20000);
        itemMst3.setItemCategory("MainMenu");
        itemMst3.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst3.setStoreMst(storeMstRepository.findByStoreName("이준범피자집"));
        itemMstList.add(itemMst3);

        itemMstRepository.saveAll(itemMstList);   // save 저장
    }

    @PostConstruct
    @Bean
    public void 아이템등록한상우보쌈집() {
        List<ItemMst> itemMstList = new ArrayList<>();

        // 한상우 메인보쌈
        ItemMst itemMst1 = new ItemMst();
        itemMst1.setItemName("한상우메인보쌈");
        itemMst1.setItemPrice(18000);
        itemMst1.setItemCategory("MainMenu");
        itemMst1.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst1.setStoreMst(storeMstRepository.findByStoreName("한상우보쌈집"));
        itemMstList.add(itemMst1);

        // 한상우 메인족발
        ItemMst itemMst2 = new ItemMst();
        itemMst2.setItemName("한상우메인족발");
        itemMst2.setItemPrice(18000);
        itemMst2.setItemCategory("MainMenu");
        itemMst2.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst2.setStoreMst(storeMstRepository.findByStoreName("한상우보쌈집"));
        itemMstList.add(itemMst2);

        // 한상우 반반족발세트
        ItemMst itemMst3 = new ItemMst();
        itemMst3.setItemName("한상우반반족발세트");
        itemMst3.setItemPrice(20000);
        itemMst3.setItemCategory("MainMenu");
        itemMst3.setCommonColumn(new CommonColumn(LocalDateTime.now(), "PrivateTest", LocalDateTime.now(), "PrivateTest"));
        itemMst3.setStoreMst(storeMstRepository.findByStoreName("한상우보쌈집"));
        itemMstList.add(itemMst3);

        itemMstRepository.saveAll(itemMstList);   // save 저장
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

/**
 * 프랜차이즈 점포는 itemMst에 STORE_MST_SEQ 를 가질 필요가 없음
 */
//        StoreMst storeMstValue = storeMstRepository.findByStoreName("바로그집한밭대점");
//        itemMst.setStoreMst(storeMstValue);