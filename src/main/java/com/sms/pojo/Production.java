package com.sms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Production {
    private int productionId;
    private String productionName;
    private int productionCount;
    private int userId;
    private String userName;
    private String productionDate;
}
