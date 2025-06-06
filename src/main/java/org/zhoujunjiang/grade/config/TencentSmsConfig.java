package org.zhoujunjiang.grade.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class TencentSmsConfig {
    private String secretId = "AKIDxxxxxxxxxxxx";     // 替换为您的SecretId
    private String secretKey = "xxxxxxxxxxxxxxxxxx";  // 替换为您的SecretKey
    private String appId = "1400xxxxxxx";             // 替换为短信应用ID
    private String signName = "签名内容";              // 替换为短信签名
    private String templateId = "123456";             // 替换为模板ID
}