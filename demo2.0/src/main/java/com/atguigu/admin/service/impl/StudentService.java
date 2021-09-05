package com.atguigu.admin.service.impl;

import com.atguigu.admin.beans.Student;
import com.atguigu.admin.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student getStudentById(Long id){
        return studentMapper.getStudent(id);
    }
}
