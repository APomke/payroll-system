package com.sms.dao;

import com.sms.pojo.Salary;
import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalaryMapper {
    //添加用户
    int addSalary(Salary salary);
    //修改薪水
    int updateSalary(Salary salary);
    //获取全部用户
    List<Salary> getAllSalary();
    //删除用户
    int deleteSalary(@Param("userId") int userId);
    //通过名称获取用户
    Salary getSalaryByName(@Param("userName") String userName);
    //获取全部用户根据薪水升序
    List<Salary> getSalaryByAscendingOrder();
    //获取全部用户根据薪水倒序
    List<Salary> getSalaryByInvertedOrder();
    //获取这个月已经发了薪水的用户
    List<Salary> getSalaryByIsPay();
    //获取这个月没发薪水的用户
    List<Salary> getSalaryByNoPay();
}
