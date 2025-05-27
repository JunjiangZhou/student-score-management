package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.zhoujunjiang.grade.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.User;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    // 跳转注册页面
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // 返回注册页面视图
    }
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user, Model model) {
        // 检查用户名是否已存在
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "用户名已存在");
            return "register";
        }

        // 加密密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 保存用户
        userService.save(user);

        // 注册成功后重定向到登录页
        return "redirect:/login?registerSuccess=true";
    }
}
