package org.minideliveryproject.application.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.entity.embeded.UserRoleType;
import org.minideliveryproject.application.login.dto.UserForm;
import org.minideliveryproject.application.login.service.LoginMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginMainController {

    private final LoginMainService loginMainService;

    @GetMapping(value = "/")
    public String gotoLoginPage(@ModelAttribute UserForm userForm) {
        log.info("LoginMainController::gotoLoginPage called");
        return "/login/login";
    }

    @PostMapping(value = "/login")
    public ModelAndView loginProcess(@ModelAttribute UserForm userForm) {
        log.info("LoginMainController::gotoLoginPage called");

        String realPassword;
        UserRoleType accessCd;
        ModelAndView viewPage = new ModelAndView();

        Optional<UserMst> selectUserServiceList = loginMainService.selectUserInfo(userForm.getId());

        viewPage.setViewName("/login/login");

        // 아이디 체크
        if(selectUserServiceList.isEmpty()) {  // 아이디가 존재하지않음
            viewPage.addObject("message", "NONID");
            return viewPage;
        } else {  // 아이디가 존재함
            // 패스워드까지 맞으면 (후에 암호화 방식으로)
            realPassword = selectUserServiceList.get().getUserPassword();

            if(realPassword.equals(userForm.getPassword())){
                accessCd = selectUserServiceList.get().getUserRoleType(); // 접근 권한 코드
                switch (accessCd) {
                    case PLATFORM :
                        viewPage.setViewName("redirect:/customer");
                        viewPage.addObject("message", "PLATFORM");
                        break;
                    case STORE :
                        viewPage.setViewName("redirect:/customer");
                        viewPage.addObject("message", "STORE");
                        break;
                    case CUSTOMER :
                        viewPage.setViewName("redirect:/customer");
                        viewPage.addObject("message", "CUSTOMER");
                        break;
                    default:
                        break;
                }
            } else {
                viewPage.addObject("message", "WRONGPASSWORD");
                return viewPage;
            }
        }

        return viewPage;
    }

}
