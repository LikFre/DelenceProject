package com.uxsino.delenceproject.repository;

import com.uxsino.delenceproject.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description 用户信息数据访问
 * @Author Administrator
 * @Date 2020/8/9 0009
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    @Query(value = "select * from ux_user where username=:username",nativeQuery = true)
    UserInfo findByUserName(@Param("username") String s);

}
