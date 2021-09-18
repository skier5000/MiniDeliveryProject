package org.minideliveryproject.application.platform.service.itemmgt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.ItemMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
import org.minideliveryproject.application.domain.repository.ItemMstRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class PlatformFranchiseProdService {

    private final ItemMstRepository itemMstRepository;
    private final FranchiseMstRepository franchiseMstRepository;

    public List<ItemMst> selectFranchiseItemList(Long franchiseItemCode, Long franchiseStoreCode, String franchiseStoreName, String itemCategory, String franchiseItemName) {
        log.info("PlatformMainService::selectFranchiseProdAllList called");
        List<ItemMst> franchiseItemAllList = itemMstRepository.findAll();
        List<ItemMst> franchiseStoreNameList = itemMstRepository.findByStoreName(franchiseStoreCode);  // ItemMst의 franchise.seq와 일치하는 프랜차이즈 점포명 조회
        List<ItemMst> franchiseItemSearchList = new ArrayList<>();  // 프랜차이즈 점포코드, 프랜차이즈 점포명, 상품타입, 프랜차이즈 상품명을 담을 List

        if (franchiseItemCode == null && franchiseStoreCode == null && franchiseStoreName == null && itemCategory == null && franchiseItemName == null) {

        }
        return franchiseItemSearchList;
    }
}
