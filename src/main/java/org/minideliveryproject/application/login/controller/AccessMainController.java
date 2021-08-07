package org.minideliveryproject.application.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.entity.embeded.UserRoleType;
import org.minideliveryproject.application.login.dto.UserForm;
import org.minideliveryproject.application.login.service.AccessMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


/**
 * <pre>
 * ID, PW 접속 Main Contoller
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
@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class AccessMainController {
    // Bean
    private final AccessMainService accessMainService;

//    @Autowired
//    public AccessMainController(AccessMainService accessMainService){
//        this.accessMainService = accessMainService;
//    }


    /**
     * MainController
     * Index 메인화면 접근
     * @param
     * @return index
     * @throws Exception
     */
    @GetMapping("/main")
    public ModelAndView indexAccess() throws Exception {
        log.info("AccessMainController::indexAccess called");

        ModelAndView viewPage = new ModelAndView();
        viewPage.setViewName("index");

        return viewPage;
    }


    /**
     * MainController
     * 고객정보 서비스 조회 테스트 (전체)
     * @param
     * @return index
     * @throws Exception
     */
    @PostMapping("/access")
    public ModelAndView accessPage(
            HttpServletRequest rq,
            HttpServletResponse rs,
            UserForm userForm
    ) throws Exception {
        log.info("AccessMainController::accessPage called");
        String realPassword;
        String message = null;
        UserRoleType realAccessCd;
        ModelAndView viewPage = new ModelAndView();

        Optional<UserMst> selectUserServiceList = accessMainService.selectUserInfo(userForm.getId());

        // 아이디 체크
        if(selectUserServiceList.isEmpty()) {
            System.out.println("등록된 아이디 없음");
            viewPage.setViewName("");
            viewPage.addObject("loginErrorMessage", message);
            return viewPage;
        }
        else {
            // 패스워드까지 맞으면 (후에 암호화 방식으로)
            realPassword = selectUserServiceList.get().getUserPassword();

            if(realPassword.equals(userForm.getPassword())){
                realAccessCd = selectUserServiceList.get().getUserRoleType(); // 접근 권한 코드
                switch (realAccessCd) {
//                    case "ADMIN":
//                        viewPage.setViewName("platform/platformIndex");
//                        message = "관리자님 환영합니다.";
//                        System.out.println("관리자 화면 진입");
//                        break;
//                    case "STORE":
//                        viewPage.setViewName("store/storeIndex");
//                        message = "점포명 + 님 환영합니다."; // 후에 점포명 삽입
//                        System.out.println("점포 화면 진입");
//                        break;
//                    case "CUSTOMER":
//                        viewPage.setViewName("customer/customerIndex");
//                        message = "이름 + 님 환영합니다."; // 후에 이름 삽입
//                        System.out.println("회원 화면 진입");
//                        break;
//                    default:
//                        break;
                }
            }
            else {
                viewPage.setViewName("index");
                message = "패스워드가 다릅니다";
                System.out.println("패스워드가 다릅니다");
            }
        }

        viewPage.addObject("loginMessage", message);
        return viewPage;
    }


    @GetMapping("/test")
    public ModelAndView htmlTest() throws IOException {
        log.info("AccessMainController::htmlTest called");

        ModelAndView viewPage = new ModelAndView();
        viewPage.setViewName("layout/defaultLayout");

        return viewPage;
    }
}
