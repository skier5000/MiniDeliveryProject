package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.domain.repository.UserMstRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class PlatformMainService {

    private final StoreMstRepositoryImpl storeMstRepository;
    private final FranchiseMstRepository franchiseMstRepository;
    private final UserMstRepositoryImpl userMstRepository;

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 조회버튼
     * @param
     * @return
     */
    public List<StoreMst> selectFranchiseStoreAllList() {
        log.info("PlatformMainService::selectFranchiseAllList called");
        List<StoreMst> franchiseStoreAllList = storeMstRepository.findAll();
        List<StoreMst> franchiseSearchList = new ArrayList<>();

        for (int i = 0; i < franchiseStoreAllList.size(); i++) {
            if (franchiseStoreAllList.get(i).getFranchiseMst() != null)
                franchiseSearchList.add(franchiseStoreAllList.get(i));
        }

        return franchiseSearchList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 등록버튼
     */
    public List<StoreMst> createFranchiseStoreAllList(List<StoreMst> createFranchiseStoreList) {
        log.info("PlatformMainService::createFranchiseStoreAllList called");

        // STORE_MST, FRANCHISE_MST, USER_MST 저장
        storeMstRepository.saveAll(createFranchiseStoreList);
        for (int i = 0; i < createFranchiseStoreList.size(); i++) {
            franchiseMstRepository.save(createFranchiseStoreList.get(i).getFranchiseMst());
            userMstRepository.save(createFranchiseStoreList.get(i).getUserMst());
        }

        return createFranchiseStoreList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 수정버튼
     * @param updateFranchiseStoreList
     * @return
     */
    public List<StoreMst> updateFranchiseStoreAllList(List<StoreMst> updateFranchiseStoreList) {
        log.info("PlatformMainService::updateFranchiseStoreAllList called");

        // STORE_MST, FRANCHISE_MST, USER_MST 저장
        storeMstRepository.saveAll(updateFranchiseStoreList);
        for (int i = 0; i < updateFranchiseStoreList.size(); i++) {
            franchiseMstRepository.save(updateFranchiseStoreList.get(i).getFranchiseMst());
            userMstRepository.save(updateFranchiseStoreList.get(i).getUserMst());
        }

        return updateFranchiseStoreList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * DELETE_TYPE = NO 수정
     * 삭제버튼
     */
    public List<StoreMst> deleteFranchiseStoreAllList(List<StoreMst> deleteFranchiseStoreList) {
        log.info("PlatformMainService::deleteFranchiseStoreAllList called");

        for (int i = 0; i < deleteFranchiseStoreList.size(); i++) {
            List<StoreMst> deleteStoreList = deleteFranchiseStoreList;
            deleteStoreList.get(i).setDeleteType(DeleteType.YES);
            storeMstRepository.save(deleteStoreList.get(i));
        }

        return deleteFranchiseStoreList;
    }

}
