package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
import org.minideliveryproject.application.domain.repository.StoreMstRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class PlatformMainService {

    private final StoreMstRepositoryImpl storeMstRepository;

    /**
     * 프랜차이즈 점포 find All to JSON
     */
    public List<StoreMst> selectFranchiseStoreAllList() {
        log.info("PlatformMainService::selectFranchiseAllList called");
        List<StoreMst> franchiseStoreAllList = null;

        for (StoreMst storeMst : storeMstRepository.findAll()) {
            System.out.println("storeMst = " + storeMst);
        }

        return franchiseStoreAllList;
    }


}
