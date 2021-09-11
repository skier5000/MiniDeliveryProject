package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.dto.UserMstDto;
import org.minideliveryproject.application.platform.service.PlatformEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/platform/infoMgt/employee")
public class PlatformInfoMgtEmployeeController {

    private final PlatformEmployeeService platformEmployeeService;

    @GetMapping("/")
    public String indexInfoMgtEmployee() {
        log.info("PlatformEmployeeController::indexInfoMgtEmployee called");
        return "platform/infoMgt/employee";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<UserMstDto> selectEmployeeList() {
        log.info("PlatformEmployeeController::selectEmployeeList called");

        List<UserMstDto> selectEmployeeList = platformEmployeeService.selectEmployeeList();

        return selectEmployeeList;
    }

    @ResponseBody
    @GetMapping("/createOrUpdateOrDelete")
    public UserMstDto createEmployeeList(
            @RequestParam(value = "createEmployeeList", required = true) UserMstDto userMstDto,
            @RequestParam(value = "createOrUpdateOrDelete", required = true) String createOrUpdateOrDelete
    ) {
        log.info("PlatformEmployeeController::createEmployeeList called");
        UserMstDto returnEmployeeList = new UserMstDto();

        try {
            if (createOrUpdateOrDelete.equals("CREATE")) {
                returnEmployeeList = platformEmployeeService.createEmployeeList(userMstDto);
            } else if (createOrUpdateOrDelete.equals("UPDATE")) {
                returnEmployeeList = platformEmployeeService.updateEmployeeList(userMstDto);
            } else if (createOrUpdateOrDelete.equals("DELETE")) {
                returnEmployeeList = platformEmployeeService.deleteEmployeeList(userMstDto);
            }
        } catch (Exception e) {
            returnEmployeeList.setUserId("ERROR");
            returnEmployeeList.setUserName(createOrUpdateOrDelete);
            return returnEmployeeList;
        }

        return returnEmployeeList;
    }



}
