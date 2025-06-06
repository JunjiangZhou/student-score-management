package org.zhoujunjiang.grade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.PhoneUser;
import org.zhoujunjiang.grade.service.PhoneUserService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
@RequestMapping("/phone")
public class PhoneLoginController {

    @Autowired
    private PhoneUserService phoneUserService;

    @Autowired
    private JedisPool jedisPool;

    @GetMapping("/login")
    public String showPhoneLoginPage() {
        return "phone-login";
    }

    @PostMapping("/verify")
    public String verifyLogin(@RequestParam String phone,
                              @RequestParam String code,
                              HttpSession session,
                              Model model) {
        try (Jedis jedis = jedisPool.getResource()) {
            String storedCode = jedis.get("login:code:" + phone);
            if (storedCode != null && storedCode.equals(code)) {
                PhoneUser user = phoneUserService.findByPhone(phone);
                if (user != null) {
                    session.setAttribute("user", user);
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(phone, null, Collections.emptyList());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    return "redirect:/index";
                }
            }
        }
        model.addAttribute("error", "手机号或验证码错误");
        return "phone-login";
    }
}