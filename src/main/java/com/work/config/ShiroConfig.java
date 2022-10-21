package com.work.config;

import com.work.utils.MyRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public MyRealm realm(){
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        factoryBean.setUnauthorizedUrl("/unauth");

        //设置shiro的拦截规则
        //anon 匿名用户可访问   authc  认证用户可访问
        //user 使用RemeberMe的用户可访问  perms  对应权限可访问
        //role  对应的角色可访问
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/logout", "logout");
        map.put("/loginIn", "anon");

        map.put("/reg", "roles[0]");
        map.put("/admin/coupon/add", "roles[0]");
        map.put("/admin/coupon/del", "roles[0]");
        map.put("/admin/table/add", "roles[0]");
        map.put("/admin/table/del", "roles[0]");
        map.put("/admin/order/del", "roles[0]");
        map.put("/admin/product/add", "roles[0]");
        map.put("/admin/product/del", "roles[0]");
        map.put("/admin/customer/del", "roles[0]");
        map.put("/upload", "roles[0]");

        //暂先注释,测试接口有无问题,
//        map.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(map);

        return factoryBean;
    }
}
