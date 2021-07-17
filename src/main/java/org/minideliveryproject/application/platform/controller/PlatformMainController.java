package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import org.minideliveryproject.application.platform.service.PlatformMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
public class PlatformMainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Bean
    private final PlatformMainService platformMainService;

//    @Autowired
//    public PlatformMainController(AccessMainService accessMainService){
//        this.accessMainService = accessMainService;
//    }


    /**
     * MainController
     * Index 메인화면 접근
     * @param
     * @return index
     * @throws Exception
     */
    @GetMapping("/platform/platformIndex")
    public ModelAndView indexAccess() throws Exception {
        logger.info("AccessMainController::indexAccess called");

        ModelAndView viewPage = new ModelAndView();
        viewPage.setViewName("index");

        return viewPage;
    }

}
