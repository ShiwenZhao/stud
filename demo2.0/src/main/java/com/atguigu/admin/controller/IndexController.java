package com.atguigu.admin.controller;

import com.atguigu.admin.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    // 进入登录页
    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }

    // 处理登录请求
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            // 把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            // 登录成功重定向到main.html，重定向解决表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }


    // ".html"---跳转
    @GetMapping(value = {"/main.html","/main"})
    public String mainPage(HttpSession session,Model model){
        return "main";
    }


}
