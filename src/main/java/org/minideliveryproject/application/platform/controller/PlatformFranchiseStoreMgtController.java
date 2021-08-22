package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.Address;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.minideliveryproject.application.platform.service.PlatformFranchiseStoreService;
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
@Slf4j
@RequestMapping("/platform/storeMgt/franchise")
public class PlatformFranchiseStoreMgtController {

    private final PlatformFranchiseStoreService platformFranchiseStoreService;

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * @return
     */
    @GetMapping(value = "/")
    public String indexStoreMgtFranchise(){
        return "platform/storeMgt/franchise";
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 조회버튼
     * @param franchiseStoreCode
     * @param franchiseStoreName
     * @param franchiseStoreCity
     * @return
     */
    @ResponseBody
    @GetMapping("/search")
    public List<StoreMstDto> franchiseSearch(
            @RequestParam(value = "franchiseStoreCode", required = false) Long franchiseStoreCode,
            @RequestParam(value = "franchiseStoreName", required = false) String franchiseStoreName,
            @RequestParam(value = "franchiseStoreCity", required = false) Address franchiseStoreCity
    ) {
        log.info("PlatformFranchiseStoreMgtController::franchiseSearch called");
        List<StoreMstDto> franchiseStoreSearchList = platformFranchiseStoreService.selectFranchiseStoreList(franchiseStoreCode, franchiseStoreName, franchiseStoreCity);

        return franchiseStoreSearchList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 등록버튼
     */
    @PostMapping("/create")
    public List<StoreMstDto> franchiseCreate(
            @RequestParam(value = "createFranchiseStoreList", required = true) List<StoreMst> createFranchiseStoreList
    ) {
        log.info("PlatformFranchiseStoreMgtController::franchiseCreate called");
        List<StoreMstDto> franchiseStoreAllList = platformFranchiseStoreService.createFranchiseStoreAllList(createFranchiseStoreList);

        return franchiseStoreAllList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 객체에서 일부분 수정
     * 수정버튼
     * @param updateFranchiseStoreList
     * @return
     */
    @PatchMapping("/update")
    public List<StoreMst> franchiseUpdate(
            @RequestParam(value = "updateFranchiseStoreList", required = true) List<StoreMst> updateFranchiseStoreList
    ) {
        log.info("PlatformFranchiseStoreMgtController::franchiseUpdate called");
        platformFranchiseStoreService.updateFranchiseStoreAllList(updateFranchiseStoreList);

        return updateFranchiseStoreList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * DELETE_TYPE = NO 수정
     * 삭제버튼
     */
    @PatchMapping("/delete")
    public List<StoreMst> franchiseDelete(
            @RequestParam(value = "deleteFranchiseStoreList", required = true) List<StoreMst> deleteFranchiseStoreList
    ) {
        log.info("PlatformFranchiseStoreMgtController::franchiseDelete called");
        platformFranchiseStoreService.deleteFranchiseStoreAllList(deleteFranchiseStoreList);

        return deleteFranchiseStoreList;
    }


}












