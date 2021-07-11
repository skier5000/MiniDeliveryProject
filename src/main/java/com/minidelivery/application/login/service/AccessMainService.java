package com.minidelivery.application.login.service;

import com.minidelivery.application.login.repository.AccessMainRepository;
import com.minidelivery.application.domain.UserMst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class AccessMainService {

    private final AccessMainRepository accessMainRepository;

//    @Autowired
//    public AccessMainService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 고객 ID에 따른 정보 조회
     */
    public Optional<UserMst> selectUserInfo(String id) {
        log.info("AccessMainService::selectUserInfo called");
        Optional<UserMst> memberList = accessMainRepository.findById(id);

        return memberList;
    }

}
