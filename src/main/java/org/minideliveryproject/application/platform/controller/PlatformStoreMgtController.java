package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.platform.service.PlatformMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <pre>
 * 점포관리 Controller
 * <pre>
 *
 * @author LJB
 * @since 2021.08.14
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.08.14.		LJB			최초작성
 */


@Controller
@RequiredArgsConstructor
@RequestMapping("/storeMgt")
@Slf4j
public class PlatformStoreMgtController {

    private final PlatformMainService platformMainService;

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * @return
     */
    @GetMapping("/franchise")
    public String storeMgtFranchise(){
        return "platform/storeMgt/franchise";
    }

    @ResponseBody
    @PostMapping("/franchise/search")
    public List<StoreMst> franchiseSearch(@RequestParam("??") String dd) {
        List<StoreMst> franchiseStoreAllList = platformMainService.selectFranchiseStoreAllList();

        return franchiseStoreAllList;
    }


}












