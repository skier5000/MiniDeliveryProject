package org.minideliveryproject.application.login.repository;

import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.login.repository.AccessMainRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <pre>
 * ID, PW 접속 Main Service Repository
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
public interface AccessMainServiceRepository extends JpaRepository<UserMst, Long>, AccessMainRepository {

    @Override
    Optional<UserMst> findByUserName(String userName);
    // JPQL : select m from Member m where m.name = ?

}
