package org.minideliveryproject.application.platform.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.StoreMstDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <pre>
 * 점포관리 계약관리 Controller
 * <pre>
 *
 * @author LJB
 * @since 2021.09.02
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.09.02.		LJB			최초작성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/storeMgt/contract")
public class PlatformStoreContractController {

    @GetMapping("/")
    public String indexStoreMgtStoreContract() {
        log.info("PlatformStoreContractController::indexStoreMgtStoreContract called");
        return "platform/storeMgt/contract";
    }

//    @ResponseBody
//    @GetMapping("/search")
//    public List<StoreMstDto> storeStatusMstSearch (
//            @RequestParam(value = "storeType", required = false) String storeType,
//            @RequestParam(value = "storeMstSeq", required = false) Long storeMstSeq,
//            @RequestParam(value = "storeName", required = false) String storeName,
//            @RequestParam(value = "storeState", required = false) String storeState
//    ) {
//        log.info("PlatformStoreStatusController::storeStatusMstSearch called");
//
//        List<StoreMstDto> storeStatusMstList = platformStoreStatusService.selectStoreStatusMstList(storeType, storeMstSeq, storeName, storeState);
//
//        return storeStatusMstList;
//    }

}
