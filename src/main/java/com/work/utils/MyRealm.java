package com.work.utils;

import com.work.pojo.Staff;
import com.work.service.StaffService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.AllPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private StaffService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = (String) principalCollection.iterator().next();
        int role = service.findRoleByUserName(userName);
        Set<String> roles = new HashSet<>();
        roles.add(role+"");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.setRoles(roles);
        return info;
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
