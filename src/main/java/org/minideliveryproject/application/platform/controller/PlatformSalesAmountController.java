package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.platform.service.PlatformSalesAmountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/platform/storeMgt/salesAmount")
public class PlatformSalesAmountController {

    private final PlatformSalesAmountService platformSalesAmountService;

    /**
     * 플랫폼 > 점포관리 > 매출관리
     *
     * @return
     */
    @GetMapping(value = "/")
    public String indexStoreMgtSalesAmount() {
        log.info("PlatformSalesAmountController::indexStoreMgtSalesAmount called");
        return "platform/storeMgt/salesAmount";
    }


    @ResponseBody
    @GetMapping("/search")
    public void salesAmountMstSearch(
            @RequestParam(value = "startContract", required = false) String startContract,
            @RequestParam(value = "endContract", required = false) String endContract,
            @RequestParam(value = "storeCode", required = false) Long storeCode,
            @RequestParam(value = "storeNm", required = false) String storeNm
    ) {
        log.info("PlatformSalesAmountController::salesAmountMstSearch called");

//        List<OrderMstDto> orderMstDtoList = platformOrderService.selectOrderMstList(startContract, endContract, storeCode, storeNm);
//
//        return orderMstDtoList;
    }

    @ResponseBody
    @GetMapping("/search")
    public void salesAmountDetailSearch(
            @RequestParam(value = "storeMstSeq", required = true) Long storeMstSeq
    ) {
        log.info("PlatformSalesAmountController::orderMstSearch called");

//        List<OrderDetailDto> orderDetailDtoList = platformOrderService.selectOrderDetailList(storeMstSeq);
//
//        return orderDetailDtoList;
    }

}
