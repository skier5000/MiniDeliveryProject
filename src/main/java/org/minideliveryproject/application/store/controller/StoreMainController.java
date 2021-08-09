package org.minideliveryproject.application.store.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/store")
@Slf4j
public class StoreMainController {

    @GetMapping(value = "/")
    public String gotoMainPage() {
        log.info("StoreMainController::gotoMainPage called");

        return "/store/storeIndex";
    }
}
