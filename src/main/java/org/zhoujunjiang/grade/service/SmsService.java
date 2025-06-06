package org.zhoujunjiang.grade.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;

@Service
public class SmsService {

    private final JedisPool jedisPool;

    public SmsService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public boolean sendCode(String phone) {
        String code = String.valueOf(new Random().nextInt(9000) + 1000);
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex("sms:code:" + phone, 300, code); // 5分钟过期
        }
        System.out.println("模拟发送验证码：" + code);
        return true;
    }

    public boolean verifyCode(String phone, String inputCode) {
        try (Jedis jedis = jedisPool.getResource()) {
            String realCode = jedis.get("sms:code:" + phone);
            return realCode != null && realCode.equals(inputCode);
        }
    }
}