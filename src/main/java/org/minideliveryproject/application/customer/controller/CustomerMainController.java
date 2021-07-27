package org.minideliveryproject.application.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CustomerMainController {

    @GetMapping(value = "/customer")
    public String gotoMainPage() {
        log.info("고객 메인화면 이동");

        return "/customer/customerMain";
    }
}
