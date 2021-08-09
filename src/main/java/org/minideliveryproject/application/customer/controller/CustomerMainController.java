package org.minideliveryproject.application.customer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.customer.service.CustomerMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customer")
@Controller
public class CustomerMainController {

    private final CustomerMainService customerMainService;

    @GetMapping(value = "/")
    public String gotoMainPage() {
        log.info("CustomerMainController::gotoMainPage called");

        return "/customer/customerMain";
    }
}
