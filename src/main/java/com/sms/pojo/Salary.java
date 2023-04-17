package com.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salary {
    private int userId;
    private String userName;
    private int salary;
    private int isSalary;
}
