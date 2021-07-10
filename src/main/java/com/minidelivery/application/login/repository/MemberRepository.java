package com.minidelivery.application.login.repository;


import com.minidelivery.application.domain.UserMst;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * Member Repository 인터페이스 생성
 * <pre>
 *
 * @author LJB
 * @since 2021.06.20
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.06.20.		LJB			최초작성
 */

public interface UserRepository {
    public UserMst save(UserMst userMst);
    public Optional<UserMst> findById(String id);
    public Optional<UserMst> findByName(String name);
    public List<UserMst> findAll();
}
