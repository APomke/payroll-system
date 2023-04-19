package com.sms.service;

import com.sms.dao.PunchMapper;
import com.sms.pojo.Punch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunchServiceImpl implements PunchService{
    @Autowired
    private PunchMapper punchMapper;

    @Override
    public List<Punch> getAllPunch() {
        return punchMapper.getAllPunch();
    }

    @Override
    public int updatePunch(Punch punch) {
        return punchMapper.updatePunch(punch);
    }

    @Override
    public Punch getPunchByUserName(String userName) {
        return punchMapper.getPunchByUserName(userName);
    }

    @Override
    public List<Punch> getAllYesPunch() {
        return punchMapper.getAllYesPunch();
    }

    @Override
    public List<Punch> getAllNoPunch() {
        return punchMapper.getAllNoPunch();
    }

    @Override
    public int addPunch(Punch punch) {
        return punchMapper.addPunch(punch);
    }
}
