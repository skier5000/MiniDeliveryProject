package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.OrderMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.dto.OrderDetailDto;
import org.minideliveryproject.application.dto.OrderMstDto;
import org.minideliveryproject.application.platform.service.PlatformOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/platform/storeMgt/order")
public class PlatformOrderController {

    private final PlatformOrderService platformOrderService;

    /**
     * 플랫폼 > 점포관리 > 주문관리
     * @return
     */
    @GetMapping(value = "/")
    public String indexStoreMgtOrder() {
        return "platform/storeMgt/order";
    }

    /**
     * 플랫폼 > 점포관리 > 주문관리
     * 오더 마스터 조회
     * @param startContract
     * @param endContract
     * @param storeCode
     * @param storeNm
     * @return
     */
    @ResponseBody
    @GetMapping("/search")
    public List<OrderMstDto> orderMstSearch(
            @RequestParam(value = "startContract", required = false) String startContract,
            @RequestParam(value = "endContract", required = false) String endContract,
            @RequestParam(value = "storeCode", required = false) Long storeCode,
            @RequestParam(value = "storeNm", required = false) String storeNm
    ) {
        log.info("PlatformOrderController::orderMstSearch called");
        List<OrderMstDto> orderMstDtoList = platformOrderService.selectOrderMstList(startContract, endContract, storeCode, storeNm);

        return orderMstDtoList;
    }


    /**
     * 플랫폼 > 점포관리 > 주문관리
     * 오더 디테일 조회
     * @return
     */
    @ResponseBody
    @GetMapping("/searchDetail")
    public List<OrderDetailDto> orderDetailSearch(
            @RequestParam(value = "storeMstSeq", required = true) Long storeMstSeq
    ) {
        log.info("PlatformOrderController::orderDetailSearch called");
        List<OrderDetailDto> orderDetailDtoList = platformOrderService.selectOrderDetailList(storeMstSeq);

        return orderDetailDtoList;
    }


}
