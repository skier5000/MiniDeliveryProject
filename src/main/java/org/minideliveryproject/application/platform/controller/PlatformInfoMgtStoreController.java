package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/infoMgt/store")
public class PlatformInfoMgtStoreController {

    @GetMapping("/")
    public String indexInfoMgtStore() {
        log.info("PlatformInfoMgtStoreController::indexInfoMgtStore called");
        return "/platform/infoMgt/store/";
    }


}
