package com.sms.service;

import com.sms.pojo.PayrollRecords;

import java.util.List;

public interface PayrollRecordsService {
    //获取全部记录
    List<PayrollRecords> getAllRecords();
    //删除全部记录
    int deleteAllRecords();
    //添加记录
    int addRecords(PayrollRecords records);
}
