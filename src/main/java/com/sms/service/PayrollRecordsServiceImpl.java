package com.sms.service;

import com.sms.dao.PayrollRecordsMapper;
import com.sms.pojo.PayrollRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollRecordsServiceImpl implements PayrollRecordsService{
    @Autowired
    private PayrollRecordsMapper payrollRecordsMapper;

    @Override
    public List<PayrollRecords> getAllRecords() {
        return payrollRecordsMapper.getAllRecords();
    }

    @Override
    public int deleteAllRecords() {
        return payrollRecordsMapper.deleteAllRecords();
    }

    @Override
    public int addRecords(PayrollRecords records) {
        return payrollRecordsMapper.addRecords(records);
    }
}
