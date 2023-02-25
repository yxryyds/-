package com.example.springBoot.config;

import com.example.springBoot.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 创建自定义Realm
     */
    @Bean
    public Realm getRealm(){
        MyRealm myRealm = new MyRealm();
        // 创建加密对象，设置相关属性(如果每个realm用的是不同的加密算法，就不能这样写)
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置MD5加密
        matcher.setHashAlgorithmName("md5");
        // 设置迭代加密次数
        matcher.setHashIterations(5);

        // 将加密对象存储至MyRealm中
        myRealm.setCredentialsMatcher(matcher);

//        // 开启缓存管理
//        myRealm.setCacheManager(new EhCacheManager());
//        // 开启全局缓存
//        myRealm.setCachingEnabled(true);
//
//        // 开启认证缓存
//        myRealm.setAuthenticationCachingEnabled(true);
//        // 设置认证缓存名字
//        myRealm.setAuthenticationCacheName("认证缓存");
//
//        // 开启授权缓存
//        myRealm.setAuthorizationCachingEnabled(true);
//        // 设置授权缓存名字
//        myRealm.setAuthorizationCacheName("授权缓存");

        return myRealm;
    }

    /**
     * 配置securityManager
     * 安全管理器
     * @return
     */
    @Bean("securityManager")
    public SessionsSecurityManager securityManager(
            @Qualifier("getRealm") Realm myRealm){
        // 创建对象
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        // 将MyRealm存入至DefaultWebSecurityManager对象中
        manager.setRealm(myRealm);

        // 返回
        return manager;
    }

//    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
//        DefaultShiroFilterChainDefinition filter = new DefaultShiroFilterChainDefinition();
//        // 设置不认证可以访问资源
//        filter.addPathDefinition("/myController/login", "anon");
//        filter.addPathDefinition("/myController/userLogin", "anon");
//        // 设置需要进行登录认证的拦截范围
//        filter.addPathDefinition("/**", "authc");
//        return filter;
//    }
    /**
     * 配置shiro内置过滤器拦截范围
     */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        Map<String, String> filter = new LinkedHashMap<>();
        filter.put("/logout", "logout");
        filter.put("/myController/**", "anon");
        filter.put("/testDate", "anon");
        filter.put("/ask", "anon");
        filter.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filter);

        // 默认的认证界面路径,如果没有验证登录，就会跳转至此路径
        shiroFilter.setLoginUrl("/");
        return shiroFilter;
    }
}
