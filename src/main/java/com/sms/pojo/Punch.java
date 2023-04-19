package com.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Punch {
    private int punchId;
    private int userId;
    private String userName;
    private String punchTime;
    private int punchStatus;

    public Punch(int userId, String userName, String punchTime, int punchStatus) {
        this.userId = userId;
        this.userName = userName;
        this.punchTime = punchTime;
        this.punchStatus = punchStatus;
    }
}
