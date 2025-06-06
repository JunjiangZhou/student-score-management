package org.zhoujunjiang.grade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.service.SmsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sms")
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public String sendCode(@RequestParam String phone) {
        smsService.sendCode(phone);
        return "验证码已发送（本地模拟）";
    }
}