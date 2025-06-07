package org.zhoujunjiang.grade.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zhoujunjiang.grade.service.QiniuService;

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
        model.addAttribute("fileUrls", qiniuService.listFileUrls());
        return "file-list";
    }
}