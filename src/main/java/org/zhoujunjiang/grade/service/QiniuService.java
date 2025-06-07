package org.zhoujunjiang.grade.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zhoujunjiang.grade.config.QiniuConfig;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QiniuService {

    @Autowired
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
            // 修复：添加HTTP协议前缀
            return "http://" + config.getDomain() + "/" + putRet.key;
        } catch (QiniuException e) {
            throw new RuntimeException("上传失败：" + e.response.toString());
        }
    }

    public List<String> listFileUrls() {
        Configuration cfg = new Configuration(Region.huadong());
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        try {
            BucketManager bucketManager = new BucketManager(auth, cfg);
            FileListing fileListing = bucketManager.listFiles(config.getBucket(), "", "", 100, null);

            List<String> urls = new ArrayList<>();
            for (FileInfo fileInfo : fileListing.items) {
                // 修复：添加HTTP协议前缀，并正确处理URL编码
                String encodedKey = java.net.URLEncoder.encode(fileInfo.key, "UTF-8").replace("+", "%20");
                urls.add("http://" + config.getDomain() + "/" + encodedKey);
            }
            return urls;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public java.io.InputStream download(String fileName) {
        Configuration cfg = new Configuration(Region.huadong());
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        try {
            String encodedFileName = java.net.URLEncoder.encode(fileName, "UTF-8").replace("+", "%20");
            // 修复：添加HTTP协议前缀
            String downloadUrl = String.format("http://%s/%s", config.getDomain(), encodedFileName);
            return new java.net.URL(downloadUrl).openStream();
        } catch (IOException e) {
            throw new RuntimeException("文件下载失败：" + e.getMessage(), e);
        }
    }
}