package org.minideliveryproject.application.platform.controller.itemmgt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.ItemMstDto;
import org.minideliveryproject.application.platform.service.itemmgt.PlatformPersonalItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/prodMgt/personalProd")
public class PlatformPersonalItemController {

    private final PlatformPersonalItemService platformPersonalItemService;

    @GetMapping("/")
    public String indexPersonalItem() {
        log.info("PlatformPersonalItemController::indexPersonalItem called");
        return "platform/prodMgt/personalProd";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<ItemMstDto> selectPersonalItemList(
            @RequestParam(value = "storeCd", required = false) String storeCd,
            @RequestParam(value = "storeNm",required = false) String storeNm,
            @RequestParam(value = "itemType", required = false) String itemType,
            @RequestParam(value = "itemNm", required = false) String itemNm
    ) {
        log.info("PlatformPersonalItemController::selectPersonalItemList called");

        List<ItemMstDto> selectPersonalItemList = platformPersonalItemService.selectPersonalItemList(storeCd, storeNm, itemType, itemNm);

        return selectPersonalItemList;
    }



}
