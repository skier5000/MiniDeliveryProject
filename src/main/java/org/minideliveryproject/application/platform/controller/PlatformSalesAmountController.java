package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.OrderMstDto;
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
        return "platform/storeMgt/salesAmount";
    }


    @ResponseBody
    @GetMapping("/search")
    public void orderMstSearch(
            @RequestParam(value = "startContract", required = false) String startContract,
            @RequestParam(value = "endContract", required = false) String endContract,
            @RequestParam(value = "storeCode", required = false) Long storeCode,
            @RequestParam(value = "storeNm", required = false) String storeNm
    ) {
        log.info("PlatformOrderController::orderMstSearch called");
    }
}
