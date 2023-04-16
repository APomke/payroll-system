package com.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.pojo.TempUser;
import com.sms.pojo.User;
import com.sms.service.UserServiceImpl;
import com.sms.utils.JwtUtils;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;

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
        System.out.println("获取的token为：" + token);

        String subject = JwtUtils.getClaimsByToken(token).getSubject();

        Pattern pattern = Pattern.compile("TempUser\\(username=(\\w+), password=(\\d+)\\)");
        Matcher matcher = pattern.matcher(subject);
        TempUser tempUser = new TempUser();
        if (matcher.matches()) {
            String username = matcher.group(1);
            String password = matcher.group(2);
            tempUser = new TempUser(username, password);
            System.out.println("重新转成了类：" + tempUser);
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
        System.out.println("搜索用户被触发");
        User user = userService.getUserByUserName(Name);
        if (user != null){
            return Result.ok().data("result",user);
        }
        return Result.error();
    }
}
