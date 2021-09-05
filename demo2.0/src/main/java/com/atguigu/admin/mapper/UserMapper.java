package com.atguigu.admin.mapper;

import com.atguigu.admin.beans.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

// 继承 BaseMapper 声明了众多基本增删改查方法
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
