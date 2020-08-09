package com.uxsino.delenceproject.service;

import com.uxsino.delenceproject.entity.UserInfo;
import com.uxsino.delenceproject.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yinpengfei
 * @Description TODO
 * @Date 2020/8/9 0009
 **/
@Service
public class LoginService {
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public LoginService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo getUserByUsername(String username) {
        return userInfoRepository.findByUserName(username);
    }

}
