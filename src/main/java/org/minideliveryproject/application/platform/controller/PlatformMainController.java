package org.minideliveryproject.application.platform.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.minideliveryproject.application.domain.entity.FranchiseMst;
import org.minideliveryproject.application.domain.entity.StoreMst;
import org.minideliveryproject.application.domain.entity.UserMst;
import org.minideliveryproject.application.domain.repository.FranchiseMstRepository;
import org.minideliveryproject.application.platform.service.PlatformMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    private final PlatformMainService platformMainService;


    /**
     * MainController
     * Index 메인화면 접근
     * @param
     * @return index
     * @throws Exception
     */
    @GetMapping("/platform/platformIndex")
    public ModelAndView indexAccess() throws Exception {
        log.info("AccessMainController::indexAccess called");

        ModelAndView viewPage = new ModelAndView();
        viewPage.setViewName("index");

        return viewPage;
    }

    /**
     * 플랫폼 메인화면 접근
     * @param userInfo
     * @return
     */
    @GetMapping("/platformMain")
    public ModelAndView mainPageAccess(@RequestParam("User") Optional<UserMst> userInfo) {
        ModelAndView viewPage = new ModelAndView();
        viewPage.setViewName("platform/platformMain");
        viewPage.addObject("userInfo", userInfo);

        return viewPage;
    }

    /**
     * 플랫폼 프랜차이즈 점포 조회 화면 접근
     * @return
     */
    @GetMapping("/storeMgt/franchise")
    public String franchise(){
        return "platform/storeMgt/franchise";
    }

    /**
     * 프랜차이즈 점포 find All to JSON
     * @return List<StoreMst>
     */
    @ResponseBody
    @GetMapping("/storeMgt/franchise/search")
    public List<StoreMst> franchiseAllList() {
        List<StoreMst> franchiseStoreAllList = platformMainService.selectFranchiseStoreAllList();

        return franchiseStoreAllList;
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
