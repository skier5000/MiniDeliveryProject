package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.minideliveryproject.application.platform.service.PlatformInfoMgtStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/infoMgt/store")
public class PlatformInfoMgtStoreController {

    private final PlatformInfoMgtStoreService platformInfoMgtStoreService;

    @GetMapping("/")
    public String indexInfoMgtStore() {
        log.info("PlatformInfoMgtStoreController::indexInfoMgtStore called");
        return "/platform/infoMgt/store";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<StoreMstDto> selectStoreList(

    ) {
        log.info("PlatformInfoMgtStoreController::selectStoreList called");
        List<StoreMstDto> returnStoreList = platformInfoMgtStoreService.selectStoreList();

        return returnStoreList;
    }

}
