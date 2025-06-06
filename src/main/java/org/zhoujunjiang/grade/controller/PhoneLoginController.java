package org.zhoujunjiang.grade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.entity.PhoneUser;
import org.zhoujunjiang.grade.service.PhoneUserService;
import org.zhoujunjiang.grade.service.SmsService;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/phone")
public class PhoneLoginController {
    @Autowired
    private PhoneUserService phoneUserService;
    @Autowired
    private SmsService smsService;

    @GetMapping("/login")
    public String loginPage() {
        return "phone-login";
    }

    @PostMapping("/verify")
    public String verify(@RequestParam String phone,
                         @RequestParam String code,
                         Model model) {

        if (!smsService.verifyCode(phone, code)) {
            model.addAttribute("error", "验证码错误或已过期");
            return "phone-login";
        }

        PhoneUser user = phoneUserService.findByPhone(phone);
        if (user == null) {
            user = new PhoneUser();
            user.setPhone(phone);
            phoneUserService.insert(user);
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                phone, null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/index";
    }
}