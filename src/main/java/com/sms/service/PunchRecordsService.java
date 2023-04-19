package com.sms.service;

import com.sms.pojo.PunchRecords;

import java.util.List;

public interface PunchRecordsService{
    //获取全部打卡记录
    List<PunchRecords> getAllPunchRecords();
    //增加记录
    int addPunchRecords(PunchRecords punchRecords);
    //清除所有记录
    int deletePunchRecords();
}
