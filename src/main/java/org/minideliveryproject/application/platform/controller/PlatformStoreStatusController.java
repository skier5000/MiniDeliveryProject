package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.minideliveryproject.application.platform.dto.SalesAmountDto;
import org.minideliveryproject.application.platform.service.PlatformStoreStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <pre>
 * 점포관리 운영관리 Controller
 * <pre>
 *
 * @author LJB
 * @since 2021.08.30
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.08.30.		LJB			최초작성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/storeMgt/storeStatus")
public class PlatformStoreStatusController {

    private final PlatformStoreStatusService platformStoreStatusService;

    @GetMapping("/")
    public String indexStoreMgtStoreStatus() {
        log.info("PlatformStoreStatusController::indexStoreMgtStoreStatus called");
        return "platform/storeMgt/storeStatus";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<StoreMstDto> storeStatusMstSearch (
            @RequestParam(value = "storeType", required = false) String storeType,
            @RequestParam(value = "storeMstSeq", required = false) Long storeMstSeq,
            @RequestParam(value = "storeName", required = false) String storeName,
            @RequestParam(value = "storeState", required = false) String storeState
    ) {
        log.info("PlatformStoreStatusController::storeStatusMstSearch called");

        List<StoreMstDto> storeStatusMstList = platformStoreStatusService.selectStoreStatusMstList(storeType, storeMstSeq, storeName, storeState);

        return storeStatusMstList;
    }

    @ResponseBody
    @GetMapping("/searchDetail")
    public List<StoreMstDto> storeStatusDetailSearch (
            @RequestParam(value = "storeMstSeq", required = true) String storeMstSeq
    ) {
        log.info("PlatformStoreStatusController::storeStatusDetailSearch called");

        List<StoreMstDto> storeStatusDetailList = platformStoreStatusService.selectStoreStatusDetailList(storeMstSeq);

        return storeStatusDetailList;
    }


}
