package com.sms.controller;

import com.sms.pojo.PayrollRecords;
import com.sms.service.PayrollRecordsServiceImpl;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/records")
@CrossOrigin
public class PayrollRecordsController {
    @Autowired
    private PayrollRecordsServiceImpl recordsService;

    @GetMapping("/getAllRecords")
    public Result getAllRecord(){
        List<PayrollRecords> payrollRecordsList = recordsService.getAllRecords();
        if (payrollRecordsList != null){
            return Result.ok().data("recordsList",payrollRecordsList);
        }
        return Result.error();
    }
}
