package org.zhoujunjiang.grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({ "/index"})
    public String index() {
        return "index"; // 对应 /WEB-INF/views/index.jsp
    }
}
