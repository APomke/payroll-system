package com.sms.service;

import com.sms.dao.UserMapper;
import com.sms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public User getUserByAccountAndPassword(String account, String password) {
        return userMapper.getUserByAccountAndPassword(account,password);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public User getUserByRoleId(int roleId) {
        return userMapper.getUserByRoleId(roleId);
    }

    @Override
    public List<User> getUserByDepartmentId(int departmentId) {
        return userMapper.getUserByDepartmentId(departmentId);
    }

    @Override
    public List<User> getUserBySex(String sex) {
        return userMapper.getUserBySex(sex);
    }

    @Override
    public List<User> getUserByNoPunch() {
        return userMapper.getUserByNoPunch();
    }

    @Override
    public List<User> getUserByYesPunch() {
        return userMapper.getUserByYesPunch();
    }

    @Override
    public List<User> getUserByNoSalary() {
        return userMapper.getUserByNoSalary();
    }

    @Override
    public List<User> getUserByYesSalary() {
        return userMapper.getUserByYesSalary();
    }

    @Override
    public int deleteUserByUserId(int userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
