package org.zhoujunjiang.grade.service;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zhoujunjiang.grade.config.TencentSmsConfig;

@Service
@RequiredArgsConstructor
public class SmsService {

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

            SendSmsResponse resp = client.SendSms(req);
            return "Ok".equals(resp.getSendStatusSet()[0].getCode());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}