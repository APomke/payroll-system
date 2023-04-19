package com.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.*;
import com.sms.service.PunchRecordsServiceImpl;
import com.sms.service.PunchServiceImpl;
import com.sms.service.UserServiceImpl;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/punch")
@CrossOrigin
public class PunchController {
    @Autowired
    private PunchServiceImpl punchService;
    @Autowired
    private PunchRecordsServiceImpl punchRecordsService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getAllPunch")
    public Result getAllPunch(){
        List<Punch> punchList = punchService.getAllPunch();
        if (punchList != null && !punchList.isEmpty()){
            return Result.ok().data("punchList",punchList);
        }else {
            return Result.error();
        }
    }

    @GetMapping("/getPunchByUserName")
    public Result getPunchByUserName(String userName){
        Punch punch = punchService.getPunchByUserName(userName);
        List<Punch> punchList = new ArrayList<>();
        if (punch != null){
            punchList.add(punch);
            return Result.ok().data("punchList",punchList);
        }
        return Result.error();
    }

    @GetMapping("/updatePunch")
    public Result updatePunch(String punch) throws JsonProcessingException {
        System.out.println("传入的是：" + punch);
        ObjectMapper objectMapper = new ObjectMapper();
        Punch punch1 = objectMapper.readValue(punch, Punch.class);
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 创建一个日期格式化对象
        String now = dateFormat.format(date); // 将日期对象转化为字符串
        punch1.setPunchTime(now);
        int s = punchService.updatePunch(punch1);
        //添加打卡记录
        PunchRecords punchRecords = new PunchRecords();
        punchRecords.setPunchRecordsTime(now);
        punchRecords.setPunchRecordsUserName(punch1.getUserName());
        punchRecordsService.addPunchRecords(punchRecords);

        //同时修改用户的状态
        User user = userService.getUserById(punch1.getUserId());
        user.setPunch(1);
        userService.updateUser(user);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/getPunchByNoPunch")
    public Result getPunchByNoPunch(){
        List<Punch> punchList = punchService.getAllNoPunch();
        if (punchList != null && !punchList.isEmpty()){
            return Result.ok().data("punchList",punchList);
        }
        return Result.error();
    }

    @GetMapping("/getPunchByYesPunch")
    public Result getPunchByYesPunch(){
        List<Punch> punchList = punchService.getAllYesPunch();
        if (punchList != null && !punchList.isEmpty()){
            return Result.ok().data("punchList",punchList);
        }
        return Result.error();
    }
}
