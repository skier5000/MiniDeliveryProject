package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.UserMstDto;
import org.minideliveryproject.application.platform.service.PlatformInfoMgtEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    private final PlatformInfoMgtEmployeeService platformInfoMgtEmployeeService;

    @GetMapping("/")
    public String indexInfoMgtEmployee() {
        log.info("PlatformEmployeeController::indexInfoMgtEmployee called");
        return "platform/infoMgt/employee";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<UserMstDto> selectEmployeeList() {
        log.info("PlatformEmployeeController::selectEmployeeList called");

        List<UserMstDto> selectEmployeeList = platformInfoMgtEmployeeService.selectEmployeeList();

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
                returnEmployeeList = platformInfoMgtEmployeeService.createEmployeeList(userMstDto);
            } else if (createOrUpdateOrDelete.equals("UPDATE")) {
                returnEmployeeList = platformInfoMgtEmployeeService.updateEmployeeList(userMstDto);
            } else if (createOrUpdateOrDelete.equals("DELETE")) {
                returnEmployeeList = platformInfoMgtEmployeeService.deleteEmployeeList(userMstDto);
            }
        } catch (Exception e) {
            returnEmployeeList.setUserId("ERROR");
            returnEmployeeList.setUserName(createOrUpdateOrDelete);
            return returnEmployeeList;
        }

        return returnEmployeeList;
    }



}
