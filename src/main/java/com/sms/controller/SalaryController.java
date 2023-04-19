package com.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.PayrollRecords;
import com.sms.pojo.Salary;
import com.sms.pojo.User;
import com.sms.service.PayrollRecordsServiceImpl;
import com.sms.service.SalaryService;
import com.sms.service.SalaryServiceImpl;
import com.sms.service.UserServiceImpl;
import com.sms.utils.Result;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary")
@CrossOrigin
public class SalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;
    @Autowired
    private PayrollRecordsServiceImpl recordsService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getAllSalary")
    public Result getAllSalary(){
        List<Salary> salaryList = salaryService.getAllSalary();

        return Result.ok().data("salaryList",salaryList);
    }

    @GetMapping("/updateSalary")
    public Result updateSalary(String salary) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Salary salary1 = objectMapper.readValue(salary, Salary.class);
        int s = salaryService.updateSalary(salary1);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/getSalaryByName")
    public Result getSalaryByName(String Name){
        Salary salary = salaryService.getSalaryByName(Name);
        List<Salary> salaryList = new ArrayList<>();
        if (salary != null){
            salaryList.add(salary);
            return Result.ok().data("salaryList",salaryList);
        }
        return Result.error();

    }

    @GetMapping("/getSalaryACS")
    public Result getSalaryACS(){
        List<Salary> salaryList = salaryService.getSalaryByAscendingOrder();
        if (salaryList != null){
            return Result.ok().data("salaryList",salaryList);
        }
        return Result.error();
    }

    @GetMapping("/getSalaryDESC")
    public Result getSalaryDESC(){
        List<Salary> salaryList = salaryService.getSalaryByInvertedOrder();
        if (salaryList != null){
            return Result.ok().data("salaryList",salaryList);
        }
        return Result.error();
    }

    @GetMapping("/getSalaryByYesSalary")
    public Result getSalaryByYesSalary(){
        List<Salary> salaryList = salaryService.getSalaryByIsPay();
        if (salaryList != null){
            return Result.ok().data("salaryList",salaryList);
        }
        return Result.error();
    }

    @GetMapping("/getSalaryByNoSalary")
    public Result getSalaryByNoSalary(){
        List<Salary> salaryList = salaryService.getSalaryByNoPay();
        if (salaryList != null){
            return Result.ok().data("salaryList",salaryList);
        }
        return Result.error();
    }

    @GetMapping("/paySalary")
    public Result paySalary(String id){
        System.out.println("获取的id为：" + id);
        int userId = Integer.parseInt(id);
        Salary salary = salaryService.getSalaryByUserId(userId);
        System.out.println("获取的工资为:" + salary.toString());
        salary.setIsSalary(1);
        int s = salaryService.updateSalary(salary);

        //添加一条工资发放记录
        User user = userService.getUserById(userId);
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 创建一个日期格式化对象
        String now = dateFormat.format(date); // 将日期对象转化为字符串
        PayrollRecords records = new PayrollRecords(userId,user.getUserName(),salary.getSalary(),now,null);
        recordsService.addRecords(records);
        //同时修改用户表的状态
        user.setIsSalary(1);
        userService.updateUser(user);
        if (s != 0){
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("/payAllSalary")
    public Result payAllSalary(){
        List<Salary> salaryList = salaryService.getAllSalary();
        System.out.println("列表为：" + salaryList.toString());
        for (Salary salary:salaryList){
            System.out.println("userid为：" + salary.getUserId());
            this.paySalary(String.valueOf(salary.getUserId()));
        }
        int s = salaryService.payAllSalary();
        if (s != 0){
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("/NoPayAllSalary")
    public Result NoPayAllSalary(){
        int s = salaryService.NoPaySalary();
        if (s != 0){
            return Result.ok();
        }
        return Result.error();
    }

    @GetMapping("/getSalaryView")
    public Result getSalaryView(){
        List<Salary> salaryList = salaryService.getAllSalary();
        //把工资进行分类
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int s4 = 0;
        int s5 = 0;
        int s6 = 0;
        for (Salary salary:salaryList){
            if (salary.getSalary() >= 1000 && salary.getSalary() < 3000){
                s1++;
            }else if (salary.getSalary() >= 3000 && salary.getSalary() < 5000){
                s2++;
            }else if (salary.getSalary() >= 5000 && salary.getSalary() < 8000){
                s3++;
            }else if (salary.getSalary() >= 8000 && salary.getSalary() < 10000){
                s4++;
            }else if (salary.getSalary() >= 10000 && salary.getSalary() < 15000){
                s5++;
            }else if (salary.getSalary() >= 15000 && salary.getSalary() < 20000){
                s6++;
            }
        }
        return Result.ok().data("s1",s1).data("s2",s2).data("s3",s3).data("s4",s4).data("s5",s5).data("s6",s6);
    }

}
