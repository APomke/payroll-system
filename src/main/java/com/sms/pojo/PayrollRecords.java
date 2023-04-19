package com.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayrollRecords {
    private int payrollRecords;
    private int userId;
    private String userName;
    private int salary;
    private String recordsTime;
    private String remark;

    public PayrollRecords(int userId, String userName, int salary, String recordsTime, String remark) {
        this.userId = userId;
        this.userName = userName;
        this.salary = salary;
        this.recordsTime = recordsTime;
        this.remark = remark;
    }
}
