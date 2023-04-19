package com.sms.service;

import com.sms.pojo.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionService {
    //获取全部生产
    List<Production> getAllProduction();
    //添加生产
    int addProduction(Production production);
    //修改生产
    int updateProduction(Production production);
    //根据id查询生产
    Production getProductionById(int productionId);
    //根据userName查询生产
    Production getProductionByUserName(String userName);
    //根据userId查询生产
    Production getProductionByUserId(int userId);
    //删除生产
    int deleteProduction(int productionId);
    //根据产品名称查询
    Production getProductionByName(String productionName);
}
