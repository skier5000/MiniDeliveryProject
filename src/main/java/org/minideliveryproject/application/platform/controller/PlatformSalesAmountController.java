package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.platform.service.PlatformSalesAmountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/platform/storeMgt/salesAmount")
public class PlatformSalesAmountController {

    private final PlatformSalesAmountService platformSalesAmountService;

    /**
     * 플랫폼 > 점포관리 > 매출관리
     * @return
     */
    @GetMapping(value = "/")
    public String indexStoreMgtOrder() {
        return "platform/storeMgt/salesAmount";
    }
}
