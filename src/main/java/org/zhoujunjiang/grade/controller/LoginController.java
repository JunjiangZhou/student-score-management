package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import org.zhoujunjiang.grade.entity.User;
import org.zhoujunjiang.grade.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model,
                             HttpSession session) {

        User user = userService.findByUsernameAndPassword(username, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/dashboard"; // 登录成功跳转页面（你可以改成自己的）
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // 登录成功后的主页面
    }
}