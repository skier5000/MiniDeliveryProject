package com.minidelivery.access.service;

import com.minidelivery.access.repository.MemberRepository;
import com.minidelivery.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccessMainService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemberRepository memberRepository;

    @Autowired
    public AccessMainService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 고객 ID에 따른 정보 조회
     */
    public Optional<Member> selectUserInfo(String id) {

        Optional<Member> memberList = memberRepository.findById(id);

        return memberList;
    }
}
