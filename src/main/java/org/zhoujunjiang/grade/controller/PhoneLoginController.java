package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.PhoneUser;
import org.zhoujunjiang.grade.entity.User;
import org.zhoujunjiang.grade.mapper.PhoneUserMapper;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
@RequestMapping("/phone")
public class PhoneLoginController {

    @Autowired
    private PhoneUserMapper phoneUserMapper;


    @GetMapping("/login")
    public String showPhoneLoginPage() {
        return "phone-login"; // 视图 JSP 页面
    }

    @PostMapping("/verify")
    public String verifyLogin(@RequestParam String phone,
                              @RequestParam String code,
                              HttpSession session,
                              Model model) {
        // TODO: 建议用 Redis 检查验证码
        PhoneUser user = phoneUserMapper.findByPhone(phone);
        if (user != null && code.equals(user.getCode())) {
            session.setAttribute("user", user);
            org.springframework.security.core.userdetails.User userDetails =
                    new org.springframework.security.core.userdetails.User(user.getPhone(), "", Collections.emptyList());
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);

            return "redirect:/index";
        } else {
            model.addAttribute("error", "手机号或验证码错误");
            return "phone-login";
        }
    }
}