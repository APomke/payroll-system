package com.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.Salary;
import com.sms.pojo.User;
import com.sms.service.SalaryService;
import com.sms.service.SalaryServiceImpl;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/salary")
@CrossOrigin
public class SalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;

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

}
