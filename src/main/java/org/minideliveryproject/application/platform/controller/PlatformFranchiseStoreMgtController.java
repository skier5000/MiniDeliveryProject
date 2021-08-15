package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.platform.service.PlatformMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
@Slf4j
@RequestMapping("/platform/storeMgt")
public class PlatformFranchiseStoreMgtController {

    private final PlatformMainService platformMainService;

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * /platform/storeMgt/franchise
     * @return
     */
    @GetMapping("/franchise")
    public String storeMgtFranchise(){
        return "platform/storeMgt/franchise";
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 조회버튼
     * @param franchiseCode
     * @param franchiseStoreName
     * @param franchiseStoreCity
     * @param gugun
     * @return
     */
    @ResponseBody
    @GetMapping("/franchise/search")
    public List<StoreMst> franchiseSearch(
            @RequestParam(value = "franchiseCode", required = false) String franchiseCode,
            @RequestParam(value = "franchiseStoreName", required = false) String franchiseStoreName,
            @RequestParam(value = "franchiseStoreCity", required = false) String franchiseStoreCity,
            @RequestParam(value = "gugun", required = false) String gugun
    ) {
        log.info("PlatformStoreMgtController::franchiseSearch called");
        List<StoreMst> franchiseStoreSearchList = platformMainService.selectFranchiseStoreAllList();

        return franchiseStoreSearchList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 등록버튼
     */
    @PostMapping("/franchise/create")
    public List<StoreMst> franchiseCreate(
            @RequestParam(value = "createFranchiseStoreList", required = true) List<StoreMst> createFranchiseStoreList
    ) {
        log.info("PlatformStoreMgtController::franchiseCreate called");
        List<StoreMst> franchiseStoreAllList = platformMainService.createFranchiseStoreAllList(createFranchiseStoreList);

        return franchiseStoreAllList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 객체에서 일부분 수정
     * 수정버튼
     * @param updateFranchiseStoreList
     * @return
     */
    @PatchMapping("/franchise/update")
    public List<StoreMst> franchiseUpdate(
            @RequestParam(value = "updateFranchiseStoreList", required = true) List<StoreMst> updateFranchiseStoreList
    ) {
        log.info("PlatformStoreMgtController::franchiseUpdate called");
        platformMainService.updateFranchiseStoreAllList(updateFranchiseStoreList);

        return updateFranchiseStoreList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * DELETE_TYPE = NO 수정
     * 삭제버튼
     */
    @PatchMapping("/franchise/delete")
    public List<StoreMst> franchiseDelete(
            @RequestParam(value = "deleteFranchiseStoreList", required = true) List<StoreMst> deleteFranchiseStoreList
    ) {
        log.info("PlatformStoreMgtController::franchiseDelete called");
        platformMainService.deleteFranchiseStoreAllList(deleteFranchiseStoreList);

        return deleteFranchiseStoreList;
    }


}












