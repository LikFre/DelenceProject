package com.uxsino.delenceproject.service.impl;

import com.uxsino.delenceproject.entity.Role;
import com.uxsino.delenceproject.entity.UserInfo;
import com.uxsino.delenceproject.repository.RoleRepository;
import com.uxsino.delenceproject.repository.UserInfoRepository;
import com.uxsino.delenceproject.service.LoginService;
import com.uxsino.delenceproject.service.UserInfoService;
import com.uxsino.delenceproject.utils.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Yinpengfei
 * @Description 用户信息业务实现
 * @Date 2020/8/9 0009
 **/
@Service
public class UserInfoServiceImpl implements UserDetailsService,UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private LoginService loginService;

    @Override
    public int saveUser(UserInfo userInfo) {
        Role admin = roleRepository.findByRoleName("USER");
        userInfo.setPassword(PasswordEncoderUtil.encode(userInfo.getPassword()));
        userInfo.setStatus(1);
        UserInfo user = userInfoRepository.save(userInfo);
        roleRepository.saveRoleAndUser(admin.getRoleId(),user.getId());
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserInfo userInfo =userInfoRepository.findByUserName(username);
        if(userInfo!=null){
            User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 1,true,true,true,getAuthority(username));
            return user;
        }else{
            throw new UsernameNotFoundException("用户名不存在");
        }
    }

    private Collection<SimpleGrantedAuthority> getAuthority(String username) {
        List<Role> roles = roleRepository.findRolesByUserName(username);
        if(!roles.isEmpty()){
            List<SimpleGrantedAuthority> list = new ArrayList<>();
            for (Role role: roles) {
                list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }
            return list;
        }
        return null;
    }
}
