package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * <pre>
 * ID, PW 접속 Main Contoller
 * <pre>
 *
 * @author LJB
 * @since 2021.06.20
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.06.20.		LJB			최초작성
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/platform")
@Slf4j
public class PlatformMainController {

    /**
     * 플랫폼 메인화면 접근
     * @return
     */
    @GetMapping("/")
    public ModelAndView mainPageAccess(/*HttpSession session*/) {
        ModelAndView viewPage = new ModelAndView();
        viewPage.setViewName("platform/platformMain");
        //viewPage.addObject("userName", session.getAttribute("userName"));

        return viewPage;
    }


    @GetMapping("/storeMgt/personal")
    public String personal(){
        return "platform/storeMgt/personal";
    }


    @GetMapping("prodMgt/franchiseProd")
    public String test() {
        return "platform/prodMgt/franchiseProd";
    }


}
