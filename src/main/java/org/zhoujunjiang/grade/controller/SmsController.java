package org.zhoujunjiang.grade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zhoujunjiang.grade.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sms")
public class SmsController {

    private final SmsService smsService;
    private final JedisPool jedisPool;

    
    @PostMapping("/send")
    public Map<String, Object> sendSms(@RequestParam String phone) {
        String code = String.valueOf(new Random().nextInt(9000) + 1000); // 生成4位验证码
        boolean success = smsService.sendCode(phone, code);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        if (success) {
            result.put("message", "验证码已发送");
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.setex("sms:code:" + phone, 300, code); // 有效期5分钟
            }
        } else {
            result.put("message", "发送失败");
        }
        return result;
    }
}