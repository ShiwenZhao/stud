package com.atguigu.admin.controller;

import com.atguigu.admin.beans.User;
import com.atguigu.admin.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam(value = "pn",defaultValue = "1") Integer pn){
        /*
        // 表格从数据库获取数据
        List<User> list = userService.list();
        model.addAttribute("users",list);
        return "table/dynamic_table";
        */
        // 分页查询
        /*
         * 分页构造函数
         *
         * @param current 当前页
         * @param size    每页显示条数
         */
        Page<User> userPage = new Page<>(pn,2);
        /*
         * 翻页查询
         * Page<User>          查询结果
         * @param page         翻页对象
         * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
         */
        Page<User> page =userService.page(userPage,null);
        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);

        // 重定向添加参数
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

}
