package org.minideliveryproject.application.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.login.dto.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginMainController {

    @GetMapping(value = "/")
    public String gotoLoginPage(@ModelAttribute UserForm userForm) {
        log.info("로그인 화면 이동");
        return "/login/login";
    }

    @PostMapping(value = "/login")
    public String loginProcess(@ModelAttribute UserForm userForm) {
        log.info("로그인 처리");

        return "redirect:/customer";
    }
}
