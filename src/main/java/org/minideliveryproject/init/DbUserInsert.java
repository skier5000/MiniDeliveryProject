package org.minideliveryproject.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.*;
import org.minideliveryproject.application.domain.entity.embeded.*;
import org.minideliveryproject.application.domain.repository.*;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Order
@Configuration
@Component("DbUserInsert")
public class DbUserInsert {

    @PersistenceContext
    private final EntityManager em;

    private final UserMstRepository userMstRepository;

    private final UserMstRepositoryImpl userMstRepositoryImpl;

    private final StoreMstRepository storeMstRepository;

    private final StoreMstRepositoryImpl storeMstRepositoryImpl;

    private final FranchiseMstRepository franchiseMstRepository;

    /**
     * User Insert
     */
    @PostConstruct
    @Bean
    public void 관리자등록() {
        HashMap<Long, UserMst> hm = new HashMap<>();
        String admin = "ADMIN";

        for (int i = 1000; i < 1010; i++) {
            UserMst userMst = new UserMst();
            // 테스트용도라 아이디, 패스워드 중복체크 x
            userMst.setUserId(admin + i);
            userMst.setUserPassword(admin + i);
            userMst.setUserName("관리자" + i);
            userMst.setPhoneNumber("010-1234-1234");
            userMst.setEmail("MiniDeliveryProject@github.com");
            userMst.setJoinDate(LocalDate.now());

            userMst.setUserRoleType(UserRoleType.PLATFORM);
            userMst.setAddress(new Address("356-12", "천안시", "충남 천안시 서북구 불당26로80", "401-901"));
            userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

//            em.persist(userMst);
//            hm.put(em.find(), userMst);
            Long userSeq = userMstRepository.save(userMst);
            hm.put(userSeq, userMst);
        }

        // Iterator 돌면서 값 체크
        Iterator<Long> iteratorHm = hm.keySet().iterator();
        while(iteratorHm.hasNext()){
            Long key = iteratorHm.next();

            UserMst keyValue = hm.get(key); // 해시맵에 넣은 값
            UserMst findUser = userMstRepository.findBySeq(key); // 그 키값으로 찾은 값

        }
    }

    @PostConstruct
    @Bean
    public void 고객등록() {
        HashMap<Long, UserMst> hm = new HashMap<>();
        String customer = "CUSTOMER";

        for (int i = 1000; i < 1010; i++) {
            UserMst userMst = new UserMst();
            // 테스트용도라 아이디, 패스워드 중복체크 x
            userMst.setUserId(customer + i);
            userMst.setUserPassword(customer + i);
            userMst.setUserName("나는야고객" + i);
            userMst.setPhoneNumber("010-1234-1234");
            userMst.setEmail("DeliveryCustomer@github.com");
            userMst.setJoinDate(LocalDate.now());

            userMst.setUserRoleType(UserRoleType.CUSTOMER);
            userMst.setAddress(new Address("96-3", "대전광역시", "대전광역시 유성구 유성대로 703", "101"));
            userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));

            Long userSeq = userMstRepository.save(userMst);
            hm.put(userSeq, userMst);
        }

        // Iterator 돌면서 값 체크
        Iterator<Long> iteratorHm = hm.keySet().iterator();
        while(iteratorHm.hasNext()){
            Long key = iteratorHm.next();

            UserMst keyValue = hm.get(key); // 해시맵에 넣은 값
            UserMst findUser = userMstRepository.findBySeq(key); // 그 키값으로 찾은 값

        }
    }

    @PostConstruct
    @Bean
    public void 사장님등록BBQ불당() {
        // BBQ 불당점
        // given
        FranchiseMst franchiseMst = franchiseExistOrCreate("BBQ");

        UserMst userMst = new UserMst();
        userMst.setUserId("BBQ1000");
        userMst.setUserPassword("BBQ1000");
        userMst.setUserName("BBQ불당");
        userMst.setPhoneNumber("010-1234-1234");
        userMst.setEmail("DeliveryStoreKing@github.com");
        userMst.setJoinDate(LocalDate.now());
        userMst.setUserRoleType(UserRoleType.STORE);
        userMst.setAddress(new Address("356-12", "천안시", "충남 천안시 서북구 불당26로80", "401-901"));
        userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        userMstRepositoryImpl.save(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreType(StoreType.FRANCHISE);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setAddress(userMst.getAddress());
        storeMst.setDeleteType(DeleteType.NO);
        storeMst.setCommonColumn(userMst.getCommonColumn());
        storeMst.setStoreName("BBQ불당점");
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setStoreTel(userMst.getPhoneNumber());   // 향후 가게 전화번호로
        storeMst.setStoreHop(LocalTime.of(11, 59, 59));
        storeMst.setMinOrdPrice(10000);

        storeMst.setContDate(LocalDate.now());
        storeMst.setContExpDate(LocalDate.of(2023,12,31));
        storeMst.setContRenewDate(LocalDate.now());
        storeMst.setContCnt(1);

        storeMstRepositoryImpl.save(storeMst);
    }

    @PostConstruct
    @Bean
    public void 사장님등록Kyochon() {
        // Kyochon 불당점
        // given
        FranchiseMst franchiseMst = franchiseExistOrCreate("Kyochon");

        UserMst userMst = new UserMst();
        userMst.setUserId("Kyochon1000");
        userMst.setUserPassword("Kyochon1000");
        userMst.setUserName("Kyochon불당");
        userMst.setPhoneNumber("010-1234-1235");
        userMst.setEmail("DeliveryStoreKing@github.com");
        userMst.setJoinDate(LocalDate.now());
        userMst.setUserRoleType(UserRoleType.STORE);
        userMst.setAddress(new Address("356-12", "천안시", "충남 천안시 서북구 불당26로80", "401-901"));
        userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        userMstRepositoryImpl.save(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreType(StoreType.FRANCHISE);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setAddress(userMst.getAddress());
        storeMst.setDeleteType(DeleteType.NO);
        storeMst.setCommonColumn(userMst.getCommonColumn());
        storeMst.setStoreName("Kyochon불당점");
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setStoreTel(userMst.getPhoneNumber());
        storeMst.setStoreHop(LocalTime.of(11, 59, 59));
        storeMst.setMinOrdPrice(10000);

        storeMst.setContDate(LocalDate.now());
        storeMst.setContExpDate(LocalDate.of(2023,12,31));
        storeMst.setContRenewDate(LocalDate.now());
        storeMst.setContCnt(1);
        storeMstRepositoryImpl.save(storeMst);


    }

    @PostConstruct
    @Bean
    public void 사장님등록BBQ서울() {
        // BBQ 서울점
        // given
        StoreMst storeMst = new StoreMst();
        UserMst userMst = new UserMst();

        FranchiseMst franchiseMst = franchiseExistOrCreate("BBQ");

        userMst.setUserId("BBQ1001");
        userMst.setUserPassword("BBQ1001");
        userMst.setUserName("BBQ서울역");
        userMst.setPhoneNumber("010-1234-1236");
        userMst.setEmail("DeliveryStoreKing@github.com");
        userMst.setJoinDate(LocalDate.now());
        userMst.setUserRoleType(UserRoleType.STORE);
        userMst.setAddress(new Address("122-21", "서울특별시", "서울특별시 중구 한강대로 405", "서울역"));
        userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        userMstRepositoryImpl.save(userMst);


        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreType(StoreType.FRANCHISE);
        storeMst.setFoodType(FoodType.CHICKEN);

        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setAddress(userMst.getAddress());
        storeMst.setDeleteType(DeleteType.NO);
        storeMst.setCommonColumn(userMst.getCommonColumn());

        storeMst.setStoreName("BBQ서울역점");
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setStoreTel(userMst.getPhoneNumber());
        storeMst.setStoreHop(LocalTime.of(11, 59, 59));
        storeMst.setMinOrdPrice(10000);

        storeMst.setContDate(LocalDate.now());
        storeMst.setContExpDate(LocalDate.of(2023,12,31));
        storeMst.setContRenewDate(LocalDate.now());
        storeMst.setContCnt(1);
        storeMstRepositoryImpl.save(storeMst);
    }

    @PostConstruct
    @Bean
    public void 사장님등록바로그집한밭대점() {
        // BBQ 불당점
        // given
        FranchiseMst franchiseMst = franchiseExistOrCreate("OhThisHouse");

        UserMst userMst = new UserMst();
        userMst.setUserId("OhThisHouse1000");
        userMst.setUserPassword("OhThisHouse1000");
        userMst.setUserName("바로그집대전");
        userMst.setPhoneNumber("010-1234-1237");
        userMst.setEmail("DeliveryStoreKing@github.com");
        userMst.setJoinDate(LocalDate.now());
        userMst.setUserRoleType(UserRoleType.STORE);
        userMst.setAddress(new Address("597-8", "대전광역시", "대전 유성구 학하서로121번길 154", "101"));
        userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        userMstRepositoryImpl.save(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreType(StoreType.FRANCHISE);
        storeMst.setFoodType(FoodType.SNACK);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setAddress(userMst.getAddress());
        storeMst.setDeleteType(DeleteType.NO);
        storeMst.setCommonColumn(userMst.getCommonColumn());

        storeMst.setStoreName("바로그집한밭대점");
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setStoreTel(userMst.getPhoneNumber());
        storeMst.setStoreHop(LocalTime.of(11, 59, 59));
        storeMst.setMinOrdPrice(10000);

        storeMst.setContDate(LocalDate.now());
        storeMst.setContExpDate(LocalDate.of(2023,12,31));
        storeMst.setContRenewDate(LocalDate.now());
        storeMst.setContCnt(1);
        storeMstRepositoryImpl.save(storeMst);
    }

    @PostConstruct
    @Bean
    public void 사장님등록BBQ순천() {
        // BBQ 순천점
        // given
        StoreMst storeMst = new StoreMst();
        UserMst userMst = new UserMst();

        FranchiseMst franchiseMst = franchiseExistOrCreate("BBQ");

        userMst.setUserId("BBQ1005");
        userMst.setUserPassword("BBQ1005");
        userMst.setUserName("BBQ순천");
        userMst.setPhoneNumber("010-1234-1239");
        userMst.setEmail("DeliveryStoreKing@github.com");
        userMst.setJoinDate(LocalDate.now());
        userMst.setUserRoleType(UserRoleType.STORE);
        userMst.setAddress(new Address("122-21", "전라남도", "순천시 조례1길 60", "101"));
        userMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        em.persist(userMst);


        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreType(StoreType.FRANCHISE);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setAddress(userMst.getAddress());
        storeMst.setDeleteType(DeleteType.NO);
        storeMst.setCommonColumn(userMst.getCommonColumn());

        storeMst.setStoreName("BBQ순천점");
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setStoreTel(userMst.getPhoneNumber());
        storeMst.setStoreHop(LocalTime.of(11, 59, 59));
        storeMst.setMinOrdPrice(10000);

        storeMst.setContDate(LocalDate.now());
        storeMst.setContExpDate(LocalDate.of(2023,12,31));
        storeMst.setContRenewDate(LocalDate.now());
        storeMst.setContCnt(1);
        storeMstRepositoryImpl.save(storeMst);
    }


    // 프랜차이즈 중복체크 및 생성
    public FranchiseMst franchiseExistOrCreate (String FranchiseName){
        FranchiseMst franchiseMst = new FranchiseMst();
        Optional<FranchiseMst> alreadyFranchiseList = franchiseMstRepository.findByFranchiseName(FranchiseName);
        if (alreadyFranchiseList.isEmpty()) {
            franchiseMst.setFranchiseName(FranchiseName);
            //franchiseMst.setFranchiseIssue("");
            franchiseMst.setFranchiseRemark("신규생성");
            franchiseMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "franchiseCreateTest", LocalDateTime.now(), "franchiseCreateTest"));
            franchiseMstRepository.save(franchiseMst);
        }
        else {
            franchiseMst = alreadyFranchiseList.get();
        }

        return franchiseMst;
    }

}
