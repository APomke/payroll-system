package com.sms.dao;

import com.sms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    //获取全部用户
    List<User> getAllUser();
    //根据id获取用户
    User getUserById(@Param("userId") int userId);
    //根据账号获取用户
    User getUserByAccount(@Param("Account") String account);
    //根据账号和密码获取用户
    User getUserByAccountAndPassword(@Param("userAccount") String account,@Param("userPassword") String password);
    //根据用户名获取用户
    User getUserByUserName(@Param("userName") String userName);
    //根据角色id获取用户
    User getUserByRoleId(@Param("roleId") int roleId);
    //获取指定部门的所有用户
    List<User> getUserByDepartmentId(@Param("departmentId") int departmentId);
    //获取指定性别的所有用户
    List<User> getUserBySex(@Param("sex") String sex);
    //获取今天未打卡的用户
    List<User> getUserByNoPunch();
    //获取今天已打卡的用户
    List<User> getUserByYesPunch();
    //获取这个月还没有发工资的用户
    List<User> getUserByNoSalary();
    //获取这个月发了工资的用户
    List<User> getUserByYesSalary();
    //根据用户id删除用户
    int deleteUserByUserId(@Param("userId") int userId);
    //修改用户
    int updateUser(User user);

}
