package org.minideliveryproject.application.domain.repository;

import org.minideliveryproject.application.domain.entity.ItemMst;
import org.minideliveryproject.application.dto.ItemMstDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemMstRepository extends JpaRepository<ItemMst, Long> {

    public ItemMst findBySeq(Long seq);                           // 아이템 seq 조회

    public Optional<ItemMst> findByItemName(String itemName);           // 아이템 명 조회

    public Optional<ItemMst> findByItemCategory(String itemCategory);   // 아이템 카테고리 조회

    // 아이템 마스터의 franchiseMst.seq와 프랜차이즈 마스터의 seq를 비교하여 프랜차이즈 점포명 조회
    @Query("SELECT fm.franchiseName FROM FranchiseMst fm, ItemMst im WHERE fm.seq = im.franchiseMst.seq AND im.franchiseMst.seq = ?1")
    public List<ItemMst> findByStoreName(Long seq);



    // 개인점포조회
    // AND IM.franchiseMst.seq = NULL 제거
    @Query("SELECT IM FROM ItemMst IM, StoreMst SM WHERE IM.seq = SM.seq")
    public List<ItemMstDto> findByPersonalStoreAll();

}
