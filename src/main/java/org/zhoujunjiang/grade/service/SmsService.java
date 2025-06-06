package  org.zhoujunjiang.grade.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final JedisPool jedisPool;

    public boolean sendCode(String phoneNumber, String code) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex("sms:code:" + phoneNumber, 300, code); // 有效期5分钟
        }
        System.out.println("模拟发送验证码到 " + phoneNumber + "，验证码是：" + code);
        return true;
    }

    public boolean verifyCode(String phoneNumber, String inputCode) {
        try (Jedis jedis = jedisPool.getResource()) {
            String storedCode = jedis.get("sms:code:" + phoneNumber);
            return inputCode != null && inputCode.equals(storedCode);
        }
    }
}