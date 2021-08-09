package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.platform.service.PlatformMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.util.List;


/**
 * <pre>
 * 관리자 화면 접근, 점포관리
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

    private final PlatformMainService platformMainService;

    @GetMapping(value = "/")
    public String gotoMainPage() {
        log.info("PlatformMainController::gotoMainPage called");

        return "/platform/platformIndex";
    }

    @GetMapping(value = "/franchiseList")
    public ModelAndView selectFranchiseList() {
        ModelAndView viewPage = new ModelAndView();

        List<FranchiseMst> franchiseMstList = platformMainService.selectFranchiseAllList();
        JSONParser dd = new JSONParser((InputStream) franchiseMstList);

        viewPage.setViewName("/platform/platformIndex/selectFranchiseList");
        viewPage.addObject("franchiseMstList", franchiseMstList);

        return viewPage;
    }
}
