package com.atguigu.admin.service.impl;

import com.atguigu.admin.beans.City;
import com.atguigu.admin.beans.Student;
import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getCityById(Long id){
        return cityMapper.getCityById(id);
    }

    public void insert(String name,String state,String country){
        cityMapper.insert(name,state,country);
    }
}
