package com.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.Production;
import com.sms.pojo.Salary;
import com.sms.pojo.User;
import com.sms.service.PayrollRecordsServiceImpl;
import com.sms.service.ProductionServiceImpl;
import com.sms.service.UserServiceImpl;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/production")
@CrossOrigin
public class ProductionController {

    @Autowired
    private ProductionServiceImpl productionService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getAllProduction")
    public Result getAllProduction(){
        List<Production> productionList = productionService.getAllProduction();
        if (!productionList.isEmpty()){
            return Result.ok().data("productionList",productionList);
        }
        return Result.error();
    }
    @GetMapping("/getProductionByName")
    public Result getProductionByName(String Name){
        Production production = productionService.getProductionByName(Name);
        List<Production> productionList = new ArrayList<>();
        if (production != null){
            productionList.add(production);
            return Result.ok().data("productionList",productionList);
        }
        return Result.error();
    }

    @GetMapping("/updateProduction")
    public Result updateProduction(String production) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Production production1 = objectMapper.readValue(production, Production.class);
        int s = productionService.updateProduction(production1);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/deleteProduction")
    public Result deleteProduction(String id){
        int productionId = Integer.parseInt(id);
        int s = productionService.deleteProduction(productionId);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/addProduction")
    public Result addProduction(String production) throws JsonProcessingException {
        System.out.println("传入的是：" + production);
        ObjectMapper objectMapper = new ObjectMapper();
        Production production1 = objectMapper.readValue(production, Production.class);
        User user = userService.getUserByUserName(production1.getUserName());
        if (user == null){
            return Result.error();
        }
        production1.setUserId(user.getUserId());
        int s = productionService.addProduction(production1);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }
}
