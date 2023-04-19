package com.sms.service;

import com.sms.dao.PunchRecordsMapper;
import com.sms.pojo.PunchRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunchRecordsServiceImpl implements PunchRecordsService{
    @Autowired
    private PunchRecordsMapper punchRecordsMapper;
    @Override
    public List<PunchRecords> getAllPunchRecords() {
        return punchRecordsMapper.getAllPunchRecords();
    }

    @Override
    public int addPunchRecords(PunchRecords punchRecords) {
        return punchRecordsMapper.addPunchRecords(punchRecords);
    }

    @Override
    public int deletePunchRecords() {
        return punchRecordsMapper.deletePunchRecords();
    }
}
