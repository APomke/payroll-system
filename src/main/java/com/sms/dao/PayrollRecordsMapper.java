package com.sms.dao;

import com.sms.pojo.PayrollRecords;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PayrollRecordsMapper {
    //获取全部记录
    List<PayrollRecords> getAllRecords();
    //删除全部记录
    int deleteAllRecords();
    //添加记录
    int addRecords(PayrollRecords records);
}
