package com.shanghai.auth;

import com.shanghai.domain.service.CurdService;
import com.shanghai.pojo.Account;
import com.shanghai.pojo.Permission;
import com.shanghai.pojo.Role;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */
@Component
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    private CurdService curdService;

    /**权限校验
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        Account account1 = curdService.findAccountByUsername(account.getUsername());
        List<Role> roleList = curdService.findRoleListByAccountId(account1.getId());

        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        for(Role role : roleList){
            roles.add(role.getRoleName());
            List<Permission> permissionList = curdService.findPermissionListByRoleId(role.getId());
            for(Permission permission : permissionList){
                permissions.add(permission.getPermissionName());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //告诉shiro当前登录用户的角色
        simpleAuthorizationInfo.addRoles(roles);
        //告诉shiro当前登陆用户的权限(角色的细分)
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**身份校验
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Account account = curdService.findAccountByUsername(username);
        if(account != null){
           return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }
        return null;
    }
}
