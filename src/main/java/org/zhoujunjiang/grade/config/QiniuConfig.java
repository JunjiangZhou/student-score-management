package org.zhoujunjiang.grade.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class QiniuConfig {
    private String accessKey = "PnJHPmOA8ew21dM9vnHS-qUuomfzLnVBvtCKhdZ8";
    private String secretKey = "9doe8GZQrME6Co123wPglm6qGZdcqwRHFQr8RzDL";
    private String bucket = "student-score-management";
    private String domain = "sxh4hdjnm.hd-bkt.clouddn.com";
}