package org.minideliveryproject.application.platform.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.Address;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.embeded.DeleteType;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.minideliveryproject.application.domain.repository.UserMstRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformPersonalStoreService {

    private final StoreMstRepositoryImpl storeMstRepository;
    private final FranchiseMstRepository franchiseMstRepository;
    private final UserMstRepositoryImpl userMstRepository;

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * 조회버튼
     * @param
     * @return
     */
    public List<StoreMst> selectPersonalStoreList(Long personalStoreCode, String personalStoreName, String personalStoreCity) {
        log.info("PlatformPersonalStoreService::selectPersonalStoreList called");
        List<StoreMst> personalStoreAllList = storeMstRepository.findAll();
        List<StoreMst> personalStoreSearchList = new ArrayList<>();

        if (personalStoreCode == null && personalStoreName == null && personalStoreCity == null) {  // 전체 search
            for (int i = 0; i < personalStoreAllList.size(); i++) {
                if (personalStoreAllList.get(i).getFranchiseMst() != null)
                    personalStoreSearchList.add(personalStoreAllList.get(i));
            }
            return personalStoreSearchList;
        } else {
            if (personalStoreCode != null) {
                // 가게코드 검색
                personalStoreSearchList.add(storeMstRepository.findBySeq(personalStoreCode));
                return personalStoreSearchList;
            } else if (personalStoreCode == null && personalStoreName != null && personalStoreCity == null) {
                // 가게이름 검색   ->   LIKE 검색
                return storeMstRepository.findByStoreNameLike(personalStoreName);
            } else if (personalStoreCode == null && personalStoreName == null && personalStoreCity != null) {
                // 가게 시/도 검색
                for (int i = 0; i < personalStoreAllList.size(); i++) {
                    if (personalStoreAllList.get(i).getAddress().getCity().equals(personalStoreCity))
                        personalStoreSearchList.add(personalStoreAllList.get(i));
                }
                return personalStoreSearchList;
            } else if (personalStoreCode == null && personalStoreName != null && personalStoreCity != null) {
                // 가게이름, 가게시/도 검색
                List<StoreMst> byStoreNameLike = storeMstRepository.findByStoreNameLike(personalStoreName);
                for (int i = 0; i < byStoreNameLike.size(); i++) {
                    if (byStoreNameLike.get(i).getAddress().getCity().equals(personalStoreCity)) {
                        personalStoreSearchList.add(byStoreNameLike.get(i));
                        return personalStoreSearchList;
                    }
                }
            }
        }
        return personalStoreSearchList;
    }

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * 등록버튼
     */
    public Integer createPersonalStoreAllList(List<StoreMst> createPersonalStoreList) {
        log.info("PlatformPersonalStoreService::createPersonalStoreAllList called");

        if (storeMstRepository.findByStoreName(createPersonalStoreList.get(0).getStoreName()) != null) { // 해당 Store 이름이 있으면
            return 0;  // 화면 반환 코드
        } else {
            // STORE_MST 저장
            storeMstRepository.saveAll(createPersonalStoreList);
            return 1;  // 화면 반환 코드
        }
    }

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * 수정버튼
     * @param updateFranchiseStoreList
     * @return
     */
    public List<StoreMst> updatePersonalStoreAllList(List<StoreMst> updateFranchiseStoreList) {
        log.info("PlatformMainService::updatepersonalStoreAllList called");

        // STORE_MST, FRANCHISE_MST, USER_MST 저장
        storeMstRepository.saveAll(updateFranchiseStoreList);
        for (int i = 0; i < updateFranchiseStoreList.size(); i++) {
            franchiseMstRepository.save(updateFranchiseStoreList.get(i).getFranchiseMst());
            userMstRepository.save(updateFranchiseStoreList.get(i).getUserMst());
        }

        return updateFranchiseStoreList;
    }

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * DELETE_TYPE = NO 수정
     * 삭제버튼
     */
    public List<StoreMst> deletePersonalStoreAllList(List<StoreMst> deleteFranchiseStoreList) {
        log.info("PlatformMainService::deletepersonalStoreAllList called");

        for (int i = 0; i < deleteFranchiseStoreList.size(); i++) {
            List<StoreMst> deleteStoreList = deleteFranchiseStoreList;
            deleteStoreList.get(i).setDeleteType(DeleteType.YES);
            storeMstRepository.save(deleteStoreList.get(i));
        }

        return deleteFranchiseStoreList;
    }


}
