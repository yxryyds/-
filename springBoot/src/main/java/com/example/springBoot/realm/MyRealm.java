package com.example.springBoot.realm;

import com.example.springBoot.model.ShiroUser;
import com.example.springBoot.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private ShiroService service;

    /**
     *自定义授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入自定义授权方法");
        // 创建对象，封装当前登录用户的角色，权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 获取当前用户角色
        String name = (String) principalCollection.getPrimaryPrincipal();
        ShiroUser userByName = service.getUserByName(name);

        // 存储相关角色
        info.addRole(userByName.getRole());

        // 存储权限信息
        info.addStringPermission("file:write");

        // 返回角色信息
        return info;
    }

    /**
     * 自定义登录认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入登入认证");
        // 获取用户身份信息
        String name = authenticationToken.getPrincipal().toString();
        // 调用业务层获取用户信息(数据库)
        ShiroUser user = service.getUserByName(name);
        // 判断是否存在用户
        if(user.getUsername() != null){
            // 封装数据返回
            return
                new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    user.getPassword(),
                    ByteSource.Util.bytes("salt"),
                    name
                );
        }
        return null;
    }
}
