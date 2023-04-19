package com.sms.controller;

import com.sms.pojo.PunchRecords;
import com.sms.service.PunchRecordsServiceImpl;
import com.sms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/punchRecords")
@CrossOrigin
public class PunchRecordsController {
    @Autowired
    private PunchRecordsServiceImpl recordsService;
    @GetMapping("/getAllRecords")
    public Result getAllRecords(){
        List<PunchRecords> punchRecordsList = recordsService.getAllPunchRecords();
        if (punchRecordsList != null && !punchRecordsList.isEmpty()){
            return Result.ok().data("punchRecordsList",punchRecordsList);
        }
        return Result.error();
    }
}
