package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// 文件上傳
@Controller
@Slf4j
public class FormTestController {

    @GetMapping(value = {"form/form_layouts","/form_layouts"})
    public String form_layouts(){
        return "form/form_layouts";
    }
    /*MultipartFile自動封裝上傳的文件
    *
        1.@RequestPart这个注解用在multipart/form-data表单提交请求的方法上。
        2.支持的请求方法的方式MultipartFile，属于Spring的MultipartResolver类。这个请求是通过http协议传输的。
        3.@RequestParam也同样支持multipart/form-data请求。
        4.他们最大的不同是，当请求方法的请求参数类型不再是String类型的时候。
        5.@RequestParam适用于name-valueString类型的请求域，@RequestPart适用于复杂的请求域（像JSON，XML）。
    */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上傳信息：email={},username={},headerImg={},photos={}",
               email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){ // 保存到服务器
            String originalFilename = headerImg.getOriginalFilename(); // 获取原文件名
            headerImg.transferTo(new File("D:\\imgView\\" + originalFilename)); // 保存到目标路径
        }

        if(photos.length > 0){
            for (MultipartFile photo:photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename(); // 获取原文件名
                    photo.transferTo(new File("D:\\imgView\\" + originalFilename)); // 保存到目标路径
                }
            }
        }

        return "form/form_layouts";
    }
}
