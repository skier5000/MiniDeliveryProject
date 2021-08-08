package org.minideliveryproject.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.*;
import org.minideliveryproject.application.domain.entity.embeded.*;
import org.minideliveryproject.application.domain.repository.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Component
@Order
public class DbInsert {

    private final EntityManager em;

    private final UserMstRepository userMstRepository;

    private final StoreMstRepository storeMstRepository;

    private final FranchiseMstRepository franchiseMstRepository;

    private final OrderMstRepository orderMstRepository;

    private final ItemMstRepository itemMstRepository;

    private final OrderDetailRepository orderDetailRepository;


    /**
     * User Insert
     */
    @PostConstruct
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
        em.persist(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setMinOrdPrice(24000);
        storeMst.setStoreName("BBQ불당점");
        storeMst.setStoreType(StoreType.FRANCHISE);

        // when
        Long saveSeq = storeMstRepository.save(storeMst);
        em.flush();
        em.clear();
        StoreMst findStoreMst = storeMstRepository.findBySeq(saveSeq);
    }

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
        em.persist(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setMinOrdPrice(24000);
        storeMst.setStoreName("Kyochon불당점");
        storeMst.setStoreType(StoreType.FRANCHISE);

        // when
        Long saveSeq = storeMstRepository.save(storeMst);
        em.flush();
        em.clear();
        StoreMst findStoreMst = storeMstRepository.findBySeq(saveSeq);
    }

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
        em.persist(userMst);


        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setMinOrdPrice(24000);
        storeMst.setStoreName("BBQ서울역점");
        storeMst.setStoreType(StoreType.FRANCHISE);

        // when
        Long saveSeq = storeMstRepository.save(storeMst);
        em.flush();
        em.clear();
        StoreMst findStoreMst = storeMstRepository.findBySeq(saveSeq);
    }

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
        em.persist(userMst);

        StoreMst storeMst = new StoreMst();
        storeMst.setFranchiseMst(franchiseMst);
        storeMst.setUserMst(userMst);
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setFoodType(FoodType.SNACK);
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setMinOrdPrice(24000);
        storeMst.setStoreName("바로그집한밭대점");
        storeMst.setStoreType(StoreType.FRANCHISE);

        // when
        Long saveSeq = storeMstRepository.save(storeMst);
        em.flush();
        em.clear();
        StoreMst findStoreMst = storeMstRepository.findBySeq(saveSeq);
    }

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
        storeMst.setStoreState(StoreState.PREPARING);
        storeMst.setFoodType(FoodType.CHICKEN);
        storeMst.setStoreImgUrl("/reocurecs/img/210050_232");
        storeMst.setMinOrdPrice(24000);
        storeMst.setStoreName("BBQ순천점");
        storeMst.setStoreType(StoreType.FRANCHISE);

        // when
        Long saveSeq = storeMstRepository.save(storeMst);
        em.flush();
        em.clear();
        StoreMst findStoreMst = storeMstRepository.findBySeq(saveSeq);
    }



    // 프랜차이즈 중복체크 및 생성
    public FranchiseMst franchiseExistOrCreate (String FranchiseName){
        FranchiseMst franchiseMst = new FranchiseMst();
        Optional<FranchiseMst> alreadyFranchiseList = franchiseMstRepository.findByFranchiseName(FranchiseName);
        if (alreadyFranchiseList.isEmpty()) {
            franchiseMst.setFranchiseName(FranchiseName);
            em.persist(franchiseMst);
        }
        else {
            franchiseMst = alreadyFranchiseList.get();
        }

        return franchiseMst;
    }






    /**
     * Item Insert
     */
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

            // 프랜차이즈 세팅 (BBQ) → 후에는 이름이 아닌 SEQ 로 받아야하니까 findBySeq
            //itemMst.setFranchiseMst(franchiseMstRepository.findByFranchiseName("BBQ").get());
            itemMst.setFranchiseMst(franchiseMstRepository.findBySeq(3L).get());

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
//        em.find(FranchiseMst.class, 1L);
//        em.createQuery("select m From Member m WHere m.name :=username").setParameter("HSW").getResultList();

        // 아이템 중복 체크
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }


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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
    }

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
        if(itemDuplicateCheck(itemMst, itemMstRepository, franchiseMstRepository).equals("EXIST"))
            return;

        /* when */
        ItemMst savedItemMst = itemMstRepository.save(itemMst);   // save 저장
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









    /**
     * Order Insert
     */
    /**
     * 일반김밥 1개 주문
     */
    public void 바로그집주문등록1() {
        /* given */
        // 주문1개
        OrderMst orderMst = new OrderMst();
        orderMst.setStoreMst(storeMstRepository.findBySeq(2L)); // 바로그집
        orderMst.setUserMst(userMstRepository.findBySeq(13L)); // 나는야고객1000
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.CARD);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(2000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        // 불고기, 참치, 치즈 김밥 각 1개씩
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemQuantity(1);
        orderDetail.setItemPrice(2000);
        orderDetail.setOrderMst(orderMst);
        orderDetail.setItemMst(itemMstRepository.findBySeq(68L)); //일반김밥

        orderDetailList.add(orderDetail);
        orderMst.setOrderDetailList(orderDetailList);

        /* when */
        orderMstRepository.save(orderMst);
        orderDetailRepository.save(orderDetail);
        Optional<OrderMst> orderMstCompare = orderMstRepository.findById(orderMst.getSeq());
        Optional<OrderDetail> orderDetailCompare = orderDetailRepository.findById(orderDetail.getSeq());
    }

    /**
     * 불고기김밥 1개, 참치김밥 1개, 치즈김밥 1개 주문
     */
    public void 바로그집주문등록2() {
        /* given */
        // 주문1개
        OrderMst orderMst = new OrderMst();
        orderMst.setStoreMst(storeMstRepository.findBySeq(2L)); // 바로그집
        orderMst.setUserMst(userMstRepository.findBySeq(13L)); // 나는야고객1002
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.NAVERPAY);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(10000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        // 불고기, 참치, 치즈 김밥 각 1개씩
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setItemQuantity(1);
        orderDetail1.setItemPrice(3500);
        orderDetail1.setOrderMst(orderMst);
        orderDetail1.setItemMst(itemMstRepository.findBySeq(57L)); // 불고기김밥
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setItemQuantity(1);
        orderDetail2.setItemPrice(3500);
        orderDetail2.setOrderMst(orderMst);
        orderDetail2.setItemMst(itemMstRepository.findBySeq(69L)); // 참치김밥
        orderDetailList.add(orderDetail2);

        OrderDetail orderDetail3 = new OrderDetail();
        orderDetail3.setItemQuantity(1);
        orderDetail3.setItemPrice(3000);
        orderDetail3.setOrderMst(orderMst);
        orderDetail3.setItemMst(itemMstRepository.findBySeq(70L)); // 치즈김밥
        orderDetailList.add(orderDetail3);


        orderMst.setOrderDetailList(orderDetailList);

        /* when */
        orderMstRepository.save(orderMst);
        orderDetailRepository.saveAll(orderDetailList);
        Optional<OrderMst> orderMstCompare = orderMstRepository.findById(orderMst.getSeq());
    }

    /**
     * 살살치킨 1마리 주문
     */
    public void 교촌치킨주문등록1() {
        /* given */
        // 주문1개
        OrderMst orderMst = new OrderMst();
        orderMst.setStoreMst(storeMstRepository.findBySeq(1L)); // 교촌치킨
        orderMst.setUserMst(userMstRepository.findBySeq(14L)); // 나는야고객1001
        orderMst.setCommonColumn(new CommonColumn(LocalDateTime.now(), "Test", LocalDateTime.now(), "Test"));
        orderMst.setPayment(PaymentType.KAKAOPAY);
        orderMst.setOrderDate(LocalDateTime.now());
        orderMst.setTotalPrice(18000);
        orderMst.setRequests("조심히 배달 부탁드려요~");

        // 불고기, 참치, 치즈 김밥 각 1개씩
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemQuantity(1);
        orderDetail.setItemPrice(18000);
        orderDetail.setOrderMst(orderMst);
        orderDetail.setItemMst(itemMstRepository.findBySeq(54L)); // 살살치킨

        orderDetailList.add(orderDetail);
        orderMst.setOrderDetailList(orderDetailList);

        /* when */
        orderMstRepository.save(orderMst);
        orderDetailRepository.save(orderDetail);
        Optional<OrderMst> orderMstCompare = orderMstRepository.findById(orderMst.getSeq());
        Optional<OrderDetail> orderDetailCompare = orderDetailRepository.findById(orderDetail.getSeq());
    }
}

@Component
class DbBean {

    @PostConstruct
    public void dbInsert() {

    }

}