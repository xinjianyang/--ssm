package com.shanghai.domain.service.impl;

import com.shanghai.domain.service.CurdService;
import com.shanghai.exception.ServiceException;
import com.shanghai.mapper.*;
import com.shanghai.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */
@Service
public class CurdServiceImpl implements CurdService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRoleMapper accountRoleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public void saveRole(Role role) {
        if(role == null){
            throw new ServiceException("role为null");
        }
        role.setCreatetime(new Date());
        roleMapper.insertSelective(role);
    }

    @Override
    public void saveAccount(Account account) {
        if(account == null){
            throw new ServiceException("account为null");
        }
        account.setCreatetime(new Date());
        accountMapper.insertSelective(account);
    }

    @Override
    public void savePermission(Permission permission) {
        if(permission == null){
            throw new ServiceException("permission>>>>null");
        }
        permission.setCreatetime(new Date());
        permissionMapper.insertSelective(permission);
    }

    @Override
    public void saveRolePermission(RolePermissionKey rolePermissionKey) {
        if(rolePermissionKey == null){
            throw new ServiceException("数据为null了");
        }
        rolePermissionMapper.insertSelective(rolePermissionKey);
    }

    @Override
    public void saveAccountRole(AccountRoleKey accountRoleKey) {
        if(accountRoleKey == null){
            throw new ServiceException("数据为null了");
        }
        accountRoleMapper.insertSelective(accountRoleKey);
    }

    @Override
    public Account findAccountByUsername(String username) {
        if(username == null){
            throw new ServiceException("username为null");
        }
        return accountMapper.findByUsername(username);
    }

    /**根据账户id获取对应的角色列表 account_role role
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleListByAccountId(Integer id) {
        List<Role> roleList = roleMapper.findRoleListByAccountId(id);
        return roleList;
    }

    @Override
    public List<Permission> findPermissionListByRoleId(Integer id) {
        List<Permission> permissionList = permissionMapper.findPermissionListByRoleId(id);
        return permissionList;
    }


}
