package org.minideliveryproject.application.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
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

    private final FranchiseMstRepository franchiseMstRepository;

    /**
     * 고객 ID에 따른 정보 조회
     */
    public List<FranchiseMst> selectFranchiseAllList() {
        log.info("PlatformMainService::selectFranchiseAllList called");
        List<FranchiseMst> franchiseAllList = franchiseMstRepository.findAll();

        return franchiseAllList;
    }


}
