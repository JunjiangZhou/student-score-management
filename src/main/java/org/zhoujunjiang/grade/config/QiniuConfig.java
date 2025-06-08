package org.zhoujunjiang.grade.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
public class QiniuConfig {
    private String accessKey = "";
    private String secretKey = "";
    private String bucket = "";
    private String domain = "";
}
