package org.zhoujunjiang.grade.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zhoujunjiang.grade.service.QiniuService;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private QiniuService qiniuService;

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            String fileUrl = qiniuService.upload(file);
            model.addAttribute("fileUrl", fileUrl);
        } catch (Exception e) {
            model.addAttribute("error", "上传失败：" + e.getMessage());
        }
        return "upload";
    }
    @GetMapping("/files")
    public String listFiles(Model model) {
        List<String> urls = qiniuService.listFileUrls();
        List<Map<String, String>> files = new ArrayList<>();
        for (String url : urls) {
            String filename = url.substring(url.lastIndexOf('/') + 1);
            Map<String, String> map = new HashMap<>();
            map.put("url", url);
            map.put("name", filename);
            files.add(map);
        }
        model.addAttribute("fileList", files);
        return "file-list";
    }
    @GetMapping("/download/{filename}")
    public void downloadFile(@PathVariable("filename") String filename, HttpServletResponse response) {
        try (InputStream inputStream = qiniuService.download(filename);
             OutputStream outputStream = response.getOutputStream()) {

            response.setContentType("application/octet-stream");
            String encodedFilename = java.net.URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFilename);

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException("下载文件失败: " + filename, e);
        }
    }
}