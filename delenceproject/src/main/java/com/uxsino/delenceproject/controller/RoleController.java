package com.uxsino.delenceproject.controller;

import com.uxsino.delenceproject.entity.Role;
import com.uxsino.delenceproject.service.RoleService;
import com.uxsino.delenceproject.utils.Message;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yinpengfei
 * @Description 角色访问控制Controller
 * @Date 2020/8/9 0009
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    @RequestMapping("/save")
    public Message save(Role role){
        return roleService.save(role)==1?Message.OK:Message.ServerException;
    }
}
