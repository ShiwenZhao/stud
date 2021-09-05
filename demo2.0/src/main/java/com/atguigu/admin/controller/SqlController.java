package com.atguigu.admin.controller;

import com.atguigu.admin.beans.City;
import com.atguigu.admin.beans.Student;
import com.atguigu.admin.service.impl.CityService;
import com.atguigu.admin.service.impl.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController // 构造的请求一定要存在对应的解析器
@Slf4j
public class SqlController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StudentService studentService;
    @Autowired
    CityService cityService;

    private Long id_ = 1L;
    @GetMapping("/sql")
    public String myTestsql(){
        if(jdbcTemplate == null){
            log.info("jdbcTemplate is null");
        }
        Long l = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account;",Long.class);
        log.info("l is {}",l);
        return  "l is" + l;
    }

    @GetMapping("/stu/{id}")
    public Student getStuById(@PathVariable("id") Long id){
        Student student = studentService.getStudentById(id);
        log.info("Name:{}",student.getName());
        return student;
    }

    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        City city = cityService.getCityById(id);
        log.info("Name:{}",city.getName());
        return city;
    }

    @GetMapping("/insert_city")
    public void insertCity(@RequestParam("name") String name,
                            @RequestParam("state") String state,
                            @RequestParam("country") String country){
        id_ += 1L;
        cityService.insert(name,state,country);
        // City city = cityService.getCityById(id_);
        // log.info("Name:{}",city.getName());
        // return city;
    }


}
