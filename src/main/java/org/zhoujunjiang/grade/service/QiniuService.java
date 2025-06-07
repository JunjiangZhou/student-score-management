package org.zhoujunjiang.grade.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zhoujunjiang.grade.config.QiniuConfig;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class QiniuService {

    @Resource
    private QiniuConfig config;

    public String upload(MultipartFile file) throws IOException {
        Configuration cfg = new Configuration(Region.huadong()); // 根据你所在地区选择
        UploadManager uploadManager = new UploadManager(cfg);

        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        String token = auth.uploadToken(config.getBucket());

        String key = file.getOriginalFilename();

        try {
            Response response = uploadManager.put(file.getBytes(), key, token);
            DefaultPutRet putRet = new ObjectMapper().readValue(response.bodyString(), DefaultPutRet.class);
            return config.getDomain() + "/" + putRet.key;
        } catch (QiniuException e) {
            throw new RuntimeException("上传失败：" + e.response.toString());
        }
    }
}