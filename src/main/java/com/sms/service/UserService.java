package com.sms.service;

import com.sms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //获取全部用户
    List<User> getAllUser();
    //根据id获取用户
    User getUserById(int userId);
    //根据账号获取用户
    User getUserByAccount(String account);
    //根据账号和密码获取用户
    User getUserByAccountAndPassword(String account,String password);
    //根据用户名获取用户
    User getUserByUserName(String userName);
    //根据角色id获取用户
    User getUserByRoleId(int roleId);
    //获取指定部门的所有用户
    List<User> getUserByDepartmentId(int departmentId);
    //获取指定性别的所有用户
    List<User> getUserBySex(String sex);
    //获取今天未打卡的用户
    List<User> getUserByNoPunch();
    //获取今天已打卡的用户
    List<User> getUserByYesPunch();
    //获取这个月还没有发工资的用户
    List<User> getUserByNoSalary();
    //获取这个月发了工资的用户
    List<User> getUserByYesSalary();
    //根据用户id删除用户
    int deleteUserByUserId(int userId);
    //修改用户
    int updateUser(User user);
}
