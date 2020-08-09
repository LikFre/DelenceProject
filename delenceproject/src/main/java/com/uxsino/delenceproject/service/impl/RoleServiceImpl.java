package com.uxsino.delenceproject.service.impl;

import com.uxsino.delenceproject.entity.Role;
import com.uxsino.delenceproject.repository.RoleRepository;
import com.uxsino.delenceproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;

/**
 * @author Yinpengfei
 * @Description TODO
 * @Date 2020/8/9 0009
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public int save(Role role) {
        return roleRepository.save(role)==null?0:1;
    }
}
