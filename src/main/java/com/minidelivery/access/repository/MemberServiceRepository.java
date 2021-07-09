package com.minidelivery.access.repository;


import com.minidelivery.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <pre>
 * Member Repository spring data jpa 인터페이스 구현체생성 (Interface)
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

public interface MemberServiceRepository extends JpaRepository<Member, Long>, MemberRepository{

    @Override
    Optional<Member> findByName(String name);
    // JPQL : select m from Member m where m.name = ?
    // 자동으로 JPQL 생성

}
