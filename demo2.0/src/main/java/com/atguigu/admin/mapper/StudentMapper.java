package com.atguigu.admin.mapper;

import com.atguigu.admin.beans.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    public Student getStudent(Long id);

}
