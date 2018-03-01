package com.shanghai.domain.service;

import com.shanghai.pojo.*;

import java.util.List;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */
public interface CurdService {


    void checkRole();

    void saveRole(Role role);

    void saveAccount(Account account);

    void savePermission(Permission permission);

    void saveRolePermission(RolePermissionKey rolePermissionKey);

    void saveAccountRole(AccountRoleKey accountRoleKey);

    Account findAccountByUsername(String username);

    List<Role> findRoleListByAccountId(Integer id);

    List<Permission> findPermissionListByRoleId(Integer id);
}
