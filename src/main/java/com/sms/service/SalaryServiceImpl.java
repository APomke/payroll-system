package com.sms.service;

import com.sms.dao.SalaryMapper;
import com.sms.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public int addSalary(Salary salary) {
        return salaryMapper.addSalary(salary);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    @Override
    public List<Salary> getAllSalary() {
        return salaryMapper.getAllSalary();
    }

    @Override
    public int deleteSalary(int userId) {
        return salaryMapper.deleteSalary(userId);
    }

    @Override
    public Salary getSalaryByName(String userName) {
        return salaryMapper.getSalaryByName(userName);
    }

    @Override
    public List<Salary> getSalaryByAscendingOrder() {
        return salaryMapper.getSalaryByAscendingOrder();
    }

    @Override
    public List<Salary> getSalaryByInvertedOrder() {
        return salaryMapper.getSalaryByInvertedOrder();
    }

    @Override
    public List<Salary> getSalaryByIsPay() {
        return salaryMapper.getSalaryByIsPay();
    }

    @Override
    public List<Salary> getSalaryByNoPay() {
        return salaryMapper.getSalaryByNoPay();
    }

    @Override
    public Salary getSalaryByUserId(int userId) {
        return salaryMapper.getSalaryByUserId(userId);
    }

    @Override
    public int payAllSalary() {
        return salaryMapper.payAllSalary();
    }

    @Override
    public int NoPaySalary() {
        return salaryMapper.NoPaySalary();
    }
}
