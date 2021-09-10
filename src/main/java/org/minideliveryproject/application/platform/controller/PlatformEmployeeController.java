package org.minideliveryproject.application.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 점포관리 계약관리 Controller
 * <pre>
 *
 * @author LJB
 * @since 2021.09.02
 * @version 1.0
 * @see
 * =================== 변경 내역 ==================
 * 날짜				변경자			내용
 * ------------------------------------------------
 * 2021.09.02.		LJB			최초작성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/infoMgt/employee")
public class PlatformEmployeeController {

    @GetMapping("/")
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
