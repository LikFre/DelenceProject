package com.uxsino.delenceproject.controller;

import com.uxsino.delenceproject.entity.UserInfo;
import com.uxsino.delenceproject.service.UserInfoService;
import com.uxsino.delenceproject.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yinpengfei
 * @Description 用户信息Controller
 * @Date 2020/8/9 0009
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/save")
    public Message saveUser(UserInfo userInfo){
        int saveUser = userInfoService.saveUser(userInfo);
        return saveUser==1?Message.OK:Message.ServerException;
    }
}
