package com.lzdn.upms.shiro.realm;

import com.lzdn.common.util.MD5Util;
import com.lzdn.upms.dao.model.UpmsPermission;
import com.lzdn.upms.dao.model.UpmsRole;
import com.lzdn.upms.dao.model.UpmsUser;
import com.lzdn.upms.service.UpmsApiService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpmsRealm extends AuthorizingRealm {
    @Autowired
    private UpmsApiService upmsApiService;

    /**
     * 授权：验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
        System.out.println("授权：验证权限时调用");
        //当前用户所有角色
        List<UpmsRole> upmsRoles = upmsApiService.selectUpmsRoleByUpmsUserId(upmsUser.getUserId());
        Set<String> roles = new HashSet <>();
        for(UpmsRole upmsRole :upmsRoles){
            if(StringUtils.isNotBlank(upmsRole.getName())){
                roles.add(upmsRole.getName());
            }
        }
        //当前用户所有权限
        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(upmsUser.getUserId());
        Set<String> permsissions = new HashSet <>();
        for(UpmsPermission upmsPermission:upmsPermissions){
            if(StringUtils.isNotBlank(upmsPermission.getPermissionValue())){
                permsissions.add(upmsPermission.getPermissionValue());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permsissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登陆时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        String password = new String ((char[])authenticationToken.getCredentials());
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
        if(null == upmsUser){
            throw new UnknownAccountException();
        }
        if(!upmsUser.getPassword().equals(MD5Util.md5(password+upmsUser.getSalt()))){
            throw new IncorrectCredentialsException();
        }
        if(upmsUser.getLocked() == 1){
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}

