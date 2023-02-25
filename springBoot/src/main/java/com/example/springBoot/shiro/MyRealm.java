package com.example.springBoot.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthenticatingRealm {

    /**
     * 自定义登录认证方法, shiro的login方法会调佣改类的认证方法进行认证
     * 需要配置自定义realm生效，ini文件中配置/springBoot中配置。
     * 该方法自是进行认证对比信息，认证的逻辑还是shiro底层认证。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1. 获取身份信息
        String principle = authenticationToken.getPrincipal().toString();
        // 2. 获取凭证信息
        String password = new String((char[])authenticationToken.getCredentials());
        System.out.println("认证用户信息： " + principle + "---" + password);
        // 3. 获取数据库中存储的用户信息
        if("zhangsan".equals(principle)){
            // 3.1 从数据库中获取加盐10次迭代的密码
            String passInfo = "0041e835cafed13fb9cab16bca5e378f";
            // 4. 创建校验逻辑对象, 封装数据返回
            // 四个参数：
            // 第一个：用户身份信息（不是字符串）； 第二个：数据库中保存的加密密码；
            // 第三个： 密码加密所用的盐； 第四个：获取到的身份信息转化成字符串
            return new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    passInfo,
                    ByteSource.Util.bytes("salt"),
                    authenticationToken.getPrincipal().toString()
            );
        }
        return null;
    }
}
