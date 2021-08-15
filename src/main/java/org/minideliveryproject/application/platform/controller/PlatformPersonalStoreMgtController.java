package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/platform/storeMgt/personal")
public class PlatformPersonalStoreMgtController {

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * @return
     */
    @GetMapping(value = "/")
    public String indexStoreMgtFranchise(){
        return "platform/storeMgt/personal";
    }
}
