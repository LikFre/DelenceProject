package com.uxsino.delenceproject.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Yinpengfei
 * @Description 角色类
 * @Date 2020/8/9
 **/
@Data
@Entity
@Table(name = "ux_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Role {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String roleId;
    @Column(length = 10)
    private String roleName;
    @Column(length = 150)
    private String roleDesc;
}
