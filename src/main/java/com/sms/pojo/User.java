package com.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private int age;
    private String sex;
    private int departmentId;
    private int roleId;
    private int punch;
    private int isSalary;
    private String entryTime;
}
