package org.minideliveryproject.application.platform.controller;

/**
 * <pre>
 * 정보관리 사원관리 Controller
 * <pre>
 *
 * @author LJB
 * @since 2021.09.10
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.09.10.		LJB			최초작성
 */

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.UserMstDto;
import org.minideliveryproject.application.platform.service.PlatformInfoMgtCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/infoMgt/user")
public class PlatformInfoMgtCustomerController {

    private final PlatformInfoMgtCustomerService platformInfoMgtCustomerService;

    @GetMapping("/")
    public String indexInfoMgtCustomer() {
        log.info("PlatformInfoMgtCustomerController::indexInfoMgtCustomer called");
        return "platform/infoMgt/user";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<UserMstDto> selectCustomerList() {
        log.info("PlatformInfoMgtCustomerController::selectCustomerList called");
        List<UserMstDto> selectCustomerList = platformInfoMgtCustomerService.selectCustomerList();
        return selectCustomerList;
    }
}
