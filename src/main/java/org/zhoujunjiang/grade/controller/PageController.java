package org.zhoujunjiang.grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {

    // 登录页
    @RequestMapping("/")
    public String login() {
        return "login"; // 返回 login.jsp
    }
}