package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.ItemMst;
import org.minideliveryproject.application.platform.service.PlatformFranchiseProdService;
import org.minideliveryproject.application.platform.service.PlatformFranchiseStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <pre>
 *  프랜차이즈 상품 관리 Controller
 * <pre>
 *
 * @author LYW
 * @since 2021.08.14
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.08.14.		LYW			최초작성
 */

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/platform/prodMgt/franchiseProd")
public class PlatformFranchiseProdMgtController {
    private final PlatformFranchiseProdService platformFranchiseProdService;

    @GetMapping(value = "/")
    public String indexProdMgtFranchise(){
        return "platform/prodMgt/franchiseProd";
    }

    /**
     * 플랫폼 > 상품관리 > 프랜차이즈 점포
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/search")
    public List<ItemMst> franchiseProdSearch(
            @RequestParam(value = "franchiseItemCode", required = false) Long franchiseItemCode,
            @RequestParam(value = "franchiseStoreCode", required = false) Long franchiseStoreCode,
            @RequestParam(value = "franchiseStoreName", required = false) String franchiseStoreName,
            @RequestParam(value = "itemCategory", required = false) String itemCategory,
            @RequestParam(value = "franchiseItemName", required = false) String franchiseItemName
    ) {
        log.info("PlatformFranchiseProdMgtController::franchiseSearch called");
        List<ItemMst> itemMstList = platformFranchiseProdService.selectFranchiseItemList(franchiseItemCode, franchiseStoreCode, franchiseStoreName, itemCategory, franchiseItemName);
        return itemMstList;
    }

    /**
     * 플랫폼 > 상품관리 > 프랜차이즈 점포
     * [등록] 버튼
     */
    @GetMapping("/create")
    public String franchiseProdCreate(){
        return "platform/prodMgt/franchiseProdCreate";
    }
}
