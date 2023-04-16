package com.sms.service;

import com.sms.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    //获取所有部门信息
    List<Department> getAllDepartment();
    //根据部门id获取部门信息
    Department getDepartmentById(int departmentId);
    //根据部门名称获取部门信息
    Department getDepartmentByName(String departmentName);
    //添加部门
    int addDepartment(Department department);
    //删除部门
    int deleteDepartmentById(int departmentId);
    //修改部门信息
    int updateDepartment(Department department);
}
