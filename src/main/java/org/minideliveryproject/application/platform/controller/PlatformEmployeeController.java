package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.dto.UserMstDto;
import org.minideliveryproject.application.platform.service.PlatformEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/infoMgt/employee")
public class PlatformEmployeeController {

    private final PlatformEmployeeService platformEmployeeService;

    @ResponseBody
    @GetMapping("/")
    public ModelAndView selectEmployeeList(){
        ModelAndView modelAndView = new ModelAndView();

        List<UserMstDto> selectEmployeeList = platformEmployeeService.selectEmployeeList();

        modelAndView.setViewName("platform/infoMgt/employee");
        modelAndView.addObject("selectEmployeeList", selectEmployeeList);

        return modelAndView;
    }



}
