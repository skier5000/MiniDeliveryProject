package com.minidelivery.minidelivery.access.repository;

import com.minidelivery.minidelivery.domain.Member;

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

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findById(String id);
    public Optional<Member> findByName(String name);
    public List<Member> findAll();
}
