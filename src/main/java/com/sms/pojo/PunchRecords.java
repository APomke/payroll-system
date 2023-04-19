package com.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PunchRecords {
    private int punchRecordsId;
    private String punchRecordsUserName;
    private String punchRecordsTime;
}
