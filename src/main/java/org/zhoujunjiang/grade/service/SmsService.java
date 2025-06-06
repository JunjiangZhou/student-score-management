package org.zhoujunjiang.grade.service;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.config.TencentSmsConfig;

@Service
@RequiredArgsConstructor
public class SmsService {

    private static final Logger log = LoggerFactory.getLogger(SmsService.class);
    private final TencentSmsConfig smsConfig;

    public boolean sendCode(String phoneNumber, String code) {
        try {
            Credential cred = new Credential(smsConfig.getSecretId(), smsConfig.getSecretKey());
            SmsClient client = new SmsClient(cred, "ap-guangzhou");

            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppId(smsConfig.getAppId());
            req.setSignName(smsConfig.getSignName());
            req.setTemplateId(smsConfig.getTemplateId());

            req.setPhoneNumberSet(new String[]{"+86" + phoneNumber});
            req.setTemplateParamSet(new String[]{code});
            req.setSessionContext("login-code-" + phoneNumber); // 可选

            SendSmsResponse resp = client.SendSms(req);

            if (resp.getSendStatusSet() != null && resp.getSendStatusSet().length > 0) {
                String resultCode = resp.getSendStatusSet()[0].getCode();
                log.info("短信发送结果 [{}] 给 {}: {}", resultCode, phoneNumber, resp.getSendStatusSet()[0].getMessage());
                return "Ok".equals(resultCode);
            }

            log.warn("腾讯云返回空的 SendStatusSet");
            return false;

        } catch (Exception e) {
            log.error("短信发送异常: {}", e.getMessage(), e);
            return false;
        }
    }
}