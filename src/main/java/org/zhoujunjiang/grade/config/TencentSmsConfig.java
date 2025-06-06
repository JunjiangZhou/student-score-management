package org.zhoujunjiang.grade.config;

import lombok.Data;

@Data
public class TencentSmsConfig {
    private String secretId;
    private String secretKey;
    private String appId;
    private String signName;
    private String templateId;
}