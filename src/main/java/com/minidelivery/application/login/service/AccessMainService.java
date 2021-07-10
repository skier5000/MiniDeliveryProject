package com.minidelivery.application.login.service;

import com.minidelivery.application.login.repository.MemberRepository;
import com.minidelivery.application.domain.Team;
import com.minidelivery.application.domain.UserMst;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class AccessMainService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemberRepository memberRepository;

//    @Autowired
//    public AccessMainService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 고객 ID에 따른 정보 조회
     */
    public Optional<UserMst> selectUserInfo(String id) {


        Optional<UserMst> memberList = memberRepository.findById(id);

        return memberList;
    }

    public void test(){
        UserMst temp = new UserMst();
        temp.getTeam().setName("꺼져");

        Team team = new Team();
        team.setName("11");

    }

}
