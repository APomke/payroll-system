package com.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.Punch;
import com.sms.pojo.Salary;
import com.sms.pojo.TempUser;
import com.sms.pojo.User;
import com.sms.service.PunchServiceImpl;
import com.sms.service.SalaryServiceImpl;
import com.sms.service.UserServiceImpl;
import com.sms.utils.JwtUtils;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SalaryServiceImpl salaryService;

    @Autowired
    private PunchServiceImpl punchService;

    @PostMapping("/login")
    public Result login(@RequestBody TempUser tempUser){
        //判断是否有该用户
        System.out.println(tempUser.toString());
        User user1 = userService.getUserByAccountAndPassword(tempUser.getUsername(),tempUser.getPassword());
        if (user1 != null){
            System.out.println("验证成功");
            String token = JwtUtils.generateToken(tempUser);
            return Result.ok().data("token",token);
        }
        return null;
    }

    @GetMapping("/info")
    public Result info(String token) {
        String subject = JwtUtils.getClaimsByToken(token).getSubject();

        Pattern pattern = Pattern.compile("TempUser\\(username=(\\w+), password=(\\d+)\\)");
        Matcher matcher = pattern.matcher(subject);
        TempUser tempUser = new TempUser();
        if (matcher.matches()) {
            String username = matcher.group(1);
            String password = matcher.group(2);
            tempUser = new TempUser(username, password);
        }
        User user = userService.getUserByAccountAndPassword(tempUser.getUsername(),tempUser.getPassword());

        String url = "https://img0.baidu.com/it/u=4247949114,3051213350&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500";
        return Result.ok().data("name",user.getUserName()).data("avatar",url);
    }

    @PostMapping("/logout")
    public Result logout(){
        return Result.ok();
    }

    @GetMapping("/userlist")
    public Result getUserList(){
        System.out.println("获取列表被触发");
        List<User> userList = userService.getAllUser();
        return Result.ok().data("userList",userList);
    }

    //根据用户名获取用户
    @GetMapping("/getUserByName")
    public Result getUserByName(String Name){
        System.out.println("搜索用户被触发Name为：" + Name);
        User user = userService.getUserByUserName(Name);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        if (user != null){
            return Result.ok().data("userList",userList);
        }
        return Result.error();
    }

    @GetMapping("/updateUser")
    public Result updateUser(String User) throws JsonProcessingException {
        System.out.println("修改用户被触发");
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(User, User.class);
        int s = userService.updateUser(user);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/deleteUser")
    public Result deleteUser(int userId){
        System.out.println("删除用户被触发传入的userId为：" + userId);
        int s = userService.deleteUserByUserId(userId);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/addUser")
    public Result addUser(String user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user2 = objectMapper.readValue(user, User.class);
        System.out.println("添加用户触发传入的用户信息为：" + user);
        int s = userService.addUser(user2);
        //添加用户表的同时也向工资表添加员工
        User user3 = userService.getUserByUserName(user2.getUserName());
        Salary salary = new Salary(user3.getUserId(),user3.getUserName(),0,user3.getIsSalary());
        salaryService.addSalary(salary);
        //同时给打卡表添加对应用户
        Punch punch = new Punch(user3.getUserId(),user3.getUserName(),"0000",0);
        punchService.addPunch(punch);
        if (s != 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/getAllUserCount")
    public Result getAllUserCount(){
        List<User> userList = userService.getAllUser();
        return Result.ok().data("count",userList.size());
    }

    @GetMapping("/getYesPunchCount")
    public Result getYesPunchCount(){
        List<User> userList = userService.getAllUser();
        int punchCount = 0;
        for (User user:userList){
            if (user.getPunch() == 1){
                punchCount++;
            }
        }
        int NopunchCount = userList.size() - punchCount;
        return Result.ok().data("punchCount",punchCount).data("NopunchCount",NopunchCount);
    }
}
