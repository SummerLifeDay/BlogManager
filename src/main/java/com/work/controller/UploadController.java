package com.work.controller;

import com.work.utils.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public Object upload(MultipartFile file){

        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffixName;
        String filePath = ".\\static\\uploadImg\\";
        try {
            //将图片保存到static文件夹里
            file.transferTo(new File(filePath+fileName));
            //返回提示信息
            return new Message(0, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(-1,"上传失败");
        }
    }

}
