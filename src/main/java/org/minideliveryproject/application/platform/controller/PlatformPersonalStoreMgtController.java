package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.Address;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.platform.service.PlatformPersonalStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/platform/storeMgt/personal")
public class PlatformPersonalStoreMgtController {

    private final PlatformPersonalStoreService platformPersonalStoreService;

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * @return
     */
    @GetMapping(value = "/")

    public String indexStoreMgtPersonal() {
        return "platform/storeMgt/personal";
    }

    /**
     * 플랫폼 > 점포관리 > 개인 점포
     * 조회버튼
     * @param personalStoreCode
     * @param personalStoreName
     * @param personalStoreCity
     * @return
     */
    @ResponseBody
    @GetMapping("/search")
    public List<StoreMst> personalStoreSearch(
            @RequestParam(value = "personalStoreCode", required = false) Long personalStoreCode,
            @RequestParam(value = "personalStoreName", required = false) String personalStoreName,
            @RequestParam(value = "personalStoreCity", required = false) Address personalStoreCity
    ) {
        log.info("PlatformPersonalStoreMgtController::personalStoreSearch called");
        List<StoreMst> personalStoreSearchList = platformPersonalStoreService.selectPersonalStoreList(personalStoreCode, personalStoreName, personalStoreCity);

        return personalStoreSearchList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 등록버튼
     */
    @PostMapping("/create")
    public Integer personalCreate(
            @RequestParam(value = "createPersonalStoreList", required = true) List<StoreMst> createPersonalStoreList
    ) {
        log.info("PlatformPersonalStoreMgtController::personalCreate called");

        return platformPersonalStoreService.createPersonalStoreAllList(createPersonalStoreList);
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * 객체에서 일부분 수정
     * 수정버튼
     * @param updatePersonalStoreList
     * @return
     */
    @PatchMapping("/update")
    public List<StoreMst> personalUpdate(
            @RequestParam(value = "updatePersonalStoreList", required = true) List<StoreMst> updatePersonalStoreList
    ) {
        log.info("PlatformPersonalStoreMgtController::personalUpdate called");
        platformPersonalStoreService.updatePersonalStoreAllList(updatePersonalStoreList);

        return updatePersonalStoreList;
    }

    /**
     * 플랫폼 > 점포관리 > 프랜차이즈 점포
     * DELETE_TYPE = NO 수정
     * 삭제버튼
     */
    @PatchMapping("/delete")
    public List<StoreMst> personalDelete(
            @RequestParam(value = "deletePersonalStoreList", required = true) List<StoreMst> deletePersonalStoreList
    ) {
        log.info("PlatformPersonalStoreMgtController::personalDelete called");
        platformPersonalStoreService.deletePersonalStoreAllList(deletePersonalStoreList);

        return deletePersonalStoreList;
    }


}
