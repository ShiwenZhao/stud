package com.atguigu.admin.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
// 默认类名与表名一致，若不一致则使用注解标注表名()
// @TableName("user")
public class User {
    //类的所有属性都应该在数据库中
    @TableField(exist = false) // 在表中不存在
    private String username;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
