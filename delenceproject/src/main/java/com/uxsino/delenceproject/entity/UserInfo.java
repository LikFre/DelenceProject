package com.uxsino.delenceproject.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * @author Yinpengfei
 * @Description 用户实体类
 * @Date 2020/8/9
 **/
@Data
@Entity
@Table(name = "ux_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserInfo {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(length = 20)
    private String username;
    @Column(length = 64)
    private String password;
    @Column(length = 5)
    private int status;
}
