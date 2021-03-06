package org.minideliveryproject.application.login.repository;


import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * ID, PW 접속 Main Repository
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
@Repository
public interface LoginMainRepository extends JpaRepository<UserMst, Long>{
    public UserMst save(UserMst userMst);
    public Optional<UserMst> findByUserId(String userId);
    public List<UserMst> findAll();
}
