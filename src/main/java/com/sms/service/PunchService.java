package com.sms.service;


import com.sms.pojo.Punch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PunchService {
    //获取所有用户
    List<Punch> getAllPunch();
    //修改打卡
    int updatePunch(Punch punch);
    //根据用户名称搜索用户
    Punch getPunchByUserName(String userName);
    //获取所有已打卡的用户
    List<Punch> getAllYesPunch();
    //获取所有未打卡的用户
    List<Punch> getAllNoPunch();
    //添加用户
    int addPunch(Punch punch);
}
