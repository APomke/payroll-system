package com.sms.dao;

import com.sms.pojo.PunchRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@Repository
public interface PunchRecordsMapper {
    //获取全部打卡记录
    List<PunchRecords> getAllPunchRecords();
    //增加记录
    int addPunchRecords(PunchRecords punchRecords);
    //清除所有记录
    int deletePunchRecords();
}
