package com.uxsino.delenceproject.repository;

import com.uxsino.delenceproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author Yinpengfei
 * @Description 角色表数据访问
 * @Date 2020/8/9
 **/
public interface RoleRepository extends JpaRepository<Role,String> {
    @Query(value = "SELECT * from ux_role where role_name=:roleName",nativeQuery = true)
    Role findByRoleName(@Param("roleName") String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT into user_role(role_id,user_id) values(:roleId,:userId)",nativeQuery = true)
    int saveRoleAndUser(@Param("roleId")String roleId, @Param("userId")String userId);

    @Query(value="select u.role_id,role_name,role_desc from ux_role u inner join user_role ur on u.role_id=ur.role_id and ur.user_id =(select id from ux_user where username=:username)",nativeQuery = true)
    List<Role> findRolesByUserName(@Param("username") String username);
}
