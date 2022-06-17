package com.work.utils;

import com.work.pojo.Staff;
import com.work.service.StaffService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private StaffService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String userName = token.getUsername();
        Staff staff = service.selectOneByName(userName);

        if (staff == null){
            throw new UnknownAccountException("用户不存在");
        }
        String passwordInToken = new String(token.getPassword());
        String passwordInDb = staff.getPassword();
        if (passwordInDb.equals(passwordInToken)){
            return new SimpleAuthenticationInfo(userName, passwordInToken, getName());
        }

        throw new UnknownAccountException("密码错误");
    }
}
