package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import org.minideliveryproject.application.platform.service.PlatformMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    @GetMapping("/platformMain")
    public String adminMain(){
        return "platform/platformMain";
    }

    @GetMapping("/storeMgt/franchise")
    public String franchise(){
        return "platform/storeMgt/franchise";
    }

    @GetMapping("/storeMgt/personal")
    public String personal(){
        return "platform/storeMgt/personal";
    }

    @GetMapping("/infoMgt/employee")
    public String employee(Model model){
        Map<String, Object> map = new HashMap<>();
        for(int i=1; i<=55; i++){
            map.put("no", i);
            map.put("empNum", "A" + i);
            map.put("dept", "IT");
            map.put("job", "사원");
            map.put("name", "홍길동");
            map.put("hp", "010-1111-1111");
            map.put("email", "lee@gamil.com");
            map.put("inDate", "2021-08-10");
        }

        model.addAttribute("map", map);

        return "platform/infoMgt/employee";
    }


}
