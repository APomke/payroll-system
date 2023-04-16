package com.sms.dao;

import com.sms.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {
    //获取所有部门信息
    List<Department> getAllDepartment();
    //根据部门id获取部门信息
    Department getDepartmentById(@Param("departmentId") int departmentId);
    //根据部门名称获取部门信息
    Department getDepartmentByName(@Param("departmentName") String departmentName);
    //添加部门
    int addDepartment(Department department);
    //删除部门
    int deleteDepartmentById(@Param("departmentId") int departmentId);
    //修改部门信息
    int updateDepartment(Department department);

}
