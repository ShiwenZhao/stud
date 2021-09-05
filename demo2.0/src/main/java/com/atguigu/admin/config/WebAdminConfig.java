package com.atguigu.admin.config;

import com.atguigu.admin.beans.User;
import com.atguigu.admin.intercepter.LoginIntercepter;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAdminConfig implements WebMvcConfigurer {
    // 添加拦截器方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())  // 添加自定义拦截器
                .addPathPatterns("/**") // 拦截所有路径，包括靜態資源
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fronts/**"); // 放行路径
                                                    // 放行的靜態資源
    }

    // mybatis分页插件配置
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 实质是添加分页拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.H2);
        paginationInnerInterceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInnerInterceptor.setMaxLimit(500L);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);

        return interceptor;
    }

}
