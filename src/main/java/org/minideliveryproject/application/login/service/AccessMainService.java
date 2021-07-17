package org.minideliveryproject.application.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.login.repository.AccessMainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <pre>
 * ID, PW 접속 Main Service
 * <pre>
 *
 * @author LJB
 * @since 2021.06.20
 * @version 1.1
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.06.20.		LJB			최초작성
 * 2021.07.11       LJB         파일명 수정
 */

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccessMainService {

    private final AccessMainRepository accessMainRepository;

//    @Autowired
//    public AccessMainService(AccessMainRepository accessMainRepository) {
//        this.accessMainRepository = accessMainRepository;
//    }

    /**
     * 고객 ID에 따른 정보 조회
     */
    public Optional<UserMst> selectUserInfo(String id) {
        log.info("AccessMainService::selectUserInfo called");
        Optional<UserMst> userList = accessMainRepository.findByUserId(id);

        return userList;
    }

}
