package com.uxsino.delenceproject.service;

import com.uxsino.delenceproject.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Yinpengfei
 * @Description 用户信息服务
 * @Date 2020/8/9 0009
 **/
public interface UserInfoService  {

    /**
     * 保存用户信息
     * @param userInfo
     * @return
     */
    public int saveUser(UserInfo userInfo);
}
