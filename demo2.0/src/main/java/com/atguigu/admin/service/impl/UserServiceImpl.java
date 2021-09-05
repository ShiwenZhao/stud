package com.atguigu.admin.service.impl;

import com.atguigu.admin.beans.User;
import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


// 继承ServiceImpl类--->Iservice接口的众多方法的基本实现
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
