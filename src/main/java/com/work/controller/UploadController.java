package com.work.controller;

import com.work.utils.Message;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public Object upload(HttpServletRequest request, @RequestParam("file") MultipartFile file){

        HttpSession session = request.getSession();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffixName;
        String filePath = getSavePath();
        try {
            //将图片保存到static文件夹里
            file.transferTo(new File(filePath+fileName));
            session.setAttribute("filePath", "/uploadImg/"+fileName);
            System.out.println(session.getAttribute("filePath"));
            //返回提示信息
            return new Message(1, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(-1,"上传失败");
        }
    }

    public String getSavePath(){
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下resources/static/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());

        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "\\src\\main\\resources\\static\\uploadImg\\";
    }
}
