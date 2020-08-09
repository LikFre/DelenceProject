package com.uxsino.delenceproject.service;

import com.uxsino.delenceproject.entity.Role;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/9 0009
 **/
public interface RoleService {
    /**
     * 添加角色
     * @param role
     * @return
     */
    int save(Role role);
}
